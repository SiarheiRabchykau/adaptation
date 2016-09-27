package by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivCalculatorTest extends BaseCalculatorTest {


    @Test(dataProvider = "divLong", groups = "simpleMathOp")
    public void longDivTest(long a, long b, long expected) {
        long result = calculator.div(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(groups = "simpleMathOp", expectedExceptions = NumberFormatException.class)
    public void longDivZeroThrowExceptionTest() {
        long result = calculator.div(30L, 0);
    }

    @Test(dataProvider = "divDouble", groups = "simpleMathOp")
    public void doubleDivTest(double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(groups = "simpleMathOp", expectedExceptions = NumberFormatException.class)
    public void doubleDivZeroThrowExeptionTest() {
        double result = calculator.div(30L, 0);
    }

    @DataProvider(name = "divLong")
    public Object[][] valueForDivDouble() {
        return new Object[][]{
                {1, 1, 1},
                {1, 2, 0},
                {-1, -1, 1},
                {1, -1, -1},
                {-1, 1, -1},
                {20, 10, 2},
                {-100, -50, 2}

        };
    }

    @DataProvider(name = "divDouble")
    public Object[][] valueForDivLong() {
        return new Object[][]{
                {1, 1, 1.0},
                {1, 2, 0.5},
                {-1, -1, 1.0},
                {1, -1, -1.0},
                {-1, 1, -1.0},
                {20, 10, 2.0},
                {-100, -50, 2.0}
        };
    }
}