package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CosCalculatorTest extends BaseCalculatorTest {
    @Test(dataProvider = "cosDouble", groups = "cos")
    public void doubleCosTest(double a, double expected) {
        double result = calculator.cos(a);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "cosDouble")
    public Object[][] valueForCosDouble() {
        return new Object[][]{
                {0, 1.0},
                {3, -0.9899924966004454},
                {5.5, 0.70866977429126},
                {-2, -0.4161468365471424},
                {-7.2, 0.6083513145322546}
        };
    }
}