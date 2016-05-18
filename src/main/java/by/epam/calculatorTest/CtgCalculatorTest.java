package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.testng.Assert.assertEquals;

public class CtgCalculatorTest extends BaseCalculatorTest {

    @Test(dataProvider = "ctgDouble", groups = "trig")
    public void doubleCtgTest(double a, double expected) {
        double result = calculator.ctg(a);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "ctgDouble")
    public Object[][] valueForCtgDouble() {
        return new Object[][]{
                {4.5, 0.21564123255279444},
                {9, -2.2108454109991946},
                {0, POSITIVE_INFINITY},
                {-5.5, 1.0044355348765333},
                {-12, 1.5726734063976895}
        };
    }
}