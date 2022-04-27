package by.bntu.fitr.poisit.dao.repository;

import by.bntu.fitr.poisit.entity.Account;

import java.sql.SQLException;

public interface AccountRepository {
    Account findAccountByUsername(String username);
    void addAccount(String firstName, String lastName, String username, String password);

}
