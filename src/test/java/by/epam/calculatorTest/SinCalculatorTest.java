package by.epam.calculatorTest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SinCalculatorTest extends BaseCalculatorTest {

    @Test(groups = "sin1" )
    public void sin0() {
        double result = calculator.sin(0);
        assertEquals(result, 0.0);
    }

    @Test(groups = "sin1", dependsOnMethods = "sin0")
    public void sin30() {
        double result = round(calculator.sin(Math.PI / 6));
        assertEquals(result, 0.5);
    }

    @Test(groups = "sin", dependsOnGroups = "sin1")
    public void sin45() {
        double result = round(calculator.sin(Math.PI / 4));
        assertEquals(result, 0.7071);
    }

    @Test(groups = "sin", dependsOnGroups = "sin1")
    public void sin60() {
        double result = round(calculator.sin(Math.PI / 3));
        assertEquals(result, 0.866);
    }

    private double round(double value) {
        return (double) Math.round(value * 10000d) / 10000d;
    }
}