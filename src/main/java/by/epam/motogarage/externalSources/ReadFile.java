package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Source\\IDEA\\adaptation\\src\\main\\resources\\moto.txt"));

            while (reader.ready()) {
                try {
                    String motoValues[] = reader.readLine().split(" ");
                    String brand = motoValues[0];//brand
                    String model = motoValues[1];//model
                    int weight = Integer.parseInt(motoValues[2]);//weight
                    int maxSpeed = Integer.parseInt(motoValues[3]);//max speed
                    int power = Integer.parseInt(motoValues[4]);//power
                    int wheels = Integer.parseInt(motoValues[5]);//number of wheel
                    int caseCapacity = Integer.parseInt(motoValues[6]);//case capacity
                    double cost = Double.parseDouble(motoValues[7]);//cost
                    Mototechnics newMotoFromFile;
                    if (caseCapacity > 0) {
                        if (wheels > 3) {
                            newMotoFromFile = new ATV(brand, model, maxSpeed, weight, power, caseCapacity, cost);
                        } else {
                            newMotoFromFile = new TouristBike(brand, model, maxSpeed, weight, power, wheels, caseCapacity, cost);
                        }
                    } else {
                        newMotoFromFile = new SportBikes(brand, model, maxSpeed, weight, power, cost);
                    }

                    arrayMoto.add(newMotoFromFile);
                } catch (NumberFormatException e) {
                    System.out.println("One of the parameters has wrong format");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File with data not found! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayMoto;
    }
}
