package by.epam.motogarage.mototechnictype.motorcycle;

import by.epam.motogarage.mototechnictype.Mototechnic;
import by.epam.motogarage.mototechnictype.interfaces.Tuning;

public class SportBikes extends Mototechnic implements Tuning {
    public SportBikes(String brand, String model,
                      int maxSpeed, int weight, int power,
                      double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.wheels = 2;
        this.caseCapacity = 0;
    }

    public void doWheelie() {
        if (this.getWeigth() > 300 | this.power < 120) {
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
        int raceWeight = (int) (this.getWeigth()/1.02);
        this.setWeigth(raceWeight);
    }

    //override from interfaces
    @Override
    public void increasePower() {
        int racePower = (int) (this.getPower()*1.15);
        this.setPower(racePower);
    }
}
