package by.epam.motogarage.mototechnictype.motorcycle;

import by.epam.motogarage.mototechnictype.Mototechnics;
import by.epam.motogarage.mototechnictype.interfaces.Tuning;

public class SportBikes extends Mototechnics implements Tuning{
    public SportBikes(String brand, String model,
                      int maxSpeed, int weight, int power,
                      double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(2);
        this.setCaseCapacity(0);
    }

    public void doWheelie() {
        if (this.getWeight() > 300 | this.getPower() < 120) {
            System.out.println("Sorry, but your motorcycle is not powerful");
        } else {
            System.out.println("Hey! Be careful!");
        }
    }

    //override abstract method from abstract class
    @Override
    public void makeSameNoise() {
        System.out.println("Vzhzhzhzh");
    }

    //override from interfaces
    @Override
    public void reduceWeight() {
        int raceWeight = (int) (this.getWeight()/1.02);
        this.setWeight(raceWeight);
    }

    //override from interfaces
    @Override
    public void increasePower() {
        int racePower = (int) (this.getPower()*1.15);
        this.setPower(racePower);
    }
}
