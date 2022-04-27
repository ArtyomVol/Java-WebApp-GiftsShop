package by.bntu.fitr.poisit.controller.shoppingCart;

import by.bntu.fitr.poisit.dao.ShoppingCartRepositoryImpl;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.service.ShoppingCartService;
import by.bntu.fitr.poisit.service.impl.ShoppingCartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PurchaseShoppingCart", value = "/purchase-shopping-cart-servlet")
public class PurchaseShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(new ShoppingCartRepositoryImpl());
        int accountId = ((Account) request.getSession().getAttribute("account")).getId();
        shoppingCartService.purchaseShoppingCart(accountId);
        request.getRequestDispatcher("/shopping-cart-servlet").forward(request, response);
    }
}
