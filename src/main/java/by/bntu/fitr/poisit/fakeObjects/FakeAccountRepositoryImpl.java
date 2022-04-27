package by.bntu.fitr.poisit.fakeObjects;

import by.bntu.fitr.poisit.dao.repository.AccountRepository;
import by.bntu.fitr.poisit.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FakeAccountRepositoryImpl implements AccountRepository {
    private final List<FakeAccount> accounts = new ArrayList<>(Arrays.asList(
            new FakeAccount(123456, "Артём", "Волоско", "ArtyomVolosko",
                    Arrays.toString(DigestUtils.md5("qwerty123456")), 2),
            new FakeAccount(123457, "Oleg", "Goluyanov", "cOlGol",
                    Arrays.toString(DigestUtils.md5("q1w2e3r4t5y6")), 2),
            new FakeAccount(123458, "firstName", "lastName", "username",
                    Arrays.toString(DigestUtils.md5("password")), 2)
    ));

    @Override
    public Account findAccountByUsername(String username) {
        for (FakeAccount fakeAccount : accounts) {
            if (fakeAccount.getUsername().equals(username)) {
                return new Account(fakeAccount.getId(), username, fakeAccount.getPassword(), fakeAccount.getRoleId(),
                        fakeAccount.getFirstName(), fakeAccount.getLastName());
            }
        }
        return null;
    }

    @Override
    public void addAccount(String firstName, String lastName, String username, String password) {
        Random random = new Random();
        int id = random.nextInt();
        while (thereIsAccountWithId(id)) {
            id = random.nextInt();
        }
        accounts.add(new FakeAccount(id, firstName, lastName, username, Arrays.toString(DigestUtils.md5(password))));
    }

    private boolean thereIsAccountWithId(int id) {
        for (FakeAccount fakeAccount : accounts) {
            if (fakeAccount.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
