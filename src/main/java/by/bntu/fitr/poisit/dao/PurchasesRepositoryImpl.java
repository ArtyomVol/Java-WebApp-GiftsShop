package by.bntu.fitr.poisit.dao;

import by.bntu.fitr.poisit.dao.repository.PurchasesRepository;
import by.bntu.fitr.poisit.entity.Purchase;
import by.bntu.fitr.poisit.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.FIND_PURCHASES_BY_ACCOUNT_ID;

public class PurchasesRepositoryImpl implements PurchasesRepository {
    @Override
    public List<Purchase> findPurchasesByAccountId(int accountId) {
        List<Purchase> purchases = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            purchases = JDBCUtil.PurchaseSQLHandler.selectPurchases(FIND_PURCHASES_BY_ACCOUNT_ID
                    , connection, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;
    }
}
