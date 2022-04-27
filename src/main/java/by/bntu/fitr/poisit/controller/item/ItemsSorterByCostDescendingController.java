package by.bntu.fitr.poisit.controller.item;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;
import by.bntu.fitr.poisit.util.Sorter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ItemsSorterByCostDescendingController", value = "/items-sort-desc-servlet")
public class ItemsSorterByCostDescendingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        String categoryName = request.getParameter("category_name");
        Category category = categoryService.getCategoryByName(categoryName);
        ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
        String itemSearch = request.getParameter("search_text");
        List<Item> items = itemService.getAllItemsContainsStringInNameInCategory(itemSearch, category);
        Sorter.sortItemsByCostDescending(items);
        request.setAttribute("items", items);
        request.setAttribute("itemSearch", itemSearch);
        request.setAttribute("categoryName", categoryName);
        request.setAttribute("categories", categoryService.getAllCategories());
        request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
