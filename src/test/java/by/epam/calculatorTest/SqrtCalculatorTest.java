package by.epam.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.NaN;
import static org.testng.Assert.assertEquals;

public class SqrtCalculatorTest extends BaseCalculatorTest {

    @Test(dataProvider = "sqrtDouble", groups = "sqrt")
    public void doubleSqrtTest(double a, double expected) {
        double result = calculator.sqrt(a);
        assertEquals(result, expected, "Invalid result of operation");
    }

    @DataProvider(name = "sqrtDouble")
    public Object[][] valueForSqrtDouble() {
        return new Object[][]{
                {4, 2},
                {9, 3},
                {0, 0},
                {1, 1},
                {150, 12.2474487139158904},
                {25.5, 5.049752469181039},
                {-81, NaN},                       //error
                {-49, NaN}                        //error
        };
    }
}