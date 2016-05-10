package main.java.by.epam.motogarage;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;

import java.util.ArrayList;

public class Garage {
    public ArrayList<Mototechnics> motoList;

    public ArrayList<Mototechnics> getMotoList() {
        return motoList;
    }

    public void setMotoList(ArrayList<Mototechnics> motoList) {
        this.motoList = motoList;
    }
}
