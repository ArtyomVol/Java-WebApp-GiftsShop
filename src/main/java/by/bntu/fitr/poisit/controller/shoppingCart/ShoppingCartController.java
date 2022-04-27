package by.bntu.fitr.poisit.controller.shoppingCart;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.dao.ShoppingCartRepositoryImpl;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import by.bntu.fitr.poisit.service.ShoppingCartService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;
import by.bntu.fitr.poisit.service.impl.ShoppingCartServiceImpl;
import by.bntu.fitr.poisit.util.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShoppingCartController", value = "/shopping-cart-servlet")
public class ShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", new CategoryServiceImpl(new CategoryRepositoryImpl()).getAllCategories());
        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(new ShoppingCartRepositoryImpl());
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartByAccountId(
                ((Account) request.getSession().getAttribute("account")).getId());
        new ItemServiceImpl(new ItemRepositoryImpl()).fillItemsInShoppingCarts(shoppingCarts);
        request.setAttribute("shoppingCarts", shoppingCarts);
        int totalCost = Calculator.calculateShoppingCartTotalCost(shoppingCarts);
        request.setAttribute("totalCost", totalCost);
        request.getRequestDispatcher("/shopping-cart").forward(request, response);
    }
}
