package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.PurchasesRepository;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.service.PurchasesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PurchasesServiceImplTest {
    @Mock
    private PurchasesRepository purchasesRepository;

    private final int correctAccountId = 34;
    private final int incorrectAccountId = -2;

    private final PurchasesService purchasesService;

    public PurchasesServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        purchasesService = new PurchasesServiceImpl(purchasesRepository);
        List<Purchase> purchasesMock = new ArrayList<>(Arrays.asList(
                new Purchase(1, correctAccountId, 1, new Item()),
                new Purchase(2, correctAccountId, 5, new Item()),
                new Purchase(3, correctAccountId, 4, new Item())));
        when(purchasesRepository.findPurchasesByAccountId(correctAccountId)).thenReturn(purchasesMock);
        when(purchasesRepository.findPurchasesByAccountId(incorrectAccountId)).thenReturn(null);
    }

    @Test
    void getAllPurchases_TestReturnedWithCorrectAccountId_NotNull() {
        List<Purchase> purchases = purchasesService.getAllPurchases(correctAccountId);
        assertNotEquals(purchases, null);
        verify(purchasesRepository).findPurchasesByAccountId(correctAccountId);
    }

    @Test
    void getAllPurchases_TestReturnedWithIncorrectAccountId_Null() {
        List<Purchase> purchases = purchasesService.getAllPurchases(incorrectAccountId);
        assertNull(purchases);
        verify(purchasesRepository).findPurchasesByAccountId(incorrectAccountId);
    }

    @Test
    void getAllPurchases_TestReturnedList_ListContainShoppingCartWithAccountId() {
        int accountId = correctAccountId;
        List<Purchase> purchases = purchasesService.getAllPurchases(accountId);
        verify(purchasesRepository).findPurchasesByAccountId(accountId);
        for (Purchase shoppingCart : purchases) {
            assertEquals(shoppingCart.getAccountId(), accountId);
        }
    }
}