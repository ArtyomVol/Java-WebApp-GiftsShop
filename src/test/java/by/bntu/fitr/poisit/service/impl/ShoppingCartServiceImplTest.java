package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.dao.repository.ShoppingCartRepository;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import by.bntu.fitr.poisit.service.ShoppingCartService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

class ShoppingCartServiceImplTest {
    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @Mock
    private ItemRepository itemRepository;

    private final ShoppingCartService shoppingCartService;
    private final List<ShoppingCart> shoppingCartsMock = new ArrayList<>();
    private final int correctAccountId = 34;
    private final int incorrectAccountId = -2;
    int correctItemId = 2;
    int incorrectItemId = -2;

    @Before
    public void setUp() {
        shoppingCartsMock.add(new ShoppingCart(correctAccountId, 1, 1, new Item()));
        shoppingCartsMock.add(new ShoppingCart(correctAccountId, 2, 2, new Item()));
    }

    public ShoppingCartServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        shoppingCartService = new ShoppingCartServiceImpl(shoppingCartRepository);
        when(shoppingCartRepository.findShoppingCartByAccountId(correctAccountId)).thenReturn(shoppingCartsMock);
        when(shoppingCartRepository.findShoppingCartByAccountId(incorrectAccountId)).thenReturn(null);
        when(itemRepository.findItemById(incorrectItemId)).thenReturn(null);
        when(itemRepository.findItemById(correctItemId)).thenReturn(new Item());
    }

    @Test
    void getShoppingCartByAccountId_TestReturnedWithCorrectAccountId_NotNull() {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartByAccountId(correctAccountId);
        assertNotEquals(shoppingCarts, null);
        verify(shoppingCartRepository).findShoppingCartByAccountId(correctAccountId);
    }

    @Test
    void getShoppingCartByAccountId_TestReturnedWithIncorrectAccountId_Null() {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartByAccountId(incorrectAccountId);
        assertNull(shoppingCarts);
        verify(shoppingCartRepository).findShoppingCartByAccountId(incorrectAccountId);
    }

    @Test
    void getShoppingCartByAccountId_TestReturnedList_ListContainShoppingCartWithAccountId() {
        int accountId = correctAccountId;
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartByAccountId(accountId);
        for (ShoppingCart shoppingCart : shoppingCarts) {
            assertEquals(shoppingCart.getAccountId(), accountId);
        }
    }

    @Test
    void addCartItem_TestActionWithIncorrectItemId_InRepositoryAddCartItemWillNotCall() {
        int itemId = incorrectItemId;
        shoppingCartService.addCartItem(itemId, correctAccountId, itemRepository);
        int wantedNumberOfInvocationsInRepositoryAddCartItem = 0;
        verify(shoppingCartRepository, times(wantedNumberOfInvocationsInRepositoryAddCartItem)).addCartItem(anyInt(),
                anyInt());
    }

    @Test
    void addCartItem_TestActionWithCorrectItemId_InShoppingRepositoryMethodAddCartItemWillCallOneTime() {
        int itemId = correctItemId;
        shoppingCartService.addCartItem(itemId, correctAccountId, itemRepository);
        verify(shoppingCartRepository).addCartItem(anyInt(), anyInt());
    }

    @Test
    void deleteCartItem_TestActionWithAnyParams_InShoppingRepositoryMethodDeleteCartItemWillCallOneTime() {
        int itemCartId = anyInt();
        int accountId = anyInt();
        shoppingCartService.deleteCartItem(itemCartId, accountId);
        verify(shoppingCartRepository).deleteCartItem(anyInt(), anyInt());
    }

    @Test
    void purchaseShoppingCart_TestActionWithAnyParam_InShoppingRepositoryMethodPurchaseShoppingCartWillCallOneTime() {
        int accountId = anyInt();
        shoppingCartService.purchaseShoppingCart(accountId);
        verify(shoppingCartRepository).purchaseShoppingCart(anyInt());
    }
}