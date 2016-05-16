package main.java.by.epam.calculatorTest.src;

public class Timeout {
    public Timeout() {
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep((long)(sec * 1000));
        } catch (InterruptedException var2) {
            ;
        }

    }
}