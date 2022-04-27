package by.bntu.fitr.poisit.constants;

public class SqlQueryConstants {
    public static final String FIND_ACCOUNT_BY_USERNAME = "SELECT * FROM account WHERE Username = ?";
    public static final String ADD_ACCOUNT = "INSERT INTO account(username, password, first_name, last_name)" +
            " VALUES(?, ?, ?, ?)";
    public static final String FIND_ALL_CATEGORIES = "SELECT * FROM category";
    public static final String FIND_CATEGORY_BY_ID = "SELECT * FROM category WHERE category_id = ?";
    public static final String FIND_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name = ?";
    public static final String EDIT_CATEGORY_BY_ID = "UPDATE category SET name=? WHERE category_id=?";
    public static final String ADD_CATEGORY = "INSERT INTO category(name) VALUES(?)";
    public static final String DELETE_CATEGORY_BY_ID = "DELETE FROM category WHERE category_id=?";
    public static final String FIND_ALL_ITEMS = "SELECT * FROM item";
    public static final String FIND_ALL_ITEMS_IN_CATEGORY = "SELECT * FROM item WHERE category_id = ?";
    public static final String FIND_ITEM_BY_ID = "SELECT * FROM item WHERE item_id = ?";
    public static final String DELETE_ITEM_BY_ID = "DELETE FROM item WHERE item_id = ?";
    public static final String ADD_ITEM = "INSERT INTO item(name, description, cost, image_link, category_id) " +
            "VALUES(?, ?, ?, ?, ?)";
    public static final String EDIT_ITEM = "UPDATE item SET name=?, description=?, cost=?, image_link=?, " +
            "category_id=? WHERE item_id=?";
    public static final String FIND_ALL_ITEMS_CONTAINS_STRING_IN_NAME_IN_CATEGORY = "SELECT * FROM item WHERE " +
            "lower(name) like lower('%' || ? || '%') and category_id=?";
    public static final String FIND_ALL_ITEMS_CONTAINS_STRING_IN_NAME = "SELECT * FROM item WHERE lower(name) like " +
            "lower('%' || ? || '%')";
    public static final String ADD_NEWS = "INSERT INTO news(link) VALUES(?)";
    public static final String FIND_ALL_NEWS = "SELECT link FROM news ORDER BY news_id DESC";
    public static final String FIND_PURCHASES_BY_ACCOUNT_ID = "SELECT purchase_id, item_id FROM purchase WHERE " +
            "user_id = ?";
    public static final String FIND_SHOPPING_CART_BY_ACCOUNT_ID = "SELECT id, item_id FROM shopping_cart WHERE " +
            "user_id = ?";
    public static final String ADD_CART_ITEM = "INSERT INTO shopping_cart(user_id, item_id) VALUES(?, ?)";
    public static final String DELETE_CART_ITEM = "DELETE FROM shopping_cart WHERE id = ? and user_id = ?";
    public static final String MOVE_ITEMS_FROM_SHOPPING_CART_TO_PURCHASES_BY_ACCOUNT_ID = "INSERT INTO purchase(user_id, item_id," +
            " date) SELECT user_id, item_id, clock_timestamp() FROM shopping_cart WHERE user_id = ?";
    public static final String DELETE_ITEMS_FROM_SHOPPING_CART_BY_ACCOUNT_ID = "DELETE FROM shopping_cart WHERE " +
            "user_id = ?";
}
