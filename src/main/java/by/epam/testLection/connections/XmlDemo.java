package by.epam.testLection.connections;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class XmlDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.parse(new File("D:\\Source\\IDEA\\adaptation\\src\\main\\resources\\testxml.xml"));
        document.normalizeDocument();

        Element root = document.getDocumentElement();

        NodeList employees = root.getElementsByTagName("employee");
        //System.out.println(employees.item(1));
        for (int i = 0; i < employees.getLength(); i++){
            Element item = (Element) employees.item(i);
            String id = item.getAttribute("id");
            Element first_name = (Element) item.getElementsByTagName("first_name").item(0);
            System.out.println(String.format("id(%s) '%s' : '%s'", id, first_name.getTagName(), first_name.getTextContent()));
        }

    }
}
