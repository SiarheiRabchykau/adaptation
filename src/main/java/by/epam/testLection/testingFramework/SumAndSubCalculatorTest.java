package by.epam.testLection.testingFramework;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumAndSubCalculatorTest extends BaseCalculatorTest {

    @Test(groups = "sum")
    public void onePlusTwoEqualsThree() {
        long result = calculator.sum(1, 2);
        assertEquals(result, 3, "Invali result of operation");
    }

    @Test(groups = "sub")
    public void tenMinusHundred() {
        long result = calculator.sub(10, 100);
        assertEquals(result, -90, "Invalid result of opertion");
    }

    @Test(dataProvider = "sumDp", groups = "sum")
    public void oneValuePlusAnother(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @Test(dataProvider = "subDp", groups = "sub")
    public void oneValueMinusAnother(long a, long b, long expected) {
        long result = calculator.sub(a, b);
        assertEquals(result, expected, "Invali result of operation");
    }

    @DataProvider(name = "sumDp")
    public Object[][] valueForSum() {
        return new Object[][]{
                {20, 15, 35},
                {9, 6, 15},
                {1, -10, -9},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "subDp")
    public Object[][] valueForSub() {
        return new Object[][]{
                {20, 15, 5},
                {9, 6, 3},
                {1, -10, 11},
                {0, 0, 0}

        };
    }

}
