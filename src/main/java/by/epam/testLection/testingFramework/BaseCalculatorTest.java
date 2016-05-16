package main.java.by.epam.testLection.testingFramework;

import main.java.by.epam.testLection.testingFramework.calcSrc.Calculator;
import org.testng.annotations.BeforeClass;

import java.util.Date;


public class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeClass(groups = "a")
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Config1");
    }

    @BeforeClass(dependsOnGroups = "a")
    public void setUp2() {
        System.out.println("Config2");
    }

    @BeforeClass(groups = "a")
    public void setUp3() {
        System.out.println("Config3");
    }

    protected void checkTime() {
        System.out.println("Current time: " + new Date(System.currentTimeMillis()));
    }
}
