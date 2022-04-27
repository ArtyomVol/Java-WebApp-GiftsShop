package by.bntu.fitr.poisit.service;

import by.bntu.fitr.poisit.entity.Account;

import java.util.List;

public interface AccountService {
    boolean checkAuthentication(String username, String password);
    Account getAccount(String username);
    List<Byte> addAccount(String firstName, String lastName, String username, String password, String repeatPassword);
}
