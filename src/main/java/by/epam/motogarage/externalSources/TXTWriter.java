package by.epam.motogarage.externalSources;

import by.epam.motogarage.mototechnictype.Mototechnics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TXTWriter implements IWriter {

    @Override
    public void write(ArrayList<Mototechnics> motoList, String pathToWriteTXT) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWriteTXT));

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
