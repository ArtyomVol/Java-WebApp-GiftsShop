package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import by.bntu.fitr.poisit.service.ItemService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import by.bntu.fitr.poisit.util.InputsChecker;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAllItems();
    }

    @Override
    public List<Item> getAllItemsFromCategory(int categoryId) {
        return itemRepository.findAllItemsInCategory(categoryId);
    }

    @Override
    public Item getItemById(int itemId) {
        return itemRepository.findItemById(itemId);
    }

    @Override
    public void fillItemsInShoppingCarts(List<ShoppingCart> shoppingCarts) {
        if (shoppingCarts != null) {
            itemRepository.setItemsInShoppingCarts(shoppingCarts);
        }
    }

    @Override
    public void fillItemsInPurchases(List<Purchase> purchases) {
        if (purchases != null) {
            itemRepository.setItemsInPurchases(purchases);
        }
    }

    @Override
    public List<Item> getAllItemsContainsStringInNameInCategory(String string, Category category) {
        if (category == null) {
            return itemRepository.findAllItemsContainsStringInName(string);
        } else {
            return itemRepository.findAllItemsContainsStringInNameInCategory(string, category.getCategoryId());
        }
    }

    @Override
    public void deleteItemById(int itemId) {
        itemRepository.deleteItemById(itemId);
    }

    @Override
    public List<Byte> addItem(String name, String description, String stringCost, String imageLink, int categoryId,
                              CategoryRepository categoryRepository) {
        List<Byte> listWithItemAddCodes = new ArrayList<>();
        int cost = 0;
        if (!InputsChecker.checkItemName(name)) {
            listWithItemAddCodes.add(ErrorConstant.INVALID_ITEM_NAME);
        }
        if (!InputsChecker.checkItemDescription(description)) {
            listWithItemAddCodes.add(ErrorConstant.INVALID_ITEM_DESCRIPTION);
        }
        if (!InputsChecker.checkItemCost(stringCost)) {
            listWithItemAddCodes.add(ErrorConstant.INVALID_ITEM_COST);
        } else {
            cost = Integer.parseInt(stringCost);
        }
        if (!InputsChecker.checkImageLink(imageLink)) {
            listWithItemAddCodes.add(ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK);
        }
        if (categoryRepository.findCategoryById(categoryId) == null) {
            listWithItemAddCodes.add(ErrorConstant.INVALID_CATEGORY_ID);
        }
        if (listWithItemAddCodes.size() == 0) {
            itemRepository.addItem(name, description, cost, imageLink, categoryId);
            listWithItemAddCodes.add(ErrorConstant.SUCCESS_ITEM_ADD);
        }
        return listWithItemAddCodes;
    }

    @Override
    public List<Byte> editItem(int itemId, String name, String description, String stringCost, String imageLink,
                               int categoryId, CategoryRepository categoryRepository) {
        List<Byte> listWithItemEditCodes = new ArrayList<>();
        int cost = 0;
        if (!InputsChecker.checkItemName(name)) {
            listWithItemEditCodes.add(ErrorConstant.INVALID_ITEM_NAME);
        }
        if (!InputsChecker.checkItemDescription(description)) {
            listWithItemEditCodes.add(ErrorConstant.INVALID_ITEM_DESCRIPTION);
        }
        if (!InputsChecker.checkItemCost(stringCost)) {
            listWithItemEditCodes.add(ErrorConstant.INVALID_ITEM_COST);
        } else {
            cost = Integer.parseInt(stringCost);
        }
        if (!InputsChecker.checkImageLink(imageLink)) {
            listWithItemEditCodes.add(ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION);
        }
        if (categoryRepository.findCategoryById(categoryId) == null) {
            listWithItemEditCodes.add(ErrorConstant.INVALID_CATEGORY_ID);
        }
        if (itemRepository.findItemById(itemId) == null) {
            listWithItemEditCodes.add(ErrorConstant.INVALID_ITEM_ID);
        }
        if (listWithItemEditCodes.size() == 0) {
            itemRepository.editItem(itemId, name, description, cost, imageLink, categoryId);
            listWithItemEditCodes.add(ErrorConstant.SUCCESS_ITEM_EDIT);
        }
        return listWithItemEditCodes;
    }
}
