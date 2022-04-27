package by.bntu.fitr.poisit.service;

import by.bntu.fitr.poisit.dao.repository.CategoryRepository;
import by.bntu.fitr.poisit.entity.Category;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.entity.ShoppingCart;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    List<Item> getAllItemsFromCategory(int categoryId);
    List<Item> getAllItemsContainsStringInNameInCategory(String string, Category category);
    Item getItemById(int itemId);
    void fillItemsInShoppingCarts(List<ShoppingCart> shoppingCarts);
    void fillItemsInPurchases(List<Purchase> purchases);
    void deleteItemById(int itemId);
    List<Byte> addItem(String name, String description, String stringCost, String imageLink, int categoryId,
                       CategoryRepository categoryRepository);
    List<Byte> editItem(int itemId, String name, String description, String stringCost, String imageLink, int categoryId,
                         CategoryRepository categoryRepository);
}
