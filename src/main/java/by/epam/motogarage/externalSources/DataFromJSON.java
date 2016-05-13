package main.java.by.epam.motogarage.externalSources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.by.epam.motogarage.Garage;
import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.*;
import java.util.ArrayList;

public class DataFromJSON implements DataFromExternalSources {

    private static String jsonToReadFilePath = "src\\main\\resources\\JSONwithmoto.json";
    private static String jsonToWriteFilePath = "D:\\testRW\\JSONmoto.json";

    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonToReadFilePath));
            Garage garage = gson.fromJson(bufferedReader, Garage.class);

            ArrayList<Mototechnics> newMotoList = new ArrayList<>();
            newMotoList.addAll(garage.getMotoList());

            for (Mototechnics m : newMotoList) {
                String brand = m.getBrand();
                String model = m.getModel();
                int maxSpeed = m.getMaxSpeed();
                int weight = m.getWeight();
                int wheels = m.getWheels();
                int power = m.getPower();
                int case_cap = m.getCaseCapacity();
                double cost = m.getCost();

                Mototechnics newMotoFromJSON;
                if (case_cap > 0) {
                    if (wheels > 3) {
                        newMotoFromJSON = new ATV(brand, model, maxSpeed, weight, power, case_cap, cost);
                    } else {
                        newMotoFromJSON = new TouristBike(brand, model, maxSpeed, weight, power, wheels, case_cap, cost);
                    }
                } else {
                    newMotoFromJSON = new SportBikes(brand, model, maxSpeed, weight, power, cost);
                }
                arrayMoto.add(newMotoFromJSON);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to read JSON file!");
        }

        return arrayMoto;
    }

    public static void create(ArrayList<Mototechnics> arrayMoto) {
        try {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonToWriteFilePath));
        Garage garage = new Garage();
        garage.setMotoList(arrayMoto);

        String s = gson.toJson(garage, Garage.class);

        writer.write(s);
        writer.close();

        } catch (IOException e) {
            System.out.println("Unable to write JSON data to file!");
            e.printStackTrace();
        }
    }
}
