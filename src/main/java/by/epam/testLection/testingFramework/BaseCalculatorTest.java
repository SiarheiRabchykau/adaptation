package main.java.by.epam.testLection.testingFramework;

import org.testng.annotations.BeforeClass;

import java.util.Date;


public class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeClass()
    public void setUp() {
        calculator = new Calculator();
    }

    protected void checkTime() {
        System.out.println("Current time: " + new Date(System.currentTimeMillis()));
    }
}
