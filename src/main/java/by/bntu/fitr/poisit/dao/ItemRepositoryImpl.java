package by.bntu.fitr.poisit.dao;

import by.bntu.fitr.poisit.dao.repository.ItemRepository;
import by.bntu.fitr.poisit.entity.Item;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import by.bntu.fitr.poisit.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.*;

public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public List<Item> findAllItems() {
        List<Item> items = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findAllItemsInCategory(int categoryId) {
        List<Item> items = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS_IN_CATEGORY, connection, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findItemById(int itemId) {
        Item item = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            item = JDBCUtil.ItemSQLHandler.selectItem(FIND_ITEM_BY_ID, connection, itemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void setItemsInShoppingCarts(List<ShoppingCart> shoppingCarts) {
        for (ShoppingCart shoppingCart : shoppingCarts) {
            shoppingCart.setItem(findItemById(shoppingCart.getItemId()));
        }
    }

    @Override
    public void setItemsInPurchases(List<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            purchase.setItem(findItemById(purchase.getItemId()));
        }
    }

    @Override
    public void deleteItemById(int itemId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(DELETE_ITEM_BY_ID, connection, itemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addItem(String name, String description, int cost, String imageLink, int categoryId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(ADD_ITEM, connection, name, description, cost, imageLink, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editItem(int itemId, String name, String description, int cost, String imageLink, int categoryId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(EDIT_ITEM, connection, name, description, cost, imageLink, categoryId, itemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAllItemsContainsStringInNameInCategory(String string, int categoryId) {
        List<Item> items = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS_CONTAINS_STRING_IN_NAME_IN_CATEGORY, connection,
                    string, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findAllItemsContainsStringInName(String string) {
        List<Item> items = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS_CONTAINS_STRING_IN_NAME, connection, string);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

}
