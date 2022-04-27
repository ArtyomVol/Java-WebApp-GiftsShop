package by.bntu.fitr.poisit.service;

import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
    Category getCategoryByName(String name);
    List<Byte> editCategory(int categoryId, String newName);
    List<Byte> addCategory(String name);
    List<Byte> deleteCategory(int categoryId, ItemRepository itemRepository);
}
