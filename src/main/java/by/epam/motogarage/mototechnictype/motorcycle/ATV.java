package main.java.by.epam.motogarage.mototechnictype.motorcycle;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

public class ATV extends Mototechnics {
    public ATV(String brand, String model,
               int maxSpeed, int weight, int power,
               int caseCapacity,
               double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(4);
        this.setCaseCapacity(caseCapacity);
    }
}
