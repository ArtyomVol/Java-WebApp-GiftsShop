package by.bntu.fitr.poisit.controller.shoppingCart;

import by.bntu.fitr.poisit.dao.ShoppingCartRepositoryImpl;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.service.ShoppingCartService;
import by.bntu.fitr.poisit.service.impl.ShoppingCartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteItemFromShoppingCart", value = "/delete-item-from-shopping-cart-servlet")
public class DeleteItemFromShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(new ShoppingCartRepositoryImpl());
        String cartIdString = request.getParameter("cart_id");
        int cartId = Integer.parseInt(cartIdString);
        int accountId = ((Account) request.getSession().getAttribute("account")).getId();
        shoppingCartService.deleteCartItem(cartId, accountId);
        request.getRequestDispatcher("/shopping-cart-servlet").forward(request, response);
    }
}
