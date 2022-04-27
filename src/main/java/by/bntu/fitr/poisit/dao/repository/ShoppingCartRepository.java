package by.bntu.fitr.poisit.dao.repository;

import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository {
    List<ShoppingCart> findShoppingCartByAccountId(int accountId);
    void addCartItem(int itemId, int accountId);
    void deleteCartItem(int itemCartId, int accountId);
    void purchaseShoppingCart(int accountId);

}
