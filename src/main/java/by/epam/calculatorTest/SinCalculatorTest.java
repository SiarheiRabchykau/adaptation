package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SinCalculatorTest extends BaseCalculatorTest{
    @Test(dataProvider = "sinDouble", groups = "sin")
    public void doubleSinTest(double a, double expected) {
        double result = calculator.sin(a);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "sinDouble")
    public Object[][] valueForSinDouble() {
        return new Object[][]{
                {0, 0.0},
                {15, 0.6502878401571168},
                {7.8, 0.998543345374605},
                {-6, 0.27941549819892586},
                {-7.34, -0.8707938516910911}
        };
    }
}