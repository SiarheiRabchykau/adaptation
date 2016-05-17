package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TgCalculatorTest extends BaseCalculatorTest{
    @Test(dataProvider = "tgDouble", groups = "tg")
    public void doubleTgTest(double a, double expected) {
        double result = calculator.tg(a);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "tgDouble")
    public Object[][] valueForTgDouble() {
        return new Object[][]{
                {2.5, -0.7470222972386603},
                {5, -3.380515006246586},
                {0, 0.0},
                {-1, -1.5574077246549023},
                {-2, 2.185039863261519},
                {-2.5, 0.7470222972386603}
        };
    }
}
