package by.bntu.fitr.poisit.controller.item;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ItemsDisplayController", value = "/main", loadOnStartup = 0)
public class ItemsDisplayController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
        request.setAttribute("items", itemService.getAllItems());
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
