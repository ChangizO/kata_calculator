package calculator;

import java.util.Map;
import java.util.TreeMap;

public class MethodStorage {
    private final static TreeMap<Integer, String> ROMAN_VALUE = new TreeMap<>();

    static {
        ROMAN_VALUE.put(1, "I");
        ROMAN_VALUE.put(4, "IV");
        ROMAN_VALUE.put(5, "V");
        ROMAN_VALUE.put(9, "IX");
        ROMAN_VALUE.put(10, "X");
        ROMAN_VALUE.put(40, "XL");
        ROMAN_VALUE.put(50, "L");
        ROMAN_VALUE.put(90, "XC");
        ROMAN_VALUE.put(100, "C");
    }

    public static String convertRoman(int number) {
        int i = ROMAN_VALUE.floorKey(number);
        if (i == number) {
            return ROMAN_VALUE.get(number);
        }
        return ROMAN_VALUE.get(i) + convertRoman(number - i);
    }

    private static int characterToNumber(char element) {
        int result = -1;
        for (Map.Entry<Integer, String> entry : ROMAN_VALUE.entrySet()) {
            if (entry.getValue().equals(String.valueOf(element))) {
                return entry.getKey();

            }
        }
        return result;
    }

    public static int convertArabic(String romanSign) throws Exception {
        int result = 0;
        int i = 0;
        while (i < romanSign.length()) {
            char element = romanSign.charAt(i);
            int num = characterToNumber(element);
            if (num < 0) {
                throw new Exception("Invalid method sigh");
            }
            i++;
            if (i == romanSign.length()) {
                result += num;
            } else {
                int nextNum = characterToNumber(romanSign.charAt(i));
                if (nextNum > num) {
                    result = (nextNum - num);
                    i++;
                } else {
                    result += num;
                }
            }
        }
        return result;
    }

    public static Number parsing(String element) throws Exception {
        int value;
        NumberType numberType;
        try {
            value = Integer.parseInt(element);
            numberType = NumberType.ARABIC;
        } catch (NumberFormatException e) {
            value = convertArabic(element);
            numberType = NumberType.ROMAN;
        }
        if (value < 1 || value > 10) {
            throw new Exception("Invalid input parameters : expression must contain elements from 1(I) to 10(X)");
        }
        return new Number(value, numberType);
    }

    public static Number parsing(String element, NumberType numberType) throws Exception {
        Number number = parsing(element);
        if (number.getNumberType() != numberType) {
            throw new Exception("Exception occurred : different number types");
        }
        return number;
    }
}
