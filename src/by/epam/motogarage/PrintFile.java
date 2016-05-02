package by.epam.motogarage;

import by.epam.motogarage.mototechnictype.Mototechnics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class PrintFile {
    static void writeDataToFile(ArrayList<Mototechnics> motoList, String fileAddress) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileAddress)));

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
