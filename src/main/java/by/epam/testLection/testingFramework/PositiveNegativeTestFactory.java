package main.java.by.epam.testLection.testingFramework;

import org.testng.annotations.Factory;

public class PositiveNegativeTestFactory {

    @Factory
    public Object [] getTest() {
        return new Object[] {
                new PositiveNegativeTest(10, true, false),
                new PositiveNegativeTest(0, false, false)
        };
    }
}
