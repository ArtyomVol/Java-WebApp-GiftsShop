package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.entity.Item;

import java.util.List;

public class Sorter {

    public static void sortItemsByCostDescending(List<Item> items) {
        if (items != null) {
            int h, i, j;
            for (h = items.size() / 2; h > 0; h = h / 2) {
                for (i = 0; i < items.size() - h; i++) {
                    for (j = i; j >= 0; j = j - h) {
                        if (items.get(j).getCost() < items.get(j + h).getCost()) {
                            swap(items, j, j + h);
                        } else {
                            j = 0;
                        }
                    }
                }
            }
        }
    }

    public static void sortItemsByCostAscending(List<Item> items) {
        if (items != null) {
            int h, i, j;
            for (h = items.size() / 2; h > 0; h = h / 2) {
                for (i = 0; i < items.size() - h; i++) {
                    for (j = i; j >= 0; j = j - h) {
                        if (items.get(j).getCost() > items.get(j + h).getCost()) {
                            swap(items, j, j + h);
                        } else {
                            j = 0;
                        }
                    }
                }
            }
        }
    }

    private static void swap(List<Item> items, int i, int j) {
        Item buf = items.get(i);
        items.set(i, items.get(j));
        items.set(j, buf);
    }
}
