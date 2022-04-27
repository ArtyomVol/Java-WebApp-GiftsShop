package by.bntu.fitr.poisit.controller.login;

import by.bntu.fitr.poisit.dao.AccountRepositoryImpl;
import by.bntu.fitr.poisit.service.AccountService;
import by.bntu.fitr.poisit.service.impl.AccountServiceImpl;
import by.bntu.fitr.poisit.constants.ErrorConstant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "LoginController", value = "/login-servlet")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountService accountService = new AccountServiceImpl(new AccountRepositoryImpl());
        if (accountService.checkAuthentication(username, password)) {
            request.getSession().setAttribute("account", accountService.getAccount(username));
            request.getRequestDispatcher("/main").forward(request, response);
        }
        else {
            request.setAttribute("loginUsername", username);
            List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_PASSWORD_OR_LOGIN_IN_LOGIN));
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/loginErrorHandler").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
