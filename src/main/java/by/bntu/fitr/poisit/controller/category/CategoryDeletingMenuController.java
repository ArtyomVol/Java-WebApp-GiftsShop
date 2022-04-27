package by.bntu.fitr.poisit.controller.category;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.constants.ErrorConstant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryDeletingMenuController", value = "/category-deleting-menu-servlet")
public class CategoryDeletingMenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.getRequestDispatcher("/WEB-INF/view/category-deleting-menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        int categoryId = Integer.parseInt(request.getParameter("select_name"));
        List<Byte> errorsCode = categoryService.deleteCategory(categoryId, new ItemRepositoryImpl());
        request.setAttribute("categories", categoryService.getAllCategories());
        if (errorsCode.size() == 1 && errorsCode.contains(ErrorConstant.SUCCESS_CATEGORY_DELETE)) {
            request.setAttribute("successCode", ErrorConstant.SUCCESS_CATEGORY_DELETE_MSG);
            request.getRequestDispatcher("/category-deleting-menu").forward(request, response);
        }
        else {
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/category-deleting-error-handler").forward(request, response);
        }
    }
}
