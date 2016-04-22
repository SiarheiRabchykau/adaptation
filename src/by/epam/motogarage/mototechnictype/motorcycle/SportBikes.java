package by.epam.motogarage.mototechnictype.motorcycle;

/**
 * Created by Siarhei_Rabchykau on 4/22/2016.
 */
public class SportBikes extends stdmotorcycle {
    public SportBikes (String brand, String model, String nickname,
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
        this.wheels = 2;
        this.caseCapacity = 0;
        this.cost = cost;
    }
}
