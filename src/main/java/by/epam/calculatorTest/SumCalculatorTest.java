package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumCalculatorTest extends BaseCalculatorTest{


    @Test(dataProvider = "sumLong", groups = "sum")
    public void longSumTest(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "sumDouble", groups = "sum")
    public void doubleSumTest(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }


    @DataProvider(name = "sumLong")
    public Object[][] valueForSumDouble() {
        return new Object[][]{
                {0, 1, 1},
                {1, 1, 2},
                {50, 50, 100},
                {0, 0, 0},
                {0, -1, -1},
                {-1, -1, -2},
                {-50, -50, -100},
                {0,0,0}
        };
    }

    @DataProvider(name = "sumDouble")
    public Object[][] valueForSumLong() {
        return new Object[][]{
                {0, 1, 1.0},
                {1, 1, 2.0},
                {50, 50, 100.0},
                {0, 0, 0.0},
                {0, -1, -1.0},
                {-1, -1, -2.0},
                {-50, -50, -100.0},
                {0,0,0.0}
        };
    }
}
