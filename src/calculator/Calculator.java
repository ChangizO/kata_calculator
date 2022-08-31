package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("Enter your expression: ");
            String input = scanner.nextLine();

            try {
                String[] array1 = input.split(" ");
                if (array1.length != 3)
                    throw new Exception("Invalid input parameters");

                Number firstNumber = MethodStorage.parsing(array1[0]);
                Number secondNumber = MethodStorage.parsing(array1[2], firstNumber.getNumberType());
                String result = Logic.calculate(firstNumber, secondNumber, array1[1]);
                System.out.println("Output: " + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        scanner.close();
    }
}
