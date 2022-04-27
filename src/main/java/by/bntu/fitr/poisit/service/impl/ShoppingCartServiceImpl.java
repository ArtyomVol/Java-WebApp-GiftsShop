package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.dao.repository.ShoppingCartRepository;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import by.bntu.fitr.poisit.service.ShoppingCartService;

import java.util.List;


public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<ShoppingCart> getShoppingCartByAccountId(int accountId) {
        return shoppingCartRepository.findShoppingCartByAccountId(accountId);
    }

    @Override
    public void addCartItem(int itemId, int accountId, ItemRepository itemRepository) {
        if ((new ItemServiceImpl(itemRepository)).getItemById(itemId) != null) {
            shoppingCartRepository.addCartItem(itemId, accountId);
        }
    }

    @Override
    public void deleteCartItem(int cartId, int accountId) {
        shoppingCartRepository.deleteCartItem(cartId, accountId);
    }

    @Override
    public void purchaseShoppingCart(int accountId) {
        shoppingCartRepository.purchaseShoppingCart(accountId);
    }

}
