package by.bntu.fitr.poisit.controller.item;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ItemInfoDisplayController", value = "/main/item-info")
public class ItemInfoDisplayController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String itemIdString = request.getParameter("item_id");
            int itemId = Integer.parseInt(itemIdString);
            ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
            Item item = itemService.getItemById(itemId);
            request.setAttribute("item", item);
            CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
            request.setAttribute("categoryName", categoryService.getCategoryById(item.getCategoryId()).getName());
            request.setAttribute("categories", categoryService.getAllCategories());
            request.getRequestDispatcher("/WEB-INF/view/item-info.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
