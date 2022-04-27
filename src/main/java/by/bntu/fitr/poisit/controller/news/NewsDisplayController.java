package by.bntu.fitr.poisit.controller.news;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.NewsRepositoryImpl;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.NewsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsDisplayController", value = "/news-display-servlet")
public class NewsDisplayController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> newsLinks = new NewsServiceImpl(new NewsRepositoryImpl()).getAllNewsLinks();
        request.setAttribute("newsLinks", newsLinks);
        request.setAttribute("categories", new CategoryServiceImpl(new CategoryRepositoryImpl()).getAllCategories());
        request.getRequestDispatcher("/WEB-INF/view/news.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
