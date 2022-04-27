package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.constants.ErrorConstant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertingErrorListTest {
    private final String defaultResult = "Ошибки:";

    @Test
    void convertLoginErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertLoginErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertLoginErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertLoginErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertLoginErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertLoginErrorListToString_TestPresenceOfErrorINVALID_PASSWORD_OR_LOGIN_IN_LOGIN_StringMsgContainINVALID_PASSWORD_OR_LOGIN_IN_LOGIN_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_PASSWORD_OR_LOGIN_IN_LOGIN));
        String expectedResult = ErrorConstant.INVALID_PASSWORD_OR_LOGIN_IN_LOGIN_MSG;
        String result = ConvertingErrorList.convertLoginErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertRegistrationErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertRegistrationErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfErrorNOT_UNIQUE_USERNAME_IN_REGISTRATION_StringMsgContainNOT_UNIQUE_USERNAME_IN_REGISTRATION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION));
        String expectedResult = ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION_MSG;
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfErrorINVALID_FIRST_NAME_IN_REGISTRATION_StringMsgContainINVALID_FIRST_NAME_IN_REGISTRATION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION));
        String expectedResult = ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION_MSG;
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfErrorINVALID_LAST_NAME_IN_REGISTRATION_StringMsgContainINVALID_LAST_NAME_IN_REGISTRATION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION));
        String expectedResult = ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION_MSG;
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfErrorPASSWORD_MISMATCH_IN_REGISTRATION_StringMsgContainPASSWORD_MISMATCH_IN_REGISTRATION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION));
        String expectedResult = ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION_MSG;
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfErrorINVALID_USERNAME_IN_REGISTRATION_StringMsgContainINVALID_USERNAME_IN_REGISTRATION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_USERNAME_IN_REGISTRATION));
        String expectedResult = ErrorConstant.INVALID_USERNAME_IN_REGISTRATION_MSG;
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfErrorINVALID_PASSWORD_IN_REGISTRATION_StringMsgContainINVALID_PASSWORD_IN_REGISTRATION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION));
        String expectedResult = ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION_MSG;
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertRegistrationErrorListToString_TestPresenceOfAllError_StringMsgContainAllErrorMsg() {
        List<Byte> errorsCodes = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION,
                ErrorConstant.INVALID_USERNAME_IN_REGISTRATION, ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION,
                ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION, ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION));
        List<String> expectedResults = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION_MSG,
                ErrorConstant.INVALID_USERNAME_IN_REGISTRATION_MSG, ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION_MSG,
                ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION_MSG, ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION_MSG));
        String result = ConvertingErrorList.convertRegistrationErrorListToString(errorsCodes);
        for (String expectedResult : expectedResults) {
            assertTrue(result.contains(expectedResult));
        }
    }

    @Test
    void convertItemAddingErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertItemAddingErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertItemAddingErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertItemAddingErrorListToString_TestPresenceOfErrorINVALID_ITEM_NAME_StringMsgContainINVALID_ITEM_NAME_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME));
        String expectedResult = ErrorConstant.INVALID_ITEM_NAME_MSG;
        String result = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemAddingErrorListToString_TestPresenceOfErrorINVALID_ITEM_DESCRIPTION_StringMsgContainINVALID_ITEM_DESCRIPTION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_DESCRIPTION));
        String expectedResult = ErrorConstant.INVALID_ITEM_DESCRIPTION_MSG;
        String result = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemAddingErrorListToString_TestPresenceOfErrorINVALID_ITEM_COST_StringMsgContainINVALID_ITEM_COST_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_COST));
        String expectedResult = ErrorConstant.INVALID_ITEM_COST_MSG;
        String result = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemAddingErrorListToString_TestPresenceOfErrorINVALID_CATEGORY_ID_StringMsgContainINVALID_CATEGORY_ID_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_CATEGORY_ID));
        String expectedResult = ErrorConstant.INVALID_CATEGORY_ID_MSG;
        String result = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemAddingErrorListToString_TestPresenceOfErrorINVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK_StringMsgContainINVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK));
        String expectedResult = ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG;
        String result = ConvertingErrorList.convertItemAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemAddingErrorListToString_TestPresenceOfAllError_StringMsgContainAllErrorMsg() {
        List<Byte> errorsCodes = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME,
                ErrorConstant.INVALID_ITEM_DESCRIPTION, ErrorConstant.INVALID_ITEM_COST,
                ErrorConstant.INVALID_CATEGORY_ID, ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK));
        List<String> expectedResults = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME_MSG,
                ErrorConstant.INVALID_ITEM_DESCRIPTION_MSG, ErrorConstant.INVALID_ITEM_COST_MSG,
                ErrorConstant.INVALID_CATEGORY_ID_MSG, ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG));
        String result = ConvertingErrorList.convertItemAddingErrorListToString(errorsCodes);
        for (String expectedResult : expectedResults) {
            assertTrue(result.contains(expectedResult));
        }
    }

    @Test
    void convertItemEditingErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertItemEditingErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertItemEditingErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfErrorINVALID_ITEM_NAME_StringMsgContainINVALID_ITEM_NAME_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME));
        String expectedResult = ErrorConstant.INVALID_ITEM_NAME_MSG;
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfErrorINVALID_ITEM_DESCRIPTION_StringMsgContainINVALID_ITEM_DESCRIPTION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_DESCRIPTION));
        String expectedResult = ErrorConstant.INVALID_ITEM_DESCRIPTION_MSG;
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfErrorINVALID_ITEM_COST_StringMsgContainINVALID_ITEM_COST_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_COST));
        String expectedResult = ErrorConstant.INVALID_ITEM_COST_MSG;
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfErrorINVALID_CATEGORY_ID_StringMsgContainINVALID_CATEGORY_ID_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_CATEGORY_ID));
        String expectedResult = ErrorConstant.INVALID_CATEGORY_ID_MSG;
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfErrorINVALID_ITEM_IMAGE_LINK_EXPRESSION_StringMsgContainINVALID_ITEM_IMAGE_LINK_EXPRESSION_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION));
        String expectedResult = ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_MSG;
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfErrorINVALID_ITEM_ID_StringMsgContainINVALID_ITEM_ID_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_ID));
        String expectedResult = ErrorConstant.INVALID_ITEM_ID_MSG;
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertItemEditingErrorListToString_TestPresenceOfAllError_StringMsgContainAllErrorMsg() {
        List<Byte> errorsCodes = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME,
                ErrorConstant.INVALID_ITEM_DESCRIPTION, ErrorConstant.INVALID_ITEM_COST,
                ErrorConstant.INVALID_CATEGORY_ID, ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION,
                ErrorConstant.INVALID_ITEM_ID));
        List<String> expectedResults = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_ITEM_NAME_MSG,
                ErrorConstant.INVALID_ITEM_DESCRIPTION_MSG, ErrorConstant.INVALID_ITEM_COST_MSG,
                ErrorConstant.INVALID_CATEGORY_ID_MSG, ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_MSG,
                ErrorConstant.INVALID_ITEM_ID_MSG));
        String result = ConvertingErrorList.convertItemEditingErrorListToString(errorsCodes);
        for (String expectedResult : expectedResults) {
            assertTrue(result.contains(expectedResult));
        }
    }

    @Test
    void convertCategoryAddingErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertCategoryAddingErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertCategoryAddingErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertCategoryAddingErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertCategoryAddingErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertCategoryAddingErrorListToString_TestPresenceOfErrorNOT_UNIQUE_CATEGORY_NAME_StringMsgContainNOT_UNIQUE_CATEGORY_NAME_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME));
        String expectedResult = ErrorConstant.NOT_UNIQUE_CATEGORY_NAME_MSG;
        String result = ConvertingErrorList.convertCategoryAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertCategoryAddingErrorListToString_TestPresenceOfErrorINVALID_CATEGORY_NAME_StringMsgContainINVALID_CATEGORY_NAME_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_CATEGORY_NAME));
        String expectedResult = ErrorConstant.INVALID_CATEGORY_NAME_MSG;
        String result = ConvertingErrorList.convertCategoryAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertCategoryAddingErrorListToString_TestPresenceOfAllError_StringMsgContainAllErrorMsg() {
        List<Byte> errorsCodes = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME,
                ErrorConstant.INVALID_CATEGORY_NAME));
        List<String> expectedResults = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME_MSG,
                ErrorConstant.INVALID_CATEGORY_NAME_MSG));
        String result = ConvertingErrorList.convertCategoryAddingErrorListToString(errorsCodes);
        for (String expectedResult : expectedResults) {
            assertTrue(result.contains(expectedResult));
        }
    }

    @Test
    void convertCategoryEditingErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertCategoryEditingErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertCategoryEditingErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertCategoryEditingErrorListToString_TestPresenceOfErrorNOT_UNIQUE_CATEGORY_NAME_StringMsgContainNOT_UNIQUE_CATEGORY_NAME_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME));
        String expectedResult = ErrorConstant.NOT_UNIQUE_CATEGORY_NAME_MSG;
        String result = ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertCategoryEditingErrorListToString_TestPresenceOfErrorINVALID_CATEGORY_NAME_StringMsgContainINVALID_CATEGORY_NAME_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_CATEGORY_NAME));
        String expectedResult = ErrorConstant.INVALID_CATEGORY_NAME_MSG;
        String result = ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertCategoryEditingErrorListToString_TestPresenceOfErrorINVALID_CATEGORY_ID_StringMsgContainINVALID_CATEGORY_ID_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_CATEGORY_ID));
        String expectedResult = ErrorConstant.INVALID_CATEGORY_ID_MSG;
        String result = ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertCategoryEditingErrorListToString_TestPresenceOfAllError_StringMsgContainAllErrorMsg() {
        List<Byte> errorsCodes = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME,
                ErrorConstant.INVALID_CATEGORY_NAME, ErrorConstant.INVALID_CATEGORY_ID));
        List<String> expectedResults = new ArrayList<>(Arrays.asList(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME_MSG,
                ErrorConstant.INVALID_CATEGORY_NAME_MSG, ErrorConstant.INVALID_CATEGORY_ID_MSG));
        String result = ConvertingErrorList.convertCategoryEditingErrorListToString(errorsCodes);
        for (String expectedResult : expectedResults) {
            assertTrue(result.contains(expectedResult));
        }
    }

    @Test
    void convertCategoryDeletingErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertCategoryDeletingErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertCategoryDeletingErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertCategoryDeletingErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertCategoryDeletingErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertCategoryDeletingErrorListToString_TestPresenceOfErrorINVALID_CATEGORY_ID_StringMsgContainINVALID_CATEGORY_ID_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_CATEGORY_ID));
        String expectedResult = ErrorConstant.INVALID_CATEGORY_ID_MSG;
        String result = ConvertingErrorList.convertCategoryDeletingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }

    @Test
    void convertNewsAddingErrorListToString_TestForNull_Null() {
        String result = ConvertingErrorList.convertNewsAddingErrorListToString(null);
        assertNull(result);
    }

    @Test
    void convertNewsAddingErrorListToString_TestAbsenceOfErrors_ResultIsDefault() {
        List<Byte> errorsCode1 = new ArrayList<>();
        List<Byte> errorsCode2 = new ArrayList<>(Arrays.asList((byte) 0, (byte) -2));
        String expectedResult = defaultResult;
        String result1 = ConvertingErrorList.convertNewsAddingErrorListToString(errorsCode1);
        String result2 = ConvertingErrorList.convertNewsAddingErrorListToString(errorsCode2);
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
    }

    @Test
    void convertNewsAddingErrorListToString_TestPresenceOfErrorINVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK_StringMsgContainINVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG() {
        List<Byte> errorsCode = new ArrayList<>(Arrays.asList(ErrorConstant.INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK));
        String expectedResult = ErrorConstant.INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG;
        String result = ConvertingErrorList.convertNewsAddingErrorListToString(errorsCode);
        assertTrue(result.contains(expectedResult));
    }
}
