package main.java.by.epam.motogarage.externalSources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import main.java.by.epam.motogarage.Garage;
import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.*;
import java.util.ArrayList;

public class ReadJSON implements GetDataFromExternalSources {
    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\JSONwithmoto.json"));
            Garage garage = gson.fromJson(br, Garage.class);

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
            System.out.println("Unable to read JSON file!!");
        }

        return arrayMoto;
    }

    public static void write(ArrayList<Mototechnics> arrayMoto)  {
        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s = gson.toJson(arrayMoto);
            System.out.println(s);

            FileWriter fWriter = new FileWriter("D:\\TXTmoto.txt");
            BufferedWriter writer = new BufferedWriter(fWriter);

            for (Mototechnics list : arrayMoto) {
                writer.write(list.getInfo() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to write data to file!");
            e.printStackTrace();
        }


    }


}
