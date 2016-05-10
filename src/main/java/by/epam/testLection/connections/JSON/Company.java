package main.java.by.epam.testLection.connections.JSON;

import java.util.List;


public class Company {
    public List<Employee> staff;

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }
}
