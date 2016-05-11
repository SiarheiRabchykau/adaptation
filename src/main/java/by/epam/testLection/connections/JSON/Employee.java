package main.java.by.epam.testLection.connections.json;


public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Salary salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Salary getSalary() {
        return salary;
    }
}
