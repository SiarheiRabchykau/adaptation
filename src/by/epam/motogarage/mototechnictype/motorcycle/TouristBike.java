package by.epam.motogarage.mototechnictype.motorcycle;

import by.epam.motogarage.mototechnictype.Mototechnic;

public class TouristBike extends Mototechnic{
    public TouristBike (String brand, String model, String nickname,
                        int maxSpeed, int weight,  int power,
                        int capacity, int wheels, int caseCapacity,
                        double cost) {
        this.brand = brand;
        this.model = model;
        this.nickname = nickname;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.power = power;
        this.capacity = capacity;
        this.wheels = wheels;
        this.caseCapacity = caseCapacity;
        this.cost = cost;
    }
}
