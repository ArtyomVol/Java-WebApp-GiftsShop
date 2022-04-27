package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.entity.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.*;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {
    private Connection connection = null;
    private final List<Category> dbCategories = new ArrayList<>(Arrays.asList(
            new Category(30, "LEGO"), new Category(31, "Мягкие игрушки"),
            new Category(32, "Книги"), new Category(33, "Кружки")));
    private final List<Item> dbItems = new ArrayList<>(Arrays.asList(
            new Item(1, "Мягкий белый медведь", "Большой уютный мягкий белый медведь. Луший " +
                    "подарок.", 15, "soft_polar_bear.png", 31),
            new Item(25, "Lego Star Wars Мандалорец и малыш 75317", "Соберите удивительную " +
                    "версию двух самых популярных персонажей сериала «Звёздные войны: Мандалорец» от Lego. Пристегните " +
                    "бластерную винтовку к спине Мандалорца и вложите в руку этого охотника за головами бластерный " +
                    "пистолет. Теперь он готов к любым сражениям. Создайте технологичную колыбельку для Малыша и " +
                    "разверните его уши, чтобы передать настроение. К комплект входят базовые пластины для обеих " +
                    "моделей, чтобы вы могли продемонстрировать новые экспонаты своей коллекции всем друзьям.", 15,
                    "lego_mandalorian_the_child_75317.png", 30),
            new Item(45, "Преступление и наказание", "Одно из \"краеугольных\" произведений " +
                    "русской и мировой литературы, включенный во все школьные программы, неоднократно экранизированный " +
                    "роман Достоевского \"Преступление и наказание\" ставит перед читателем важнейшие " +
                    "нравственно-мировоззренческие вопросы - о вере, совести, грехе и об искуплении через страдание. " +
                    "Опровержение преступной \"идеи-страсти\", \"безобразной мечты\", завладевшей умом Родиона " +
                    "Раскольникова в самом \"умышленном\" городе на свете, составляет основное содержание этой книги.",
                    9, "crime_and_punishment_fedor_dostoevsky.png", 32),
            new Item(46, "Кружка лучший муж, эмалированная сталь", "Кружка \"Лучший муж\" - " +
                    "важный элемент в любом туристическом приключении! Ведь именно благодаря представленной емкости " +
                    "Вы сможете утолить жажду из найденного в лесах источника, посмаковать свежезаваренным чаем на " +
                    "пикнике или просто поделиться с товарищем напитком из термоса. Емкость рассчитана как на " +
                    "холодную, так и на горячую жидкость.Характеристики: Объем: 400 мл; Материал: эмалированная сталь",
                    14, "kruzhka_luchshiy_muzh_emalirovannaya_stal.png", 33)));
    private final List<String> dbNewsImageLinks = new ArrayList<>(Arrays.asList("news1.png", "news2.png"));
    private final List<Purchase> dbPurchases = new ArrayList<>(Arrays.asList(
            new Purchase(11, 32, 25, dbItems.get(1)),
            new Purchase(17, 32, 1, dbItems.get(0))));
    private final List<ShoppingCart> dbShoppingCart = new ArrayList<>(Arrays.asList(
            new ShoppingCart(34,59,25, dbItems.get(1)),
            new ShoppingCart(34,60,46, dbItems.get(3)),
            new ShoppingCart(35,61,1, dbItems.get(0))));

    JDBCUtilTest() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_copy"
                    , "postgres"
                    , "01112001");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void AccountSQLHandler_TestRepositoryFindAccountByUsernameQueryWithExistUsername_Account() {
        String username = "ArtVol123";
        Account account = JDBCUtil.AccountSQLHandler.selectAccount(FIND_ACCOUNT_BY_USERNAME, connection, username);
        assertNotNull(account);
    }

    @Test
    void AccountSQLHandler_TestAccountRepositoryQueryFindAccountByUsernameWithNonExistUsername_Account() {
        String username = "FakeUsername";
        Account account = JDBCUtil.AccountSQLHandler.selectAccount(FIND_ACCOUNT_BY_USERNAME, connection, username);
        assertNull(account);
    }

    @Test
    void AccountSQLHandler_TestAccountRepositoryQueryAddAccount_AccountIsAdded() {
        String username = "Username";
        String password = Arrays.toString(DigestUtils.md5("password"));
        String firstName = "Иван";
        String lastName = "Иванов";
        JDBCUtil.insertDeleteOrUpdate(ADD_ACCOUNT, connection, username, password, firstName,
                lastName);
        Account account = JDBCUtil.AccountSQLHandler.selectAccount(FIND_ACCOUNT_BY_USERNAME, connection, username);
        assertNotNull(account);
        assertEquals(username, account.getUsername());
        assertEquals(password, account.getPassword());
        assertEquals(firstName, account.getFirstName());
        assertEquals(lastName, account.getLastName());
        JDBCUtil.insertDeleteOrUpdate("DELETE FROM account WHERE username=?", connection, username);
    }

    @Test
    void CategorySQLHandler_TestCategoryRepositoryQueryFindAllCategories_CategoriesList() {
        List<Category> categories = JDBCUtil.CategorySQLHandler.selectCategories(FIND_ALL_CATEGORIES, connection);
        assertArrayEquals(categories.toArray(), dbCategories.toArray());
    }

    @Test
    void CategorySQLHandler_TestCategoryRepositoryQueryFindCategoryById_CategoryWithId() {
        for (Category dbCategory : dbCategories) {
            Category category = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_ID, connection,
                    dbCategory.getCategoryId());
            assertEquals(dbCategory, category);
        }
    }

    @Test
    void CategorySQLHandler_TestCategoryRepositoryQueryFindCategoryByName_CategoryWithName() {
        for (Category dbCategory : dbCategories) {
            Category category = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_NAME, connection,
                    dbCategory.getName());
            assertEquals(dbCategory, category);
        }
    }

    @Test
    void CategorySQLHandler_TestCategoryRepositoryQueryAddEditDeleteCategory_SuccessfulActions() {
        String name = "Носки";
        JDBCUtil.insertDeleteOrUpdate(ADD_CATEGORY, connection, name);
        Category addedCategory = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_NAME, connection, name);
        assertEquals(name, addedCategory.getName());

        int categoryId = addedCategory.getCategoryId();
        String newName = "Пена для бритья";
        JDBCUtil.insertDeleteOrUpdate(EDIT_CATEGORY_BY_ID, connection, newName,
                categoryId);
        Category editedCategory = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_ID, connection,
                categoryId);
        assertEquals(newName, editedCategory.getName());
        assertEquals(addedCategory.getCategoryId(), editedCategory.getCategoryId());

        JDBCUtil.insertDeleteOrUpdate(DELETE_CATEGORY_BY_ID, connection, categoryId);
        Category deletedCategory = JDBCUtil.CategorySQLHandler.selectCategory(FIND_CATEGORY_BY_ID, connection,
                categoryId);
        assertNull(deletedCategory);
    }

    @Test
    void ItemSQLHandler_TestItemRepositoryQueryFindAllItems_ItemsList() {
        List<Item> items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS, connection);
        for (Item dbItem: dbItems) {
            boolean thereIsEqualItem = false;
            int dbItemId = dbItem.getItemId();
            for (Item item: items) {
                if (item.getItemId() == dbItemId) {
                    thereIsEqualItem = true;
                    break;
                }
            }
            assertTrue(thereIsEqualItem);
        }
    }

    @Test
    void ItemSQLHandler_TestItemRepositoryQueryFindAllItemsInCategory_ItemsListFromCategoryId() {
        int categoryId = 31;
        List<Item> items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS_IN_CATEGORY, connection, categoryId);
        for (Item dbItem: dbItems) {
            if (dbItem.getCategoryId() == categoryId) {
                boolean thereIsEqualItem = false;
                int dbItemId = dbItem.getItemId();
                for (Item item: items) {
                    if (item.getItemId() == dbItemId) {
                        thereIsEqualItem = true;
                        break;
                    }
                }
                assertTrue(thereIsEqualItem);
            }
            else {
                assertFalse(items.contains(dbItem));
            }
        }
    }

    @Test
    void ItemSQLHandler_TestItemRepositoryQueryFindAllItemsContainsStringInNameInCategory_RequiredItemsList() {
        String searchString = "ягк";
        int categoryId = 31;
        List<Item> items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS_CONTAINS_STRING_IN_NAME_IN_CATEGORY,
                connection, searchString, categoryId);
        for (Item dbItem: dbItems) {
            if (dbItem.getCategoryId() == categoryId && dbItem.getName().contains(searchString)) {
                boolean thereIsEqualItem = false;
                int dbItemId = dbItem.getItemId();
                for (Item item: items) {
                    if (item.getItemId() == dbItemId) {
                        thereIsEqualItem = true;
                        break;
                    }
                }
                assertTrue(thereIsEqualItem);
            }
            else {
                assertFalse(items.contains(dbItem));
            }
        }
    }

    @Test
    void ItemSQLHandler_TestItemRepositoryQueryFindAllItemsContainsStringInName_RequiredItemsList() {
        String searchString = "а";
        List<Item> items = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS_CONTAINS_STRING_IN_NAME, connection,
                searchString);
        for (Item dbItem: dbItems) {
            if (dbItem.getName().contains(searchString)) {
                boolean thereIsEqualItem = false;
                int dbItemId = dbItem.getItemId();
                for (Item item: items) {
                    if (item.getItemId() == dbItemId) {
                        thereIsEqualItem = true;
                        break;
                    }
                }
                assertTrue(thereIsEqualItem);
            }
            else {
                assertFalse(items.contains(dbItem));
            }
        }
    }

    @Test
    void ItemSQLHandler_TestItemRepositoryQueryFindItemById_CorrectItem() {
        Item dbItem = dbItems.get(0);
        int itemId = dbItem.getItemId();
        Item item = JDBCUtil.ItemSQLHandler.selectItem(FIND_ITEM_BY_ID, connection, itemId);
        assertEquals(dbItem, item);
    }

    @Test
    void ItemSQLHandler_TestItemRepositoryQueryAddEditDeleteItem_SuccessfulActions() {
        String name = "Кот";
        String description = "Мягкий";
        int cost = 3;
        String imageLink = "cat.png";
        int categoryId = 31;
        List<Item> oldItems = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS, connection);
        JDBCUtil.insertDeleteOrUpdate(ADD_ITEM, connection, name, description, cost, imageLink, categoryId);
        List<Item> newItems = JDBCUtil.ItemSQLHandler.selectItems(FIND_ALL_ITEMS, connection);
        newItems.removeAll(oldItems);
        Item addedItem = newItems.get(0);
        assertEquals(name, addedItem.getName());
        assertEquals(description, addedItem.getDescription());
        assertEquals(cost, addedItem.getCost());
        assertEquals(imageLink, addedItem.getImageLink());
        assertEquals(categoryId, addedItem.getCategoryId());

        String newName = "Мой родны кут";
        String newDescription = "Цудоўныя творы";
        int newCost = 1;
        String newImageLink = "moy_rodny_kyt.png";
        int newCategoryId = 32;
        int itemId = addedItem.getItemId();
        JDBCUtil.insertDeleteOrUpdate(EDIT_ITEM, connection, newName, newDescription, newCost, newImageLink,
                newCategoryId, itemId);
        Item editedItem = JDBCUtil.ItemSQLHandler.selectItem(FIND_ITEM_BY_ID, connection, itemId);
        assertEquals(newName, editedItem.getName());
        assertEquals(newDescription, editedItem.getDescription());
        assertEquals(newCost, editedItem.getCost());
        assertEquals(newImageLink, editedItem.getImageLink());
        assertEquals(newCategoryId, editedItem.getCategoryId());

        JDBCUtil.insertDeleteOrUpdate(DELETE_ITEM_BY_ID, connection, itemId);
        Item deletedItem = JDBCUtil.ItemSQLHandler.selectItem(FIND_ITEM_BY_ID, connection, itemId);
        assertNull(deletedItem);
    }

    @Test
    void NewsSQLHandler_TestNewsRepositoryQueryAddNews_NewsIsAdded() {
        String imageLink = "news3.png";
        List<String> newsImageLinks = JDBCUtil.NewsSQLHandler.selectNews(FIND_ALL_NEWS, connection);
        assertFalse(newsImageLinks.contains(imageLink));
        JDBCUtil.insertDeleteOrUpdate(ADD_NEWS, connection, imageLink);
        newsImageLinks = JDBCUtil.NewsSQLHandler.selectNews(FIND_ALL_NEWS, connection);
        assertTrue(newsImageLinks.contains(imageLink));
        JDBCUtil.insertDeleteOrUpdate("DELETE FROM news WHERE link=?", connection, imageLink);
    }

    @Test
    void NewsSQLHandler_TestNewsRepositoryQueryFindAllNews_NewsList() {
        List<String> newsImageLinks = JDBCUtil.NewsSQLHandler.selectNews(FIND_ALL_NEWS, connection);
        for (String dbNewsImageLink: dbNewsImageLinks) {
            assertTrue(newsImageLinks.contains(dbNewsImageLink));
        }
    }

    @Test
    void PurchaseSQLHandler_TestPurchaseRepositoryQueryFindPurchasesByAccountId_ExistPurchaseList() {
        int accountId = dbPurchases.get(0).getAccountId();
        List<Purchase> purchases = JDBCUtil.PurchaseSQLHandler.selectPurchases(FIND_PURCHASES_BY_ACCOUNT_ID,
                connection, accountId);
        for (Purchase dbPurchase: dbPurchases) {
            if(dbPurchase.getAccountId() == accountId) {
                assertTrue(purchases.contains(dbPurchase));
            }
            else {
                assertFalse(purchases.contains(dbPurchase));
            }
        }
    }

    @Test
    void ShoppingCartSQLHandler_TestShoppingCartRepositoryQueryFindShoppingCartByAccountId_ExistShoppingCartList() {
        int accountId = dbPurchases.get(0).getAccountId();
        List<ShoppingCart> shoppingCarts = JDBCUtil.ShoppingCartSQLHandler.selectShoppingCart(
                FIND_SHOPPING_CART_BY_ACCOUNT_ID, connection, accountId);
        for (ShoppingCart dbShoppingCart: dbShoppingCart) {
            if(dbShoppingCart.getAccountId() == accountId) {
                assertTrue(shoppingCarts.contains(dbShoppingCart));
            }
            else {
                assertFalse(shoppingCarts.contains(dbShoppingCart));
            }
        }
    }

    @Test
    void ShoppingCartSQLHandler_TestShoppingCartRepositoryQueryAddDeleteCartItem_SuccessfulItemAddingAndDeleting() {
        int itemId = dbItems.get(2).getItemId();
        int accountId = 32;
        List<ShoppingCart> oldShoppingCarts = JDBCUtil.ShoppingCartSQLHandler.selectShoppingCart(
                FIND_SHOPPING_CART_BY_ACCOUNT_ID, connection, accountId);
        JDBCUtil.insertDeleteOrUpdate(ADD_CART_ITEM, connection, accountId, itemId);
        List<ShoppingCart> newShoppingCarts = JDBCUtil.ShoppingCartSQLHandler.selectShoppingCart(
                FIND_SHOPPING_CART_BY_ACCOUNT_ID, connection, accountId);
        newShoppingCarts.removeAll(oldShoppingCarts);
        ShoppingCart shoppingCart = newShoppingCarts.get(0);
        assertEquals(itemId, shoppingCart.getItemId());
        assertEquals(accountId, shoppingCart.getAccountId());

        JDBCUtil.insertDeleteOrUpdate(DELETE_CART_ITEM, connection, shoppingCart.getId(), accountId);
        List<ShoppingCart> shoppingCartsAfterDeleting = JDBCUtil.ShoppingCartSQLHandler.selectShoppingCart(
                FIND_SHOPPING_CART_BY_ACCOUNT_ID, connection, accountId);
        assertFalse(shoppingCartsAfterDeleting.contains(shoppingCart));
    }


    @Test
    void ShoppingCartSQLHandler_TestShoppingCartRepositoryQueryPurchaseShoppingCart_ItemMoveFromShoppingCartToPurchase() {
        int itemId = dbItems.get(2).getItemId();
        int accountId = 32;
        List<Purchase> oldPurchases = JDBCUtil.PurchaseSQLHandler.selectPurchases(FIND_PURCHASES_BY_ACCOUNT_ID,
                connection, accountId);
        JDBCUtil.insertDeleteOrUpdate(ADD_CART_ITEM, connection, accountId, itemId);
        JDBCUtil.insertDeleteOrUpdate(MOVE_ITEMS_FROM_SHOPPING_CART_TO_PURCHASES_BY_ACCOUNT_ID, connection,
                accountId);
        List<Purchase> newPurchases = JDBCUtil.PurchaseSQLHandler.selectPurchases(FIND_PURCHASES_BY_ACCOUNT_ID,
                connection, accountId);
        newPurchases.removeAll(oldPurchases);
        Purchase purchase = newPurchases.get(0);
        assertEquals(itemId, purchase.getItemId());
        assertEquals(accountId, purchase.getAccountId());

        JDBCUtil.insertDeleteOrUpdate("DELETE FROM purchase WHERE purchase_id=?", connection,
                purchase.getPurchaseId());
    }
}