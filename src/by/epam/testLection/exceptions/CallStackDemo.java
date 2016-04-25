package by.epam.testLection.exceptions;

public class CallStackDemo {
    public void first() {
        second();
    }
    private void second() {
        System.out.println("Job is done!");
    }
    public static void main(String[] args) {
        new CallStackDemo().first();
    }
}
