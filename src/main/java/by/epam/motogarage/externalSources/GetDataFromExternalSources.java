package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;

interface GetDataFromExternalSources {
    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList){
        return mototechnicsArrayList;
    }

    public static ArrayList<Mototechnics> create(ArrayList<Mototechnics> mototechnicsArrayList){
        return mototechnicsArrayList;
    }
}

//create, read, update, delete