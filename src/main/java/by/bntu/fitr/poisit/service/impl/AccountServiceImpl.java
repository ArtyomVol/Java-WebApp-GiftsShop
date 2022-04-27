package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.AccountRepository;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.util.InputsChecker;
import by.bntu.fitr.poisit.service.AccountService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean checkAuthentication(String username, String password) {
        Account account = accountRepository.findAccountByUsername(username);
        if (account != null) {
            return account.getPassword().equals(Arrays.toString(DigestUtils.md5(password)));
        }
        return false;
    }

    @Override
    public Account getAccount(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public List<Byte> addAccount(String firstName, String lastName, String username, String password,
                                 String repeatPassword) {
        List<Byte> listWithRegistrationCodes = new ArrayList<>();
        if (accountRepository.findAccountByUsername(username) != null) {
            listWithRegistrationCodes.add(ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION);
        } else if (!InputsChecker.checkUsername(username)) {
            listWithRegistrationCodes.add(ErrorConstant.INVALID_USERNAME_IN_REGISTRATION);
        }
        if (!InputsChecker.checkFirstName(firstName)) {
            listWithRegistrationCodes.add(ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION);
        }
        if (!InputsChecker.checkLastName(lastName)) {
            listWithRegistrationCodes.add(ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION);
        }
        if (!InputsChecker.checkPassword(password)) {
            listWithRegistrationCodes.add(ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION);
        } else if (!password.equals(repeatPassword)) {
            listWithRegistrationCodes.add(ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION);
        } else {
            password = Arrays.toString(DigestUtils.md5(password));
        }
        if (listWithRegistrationCodes.size() == 0) {
            accountRepository.addAccount(firstName, lastName, username, password);
            listWithRegistrationCodes.add(ErrorConstant.SUCCESS_REGISTRATION);
        }
        return listWithRegistrationCodes;
    }
}
