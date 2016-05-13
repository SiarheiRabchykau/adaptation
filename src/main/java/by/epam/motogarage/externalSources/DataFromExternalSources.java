package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.io.IOException;
import java.util.ArrayList;

interface DataFromExternalSources {
    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList){
        return mototechnicsArrayList;
    }

    public static void create(ArrayList<Mototechnics> mototechnicsArrayList){
        return;
    };
}
