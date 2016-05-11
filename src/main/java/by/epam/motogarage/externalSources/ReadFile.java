package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.*;
import java.util.ArrayList;

public class ReadFile implements GetDataFromExternalSources {
    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\moto.txt"));

            while (reader.ready()) {
                try {
                    String motoValues[] = reader.readLine().split(" ");
                    String brand = motoValues[0];//brand
                    String model = motoValues[1];//model
                    int weight = Integer.parseInt(motoValues[2]);//weight
                    int maxSpeed = Integer.parseInt(motoValues[3]);//max speed
                    int power = Integer.parseInt(motoValues[4]);//power
                    int wheels = Integer.parseInt(motoValues[5]);//number of wheel
                    int case_cap = Integer.parseInt(motoValues[6]);//case capacity
                    double cost = Double.parseDouble(motoValues[7]);//cost

                    Mototechnics newMotoFromFile;
                    if (case_cap > 0) {
                        if (wheels > 3) {
                            newMotoFromFile = new ATV(brand, model, maxSpeed, weight, power, case_cap, cost);
                        } else {
                            newMotoFromFile = new TouristBike(brand, model, maxSpeed, weight, power, wheels, case_cap, cost);
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
            System.out.println("File with data not found!");
        } catch (IOException e) {
            System.out.println("Same error with TXT file");
            e.printStackTrace();
        }
        return arrayMoto;
    }

    public static void write(ArrayList<Mototechnics> motoList) throws IOException {
        try {
            File file = new File("D:\\TXTmoto.txt");

            FileWriter fWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter writer = new BufferedWriter(fWriter);

            for (Mototechnics list : motoList) {
                writer.write(list.getInfo() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to write data to file!");
            e.printStackTrace();
        }
    }


}
