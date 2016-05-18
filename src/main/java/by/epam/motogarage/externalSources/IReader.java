package by.epam.motogarage.externalSources;

import by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;


public interface IReader {
    ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList, String pathToFile);
}
