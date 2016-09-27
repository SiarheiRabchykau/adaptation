package by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class PositiveNegativeTest extends BaseCalculatorTest {

    private long value;
    private boolean expectedToBePositive;
    private boolean expectedToBeNegative;

    @Factory(dataProvider = "valuesForPosNeg")
    public PositiveNegativeTest(long value, boolean expectedToBePositive, boolean expectedToBeNegative) {
        this.value = value;
        this.expectedToBePositive = expectedToBePositive;
        this.expectedToBeNegative = expectedToBeNegative;
    }

    @Test(groups = "posNegTest")
    public void checkValuePositive() {
        assertTrue(calculator.isPositive(value) == expectedToBePositive);
    }


    @Test(groups = "posNegTest")
    public void checkValueNegative() {
        assertTrue(calculator.isNegative(value) == expectedToBeNegative);
    }

    @DataProvider(name = "valuesForPosNeg")
    public static Object[][] valuesForCheck() {
        return new Object[][]{
                {23, true, false},
                {1, true, false},
                {0, false, false},
                {-1, false, true},
                {-1000, false, true}
        };
    }
}