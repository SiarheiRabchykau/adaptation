package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultCalculatorTest extends BaseCalculatorTest {


    @Test(dataProvider = "multLong", groups = "mult")
    public void longMultTest(long a, long b, long expected) {
        long result = calculator.mult(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "multDouble", groups = "mult")
    public void doubleMultTest(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }


    @DataProvider(name = "multLong")
    public Object[][] valueForMultDouble() {
        return new Object[][]{
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
                {-1, 0, 0},
                {0, -1, 0},
                {-1, -1, 1},
                {2, 2, 4},
                {-2, -2, 4}
        };
    }

    @DataProvider(name = "multDouble")
    public Object[][] valueForMultLong() {
        return new Object[][]{
                {0, 0, 0.0},
                {1, 0, 0.0},
                {0, 1, 0.0},
                {1, 1, 1.0},
                {-1, 0, 0.0},   //actual -0.0
                {0, -1, 0.0},   //actual -0.0
                {-1, -1, 1.0},
                {2, 2, 4.0},
                {-2, -2, 4.0},
                {3.6, 3.6, 12.96},          //actual 12
                {0.5, 0.5, 0.25},           //actual 0.0
                {13.75, 18.95, 260.5625}    //actual 260.0
        };
    }
}

