package by.bntu.fitr.poisit.service;

import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getShoppingCartByAccountId(int accountId);
    void addCartItem(int itemId, int accountId, ItemRepository itemRepository);
    void deleteCartItem(int itemCartId, int accountId);
    void purchaseShoppingCart(int accountId);
}
