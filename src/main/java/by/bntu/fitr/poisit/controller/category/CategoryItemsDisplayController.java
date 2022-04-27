package by.bntu.fitr.poisit.controller.category;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryItemsDisplayController", value = "/main/category")
public class CategoryItemsDisplayController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId;
        try {
            categoryId = Integer.parseInt(request.getParameter("category_id"));
            ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
            request.setAttribute("items",
                    itemService.getAllItemsFromCategory(categoryId));
            CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
            Category category = categoryService.getCategoryById(categoryId);
            request.setAttribute("categoryName", category.getName());
            request.setAttribute("categoryId", category.getCategoryId());
            request.setAttribute("categories", categoryService.getAllCategories());
            request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
