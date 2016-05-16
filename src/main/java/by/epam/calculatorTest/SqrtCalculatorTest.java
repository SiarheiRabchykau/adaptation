package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SqrtCalculatorTest extends BaseCalculatorTest{

    @Test(dataProvider = "sqrtDouble", groups = "sqrt")
    public void doubleSqrtTest(double a, double expected) {
        double result = calculator.sqrt(a);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "sqrtDouble")
    public Object[][] valueForSqrtDouble() {
        return new Object[][]{
                {4, 2},
                {9, 3},
                {0, 0}
        };
    }
}
