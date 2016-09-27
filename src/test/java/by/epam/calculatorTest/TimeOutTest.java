package by.epam.calculatorTest;

import by.epam.calculatorTest.src.Timeout;
import org.testng.annotations.Test;

public class TimeOutTest{

    @Test(timeOut = 1300)
    public void testThisShouldPass() throws InterruptedException {
        Timeout.sleep(1);
        System.out.println("something");
    }

}
