package by.bntu.fitr.poisit.controller.item;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.service.impl.CategoryServiceImpl;
import by.bntu.fitr.poisit.service.impl.ItemServiceImpl;
import by.bntu.fitr.poisit.constants.ErrorConstant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ItemAddingMenuController", value = "/item-adding-menu-servlet")
public class ItemAddingMenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.getRequestDispatcher("/item-adding-menu").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
        Part image = request.getPart("uploaded_file");
        String name = request.getParameter("item_name");
        String description = request.getParameter("item_description");
        String stringCost = request.getParameter("item_cost");
        String imageLink = image.getSubmittedFileName();
        int categoryId = Integer.parseInt(request.getParameter("select_name"));
        List<Byte> errorsCode = itemService.addItem(name, description, stringCost, imageLink, categoryId,
                new CategoryRepositoryImpl());
        if (errorsCode.size() == 1 && errorsCode.contains(ErrorConstant.SUCCESS_ITEM_ADD)) {
            String imagePath = "D:\\CourseWork\\src\\main\\webapp\\media\\" + imageLink;
            OutputStream out;
            InputStream fileContent;
            try {
                out = new FileOutputStream(imagePath);
                fileContent = image.getInputStream();
                int read;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                out.close();
                fileContent.close();
            } catch (IOException fne) {
                fne.printStackTrace();
            }
            request.setAttribute("successCode", ErrorConstant.SUCCESS_ITEM_ADD_MSG);
            request.getRequestDispatcher("/item-adding-menu").forward(request, response);
        }
        else {
            request.setAttribute("itemName", name);
            request.setAttribute("itemDescription", description);
            request.setAttribute("itemCost", stringCost);
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/item-adding-error-handler").forward(request, response);
        }
    }
}
