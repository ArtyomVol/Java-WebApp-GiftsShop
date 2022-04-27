package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.ItemRepositoryImpl;
import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.service.CategoryService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;
    private final int correctCategoryId = 1;
    private final int incorrectCategoryId = -1;
    private final String correctCategoryName = "LEGO";
    private final String newCategoryName = "someNewCategoryName";
    private final Category category = new Category(correctCategoryId, correctCategoryName);
    private final List<Category> categories = new ArrayList<>(Arrays.asList(
            new Category(1, "LEGO"), new Category(2, "Книжки"),
            new Category(3, "Мягкие игрушки")
    ));
    private final CategoryService categoryService;

    public CategoryServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository);
        when(categoryRepository.findAllCategories()).thenReturn(categories);
        when(categoryRepository.findCategoryById(correctCategoryId)).thenReturn(category);
        when(categoryRepository.findCategoryById(incorrectCategoryId)).thenReturn(null);
        when(categoryRepository.findCategoryByName(correctCategoryName)).thenReturn(category);
    }

    @Test
    void getAllCategories_TestResultOfMethod_CorrectCategoryList() {
        List<Category> resultCategories = categoryService.getAllCategories();
        assertArrayEquals(resultCategories.toArray(), categories.toArray());
        verify(categoryRepository).findAllCategories();
    }

    @Test
    void getCategoryById_TestResultWithIncorrectCategoryId_Null() {
        int categoryId = incorrectCategoryId;
        Category resultCategory = categoryService.getCategoryById(categoryId);
        assertNull(resultCategory);
        verify(categoryRepository).findCategoryById(categoryId);
    }

    @Test
    void getCategoryById_TestResultWithCorrectCategoryId_MatchItem() {
        int categoryId = correctCategoryId;
        Category resultCategory = categoryService.getCategoryById(categoryId);
        assertEquals(category, resultCategory);
        verify(categoryRepository).findCategoryById(categoryId);
    }

    @Test
    void getCategoryByName_TestResultWithIncorrectCategoryName_Null() {
        String incorrectCategoryName = "Some wrong category○";
        Category resultCategory = categoryService.getCategoryByName(incorrectCategoryName);
        assertNull(resultCategory);
        verify(categoryRepository).findCategoryByName(incorrectCategoryName);
    }

    @Test
    void getCategoryByName_TestResultWithCorrectCategoryName_MatchItem() {
        String categoryName = correctCategoryName;
        Category resultCategory = categoryService.getCategoryByName(categoryName);
        assertEquals(category, resultCategory);
        verify(categoryRepository).findCategoryByName(categoryName);
    }

    @Test
    void editCategory_TestInvalidCategoryName_ListContainConstantINVALID_CATEGORY_NAME() {
        String categoryName1 = "a";
        List<Byte> listWithCategoryEditCodes1 = categoryService.editCategory(correctCategoryId, categoryName1);
        List<Byte> listWithCategoryEditCodes2 = categoryService.editCategory(correctCategoryId, null);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_NAME;
        assertTrue(listWithCategoryEditCodes1.contains(expectedRegistrationCode));
        assertTrue(listWithCategoryEditCodes2.contains(expectedRegistrationCode));
    }

    @Test
    void editCategory_TestValidCategoryName_ListNotContainConstantINVALID_CATEGORY_NAME() {
        List<Byte> listWithCategoryEditCodes = categoryService.editCategory(correctCategoryId, correctCategoryName);
        byte unexpectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_NAME;
        assertFalse(listWithCategoryEditCodes.contains(unexpectedRegistrationCode));
    }

    @Test
    void editCategory_TestInvalidCategoryId_ListContainConstantINVALID_CATEGORY_NAME() {
        List<Byte> listWithCategoryEditCodes = categoryService.editCategory(incorrectCategoryId, correctCategoryName);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertTrue(listWithCategoryEditCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editCategory_TestValidCategoryId_ListNotContainConstantINVALID_CATEGORY_NAME() {
        List<Byte> listWithCategoryEditCodes = categoryService.editCategory(correctCategoryId, correctCategoryName);
        byte unexpectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertFalse(listWithCategoryEditCodes.contains(unexpectedRegistrationCode));
    }

    @Test
    void editCategory_TestAllEditCategoryDataIsCorrect_ListContainConstantSUCCESS_ITEM_ADD() {
        List<Byte> listWithCategoryEditCodes = categoryService.editCategory(correctCategoryId, newCategoryName);
        byte expectedRegistrationCode = ErrorConstant.SUCCESS_CATEGORY_EDIT;
        assertTrue(listWithCategoryEditCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addCategory_TestInvalidCategoryName_ListContainConstantINVALID_CATEGORY_NAME() {
        String categoryName1 = "a";
        List<Byte> listWithCategoryEditCodes1 = categoryService.addCategory(categoryName1);
        List<Byte> listWithCategoryEditCodes2 = categoryService.addCategory(null);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_NAME;
        assertTrue(listWithCategoryEditCodes1.contains(expectedRegistrationCode));
        assertTrue(listWithCategoryEditCodes2.contains(expectedRegistrationCode));
    }

    @Test
    void addCategory_TestValidCategoryName_ListNotContainConstantINVALID_CATEGORY_NAME() {
        List<Byte> listWithCategoryEditCodes = categoryService.addCategory(correctCategoryName);
        byte unexpectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_NAME;
        assertFalse(listWithCategoryEditCodes.contains(unexpectedRegistrationCode));
    }

    @Test
    void addCategory_TestAllAddCategoryDataIsCorrect_ListContainConstantSUCCESS_ITEM_EDIT() {
        List<Byte> listWithCategoryEditCodes = categoryService.addCategory(newCategoryName);
        byte expectedRegistrationCode = ErrorConstant.SUCCESS_CATEGORY_ADD;
        assertTrue(listWithCategoryEditCodes.contains(expectedRegistrationCode));
    }

    @Test
    void deleteCategory_TestInvalidCategoryId_ListContainConstantINVALID_CATEGORY_NAME() {
        List<Byte> listWithCategoryEditCodes = categoryService.deleteCategory(incorrectCategoryId, new ItemRepositoryImpl());
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertTrue(listWithCategoryEditCodes.contains(expectedRegistrationCode));
    }

    @Test
    void deleteCategory_TestValidCategoryId_ListNotContainConstantINVALID_CATEGORY_NAME() {
        List<Byte> listWithCategoryEditCodes = categoryService.deleteCategory(correctCategoryId, new ItemRepositoryImpl());
        byte unexpectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertFalse(listWithCategoryEditCodes.contains(unexpectedRegistrationCode));
    }

    @Test
    void deleteCategory_TestAllItemAddDataIsCorrect_ListContainConstantSUCCESS_ITEM_ADD() {
        List<Byte> listWithCategoryEditCodes = categoryService.deleteCategory(correctCategoryId, new ItemRepositoryImpl());
        byte expectedRegistrationCode = ErrorConstant.SUCCESS_CATEGORY_DELETE;
        assertTrue(listWithCategoryEditCodes.contains(expectedRegistrationCode));
    }
}