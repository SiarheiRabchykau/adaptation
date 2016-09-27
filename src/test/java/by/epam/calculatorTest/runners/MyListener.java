package by.epam.calculatorTest.runners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

class MyListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult TestResult) {
        System.out.println("method started: " + method.getTestMethod());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("method finished [" + testResult.getStatus() + "] " + method.getTestMethod().getMethodName() + "\n");
    }
}
