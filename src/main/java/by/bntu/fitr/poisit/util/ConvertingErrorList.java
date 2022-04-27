package by.bntu.fitr.poisit.util;

import by.bntu.fitr.poisit.constants.ErrorConstant;

import java.util.List;

public class ConvertingErrorList {

    public static String convertLoginErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                if (errorCode == ErrorConstant.INVALID_PASSWORD_OR_LOGIN_IN_LOGIN) {
                    errorMsgSB.append(ErrorConstant.INVALID_PASSWORD_OR_LOGIN_IN_LOGIN_MSG);
                } else {
                    errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertRegistrationErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION:
                        errorMsgSB.append(ErrorConstant.NOT_UNIQUE_USERNAME_IN_REGISTRATION_MSG);
                        break;
                    case ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION:
                        errorMsgSB.append(ErrorConstant.INVALID_FIRST_NAME_IN_REGISTRATION_MSG);
                        break;
                    case ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION:
                        errorMsgSB.append(ErrorConstant.INVALID_LAST_NAME_IN_REGISTRATION_MSG);
                        break;
                    case ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION:
                        errorMsgSB.append(ErrorConstant.PASSWORD_MISMATCH_IN_REGISTRATION_MSG);
                        break;
                    case ErrorConstant.INVALID_USERNAME_IN_REGISTRATION:
                        errorMsgSB.append(ErrorConstant.INVALID_USERNAME_IN_REGISTRATION_MSG);
                        break;
                    case ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION:
                        errorMsgSB.append(ErrorConstant.INVALID_PASSWORD_IN_REGISTRATION_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertItemAddingErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.INVALID_ITEM_NAME:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_NAME_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_DESCRIPTION:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_DESCRIPTION_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_COST:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_COST_MSG);
                        break;
                    case ErrorConstant.INVALID_CATEGORY_ID:
                        errorMsgSB.append(ErrorConstant.INVALID_CATEGORY_ID_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertItemEditingErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.INVALID_ITEM_NAME:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_NAME_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_DESCRIPTION:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_DESCRIPTION_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_COST:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_COST_MSG);
                        break;
                    case ErrorConstant.INVALID_CATEGORY_ID:
                        errorMsgSB.append(ErrorConstant.INVALID_CATEGORY_ID_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_IMAGE_LINK_EXPRESSION_MSG);
                        break;
                    case ErrorConstant.INVALID_ITEM_ID:
                        errorMsgSB.append(ErrorConstant.INVALID_ITEM_ID_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertCategoryAddingErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.NOT_UNIQUE_CATEGORY_NAME:
                        errorMsgSB.append(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME_MSG);
                        break;
                    case ErrorConstant.INVALID_CATEGORY_NAME:
                        errorMsgSB.append(ErrorConstant.INVALID_CATEGORY_NAME_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertCategoryEditingErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.INVALID_CATEGORY_ID:
                        errorMsgSB.append(ErrorConstant.INVALID_CATEGORY_ID_MSG);
                        break;
                    case ErrorConstant.NOT_UNIQUE_CATEGORY_NAME:
                        errorMsgSB.append(ErrorConstant.NOT_UNIQUE_CATEGORY_NAME_MSG);
                        break;
                    case ErrorConstant.INVALID_CATEGORY_NAME:
                        errorMsgSB.append(ErrorConstant.INVALID_CATEGORY_NAME_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertCategoryDeletingErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.INVALID_CATEGORY_ID:
                        errorMsgSB.append(ErrorConstant.INVALID_CATEGORY_ID_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }

    public static String convertNewsAddingErrorListToString(List<Byte> errorsCode) {
        if (errorsCode != null) {
            StringBuilder errorMsgSB = new StringBuilder();
            errorMsgSB.append("Ошибки:");
            for (Byte errorCode : errorsCode) {
                errorMsgSB.append("\n");
                switch (errorCode) {
                    case ErrorConstant.INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK:
                        errorMsgSB.append(ErrorConstant.INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG);
                        break;
                    default:
                        errorMsgSB.deleteCharAt(errorMsgSB.length() - 1);
                        break;
                }
            }
            return errorMsgSB.toString();
        }
        return null;
    }
}
