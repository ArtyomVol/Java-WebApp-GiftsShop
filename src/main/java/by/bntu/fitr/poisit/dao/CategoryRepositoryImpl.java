package by.bntu.fitr.poisit.dao;

import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.*;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection()) {
            categories = JDBCUtil.CategorySQLHandler.selectCategories(FIND_ALL_CATEGORIES,
                    connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        Category category = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            category = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_ID, connection,
                    categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category findCategoryByName(String name) {
        Category category = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            category = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_NAME, connection,
                    name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void editCategory(int categoryId, String newName) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(EDIT_CATEGORY_BY_ID, connection, newName, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(String name) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(ADD_CATEGORY, connection, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(DELETE_CATEGORY_BY_ID, connection, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
