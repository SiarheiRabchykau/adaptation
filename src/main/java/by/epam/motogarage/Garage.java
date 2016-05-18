package by.epam.motogarage;

import by.epam.motogarage.mototechnictype.Mototechnics;

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
