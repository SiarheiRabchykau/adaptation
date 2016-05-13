package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class DataFromXML implements DataFromExternalSources {

    private static String xmlToReadFilePath = "src\\main\\resources\\XMLwithmoto.xml";
    private static String xmlToWriteFilePath = "D:\\testRW\\XMLmoto.xml";

    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = docBuilder.parse(new File(xmlToReadFilePath));
            doc.normalizeDocument();


            Element root = doc.getDocumentElement();

            NodeList moto = root.getElementsByTagName("moto");
            for (int i = 0; i < moto.getLength(); i++) {
                Element item = (Element) moto.item(i);
                Element brand_element = (Element) item.getElementsByTagName("brand").item(0);
                Element model_element = (Element) item.getElementsByTagName("model").item(0);
                Element max_speed_element = (Element) item.getElementsByTagName("max_speed").item(0);
                Element weight_element = (Element) item.getElementsByTagName("weight").item(0);
                Element power_element = (Element) item.getElementsByTagName("power").item(0);
                Element wheels_element = (Element) item.getElementsByTagName("wheels").item(0);
                Element case_cap_element = (Element) item.getElementsByTagName("caseCapacity").item(0);
                Element cost_element = (Element) item.getElementsByTagName("cost").item(0);

                String brand = brand_element.getTextContent();
                String model = model_element.getTextContent();
                int max_speed = Integer.parseInt(max_speed_element.getTextContent());
                int weight = Integer.parseInt(weight_element.getTextContent());
                int power = Integer.parseInt(power_element.getTextContent());
                int wheels = Integer.parseInt(wheels_element.getTextContent());
                int case_cap = Integer.parseInt(case_cap_element.getTextContent());
                double cost = Double.parseDouble(cost_element.getTextContent());


                Mototechnics newMotoFromDB;
                if (case_cap > 0) {
                    if (wheels > 3) {
                        newMotoFromDB = new ATV(brand, model, max_speed, weight, power, case_cap, cost);
                    } else {
                        newMotoFromDB = new TouristBike(brand, model, max_speed, weight, power, wheels, case_cap, cost);
                    }
                } else {
                    newMotoFromDB = new SportBikes(brand, model, max_speed, weight, power, cost);
                }
                arrayMoto.add(newMotoFromDB);

            }

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Unable to parse file!");
        } catch (IOException e) {
            System.out.println("Unable to read file!");
        }

        return arrayMoto;
    }

    public static void create(ArrayList<Mototechnics> arrayMoto){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();;
            Document document = documentBuilder.newDocument();

            //define root element
            Element rootElement = document.createElement("motoList");
            document.appendChild(rootElement);

            for (Mototechnics m : arrayMoto) {

                //define subroot element
                Element moto = document.createElement("moto");
                rootElement.appendChild(moto);

                //define child elements for branch
                Element brand = document.createElement("brand");
                brand.appendChild(document.createTextNode(m.getBrand()));
                moto.appendChild(brand);

                Element model = document.createElement("model");
                model.appendChild(document.createTextNode(m.getModel()));
                moto.appendChild(model);

                Element maxSpeed = document.createElement("maxSpeed");
                maxSpeed.appendChild(document.createTextNode(String.valueOf(m.getMaxSpeed())));
                moto.appendChild(maxSpeed);

                Element weight = document.createElement("weight");
                weight.appendChild(document.createTextNode(String.valueOf(m.getWeight())));
                moto.appendChild(weight);

                Element power = document.createElement("power");
                power.appendChild(document.createTextNode(String.valueOf(m.getPower())));
                moto.appendChild(power);

                Element wheels = document.createElement("wheels");
                wheels.appendChild(document.createTextNode(String.valueOf(m.getWheels())));
                moto.appendChild(wheels);

                Element caseCapacity = document.createElement("caseCapacity");
                caseCapacity.appendChild(document.createTextNode(String.valueOf(m.getCaseCapacity())));
                moto.appendChild(caseCapacity);

                Element cost = document.createElement("cost");
                cost.appendChild(document.createTextNode(String.valueOf(m.getCost())));
                moto.appendChild(cost);
            }

            document.normalizeDocument();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            Result result = new StreamResult(new File(xmlToWriteFilePath));

            transformer.transform(domSource, result);
        } catch (TransformerException |ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
