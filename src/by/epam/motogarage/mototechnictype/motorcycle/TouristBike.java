package by.epam.motogarage.mototechnictype.motorcycle;

import by.epam.motogarage.mototechnictype.Mototechnics;
import by.epam.motogarage.mototechnictype.interfaces.Tuning;

public class TouristBike extends Mototechnics implements Tuning{
    public TouristBike(String brand, String model,
                       int maxSpeed, int weight, int power,
                       int wheels, int caseCapacity,
                       double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(wheels);
        this.setCaseCapacity(caseCapacity);
    }

    //override from interfaces
    @Override
    public void reduceWeight() {
        int raceWeight = (int) (this.getWeight()/1.15);
        this.setWeight(raceWeight);
    }
    //override from interfaces
    @Override
    public void increasePower() {
        int racePower = (int) (this.getPower()*1.05);
        this.setPower(racePower);
    }

    //override abstract method from abstract class
    @Override
    public void makeSameNoise() {
        System.out.println("puf-puf-puf");
    }
}
