package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivCalculatorTest extends BaseCalculatorTest{



    @Test(dataProvider = "divLong", groups = "div")
    public void longDivTest(long a, long b, long expected) {
        long result = calculator.div(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "divDouble", groups = "div")
    public void doubleDivTest(double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }


    @DataProvider(name = "divLong")
    public Object[][] valueForDivDouble() {
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

    @DataProvider(name = "divDouble")
    public Object[][] valueForDivLong() {
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

