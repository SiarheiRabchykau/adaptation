package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PowCalculatorTest extends BaseCalculatorTest {


    @Test(dataProvider = "powDouble", groups = "pow")
    public void doublePowTest(double a, double b, double expected) {
        double result = calculator.pow(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "powDouble")
    public Object[][] valueForPowDouble() {
        return new Object[][]{
                {2, 2, 4.0},
                {5, 2, 25.0},
                {3, 3, 27.0}
                //{0, 0, 0.0}           error
        };
    }
}
