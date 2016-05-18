package by.epam.motogarage.externalSources;

import by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;

public interface IWriter {
    void write(ArrayList<Mototechnics> mototechnicsArrayList, String pathToFile);
}
