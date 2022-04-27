package by.bntu.fitr.poisit.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputsCheckerTest {

    @Test
    void checkLastName_TestForNull_False() {
        boolean result = InputsChecker.checkLastName(null);
        assertFalse(result);
    }

    @Test
    void checkLastName_TestLastNameLengthBorders_False() {
        String lastName1 = "";
        String lastName2 = "абвгдеёжзийклмнопрстуфхцчшщъыьэ";
        boolean result1 = InputsChecker.checkLastName(lastName1);
        boolean result2 = InputsChecker.checkLastName(lastName2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkLastName_TestLastNameLengthBorders_True() {
        String lastName1 = "a";
        String lastName2 = "абвгдеёжзийклмнопрстуфхцчшщъыь";
        boolean result1 = InputsChecker.checkLastName(lastName1);
        boolean result2 = InputsChecker.checkLastName(lastName2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkLastName_TestLastNameContainApostrophe_True() {
        String lastName = "'";
        boolean result = InputsChecker.checkLastName(lastName);
        assertTrue(result);
    }

    @Test
    void checkLastName_TestLastNameContainHyphen_True() {
        String lastName = "-";
        boolean result = InputsChecker.checkLastName(lastName);
        assertTrue(result);
    }

    @Test
    void checkLastName_TestLastNameContainCyrillicLetters_True() {
        String lastName = "Абв";
        boolean result = InputsChecker.checkLastName(lastName);
        assertTrue(result);
    }

    @Test
    void checkLastName_TestLastNameContainLatinLetters_True() {
        String lastName = "Abc";
        boolean result = InputsChecker.checkLastName(lastName);
        assertTrue(result);
    }

    @Test
    void checkLastName_TestLastNameContainIncorrectSymbols_False() {
        String lastName1 = "*art";
        String lastName2 = "#Друг";
        String lastName3 = "123";
        boolean result1 = InputsChecker.checkLastName(lastName1);
        boolean result2 = InputsChecker.checkLastName(lastName2);
        boolean result3 = InputsChecker.checkLastName(lastName3);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void checkLastName_TestLastNameContainCorrectSymbols_True() {
        String lastName = "Ab'c-Абв";
        boolean result = InputsChecker.checkLastName(lastName);
        assertTrue(result);
    }

    @Test
    void checkFirstName_TestForNull_False() {
        boolean result = InputsChecker.checkFirstName(null);
        assertFalse(result);
    }

    @Test
    void checkFirstName_TestFirstNameLengthBorders_False() {
        String firstName1 = "";
        String firstName2 = "абвгдеёжзийклмнопрстуфхцчшщъыьэ";
        boolean result1 = InputsChecker.checkFirstName(firstName1);
        boolean result2 = InputsChecker.checkFirstName(firstName2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkFirstName_TestFirstNameLengthBorders_True() {
        String firstName1 = "a";
        String firstName2 = "абвгдеёжзийклмнопрстуфхцчшщъыь";
        boolean result1 = InputsChecker.checkFirstName(firstName1);
        boolean result2 = InputsChecker.checkFirstName(firstName2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkFirstName_TestFirstNameContainApostrophe_True() {
        String firstName = "'";
        boolean result = InputsChecker.checkFirstName(firstName);
        assertTrue(result);
    }

    @Test
    void checkFirstName_TestFirstNameContainHyphen_True() {
        String firstName = "-";
        boolean result = InputsChecker.checkFirstName(firstName);
        assertTrue(result);
    }

    @Test
    void checkFirstName_TestFirstNameContainCyrillicLetters_True() {
        String firstName = "Абв";
        boolean result = InputsChecker.checkFirstName(firstName);
        assertTrue(result);
    }

    @Test
    void checkFirstName_TestFirstNameContainLatinLetters_True() {
        String firstName = "Abc";
        boolean result = InputsChecker.checkFirstName(firstName);
        assertTrue(result);
    }

    @Test
    void checkFirstName_TestFirstNameContainIncorrectSymbols_False() {
        String firstName1 = "*art";
        String firstName2 = "#Друг";
        String firstName3 = "123";
        boolean result1 = InputsChecker.checkFirstName(firstName1);
        boolean result2 = InputsChecker.checkFirstName(firstName2);
        boolean result3 = InputsChecker.checkFirstName(firstName3);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void checkFirstName_TestFirstNameContainCorrectSymbols_True() {
        String firstName = "Ab'c-Абв";
        boolean result = InputsChecker.checkFirstName(firstName);
        assertTrue(result);
    }

    @Test
    void checkUsername_TestForNull_False() {
        boolean result = InputsChecker.checkUsername(null);
        assertFalse(result);
    }

    @Test
    void checkUsername_TestUsernameLengthBorders_False() {
        String username1 = "1234";
        String username2 = "123456789012345678901";
        boolean result1 = InputsChecker.checkUsername(username1);
        boolean result2 = InputsChecker.checkUsername(username2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkUsername_TestUsernameLengthBorders_True() {
        String username1 = "12345";
        String username2 = "12345678901234567890";
        boolean result1 = InputsChecker.checkUsername(username1);
        boolean result2 = InputsChecker.checkUsername(username2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkUsername_TestUsernameContainPunctuationMarks_True() {
        String username = "(\"-!?:;.,)";
        boolean result = InputsChecker.checkUsername(username);
        assertTrue(result);
    }

    @Test
    void checkUsername_TestUsernameContainNumbers_True() {
        String username = "7777777";
        boolean result = InputsChecker.checkUsername(username);
        assertTrue(result);
    }

    @Test
    void checkUsername_TestUsernameContainLatinLetters_True() {
        String username = "Abcde";
        boolean result = InputsChecker.checkUsername(username);
        assertTrue(result);
    }

    @Test
    void checkUsername_TestUsernameContainIncorrectSymbols_False() {
        String username1 = "Абвгд";
        String username2 = "*art";
        String username3 = "#123";
        boolean result1 = InputsChecker.checkUsername(username1);
        boolean result2 = InputsChecker.checkUsername(username2);
        boolean result3 = InputsChecker.checkUsername(username3);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void checkUserName_TestUserNameContainCorrectSymbols_True() {
        String username = "Abc123:)";
        boolean result = InputsChecker.checkUsername(username);
        assertTrue(result);
    }

    @Test
    void checkPassword_TestForNull_False() {
        boolean result = InputsChecker.checkPassword(null);
        assertFalse(result);
    }

    @Test
    void checkPassword_TestPasswordLengthBorders_False() {
        String password1 = "1234567";
        String password2 = "123456789012345678901";
        boolean result1 = InputsChecker.checkPassword(password1);
        boolean result2 = InputsChecker.checkPassword(password2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkPassword_TestPasswordLengthBorders_True() {
        String password1 = "12345678";
        String password2 = "12345678901234567890";
        boolean result1 = InputsChecker.checkPassword(password1);
        boolean result2 = InputsChecker.checkPassword(password2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkPassword_TestPasswordContainPunctuationMarks_True() {
        String password = "(\"-!?:;.,)";
        boolean result = InputsChecker.checkPassword(password);
        assertTrue(result);
    }

    @Test
    void checkPassword_TestPasswordContainNumbers_True() {
        String password = "77777777";
        boolean result = InputsChecker.checkPassword(password);
        assertTrue(result);
    }

    @Test
    void checkPassword_TestPasswordContainLatinLetters_True() {
        String password = "qwertyasd";
        boolean result = InputsChecker.checkPassword(password);
        assertTrue(result);
    }

    @Test
    void checkPassword_TestPasswordContainIncorrectSymbols_False() {
        String password1 = "Абвгдеёж";
        String password2 = "*ArtyomVolosko#";
        String password3 = "☺12345qwerty☻";
        boolean result1 = InputsChecker.checkPassword(password1);
        boolean result2 = InputsChecker.checkPassword(password2);
        boolean result3 = InputsChecker.checkPassword(password3);
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void checkPassword_TestPasswordContainCorrectSymbols_True() {
        String password = ")qwerty54321(";
        boolean result = InputsChecker.checkPassword(password);
        assertTrue(result);
    }

    @Test
    void checkItemName_TestForNull_False() {
        boolean result = InputsChecker.checkItemName(null);
        assertFalse(result);
    }

    @Test
    void checkItemName_TestItemNameLengthBorders_False() {
        String itemName1 = "1234";
        String itemName2 = "123456789012345678901234567890123456789012345678901";
        boolean result1 = InputsChecker.checkItemName(itemName1);
        boolean result2 = InputsChecker.checkItemName(itemName2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkItemName_TestItemNameLengthBorders_True() {
        String itemName1 = "12345";
        String itemName2 = "12345678901234567890123456789012345678901234567890";
        boolean result1 = InputsChecker.checkItemName(itemName1);
        boolean result2 = InputsChecker.checkItemName(itemName2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkItemName_TestItemNameContainCyrillicLetters_True() {
        String lastName = "Абвгд";
        boolean result = InputsChecker.checkItemName(lastName);
        assertTrue(result);
    }

    @Test
    void checkItemName_TestItemNameContainLatinLetters_True() {
        String lastName = "Abcde";
        boolean result = InputsChecker.checkItemName(lastName);
        assertTrue(result);
    }

    @Test
    void checkItemName_TestItemNameContainPunctuationMarks_True() {
        String itemName = "(\"-!?:;.,)";
        boolean result = InputsChecker.checkItemName(itemName);
        assertTrue(result);
    }

    @Test
    void checkItemName_TestItemNameContainNumbers_True() {
        String itemName = "77777";
        boolean result = InputsChecker.checkItemName(itemName);
        assertTrue(result);
    }

    @Test
    void checkItemName_TestItemNameContainSpace_True() {
        String itemName = "     ";
        boolean result = InputsChecker.checkItemName(itemName);
        assertTrue(result);
    }

    @Test
    void checkItemName_TestItemNameContainIncorrectSymbols_False() {
        String itemName1 = "*плюшевая игрушка#";
        String itemName2 = "☺лучшая книга☻";
        boolean result1 = InputsChecker.checkItemName(itemName1);
        boolean result2 = InputsChecker.checkItemName(itemName2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkItemName_TestItemNameContainCorrectSymbols_True() {
        String lastName = "Игрушка BestFriend 2.0";
        boolean result = InputsChecker.checkItemName(lastName);
        assertTrue(result);
    }

    @Test
    void checkItemDescription_TestForNull_False() {
        boolean result = InputsChecker.checkItemDescription(null);
        assertFalse(result);
    }

    @Test
    void checkItemDescription_TestItemDescriptionLengthBorder_False() {
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 501; ++i) {
            description.append("a");
        }
        boolean result = InputsChecker.checkItemDescription(description.toString());
        assertFalse(result);
    }

    @Test
    void checkItemDescription_TestItemDescriptionLengthBorders_True() {
        StringBuilder description1 = new StringBuilder();
        for (int i = 0; i < 500; ++i) {
            description1.append("a");
        }
        boolean result1 = InputsChecker.checkItemDescription(description1.toString());
        String description2 = "";
        boolean result2 = InputsChecker.checkItemDescription(description2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkItemCost_TestForNull_False() {
        boolean result = InputsChecker.checkItemCost(null);
        assertFalse(result);
    }

    @Test
    void checkItemCost_TestItemCostBorders_False() {
        String itemCost1 = "";
        String itemCost2 = "12345678901";
        boolean result1 = InputsChecker.checkItemCost(itemCost1);
        boolean result2 = InputsChecker.checkItemCost(itemCost2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkItemCost_TestItemCostBorders_True() {
        String itemCost1 = "1";
        String itemCost2 = "1234567890";
        boolean result1 = InputsChecker.checkItemCost(itemCost1);
        boolean result2 = InputsChecker.checkItemCost(itemCost2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkItemCost_TestItemCostContainIncorrectSymbol_False() {
        String itemCost1 = "2-3";
        String itemCost2 = "qwerty";
        boolean result1 = InputsChecker.checkItemCost(itemCost1);
        boolean result2 = InputsChecker.checkItemCost(itemCost2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkItemCost_TestItemCostContainCorrectSymbol_True() {
        String itemCost1 = "231";
        String itemCost2 = "5";
        boolean result1 = InputsChecker.checkItemCost(itemCost1);
        boolean result2 = InputsChecker.checkItemCost(itemCost2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void checkImageLink_TestForNull_False() {
        boolean result = InputsChecker.checkImageLink(null);
        assertFalse(result);
    }

    @Test
    void checkImageLink_TestImageLinkBorder_False() {
        StringBuilder imageLink = new StringBuilder();
        for (int i = 0; i < 497; ++i) {
            imageLink.append("a");
        }
        imageLink.append(".png");
        boolean result1 = InputsChecker.checkImageLink(imageLink.toString());
        assertFalse(result1);
    }


    @Test
    void checkImageLink_TestImageLinkBorder_True() {
        StringBuilder imageLink = new StringBuilder();
        for (int i = 0; i < 496; ++i) {
            imageLink.append("a");
        }
        imageLink.append(".png");
        boolean result1 = InputsChecker.checkImageLink(imageLink.toString());
        assertTrue(result1);
    }

    @Test
    void checkImageLink_TestImageLinkContainCorrectExtension_True() {
        String imageLink1 = "cat.jpg";
        String imageLink2 = "cat.jfif";
        String imageLink3 = "cat.pjpeg";
        String imageLink4 = "cat.jpeg";
        String imageLink5 = "cat.pjp";
        String imageLink6 = "cat.png";
        boolean result1 = InputsChecker.checkImageLink(imageLink1);
        boolean result2 = InputsChecker.checkImageLink(imageLink2);
        boolean result3 = InputsChecker.checkImageLink(imageLink3);
        boolean result4 = InputsChecker.checkImageLink(imageLink4);
        boolean result5 = InputsChecker.checkImageLink(imageLink5);
        boolean result6 = InputsChecker.checkImageLink(imageLink6);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertTrue(result5);
        assertTrue(result6);
    }

    @Test
    void checkImageLink_TestImageLinkContainIncorrectExtension_False() {
        String imageLink1 = "cat.txt";
        String imageLink2 = "cat.docx";
        boolean result1 = InputsChecker.checkImageLink(imageLink1);
        boolean result2 = InputsChecker.checkImageLink(imageLink2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkImageLink_TestImageLinkNotContainExtension_False() {
        String imageLink1 = "cattxt";
        String imageLink2 = "cat";
        boolean result1 = InputsChecker.checkImageLink(imageLink1);
        boolean result2 = InputsChecker.checkImageLink(imageLink2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkCategoryName_TestForNull_False() {
        boolean result = InputsChecker.checkCategoryName(null);
        assertFalse(result);
    }

    @Test
    void checkCategoryName_TestCategoryNameLengthBorder_False() {
        StringBuilder categoryName1 = new StringBuilder();
        for (int i = 0; i < 41; ++i) {
            categoryName1.append("a");
        }
        String categoryName2 = "a";
        boolean result1 = InputsChecker.checkCategoryName(categoryName1.toString());
        boolean result2 = InputsChecker.checkCategoryName(categoryName2);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void checkCategoryName_TestCategoryNameLengthBorders_True() {
        StringBuilder categoryName1 = new StringBuilder();
        for (int i = 0; i < 40; ++i) {
            categoryName1.append("a");
        }
        boolean result1 = InputsChecker.checkCategoryName(categoryName1.toString());
        String categoryName2 = "ab";
        boolean result2 = InputsChecker.checkCategoryName(categoryName2);
        assertTrue(result1);
        assertTrue(result2);
    }

}