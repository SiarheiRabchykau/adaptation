package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;

public interface GetDataFromExternalSources {
    static ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList){
        return mototechnicsArrayList;
    }

/*    static ArrayList<Mototechnics> print(ArrayList<Mototechnics> mototechnicsArrayList){
        return mototechnicsArrayList;
    }*/
}

//create, read, update, delete