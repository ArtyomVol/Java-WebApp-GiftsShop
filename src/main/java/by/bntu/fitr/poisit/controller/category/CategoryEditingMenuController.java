package by.bntu.fitr.poisit.controller.category;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.constants.ErrorConstant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryEditingMenuController", value = "/category-editing-menu-servlet")
public class CategoryEditingMenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.getRequestDispatcher("/category-editing-menu").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        int categoryId = Integer.parseInt(request.getParameter("select_name"));
        String newName = request.getParameter("new_category_name");
        List<Byte> errorsCode = categoryService.editCategory(categoryId, newName);
        request.setAttribute("categories", categoryService.getAllCategories());
        if (errorsCode.size() == 1 && errorsCode.contains(ErrorConstant.SUCCESS_CATEGORY_EDIT)) {
            request.setAttribute("successCode", ErrorConstant.SUCCESS_CATEGORY_EDIT_MSG);
            request.getRequestDispatcher("/category-editing-menu").forward(request, response);
        }
        else {
            request.setAttribute("newCategoryName", newName);
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/category-editing-error-handler").forward(request, response);
        }
    }
}
