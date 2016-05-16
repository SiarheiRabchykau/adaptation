package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubCalculatorTest extends BaseCalculatorTest {

    @Test(dataProvider = "subLong", groups = "sub")
    public void longSubTest(long a, long b, long expected) {
        long result = calculator.sub(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "subDouble", groups = "sub")
    public void doubleSubTest(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }


    @DataProvider(name = "subLong")
    public Object[][] valueForSubDouble() {
        return new Object[][]{
                {0, 0, 0},
                {0, 1, -1},
                {50, 50, 0},
                {0, -1, 1},
                {-1, -1, 0},
                {-50, -50, 0}
        };
    }

    @DataProvider(name = "subDouble")
    public Object[][] valueForSubLong() {
        return new Object[][]{
                {0, 0, 0.0},
                {0, 1, -1.0},
                {50, 50, 0.0},
                {0, -1, 1.0},
                {-1, -1, 0.0},
                {-50, -50, 0.0}
        };
    }
}
