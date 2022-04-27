package by.bntu.fitr.poisit.fakeObjects;

import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.entity.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeCategoryRepositoryImpl implements CategoryRepository {
    private final List<Category> categories = new ArrayList<>(Arrays.asList(
            new Category(1, "LEGO"), new Category(2, "Книжки"),
            new Category(3, "Мягкие игрушки")
    ));

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category findCategoryByName(String name) {
        return null;
    }

    @Override
    public void editCategory(int categoryId, String newName) {

    }

    @Override
    public void addCategory(String name) {

    }

    @Override
    public void deleteCategory(int categoryId) {

    }
}
