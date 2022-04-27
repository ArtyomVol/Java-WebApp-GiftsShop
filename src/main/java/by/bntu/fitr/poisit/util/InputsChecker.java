package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.constants.FileExtensionConstants;
import by.bntu.fitr.poisit.constants.SymbolsConstants;

public class InputsChecker {

    public static boolean checkFirstName(String firstName) {
        return isNotNull(firstName) && isStringLengthInInterval(firstName, 1, 30) &&
                isLettersInStringCyrillicLatinApostropheHyphen(firstName);
    }

    public static boolean checkLastName(String lastName) {
        return isNotNull(lastName) && isStringLengthInInterval(lastName, 1, 30) &&
                isLettersInStringCyrillicLatinApostropheHyphen(lastName);
    }

    public static boolean checkUsername(String username) {
        return isNotNull(username) && isStringLengthInInterval(username, 5, 20) &&
                isLettersInStringLatinNumberPunctuationMarks(username);
    }

    public static boolean checkPassword(String password) {
        return isNotNull(password) && isStringLengthInInterval(password, 8, 20) &&
                isLettersInStringLatinNumberPunctuationMarks(password);
    }

    public static boolean checkItemName(String itemName) {
        return isNotNull(itemName) && isStringLengthInInterval(itemName, 5, 50) &&
                isLettersInStringCyrillicLatinNumberPunctuationMarks(itemName);
    }

    public static boolean checkItemDescription(String itemDescription) {
        return isNotNull(itemDescription) && isStringLengthInInterval(itemDescription, 0,
                500);
    }

    public static boolean checkItemCost(String itemCost) {
        return isNotNull(itemCost) && isStringLengthInInterval(itemCost, 1, 10) &&
                isLettersInStringNumber(itemCost);
    }

    public static boolean checkCategoryName(String name) {
        return isNotNull(name) && isStringLengthInInterval(name, 2, 40);
    }

    public static boolean checkImageLink(String imageLink) {
        int pointIndex = 0;
        if (isNotNull(imageLink) && isStringLengthInInterval(imageLink, 1, 500)) {
            for (int i = imageLink.length() - 1; i > 0; i--) {
                if (imageLink.charAt(i) == '.') {
                    pointIndex = i;
                    break;
                }
            }
            String extension = imageLink.substring(pointIndex + 1);
            return FileExtensionConstants.IMAGE_EXTENSIONS.contains(extension);
        }
        return false;
    }

    private static boolean isNotNull(String string) {
        return string != null;
    }

    private static boolean isStringLengthInInterval(String string, int intervalLowerBorder, int intervalUpperBorder) {
        int stringLength = string.length();
        return stringLength >= intervalLowerBorder && stringLength <= intervalUpperBorder;
    }

    private static boolean isLettersInStringNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (!(letter >= SymbolsConstants.NUMBER_LOWER_BORDER_CODE &&
                    letter <= SymbolsConstants.NUMBER_UPPER_BORDER_CODE)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLettersInStringCyrillicLatinNumberPunctuationMarks(String string) {
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (!((letter >= SymbolsConstants.LATIN_LOWER_BORDER_CODE &&
                    letter <= SymbolsConstants.LATIN_UPPER_BORDER_CODE) ||
                    SymbolsConstants.CYRILLIC_LETTERS.contains(letter) ||
                    (letter >= SymbolsConstants.NUMBER_LOWER_BORDER_CODE &&
                            letter <= SymbolsConstants.NUMBER_UPPER_BORDER_CODE) ||
                    SymbolsConstants.PUNCTUATION_MARKS.contains(letter) ||
                    letter == SymbolsConstants.SPACE_CODE)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLettersInStringCyrillicLatinApostropheHyphen(String string) {
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (!(SymbolsConstants.CYRILLIC_LETTERS.contains(letter) ||
                    (letter >= SymbolsConstants.LATIN_LOWER_BORDER_CODE &&
                            letter <= SymbolsConstants.LATIN_UPPER_BORDER_CODE) ||
                    letter == SymbolsConstants.APOSTROPHE_CODE ||
                    letter == SymbolsConstants.HYPHEN_CODE)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLettersInStringLatinNumberPunctuationMarks(String string) {
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (!((letter >= SymbolsConstants.LATIN_LOWER_BORDER_CODE &&
                    letter <= SymbolsConstants.LATIN_UPPER_BORDER_CODE) ||
                    (letter >= SymbolsConstants.NUMBER_LOWER_BORDER_CODE &&
                            letter <= SymbolsConstants.NUMBER_UPPER_BORDER_CODE) ||
                    SymbolsConstants.PUNCTUATION_MARKS.contains(letter))) {
                return false;
            }
        }
        return true;
    }
}
