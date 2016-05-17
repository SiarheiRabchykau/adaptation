package main.java.by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PositiveNegativeTest extends BaseCalculatorTest {

    @Test(dataProvider = "positiveValue")
    public void checkValueNegative(long value, boolean expected) {
        boolean result = calculator.isPositive(value);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "negativeValue")
    public void checkValuePositive(long value, boolean expected) {
        boolean result = calculator.isNegative(value);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "positiveValue")
    public static Object[][] valueForPos() {
        return new Object[][]{
                {70, true},
                {1, true},
                {0, false},
                {-1, false},
                {-5, false}
        };
    }

    @DataProvider(name = "negativeValue")
    public static Object[][] valueForSinNeg() {
        return new Object[][]{
                {70, false},
                {1, false},
                {0, false},
                {-1, true},
                {-5, true}
        };
    }
}