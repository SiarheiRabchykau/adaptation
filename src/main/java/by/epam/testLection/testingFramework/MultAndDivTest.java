package by.epam.testLection.testingFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultAndDivTest extends BaseCalculatorTest{

    @Test(groups = "a")
    public void divOneValueByAnother() {
        double result = calculator.div(3D, 2D);
        Assert.assertEquals(result, 1.5D, "Invalid result of operation div");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void checkDivisionByZeroThrowsExeption() {
        double result = calculator.div(3D, 0D);
    }
}
