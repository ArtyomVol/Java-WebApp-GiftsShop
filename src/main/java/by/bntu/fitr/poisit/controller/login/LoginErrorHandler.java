package by.bntu.fitr.poisit.controller.login;

import by.bntu.fitr.poisit.util.ConvertingErrorList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginErrorHandler", value = "/loginErrorHandler")
public class LoginErrorHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Byte> errorsCode = (ArrayList<Byte>)(request.getAttribute("errorsCode"));
        request.setAttribute("errorCode", ConvertingErrorList.convertLoginErrorListToString(errorsCode));
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }
}
