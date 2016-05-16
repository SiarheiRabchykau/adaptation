package main.java.by.epam.testLection.testingFramework.runner;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MyTestListener implements IInvokedMethodListener {


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult TestResult) {
        System.out.println("method started: " + method.getTestMethod().getMethod());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("method finished [" + testResult.getStatus() + "]" + method.getTestMethod().getMethodName() + "\n");
    }
}
