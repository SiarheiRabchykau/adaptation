package by.epam.motogarage;

import by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

public abstract class Main {
    public static void main(String[] args) {
        SportBikes cbr = new SportBikes("Honda", "CBR1100xx", 300, 259, 163, 7500.50);
        cbr.setCost(8000);
        cbr.setIsNaked(true);
        cbr.reduceWeight();
        cbr.increasePower();
        System.out.println(cbr.getInfo());
        cbr.doWheelie();
        cbr.makeSameNoise();

        TouristBike european = new TouristBike("Honda", "Pan European", 200, 350, 140, 2, 40, 3000);
        european.setIsNaked(false);
        System.out.println(european.getInfo());
        european.doWheelie();
    }
}
