package main.java.by.epam.motogarage;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class PrintFile {
    static void writeDataToFile(ArrayList<Mototechnics> motoList, String fileAddress) throws IOException {
        try {
            File file = new File(fileAddress);

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
