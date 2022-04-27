package by.bntu.fitr.poisit.dao.repository;


import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.entity.ShoppingCart;

import java.util.List;

public interface ItemRepository {
    List<Item> findAllItems();
    List<Item> findAllItemsInCategory(int categoryId);
    List<Item> findAllItemsContainsStringInNameInCategory(String string, int categoryId);
    List<Item> findAllItemsContainsStringInName(String string);
    Item findItemById(int itemId);
    void setItemsInShoppingCarts(List<ShoppingCart> shoppingCarts);
    void setItemsInPurchases(List<Purchase> purchases);
    void deleteItemById(int itemId);
    void addItem(String name, String description, int cost, String imageLink, int categoryId);
    void editItem(int itemId, String name, String description, int cost, String imageLink, int categoryId);

}
