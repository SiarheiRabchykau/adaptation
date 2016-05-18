package main.java.by.epam.calculatorTest;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class CosCalculatorTest extends BaseCalculatorTest {

    @BeforeGroups("cos")
    public void setUpGroup() {
        System.out.println("Before Group");
    }

    @AfterGroups("cos")
    public void cleanUpGroup() {
        System.out.println("After Group");
    }


    @BeforeMethod()
    public void setUpMethod() {
        System.out.println("Before method in class" + getClass());
    }

    @AfterMethod()
    public void cleanUpMethod() {
        System.out.println("After method in class" + getClass());
    }


    @Test(priority = 0, groups = "cos")
    public void cos0() {
        double result = calculator.cos(0);
        assertEquals(result, 1.0);
    }


    @Test(priority = 1, groups = "cos")
    public void cos30() {
        double result = round(calculator.cos(Math.PI / 6));
        assertEquals(result, 0.866);
    }

    @Test(priority = 2, groups = "cos")
    public void cos45() {
        double result = round(calculator.cos(Math.PI / 4));
        assertEquals(result, 0.7071);
    }

    @Test(priority = 1, groups = "cos")
    public void cos60() {
        double result = round(calculator.cos(Math.PI / 3));
        assertEquals(result, 0.5);
    }

    private double round(double value) {
        return (double) Math.round(value * 10000d) / 10000d;
    }
}