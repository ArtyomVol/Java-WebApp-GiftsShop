package by.bntu.fitr.poisit.controller;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.dao.PurchasesRepositoryImpl;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;
import by.bntu.fitr.poisit.service.impl.PurchasesServiceImpl;
import by.bntu.fitr.poisit.util.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PersonalAreaController", value = "/personal-area-servlet")
public class PersonalAreaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", new CategoryServiceImpl(new CategoryRepositoryImpl()).getAllCategories());
        List<Purchase> purchases = new PurchasesServiceImpl(new PurchasesRepositoryImpl()).getAllPurchases(
                ((Account) request.getSession().getAttribute("account")).getId());
        new ItemServiceImpl(new ItemRepositoryImpl()).fillItemsInPurchases(purchases);
        request.setAttribute("purchases", purchases);
        int totalCost = Calculator.calculatePurchasesTotalCost(purchases);
        request.setAttribute("totalCost", totalCost);
        request.getRequestDispatcher("/personal-area").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
