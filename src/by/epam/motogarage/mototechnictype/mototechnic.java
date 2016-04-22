package by.epam.motogarage.mototechnictype;

public abstract class Mototechnic {
    protected String brand;
    protected String model;
    protected String nickname;

    protected int maxSpeed;
    protected int weight;
    protected int power;
    protected int capacity;
    protected int wheels;
    protected int caseCapacity;

    protected double cost;

    protected boolean isNaked;

    protected Mototechnic() {
    }

    // getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand() {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel() {
        this.model = model;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname() {
        this.nickname = nickname;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed() {
        this.maxSpeed = maxSpeed;
    }

    public int getWeigth() {
        return weight;
    }

    public void setWeigth() {
        this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public void setPower() {
        this.power = power;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity() {
        this.capacity = capacity;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels() {
        this.wheels = wheels;
    }

    public int getCaseCapacity() {
        return caseCapacity;
    }

    public void setCaseCapacity() {
        this.caseCapacity= caseCapacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = cost;
    }

    public boolean getIsNaked() {
        return isNaked;
    }

    public void setIsNaked() {
        this.isNaked = isNaked;
    }

}
