package calculator;

public class Logic {
    public static String calculate(Number firstNumber,Number secondNumber, String operation) throws Exception {
        int result = switch (operation) {
            case "+" -> firstNumber.getValue() + secondNumber.getValue();
            case "-" -> firstNumber.getValue() - secondNumber.getValue();
            case "*" -> firstNumber.getValue() * secondNumber.getValue();
            case "/" -> firstNumber.getValue() / secondNumber.getValue();
            default -> throw new Exception("Only [+/-*] sign`s allowed");
        };
        if(firstNumber.getNumberType()==NumberType.ROMAN) {
           return MethodStorage.convertRoman(result);
        }
        else {
            return String.valueOf(result);
        }
    }
}
