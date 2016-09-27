package by.epam.calculatorTest.runners;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG tng = new TestNG();
        TestListenerAdapter tla = new TestListenerAdapter();
        tng.addListener(tla);
        tng.addListener(new MyListener());

        XmlSuite suite = new XmlSuite();
        suite.setName("TmlSuite");
        List<String> files = new ArrayList<>();
        files.addAll(new ArrayList<String>() {{
            add("src\\test\\resoures\\othertest.xml");
            add("src\\test\\resoures\\simpleop.xml");
            add("src\\test\\resoures\\trigonometry.xml");
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

