package by.bntu.fitr.poisit.controller.category;

import by.bntu.fitr.poisit.util.ConvertingErrorList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryEditingErrorHandler", value = "/category-editing-error-handler")
public class CategoryEditingErrorHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Byte> errorsCode = (ArrayList<Byte>)(request.getAttribute("errorsCode"));
        request.setAttribute("errorCode", ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCode));
        request.getRequestDispatcher("/WEB-INF/view/category-editing-menu.jsp").forward(request, response);
    }
}
