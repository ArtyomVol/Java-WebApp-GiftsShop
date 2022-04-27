package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop"
                    , "postgres"
                    , "01112001");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertDeleteOrUpdate(String sqlQuery, Connection connection, Object... params) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            prepareStatement(preparedStatement, params);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prepareStatement(PreparedStatement preparedStatement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
    }

    public static class AccountSQLHandler {
        private static Account accountResultSet(ResultSet resultSet) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("user_id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
            account.setRoleId(resultSet.getInt("role_id"));
            account.setFirstName(resultSet.getString("first_name"));
            account.setLastName(resultSet.getString("last_name"));
            return account;
        }

        public static Account selectAccount(String sqlQuery, Connection connection, Object... params) {
            Account account = null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    account = accountResultSet(resultSet);
                }

                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return account;
        }
    }

    public static class CategorySQLHandler {
        public static Category categoryResultSet(ResultSet resultSet) throws SQLException {
            Category category = new Category();
            category.setCategoryId(resultSet.getInt("category_id"));
            category.setName(resultSet.getString("name"));
            return category;
        }

        public static Category selectCategory(String sqlQuery, Connection connection, Object... params) {
            Category category = null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    category = categoryResultSet(resultSet);
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return category;
        }

        public static List<Category> selectCategories(String sqlQuery, Connection connection, Object... params) {
            List<Category> categories = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Category category = categoryResultSet(resultSet);
                    categories.add(category);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return categories;
        }
    }

    public static class ItemSQLHandler {
        private static Item itemResultSet(ResultSet resultSet) throws SQLException {
            Item item = new Item();
            item.setItemId(resultSet.getInt("item_id"));
            item.setName(resultSet.getString("name"));
            item.setDescription(resultSet.getString("description"));
            item.setCost(resultSet.getInt("cost"));
            item.setImageLink(resultSet.getString("image_link"));
            item.setCategoryId(resultSet.getInt("category_id"));
            return item;
        }

        public static Item selectItem(String sqlQuery, Connection connection, Object... params) {
            Item item = null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    item = itemResultSet(resultSet);
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return item;
        }

        public static List<Item> selectItems(String sqlQuery, Connection connection, Object... params) {
            List<Item> items = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Item item = itemResultSet(resultSet);
                    items.add(item);
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return items;
        }
    }

    public static class ShoppingCartSQLHandler {
        private static void shoppingCartResultSet(ShoppingCart shoppingCart, ResultSet resultSet) throws SQLException {
            shoppingCart.setId(resultSet.getInt("id"));
            shoppingCart.setItemId(resultSet.getInt("item_id"));
        }

        /**
         * fill the cart by account id
         *
         * @param params: accountId
         */
        public static List<ShoppingCart> selectShoppingCart(String sqlQuery, Connection connection, Object... params) {

            List<ShoppingCart> shoppingCarts = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();
                int accountId = (int) params[0];
                while (resultSet.next()) {
                    ShoppingCart shoppingCart = new ShoppingCart();
                    shoppingCart.setAccountId(accountId);
                    shoppingCartResultSet(shoppingCart, resultSet);
                    shoppingCarts.add(shoppingCart);
                }
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return shoppingCarts;
        }
    }

    public static class NewsSQLHandler {
        public static List<String> selectNews(String sqlQuery, Connection connection, Object... params) {
            List<String> news = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    news.add(resultSet.getString("link"));
                }
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return news;
        }
    }

    public static class PurchaseSQLHandler {
        private static void purchaseResultSet(Purchase purchase, ResultSet resultSet) throws SQLException {
            purchase.setPurchaseId(resultSet.getInt("purchase_id"));
            purchase.setItemId(resultSet.getInt("item_id"));
        }

        /**
         * fill the cart by account id
         *
         * @param params: accountId
         */
        public static List<Purchase> selectPurchases(String sqlQuery, Connection connection, Object... params) {
            List<Purchase> purchases = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                prepareStatement(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();
                int accountId = (int) params[0];
                while (resultSet.next()) {
                    Purchase purchase = new Purchase();
                    purchase.setAccountId(accountId);
                    purchaseResultSet(purchase, resultSet);
                    purchases.add(purchase);
                }
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return purchases;
        }
    }
}
