package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.entity.ShoppingCart;

import java.util.List;

public class Calculator {

    public static int calculateShoppingCartTotalCost(List<ShoppingCart> shoppingCarts) {
        int totalCost = 0;
        if (shoppingCarts != null) {
            for (ShoppingCart shoppingCart : shoppingCarts) {
                totalCost += shoppingCart.getItem().getCost();
            }
        }
        return totalCost;
    }

    public static int calculatePurchasesTotalCost(List<Purchase> purchases) {
        int totalCost = 0;
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                totalCost += purchase.getItem().getCost();
            }
        }
        return totalCost;
    }
}
