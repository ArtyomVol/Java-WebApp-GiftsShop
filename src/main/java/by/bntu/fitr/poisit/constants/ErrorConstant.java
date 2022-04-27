package by.bntu.fitr.poisit.constants;

public class ErrorConstant {

    public static final byte SUCCESS_REGISTRATION = 11;
    public static final byte NOT_UNIQUE_USERNAME_IN_REGISTRATION = 12;
    public static final String NOT_UNIQUE_USERNAME_IN_REGISTRATION_MSG = "* Такой логин уже есть";
    public static final byte INVALID_FIRST_NAME_IN_REGISTRATION = 13;
    public static final String INVALID_FIRST_NAME_IN_REGISTRATION_MSG = "* Имя должно быть от 1 до 30 символов, " +
            "включая только буквы латиницы, кириллицы, апострофа, дефиса";
    public static final byte INVALID_LAST_NAME_IN_REGISTRATION = 14;
    public static final String INVALID_LAST_NAME_IN_REGISTRATION_MSG = "* Фамилия должна быть от 1 до 30 символов, " +
            "включая только буквы латиницы, кириллицы, апострофа, дефиса";
    public static final byte PASSWORD_MISMATCH_IN_REGISTRATION = 15;
    public static final String PASSWORD_MISMATCH_IN_REGISTRATION_MSG = "* Введённые пароли не совпадают";
    public static final byte INVALID_USERNAME_IN_REGISTRATION = 16;
    public static final String INVALID_USERNAME_IN_REGISTRATION_MSG = "* Логин должен быть от 5 до 20 символов, " +
            "включая только латинские буквы, цифры и знаки препинания";
    public static final byte INVALID_PASSWORD_IN_REGISTRATION = 17;
    public static final String INVALID_PASSWORD_IN_REGISTRATION_MSG = "* Пароль должен быть от 8 до 20 символов, " +
            "включая только латинские буквы, цифры и знаки препинания";

    public static final byte INVALID_PASSWORD_OR_LOGIN_IN_LOGIN = 22;
    public static final String INVALID_PASSWORD_OR_LOGIN_IN_LOGIN_MSG = "* Неверный логин или пароль";

    public static final byte SUCCESS_ITEM_ADD = 31;
    public static final String SUCCESS_ITEM_ADD_MSG = "* Товар успешно добавлен";
    public static final byte SUCCESS_ITEM_EDIT = 32;
    public static final String SUCCESS_ITEM_EDIT_MSG = "* Товар успешно изменён";
    public static final byte INVALID_ITEM_NAME = 33;
    public static final String INVALID_ITEM_NAME_MSG = "* Название товара должно быть от 5 до 50 символов, включая" +
            " только буквы латиницы или кириллицы, цифры, знаки препинания";
    public static final byte INVALID_ITEM_DESCRIPTION = 34;
    public static final String INVALID_ITEM_DESCRIPTION_MSG = "* Описание должно быть от 0 до 500 символов";
    public static final byte INVALID_ITEM_COST = 35;
    public static final String INVALID_ITEM_COST_MSG = "* Цена должна быть от 1 до 10 символов, включая только цифры";
    public static final byte INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK = 36;
    public static final String INVALID_ITEM_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG = "* Не загружено фото товара или тип файла " +
            "не верен, разрешены png, jpg, jfif, pjpeg, pjp, jpeg, или название фото превышает 500 символов";
    public static final byte INVALID_ITEM_IMAGE_LINK_EXPRESSION = 37;
    public static final String INVALID_ITEM_IMAGE_LINK_EXPRESSION_MSG = "* Тип файла не верен, разрешены" +
            " png, jpg, jfif, pjpeg, pjp, jpeg, или название фото превышает 500 символов";
    public static final byte INVALID_ITEM_ID = 38;
    public static final String INVALID_ITEM_ID_MSG = "* Выбранного товара не существует";

    public static final byte SUCCESS_CATEGORY_ADD = 41;
    public static final String SUCCESS_CATEGORY_ADD_MSG = "* Категория успешно добавлена";
    public static final byte SUCCESS_CATEGORY_EDIT = 42;
    public static final String SUCCESS_CATEGORY_EDIT_MSG = "* Категория успешно изменена";
    public static final byte SUCCESS_CATEGORY_DELETE = 43;
    public static final String SUCCESS_CATEGORY_DELETE_MSG = "* Категория успешно удалена";
    public static final byte NOT_UNIQUE_CATEGORY_NAME = 44;
    public static final String NOT_UNIQUE_CATEGORY_NAME_MSG = "* Данное название категории уже существует";
    public static final byte INVALID_CATEGORY_NAME = 45;
    public static final String INVALID_CATEGORY_NAME_MSG = "* Название категории должно быть от 2 до 40 символов";
    public static final byte INVALID_CATEGORY_ID = 46;
    public static final String INVALID_CATEGORY_ID_MSG = "* Выбранной категории не существует";

    public static final byte SUCCESS_NEWS_ADD = 50;
    public static final String SUCCESS_NEWS_ADD_MSG = "* Новость успешно добавлена";
    public static final byte INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK = 51;
    public static final String INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK_MSG = "* Не загружено изображение новости или тип файла " +
            "не верен, разрешены png, jpg, jfif, pjpeg, pjp, jpeg, или название изображения превышает 500 символов";
}
