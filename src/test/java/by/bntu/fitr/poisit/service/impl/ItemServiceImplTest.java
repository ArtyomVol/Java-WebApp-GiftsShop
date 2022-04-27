package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.fakeObjects.FakeCategoryRepositoryImpl;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;

    private final ItemService itemService;
    private final CategoryRepository categoryRepository = new FakeCategoryRepositoryImpl();
    private final String correctItemName = "Плюшевый медведь";
    private final String correctItemDescription = "Самый лучший подарок, которой можно пожелать.";
    private final String correctItemCost = "12";
    private final String correctImageLink = "soft_bear.png";
    private final int correctCategoryId = 1;
    private final int incorrectCategoryId = -1;
    private final int correctItemId = 1;
    private final Item item = new Item(1, "Кот", "Мягкий", 3, "cat.png", 1);
    private final int incorrectItemId = -1;
    private final List<Item> items = new ArrayList<>(Arrays.asList(
            new Item(3, "Телефон", "Дорогой", 999, "phone.png", 2),
            new Item(1, "Кот", "Мягкий", 3, "cat.png", 1),
            new Item(2, "Собака", "Красивая", 4, "dog.jpg", 1)));
    private final List<Item> itemsFromCategory1 = new ArrayList<>(Arrays.asList(
            new Item(1, "Кот", "Мягкий", 3, "cat.png", 1),
            new Item(2, "Собака", "Красивая", 4, "dog.jpg", 1)));

    public ItemServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        itemService = new ItemServiceImpl(itemRepository);
        when(itemRepository.findAllItems()).thenReturn(items);
        when(itemRepository.findAllItemsInCategory(incorrectCategoryId)).thenReturn(null);
        when(itemRepository.findAllItemsInCategory(correctCategoryId)).thenReturn(itemsFromCategory1);
        when(itemRepository.findItemById(incorrectItemId)).thenReturn(null);
        when(itemRepository.findItemById(correctItemId)).thenReturn(item);
    }

    @Test
    void getAllItems_TestResultOfMethod_MatchItemsList() {
        List<Item> resultItems = itemService.getAllItems();
        assertArrayEquals(resultItems.toArray(), items.toArray());
        verify(itemRepository).findAllItems();
    }

    @Test
    void getAllItemsFromCategory_TestResultWithIncorrectCategoryId_Null() {
        int categoryId = incorrectCategoryId;
        List<Item> resultItems = itemService.getAllItemsFromCategory(categoryId);
        assertNull(resultItems);
        verify(itemRepository).findAllItemsInCategory(categoryId);
    }

    @Test
    void getAllItemsFromCategory_TestResultWithCorrectCategoryId_MatchItemsList() {
        int categoryId = correctCategoryId;
        List<Item> resultItems = itemService.getAllItemsFromCategory(categoryId);
        assertArrayEquals(itemsFromCategory1.toArray(), resultItems.toArray());
        verify(itemRepository).findAllItemsInCategory(categoryId);
    }

    @Test
    void getItemById_TestResultWithIncorrectItemId_Null() {
        int itemId = incorrectItemId;
        Item resultItem = itemService.getItemById(itemId);
        assertNull(resultItem);
        verify(itemRepository).findItemById(itemId);
    }

    @Test
    void getItemById_TestResultWithCorrectItemId_MatchItem() {
        int itemId = correctItemId;
        Item resultItem = itemService.getItemById(itemId);
        assertEquals(item, resultItem);
        verify(itemRepository).findItemById(itemId);
    }

    @Test
    void fillItemsInShoppingCarts_TestActionWithNull_InRepositorySetItemsInShoppingCartsWillNotCall() {
        itemService.fillItemsInShoppingCarts(null);
        int wantedNumberOfInvocationsInRepositorySetItemsInShoppingCarts = 0;
        verify(itemRepository, times(wantedNumberOfInvocationsInRepositorySetItemsInShoppingCarts)).
                setItemsInShoppingCarts(any());
    }

    @Test
    void fillItemsInPurchases_TestActionWithNull_InRepositorySetItemsInPurchasesWillNotCall() {
        itemService.fillItemsInPurchases(null);
        int wantedNumberOfInvocationsInRepositorySetItemsInPurchases = 0;
        verify(itemRepository, times(wantedNumberOfInvocationsInRepositorySetItemsInPurchases)).
                setItemsInPurchases(any());
    }

    @Test
    void getAllItemsContainsStringInNameInCategory_TestActionWhenCategoryIdIsNull_InRepositoryWillCallFindAllItemsContainsStringInName() {
        String searchString = "some text";
        itemService.getAllItemsContainsStringInNameInCategory(searchString, null);
        verify(itemRepository).findAllItemsContainsStringInName(anyString());
        verify(itemRepository, times(0)).findAllItemsContainsStringInNameInCategory(anyString(),
                anyInt());
    }

    @Test
    void getAllItemsContainsStringInNameInCategory_TestActionWhenCategoryIdIsExist_InRepositoryWillCallFindAllItemsContainsStringInName() {
        String searchString = "some text";
        Category category = new Category(1, "LEGO");
        itemService.getAllItemsContainsStringInNameInCategory(searchString, category);
        verify(itemRepository).findAllItemsContainsStringInNameInCategory(anyString(), anyInt());
        verify(itemRepository, times(0)).findAllItemsContainsStringInName(anyString());
    }

    @Test
    void deleteItemById() {
        int itemId = correctItemId;
        itemService.deleteItemById(itemId);
        verify(itemRepository).deleteItemById(itemId);
    }

    @Test
    void addItem_TestInvalidItemName_ListContainConstantINVALID_ITEM_NAME() {
        String itemName1 = "Кот";
        String itemName2 = "Лучший подарок☺";
        List<Byte> listWithItemAddCodes1 = itemService.addItem(itemName1, correctItemDescription, correctItemCost, correctImageLink,
                correctCategoryId, categoryRepository);
        List<Byte> listWithItemAddCodes2 = itemService.addItem(itemName2, correctItemDescription, correctItemCost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_NAME;
        assertTrue(listWithItemAddCodes1.contains(expectedRegistrationCode));
        assertTrue(listWithItemAddCodes2.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestValidItemName_ListNotContainConstantINVALID_ITEM_NAME() {
        String itemName = "Лучший подарок";
        List<Byte> listWithItemAddCodes = itemService.addItem(itemName, correctItemDescription, correctItemCost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_NAME;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestInvalidItemDescription_ListContainConstantINVALID_ITEM_DESCRIPTION() {
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 501; ++i) {
            description.append("a");
        }
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, description.toString(), correctItemCost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_DESCRIPTION;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestValidItemDescription_ListNotContainConstantINVALID_ITEM_DESCRIPTION() {
        String description = "Лучший подарок для вашего друга.";
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, description, correctItemCost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_DESCRIPTION;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestInvalidItemCost_ListContainConstantINVALID_ITEM_COST() {
        String cost = "";
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, cost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_COST;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestValidItemCost_ListNotContainConstantINVALID_ITEM_COST() {
        String cost = "21";
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, cost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_COST;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestInvalidItemImageLinkExpression_ListContainConstantINVALID_ITEM_IMAGE_LINK_EXPRESSION() {
        String imageLink = "cat.txt";
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, correctItemCost, imageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestValidItemImageLinkExpression_ListNotContainConstantINVALID_ITEM_IMAGE_LINK_EXPRESSION() {
        String imageLink = "bear.jpg";
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, correctItemCost, imageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestInvalidItemCategoryID_ListContainConstantINVALID_ITEM_CATEGORY_ID() {
        int categoryId = 1234;
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, correctItemCost, correctImageLink,
                categoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestValidItemCategoryID_ListNotContainConstantINVALID_ITEM_CATEGORY_ID() {
        int categoryId = 3;
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, correctItemCost, correctImageLink,
                categoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestAllItemAddDataIsCorrect_ListContainConstantSUCCESS_ITEM_ADD() {
        List<Byte> listWithItemAddCodes = itemService.addItem(correctItemName, correctItemDescription, correctItemCost, correctImageLink,
                correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.SUCCESS_ITEM_ADD;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addItem_TestAllDataIsIncorrect_ListContainConstantAllConstantItemAddErrorsCode() {
        String itemName = "Котик☺";
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 501; ++i) {
            description.append("a");
        }
        String cost = "";
        String imageLink = "cat.txt";
        int categoryId = 1234;
        List<Byte> listWithItemAddCodes = itemService.addItem(itemName, description.toString(), cost, imageLink,
                categoryId, categoryRepository);
        List<Byte> expectedListWithErrorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME,
                ErrorConstant.INVALID_ITEM_DESCRIPTION, ErrorConstant.INVALID_ITEM_COST,
                ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK, ErrorConstant.INVALID_CATEGORY_ID));
        for (byte errorCode : expectedListWithErrorsCode) {
            assertTrue(listWithItemAddCodes.contains(errorCode));
        }
    }

    @Test
    void editItem_TestInvalidItemName_ListContainConstantINVALID_ITEM_NAME() {
        String itemName1 = "Кот";
        String itemName2 = "Лучший подарок☺";
        List<Byte> listWithItemAddCodes1 = itemService.editItem(correctItemId, itemName1, correctItemDescription,
                correctItemCost, correctImageLink, correctCategoryId, categoryRepository);
        List<Byte> listWithItemAddCodes2 = itemService.editItem(correctItemId, itemName2, correctItemDescription,
                correctItemCost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_NAME;
        assertTrue(listWithItemAddCodes1.contains(expectedRegistrationCode));
        assertTrue(listWithItemAddCodes2.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestValidItemName_ListNotContainConstantINVALID_ITEM_NAME() {
        String itemName = "Лучший подарок";
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, itemName, correctItemDescription,
                correctItemCost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_NAME;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestInvalidItemDescription_ListContainConstantINVALID_ITEM_DESCRIPTION() {
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 501; ++i) {
            description.append("a");
        }
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, description.toString(),
                correctItemCost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_DESCRIPTION;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestValidItemDescription_ListNotContainConstantINVALID_ITEM_DESCRIPTION() {
        String description = "Лучший подарок для вашего друга.";
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, description,
                correctItemCost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_DESCRIPTION;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestInvalidItemCost_ListContainConstantINVALID_ITEM_COST() {
        String cost = "";
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, correctItemDescription,
                cost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_COST;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestValidItemCost_ListNotContainConstantINVALID_ITEM_COST() {
        String cost = "21";
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, correctItemDescription,
                cost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_COST;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestInvalidItemImageLinkExpression_ListContainConstantINVALID_ITEM_IMAGE_LINK_EXPRESSION() {
        String imageLink = "cat.txt";
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, correctItemDescription,
                correctItemCost, imageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestValidItemImageLinkExpression_ListNotContainConstantINVALID_ITEM_IMAGE_LINK_EXPRESSION() {
        String imageLink = "bear.jpg";
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, correctItemDescription,
                correctItemCost, imageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestInvalidItemCategoryID_ListContainConstantINVALID_ITEM_CATEGORY_ID() {
        int categoryId = 1234;
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, correctItemDescription,
                correctItemCost, correctImageLink, categoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertTrue(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestValidItemCategoryID_ListNotContainConstantINVALID_ITEM_CATEGORY_ID() {
        int categoryId = 3;
        List<Byte> listWithItemAddCodes = itemService.editItem(correctItemId, correctItemName, correctItemDescription,
                correctItemCost, correctImageLink, categoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.INVALID_CATEGORY_ID;
        assertFalse(listWithItemAddCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestAllItemAddDataIsCorrect_ListContainConstantSUCCESS_ITEM_ADD() {
        List<Byte> listWithItemEditCodes = itemService.editItem(correctItemId, correctItemName,
                correctItemDescription, correctItemCost, correctImageLink, correctCategoryId, categoryRepository);
        byte expectedRegistrationCode = ErrorConstant.SUCCESS_ITEM_EDIT;
        assertTrue(listWithItemEditCodes.contains(expectedRegistrationCode));
    }

    @Test
    void editItem_TestAllDataIsIncorrect_ListContainConstantAllConstantItemEditErrorsCode() {
        String itemName = "Котик☺";
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 501; ++i) {
            description.append("a");
        }
        String cost = "";
        String imageLink = "cat.txt";
        int categoryId = 1234;
        List<Byte> listWithItemEditCodes = itemService.editItem(incorrectItemId, itemName, description.toString(), cost, imageLink,
                categoryId, categoryRepository);
        List<Byte> expectedListWithErrorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_ID,
                ErrorConstant.INVALID_ITEM_NAME, ErrorConstant.INVALID_ITEM_DESCRIPTION,
                ErrorConstant.INVALID_ITEM_COST, ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION,
                ErrorConstant.INVALID_CATEGORY_ID));
        for (byte errorCode : expectedListWithErrorsCode) {
            assertTrue(listWithItemEditCodes.contains(errorCode));
        }
    }
}