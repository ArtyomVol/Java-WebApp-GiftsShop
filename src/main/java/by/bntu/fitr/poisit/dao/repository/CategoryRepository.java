package by.bntu.fitr.poisit.dao.repository;


import by.bntu.fitr.poisit.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAllCategories();
    Category findCategoryById(int categoryId);
    Category findCategoryByName(String name);
    void editCategory(int categoryId, String newName);
    void addCategory(String name);
    void deleteCategory(int categoryId);
}
