package main.java.by.epam.testLection.testingFramework;

import org.testng.annotations.Test;

public class TestNgExample {
    Object object = new Object();

    @Test
    public void test1() {
        System.out.println("I'm object: " + object.toString());
    }

    @Test
    public void test2() {
        System.out.println("I'm object: " + object.toString());
    }
}
