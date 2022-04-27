package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.AccountRepository;
import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.fakeObjects.FakeAccountRepositoryImpl;
import by.bntu.fitr.poisit.service.AccountService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {
    @Mock
    private final AccountRepository accountRepository = new FakeAccountRepositoryImpl();
    private final AccountService accountService = new AccountServiceImpl(accountRepository);
    private final String FIRST_NAME = "Артём";
    private final String LAST_NAME = "Волоско";
    private final String USERNAME = "ArtyomVolosko";
    private final String PASSWORD = "qwerty123456";
    private final String REPEAT_PASSWORD = "qwerty123456";

    @Test
    void checkAuthentication_TestExistAccountData_True() {
        boolean result = accountService.checkAuthentication(USERNAME, PASSWORD);
        assertTrue(result);
    }

    @Test
    void checkAuthentication_TestNonExistUsername_False() {
        String username = "abvgdayka";
        boolean result = accountService.checkAuthentication(username, PASSWORD);
        assertFalse(result);
    }

    @Test
    void checkAuthentication_TestIncorrectPassword_False() {
        String password = "abvgdayka";
        boolean result = accountService.checkAuthentication(USERNAME, password);
        assertFalse(result);
    }

    @Test
    void getAccount_TestNonExistAccountUsername_Null() {
        String username = "SomeUsername";
        Account account = accountService.getAccount(username);
        assertNull(account);
    }

    @Test
    void getAccount_TestExistAccountUsername_NotNull() {
        Account account = accountService.getAccount(USERNAME);
        assertNotNull(account);
    }

    @Test
    void addAccount_TestDBContainUsername_ListContainConstantNOT_UNIQUE_USERNAME_IN_REGISTRATION() {
        String username = "ArtyomVolosko"; // already in the database (list) in FakeAccountRepositoryImpl
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, username, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestDBNotContainUsername_ListNotContainConstantNOT_UNIQUE_USERNAME_IN_REGISTRATION() {
        String username = "NewUsername"; // not in the database (list) in FakeAccountRepositoryImpl
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, username, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION;
        assertFalse(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestInvalidUsername_ListContainConstantINVALID_USERNAME_IN_REGISTRATION() {
        String username = "*ArtyomVolosko";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, username, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.INVALID_USERNAME_IN_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestValidUsername_ListNotContainConstantINVALID_USERNAME_IN_REGISTRATION() {
        String username = "ArtyomVolosko";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, username, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.INVALID_USERNAME_IN_REGISTRATION;
        assertFalse(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestInvalidFirstName_ListContainConstantINVALID_FIRST_NAME_IN_REGISTRATION() {
        String firstName = "*Артём";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(firstName, LAST_NAME, USERNAME, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestValidFirstName_ListNotContainConstantINVALID_FIRST_NAME_IN_REGISTRATION() {
        String firstName = "Артём";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(firstName, LAST_NAME, USERNAME, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.INVALID_USERNAME_IN_REGISTRATION;
        assertFalse(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestInvalidLastName_ListContainConstantINVALID_LAST_NAME_IN_REGISTRATION() {
        String lastName = "*Волоско";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, lastName, USERNAME, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestValidLastName_ListNotContainConstantINVALID_LAST_NAME_IN_REGISTRATION() {
        String lastName = "Волоско";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, lastName, USERNAME, PASSWORD,
                REPEAT_PASSWORD);
        byte expectedRegistrationCode = ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION;
        assertFalse(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestInvalidPassword_ListContainConstantINVALID_PASSWORD_IN_REGISTRATION() {
        String password = "*qwerty123456";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, USERNAME, password,
                password);
        byte expectedRegistrationCode = ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestValidPassword_ListNotContainConstantINVALID_PASSWORD_IN_REGISTRATION() {
        String password = "qwerty123456";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, USERNAME, password,
                password);
        byte expectedRegistrationCode = ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION;
        assertFalse(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestPasswordsMismatch_ListContainConstantPASSWORD_MISMATCH_IN_REGISTRATION() {
        String password = "qwerty1234567";
        String repeatPassword = "qwerty123456";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, USERNAME, password,
                repeatPassword);
        byte expectedRegistrationCode = ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestPasswordsMatch_ListNotContainConstantPASSWORD_MISMATCH_IN_REGISTRATION() {
        String password = "qwerty123456";
        String repeatPassword = "qwerty123456";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(FIRST_NAME, LAST_NAME, USERNAME, password,
                repeatPassword);
        byte expectedRegistrationCode = ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION;
        assertFalse(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestAllRegistrationDataIsCorrect_ListContainConstantSUCCESS_REGISTRATION() {
        String firstName = "Артём";
        String lastName = "Волоско";
        String username = "Secvad";
        String password = "qwerty123456";
        String repeatPassword = "qwerty123456";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(firstName, lastName, username, password,
                repeatPassword);
        byte expectedRegistrationCode = ErrorConstant.SUCCESS_REGISTRATION;
        assertTrue(listWithRegistrationCodes.contains(expectedRegistrationCode));
    }

    @Test
    void addAccount_TestAllRegistrationDataIsIncorrect_ListContainAllConstantRegistrationErrorsCode() {
        String firstName = "*Артём";
        String lastName = "*Волоско";
        String username = "*Secvad";
        String password = "*qwerty123456";
        String repeatPassword = "*qwerty123456";
        List<Byte> listWithRegistrationCodes = accountService.addAccount(firstName, lastName, username, password,
                repeatPassword);
        List<Byte> expectedListWithErrorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION,
                ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION, ErrorConstant.INVALID_USERNAME_IN_REGISTRATION,
                ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION));
        for (byte errorCode: expectedListWithErrorsCode) {
            assertTrue(listWithRegistrationCodes.contains(errorCode));
        }
    }

}