package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.entity.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    private static final List<Item> items = new ArrayList<>(Arrays.asList(
            new Item(3, "Телефон", "Дорогой", 999, "phone.png", 2),
            new Item(1, "Кот", "Мягкий", 3, "cat.png", 1),
            new Item(2, "Собака", "Красивая", 4, "dog.jpg", 1)));

    @Test
    void sortItemsByCostDescending_TestSorting_ListOfItemsSortedDescendingByCost() {
        List<Integer> expectedCostList = new ArrayList<>(Arrays.asList(999, 4, 3));
        List<Item> resultItems = items.subList(0, items.size());
        Sorter.sortItemsByCostDescending(resultItems);
        List<Integer> resultCostList = new ArrayList<>();
        for (Item resultItem : resultItems) {
            resultCostList.add(resultItem.getCost());
        }
        assertArrayEquals(expectedCostList.toArray(), resultCostList.toArray());
    }

    @Test
    void sortItemsByCostAscending_TestSorting_ListOfItemsSortedAscendingByCost() {
        List<Integer> expectedCostList = new ArrayList<>(Arrays.asList(3, 4, 999));
        List<Item> resultItems = items.subList(0, items.size());
        Sorter.sortItemsByCostAscending(resultItems);
        List<Integer> resultCostList = new ArrayList<>();
        for (Item resultItem : resultItems) {
            resultCostList.add(resultItem.getCost());
        }
        assertArrayEquals(expectedCostList.toArray(), resultCostList.toArray());
    }

    @Test
    void sortItemsByCostDescending_TestForNull_AbsenceOfNullPointerException() {
        try {
            Sorter.sortItemsByCostDescending(null);
        } catch (NullPointerException e) {
            fail("Should not have thrown nullPointerException");
        }
    }

    @Test
    void sortItemsByCostAscending_TestForNull_AbsenceOfNullPointerException() {
        try {
            Sorter.sortItemsByCostAscending(null);
        } catch (NullPointerException e) {
            fail("Should not have thrown nullPointerException");
        }
    }
}