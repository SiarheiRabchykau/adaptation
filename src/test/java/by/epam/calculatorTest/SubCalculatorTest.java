package by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubCalculatorTest extends BaseCalculatorTest {

    @Test(dataProvider = "subLong", groups = "simpleMathOp")
    public void longSubTest(long a, long b, long expected) {
        long result = calculator.sub(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "subDouble", groups = "simpleMathOp")
    public void doubleSubTest(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }


    @DataProvider(name = "subLong")
    public Object[][] valueForSubDouble() {
        return new Object[][]{
                {0, 0, 0},
                {0, 1, -1},
                {1, 1, 0},
                {5, -5, 10},
                {-5, 5, -10},
                {0, -1, 1},
                {-1, -1, 0},
                {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                {Long.MIN_VALUE, Long.MAX_VALUE, 1}
        };
    }

    @DataProvider(name = "subDouble")
    public Object[][] valueForSubLong() {
        return new Object[][]{
                {0.0, 0.0, 0.0},
                {0, 1, -1.0},
                {1, 1, 0.0},
                {5, -5, 10.0},
                {-5, 5, -10.0},
                {0, -1, 1.0},
                {-1, -1, 0},
                {Double.MAX_VALUE, 1, Double.MAX_VALUE}
        };
    }
}
