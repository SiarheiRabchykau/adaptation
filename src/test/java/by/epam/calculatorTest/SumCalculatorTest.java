package by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumCalculatorTest extends BaseCalculatorTest {


    @Test(dataProvider = "sumLong", groups = "simpleMathOp")
    public void longSumTest(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "sumDouble", groups = "simpleMathOp")
    public void doubleSumTest(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }


    @DataProvider(name = "sumLong")
    public Object[][] valueForSumDouble() {
        return new Object[][]{
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 2},
                {5, -5, 0},
                {-5, 5, 0},
                {0, -1, -1},
                {-1, -1, -2},
                {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                {Long.MIN_VALUE, Long.MAX_VALUE, -1}

        };
    }

    @DataProvider(name = "sumDouble")
    public Object[][] valueForSumLong() {
        return new Object[][]{
                {0.0, 0.0, 0.0},
                {0, 1, 1.0},
                {1, 1, 2.0},
                {5, -5, 0.0},
                {-5, 5, 0.0},
                {0, -1, -1.0},
                {-1, -1, -2.0},
                {0.5, 0.5, 1.0},
                {-0.5, 0.5, 0.0},
                {-0.5, -0.5, -1.0},
                {Double.MAX_VALUE, 1 ,Double.MAX_VALUE}
        };
    }
}