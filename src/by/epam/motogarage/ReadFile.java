package by.epam.motogarage;

import by.epam.motogarage.mototechnictype.Mototechnics;
import by.epam.motogarage.mototechnictype.motorcycle.ATV;
import by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<Mototechnics> readFileWithMoto(ArrayList<Mototechnics> arrayMoto, String fileAddress) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress));

        /* test.txt
        Brand;Model;Weight;Max_Speed;Power;Number_of_wheel;Case capacity;Cost
        Honda;Dio;60;80;5;2;0;500
        Kawasaki;ZX6R;180;220;120;2;0;2000
        Ducati;1198;171;300;157;2;0;35000
         */

            while (reader.ready()) {
                String motoValues[] = reader.readLine().split(";");
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

            }
        } catch (FileNotFoundException e) {
            System.out.println("File with data not found! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayMoto;
    }
}
