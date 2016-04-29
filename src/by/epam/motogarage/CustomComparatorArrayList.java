package by.epam.motogarage;

import by.epam.motogarage.mototechnictype.Mototechnics;

import java.util.Comparator;

public class CustomComparatorArrayList implements Comparator<Mototechnics> {
    @Override
    public int compare(Mototechnics object1, Mototechnics object2) {
        return (object2.getWeight() - object1.getWeight());
    }
}
