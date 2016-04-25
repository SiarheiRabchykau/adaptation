package by.epam.motogarage.mototechnictype.motorcycle;

import by.epam.motogarage.mototechnictype.Mototechnic;

public class ATV extends Mototechnic{
    public ATV(String brand, String model,
               int maxSpeed, int weight, int power,
               int caseCapacity,
               double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(4);
        this.setCaseCapacity(caseCapacity);
    }

    //override abstract method from abstract class
    @Override
    public void makeSameNoise() {
        System.out.println("Tr-tr-tr");
    }

}
