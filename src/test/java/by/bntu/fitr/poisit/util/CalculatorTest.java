package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static final List<ShoppingCart> shoppingCarts = new ArrayList<>(Arrays.asList(
            new ShoppingCart(1, 1, 3, new Item(3, "Телефон", "Дорогой",
                    999, "phone.png", 2)),
            new ShoppingCart(1, 2, 1, new Item(1, "Кот", "Мягкий", 3,
                    "cat.png", 1)),
            new ShoppingCart(2, 3, 2, new Item(2, "Собака", "Красивая",
                    4, "dog.jpg", 1))));

    private static final List<Purchase> purchases = new ArrayList<>(Arrays.asList(
            new Purchase(1, 1, 3, new Item(3, "Телефон", "Дорогой",
                    999, "phone.png", 2)),
            new Purchase(2, 1, 1, new Item(1, "Кот", "Мягкий",
                    3, "cat.png", 1)),
            new Purchase(3, 2, 2, new Item(2, "Собака", "Красивая",
                    4, "dog.jpg", 1))));

    @Test
    void calculateShoppingCartTotalCost() {
        int resultTotalCost = Calculator.calculateShoppingCartTotalCost(shoppingCarts);
        int expectedTotalCost = 1006;
        assertEquals(expectedTotalCost, resultTotalCost);
    }

    @Test
    void calculatePurchasesTotalCost() {
        int resultTotalCost = Calculator.calculatePurchasesTotalCost(purchases);
        int expectedTotalCost = 1006;
        assertEquals(expectedTotalCost, resultTotalCost);
    }

    @Test
    void calculateShoppingCartTotalCost_TestForNull_AbsenceOfNullPointerException() {
        try {
            Calculator.calculateShoppingCartTotalCost(null);
        } catch (NullPointerException e) {
            fail("Should not have thrown nullPointerException");
        }
    }

    @Test
    void calculatePurchasesTotalCost_TestForNull_AbsenceOfNullPointerException() {
        try {
            Calculator.calculatePurchasesTotalCost(null);
        } catch (NullPointerException e) {
            fail("Should not have thrown nullPointerException");
        }
    }
}