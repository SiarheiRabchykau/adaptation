package by.epam.motogarage.externalSources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import by.epam.motogarage.Garage;
import by.epam.motogarage.mototechnictype.Mototechnics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONWriter implements IWriter {

    @Override
    public void write(ArrayList<Mototechnics> arrayMoto, String pathToWrite) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWrite));
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
