package by.bntu.fitr.poisit.controller.shoppingCart;

import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.dao.ShoppingCartRepositoryImpl;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.service.ShoppingCartService;
import by.bntu.fitr.poisit.service.impl.ShoppingCartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ItemAddingToShoppingCartController", value = "/item-adding-to-shopping-cart-servlet")
public class ItemAddingToShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(new ShoppingCartRepositoryImpl());
        int accountId = ((Account) request.getSession().getAttribute("account")).getId();
        String itemIdString = request.getParameter("item_id");
        int itemId = Integer.parseInt(itemIdString);
        shoppingCartService.addCartItem(itemId, accountId, new ItemRepositoryImpl());
        request.getRequestDispatcher("/main/item-info?item-id=" + itemId).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
