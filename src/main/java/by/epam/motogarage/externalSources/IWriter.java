package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;

public interface IWriter {
    void write(ArrayList<Mototechnics> mototechnicsArrayList, String pathToFile);
}
