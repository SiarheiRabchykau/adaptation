package by.epam.motogarage.mototechnictype;

public abstract class Mototechnics {
    protected String brand;
    protected String model;

    protected int maxSpeed;
    protected int weight;
    protected int power;
    protected int wheels;
    protected int caseCapacity;

    protected double cost;

    protected boolean isNaked;

    protected Mototechnics(String brand, String model,
                           int maxSpeed, int weight, int power,
                           double cost) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.power = power;
        this.cost = cost;

    }

    // getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int newMaxSpeed) {
        this.maxSpeed = newMaxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int newPower) {
        this.power = newPower;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int newNumberOfWheels) {
        this.wheels = newNumberOfWheels;
    }

    public int getCaseCapacity() {
        return caseCapacity;
    }

    public void setCaseCapacity(int newCaseCapacity) {
        this.caseCapacity = newCaseCapacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

    public boolean getIsNaked() {
        return isNaked;
    }

    public void setIsNaked(boolean newNaked) {
        this.isNaked = newNaked;
    }

    public String getInfo() {
        return "Brand: " + this.brand + " Model: " + this.model + " Max Speed: " + this.maxSpeed
                + " Weight: " + this.weight + " Power: " + this.power + " Number of wheel: " + this.wheels
                + " Case capacity: " + this.caseCapacity + " Cost: " + this.cost
                + " Is it naked bike: " + this.isNaked;
    }

    public void doWheelie(){
        System.out.println("Hey!" + this.model + " is not sportbike! It's can't do wheelie!");
    }

    public abstract void makeSameNoise();
}
