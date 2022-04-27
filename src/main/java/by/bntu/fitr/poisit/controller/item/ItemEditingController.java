package by.bntu.fitr.poisit.controller.item;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.entity.Item;
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
import java.util.Objects;

@MultipartConfig
@WebServlet(name = "ItemEditingController", value = "/item-editing-servlet")
public class ItemEditingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("item_id"));
        ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
        Item item = itemService.getItemById(itemId);
        request.setAttribute("item", item);
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.getRequestDispatcher("/item-editing-menu").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());
        Part image = request.getPart("uploaded_file");
        String name = request.getParameter("item_name");
        String description = request.getParameter("item_description");
        String stringCost = request.getParameter("item_cost");
        String stringItemId = request.getParameter("item_id");
        int itemId = Integer.parseInt(stringItemId);
        int categoryId = Integer.parseInt(request.getParameter("select_name"));
        Item item = itemService.getItemById(itemId);
        String imageLink = image.getSubmittedFileName();
        boolean imageIsNew = true;
        if(Objects.equals(imageLink, "")) {
            imageLink = item.getImageLink();
            imageIsNew = false;
        }
        List<Byte> errorsCode = itemService.editItem(itemId, name, description, stringCost, imageLink, categoryId,
                new CategoryRepositoryImpl());
        request.setAttribute("categories", new CategoryServiceImpl(new CategoryRepositoryImpl()).getAllCategories());
        request.setAttribute("item", item);
        if (errorsCode.size() == 1 && errorsCode.contains(ErrorConstant.SUCCESS_ITEM_EDIT)) {
            if (imageIsNew) {
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
            }
            request.setAttribute("successCode", ErrorConstant.SUCCESS_ITEM_EDIT_MSG);
            request.getRequestDispatcher("/item-editing-menu").forward(request, response);
        }
        else {
            request.setAttribute("errorsCode", errorsCode);
            request.getRequestDispatcher("/item-editing-error-handler").forward(request, response);
        }
    }
}
