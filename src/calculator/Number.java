package calculator;

public class Number {
    private int value;
    private NumberType numberType;

    public Number(int value, NumberType numberType) {
        this.value = value;
        this.numberType = numberType;
    }

    public int getValue() {
        return value;
    }

    public NumberType getNumberType() {
        return numberType;
    }
}
