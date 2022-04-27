package by.bntu.fitr.poisit.controller.registration;

import by.bntu.fitr.poisit.util.ConvertingErrorList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegistrationErrorHandler", value = "/registrationErrorHandler")
public class RegistrationErrorHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Byte> errorsCode = (ArrayList<Byte>)(request.getAttribute("errorsCode"));
        request.setAttribute("errorCode", ConvertingErrorList.convertRegistrationErrorListToString(errorsCode));
        request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
    }

}