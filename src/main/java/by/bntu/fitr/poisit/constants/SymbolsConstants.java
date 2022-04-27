package by.bntu.fitr.poisit.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymbolsConstants {
    public static final int APOSTROPHE_CODE = 39;
    public static final int HYPHEN_CODE = 45;
    public static final int SPACE_CODE = 32;
    public static final int LATIN_LOWER_BORDER_CODE = 65;
    public static final int LATIN_UPPER_BORDER_CODE = 122;
    public static final int NUMBER_LOWER_BORDER_CODE = 48;
    public static final int NUMBER_UPPER_BORDER_CODE = 57;
    public static final List<Character> CYRILLIC_LETTERS =
            new ArrayList<>(Arrays.asList(
                    'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т',
                    'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё',
                    'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                    'ъ', 'ы', 'ь', 'э', 'ю', 'я'));
    public static final List<Character> PUNCTUATION_MARKS =
            new ArrayList<>(Arrays.asList('.', ',', ';', ':', '?', '!', '-', '"', '(', ')'));
}
