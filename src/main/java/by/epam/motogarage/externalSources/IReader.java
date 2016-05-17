package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;


public interface IReader {
    ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList, String pathToFile);
}
