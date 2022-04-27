package by.bntu.fitr.poisit.controller.item;

import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ItemDeletingController", value = "/item-deleting-servlet")
public class ItemDeletingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
        int itemId = Integer.parseInt(request.getParameter("item_id"));
        String stringChoiceYN = request.getParameter("choice");
        int choiceYN = Integer.parseInt(stringChoiceYN);
        if (choiceYN == 1) {
            itemService.deleteItemById(itemId);
            request.getRequestDispatcher("/main").forward(request, response);
        } else {
            request.getRequestDispatcher("/main/item-info").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
