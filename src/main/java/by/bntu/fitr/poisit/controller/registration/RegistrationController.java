package by.bntu.fitr.poisit.controller.registration;

import by.bntu.fitr.poisit.dao.AccountRepositoryImpl;
import by.bntu.fitr.poisit.service.AccountService;
import by.bntu.fitr.poisit.service.impl.AccountServiceImpl;
import by.bntu.fitr.poisit.constants.ErrorConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistrationController", value = "/registration-servlet")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeat_password");
        AccountService accountService = new AccountServiceImpl(new AccountRepositoryImpl());
        List<Byte> errorsCode = accountService.addAccount(firstName, lastName, username, password, repeatPassword);
        if (errorsCode.size() == 1 && errorsCode.get(0) == ErrorConstant.SUCCESS_REGISTRATION) {
            response.sendRedirect("http://localhost:8081/shop/login");
        }
        else {
            request.setAttribute("registrationUsername", username);
            request.setAttribute("registrationFirstName", firstName);
            request.setAttribute("registrationLastName", lastName);
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/registrationErrorHandler").forward(request, response);
        }
    }
}
