package by.bntu.fitr.poisit.controller.news;

import by.bntu.fitr.poisit.dao.NewsRepositoryImpl;
import by.bntu.fitr.poisit.service.NewsService;
import by.bntu.fitr.poisit.service.impl.NewsServiceImpl;
import by.bntu.fitr.poisit.constants.ErrorConstant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@MultipartConfig
@WebServlet(name = "NewsAddingMenuController", value = "/news-adding-menu-servlet")
public class NewsAddingMenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsService newsService = new NewsServiceImpl(new NewsRepositoryImpl());
        Part image = request.getPart("uploaded_file");
        String imageLink = image.getSubmittedFileName();
        List<Byte> errorsCode = newsService.addNews(imageLink);
        if (errorsCode.size() == 1 && errorsCode.contains(ErrorConstant.SUCCESS_NEWS_ADD)) {
            String imagePath = "D:\\CourseWork\\src\\main\\webapp\\media\\" + imageLink;
            OutputStream out;
            InputStream fileContent;
            try {
                out = new FileOutputStream(imagePath);
                fileContent = image.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                out.close();
                fileContent.close();
            } catch (IOException fne) {
                fne.printStackTrace();
            }
            request.setAttribute("successCode", ErrorConstant.SUCCESS_NEWS_ADD_MSG);
            request.getRequestDispatcher("/news-adding-menu").forward(request, response);
        }
        else {
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/news-adding-error-handler").forward(request, response);
        }
    }
}
