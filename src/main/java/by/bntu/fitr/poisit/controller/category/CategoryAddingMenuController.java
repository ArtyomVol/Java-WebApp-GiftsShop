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

@WebServlet(name = "CategoryAddingController", value = "/category-adding-menu-servlet")
public class CategoryAddingMenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        String name = request.getParameter("category_name");
        List<Byte> errorsCode = categoryService.addCategory(name);
        if (errorsCode.size() == 1 && errorsCode.contains(ErrorConstant.SUCCESS_CATEGORY_ADD)) {
            request.setAttribute("successCode", ErrorConstant.SUCCESS_CATEGORY_ADD_MSG);
            request.getRequestDispatcher("/category-adding-menu").forward(request, response);
        }
        else {
            request.setAttribute("categoryName", name);
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/category-adding-error-handler").forward(request, response);
        }
    }
}
