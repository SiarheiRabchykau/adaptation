package main.java.by.epam.testLection.exceptions;

class Test {
    public static void main(String[] args) {
        int a = 4;
        try {
            System.out.println(a/0);
        } catch (ArithmeticException e) {
            System.out.println("Произошла недопустимая арифметическая операция");
        }
    }
}