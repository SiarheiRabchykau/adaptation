package by.epam.secondLesson;

/*1.	Написать простейший калькулятор (реализовать как минимум
        4 операции: сложение, вычитание, умножение, деление) с вводом\выводом
        значений\результатов;*/

import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first num ");
        double firstNumber = scanner.nextInt();
        System.out.println("Enter operation ");
        String operation = scanner.next();
        System.out.println("Enter second num ");
        double secondNumber = scanner.nextInt();

        scanner.close();

        double result = Calculate(firstNumber, secondNumber, operation);
        System.out.println("Result\n" + result);

    }

    private static double Calculate(double firstNum, double secondNum, String operation) {
        double result = 0;
        switch (operation) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                if (secondNum == 0) {
                    System.out.println("Divide by zer0. You can crash the world!");
                    break;
                } else result = firstNum / secondNum;
                break;
        }
        return result;
    }
}