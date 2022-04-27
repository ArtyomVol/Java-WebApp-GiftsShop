package by.bntu.fitr.poisit.dao;

import by.bntu.fitr.poisit.dao.repository.ShoppingCartRepository;
import by.bntu.fitr.poisit.entity.ShoppingCart;
import by.bntu.fitr.poisit.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.*;

public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

    @Override
    public List<ShoppingCart> findShoppingCartByAccountId(int accountId) {
        List<ShoppingCart> shoppingCarts = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            shoppingCarts = JDBCUtil.ShoppingCartSQLHandler.selectShoppingCart(FIND_SHOPPING_CART_BY_ACCOUNT_ID,
                    connection, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCarts;
    }

    @Override
    public void addCartItem(int itemId, int accountId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(ADD_CART_ITEM, connection, accountId, itemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartItem(int cartId, int accountId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(DELETE_CART_ITEM, connection, cartId, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void purchaseShoppingCart(int accountId) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(MOVE_ITEMS_FROM_SHOPPING_CART_TO_PURCHASES_BY_ACCOUNT_ID, connection,
                    accountId);
            JDBCUtil.insertDeleteOrUpdate(DELETE_ITEMS_FROM_SHOPPING_CART_BY_ACCOUNT_ID, connection, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
