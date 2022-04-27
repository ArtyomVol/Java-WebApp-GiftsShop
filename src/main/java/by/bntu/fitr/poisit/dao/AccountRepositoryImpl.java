package by.bntu.fitr.poisit.dao;

import by.bntu.fitr.poisit.dao.repository.AccountRepository;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.*;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public Account findAccountByUsername(String username) {
        Account account = null;
        try (Connection connection = JDBCUtil.getConnection()) {
            account = JDBCUtil.AccountSQLHandler.selectAccount(FIND_ACCOUNT_BY_USERNAME, connection, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void addAccount(String firstName, String lastName, String username, String password) {
        try (Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(ADD_ACCOUNT, connection, username, password, firstName, lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
