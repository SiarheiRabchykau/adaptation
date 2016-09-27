package by.epam.testLection.testingFramework.runner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        tng.addListener(tla);
        tng.addListener(new MyTestListener());

        XmlSuite suite = new XmlSuite();
        suite.setName("TmlSuite");

        List<String> files = new ArrayList<>();
        files.addAll(new ArrayList<String>() {{
            add("D:\\Source\\IDEA\\adaptation\\src\\main\\java\\by\\epam\\testLection\\testingFramework\\by.epam.suites\\calculator.xml");
            add("D:\\Source\\IDEA\\adaptation\\src\\main\\java\\by\\epam\\testLection\\testingFramework\\by.epam.suites\\parallel.xml");
        }});
        suite.setSuiteFiles(files);
        suite.setParallel(XmlSuite.PARALLEL_METHODS);
        suite.setThreadCount(4);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);

        tng.run();
    }
}
