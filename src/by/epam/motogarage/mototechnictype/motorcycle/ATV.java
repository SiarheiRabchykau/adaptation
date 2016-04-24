package by.epam.motogarage.mototechnictype.motorcycle;

import by.epam.motogarage.mototechnictype.Mototechnic;
import by.epam.motogarage.mototechnictype.interfaces.Tuning;

public class ATV extends Mototechnic implements Tuning {
    public ATV(String brand, String model,
               int maxSpeed, int weight, int power,
               int caseCapacity,
               double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.wheels = 4;
        this.caseCapacity = caseCapacity;
    }

    //override abstract method from abstract class
    @Override
    public void makeSameNoise() {
        System.out.println("Tr-tr-tr");
    }

    //override from interfaces
    @Override
    public void reduceWeight() {
        int raceWeight = (int) (this.getWeigth()/1.01);
        this.setWeigth(raceWeight);
    }
    //override from interfaces
    @Override
    public void increasePower() {
        int racePower = (int) (this.getPower()*1.01);
        this.setPower(racePower);
    }

}
