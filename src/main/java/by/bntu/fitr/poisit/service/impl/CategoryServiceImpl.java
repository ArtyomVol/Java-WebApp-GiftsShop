package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.CategoryRepositoryImpl;
import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.constants.Constants;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import by.bntu.fitr.poisit.util.InputsChecker;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public List<Byte> editCategory(int categoryId, String newName) {
        List<Byte> listWithCategoryEditCodes = new ArrayList<>();
        if (categoryRepository.findCategoryByName(newName) != null) {
            listWithCategoryEditCodes.add(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME);
        } else if (!InputsChecker.checkCategoryName(newName)) {
            listWithCategoryEditCodes.add(ErrorConstant.INVALID_CATEGORY_NAME);
        }
        if (categoryRepository.findCategoryById(categoryId) == null) {
            listWithCategoryEditCodes.add(ErrorConstant.INVALID_CATEGORY_ID);
        }
        if (listWithCategoryEditCodes.size() == 0) {
            categoryRepository.editCategory(categoryId, newName);
            listWithCategoryEditCodes.add(ErrorConstant.SUCCESS_CATEGORY_EDIT);
        }
        return listWithCategoryEditCodes;
    }

    @Override
    public List<Byte> addCategory(String name) {
        List<Byte> listWithCategoryAddCodes = new ArrayList<>();
        if (categoryRepository.findCategoryByName(name) != null) {
            listWithCategoryAddCodes.add(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME);

        } else if (!InputsChecker.checkCategoryName(name)) {
            listWithCategoryAddCodes.add(ErrorConstant.INVALID_CATEGORY_NAME);
        }
        if (listWithCategoryAddCodes.size() == 0) {
            categoryRepository.addCategory(name);
            listWithCategoryAddCodes.add(ErrorConstant.SUCCESS_CATEGORY_ADD);
        }
        return listWithCategoryAddCodes;
    }

    @Override
    public List<Byte> deleteCategory(int categoryId, ItemRepository itemRepository) {
        List<Byte> listWithCategoryDeleteCodes = new ArrayList<>();
        if (categoryRepository.findCategoryById(categoryId) == null) {
            listWithCategoryDeleteCodes.add(ErrorConstant.INVALID_CATEGORY_ID);
        }
        if (listWithCategoryDeleteCodes.size() == 0) {
            listWithCategoryDeleteCodes.add(ErrorConstant.SUCCESS_CATEGORY_DELETE);
            Category defaultCategory = categoryRepository.findCategoryByName(Constants.DEFAULT_CATEGORY_NAME);
            List<Item> items = itemRepository.findAllItemsInCategory(categoryId);
            if (items.size() > 0) {
                if (defaultCategory == null) {
                    categoryRepository.addCategory(Constants.DEFAULT_CATEGORY_NAME);
                    defaultCategory =
                            categoryRepository.findCategoryByName(Constants.DEFAULT_CATEGORY_NAME);
                } else if (defaultCategory.getCategoryId() == categoryId) {
                    return listWithCategoryDeleteCodes;
                }
                int defaultCategoryId = defaultCategory.getCategoryId();
                for (Item item : items) {
                    itemRepository.editItem(item.getItemId(), item.getName(), item.getDescription(), item.getCost(),
                            item.getImageLink(), defaultCategoryId);
                }
            }
            categoryRepository.deleteCategory(categoryId);
        }
        return listWithCategoryDeleteCodes;
    }
}
