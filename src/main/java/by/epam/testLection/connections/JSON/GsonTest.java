package main.java.by.epam.testLection.connections.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Random;

public class GsonTest {

    private static String file = "{\n" +
            " \"staff2\": [\n" +
            "\t{\n" +
            "\t\t\"id\": 100001,\n" +
            "\t\t\"first_name\": \"Gabriel\",\n" +
            "\t\t\"last_name\": \"Gooovich\",\n" +
            "\t\t\"gender\": \"M\",\n" +
            "\t\t\"currency\": \"USD\",\n" +
            "\t\t\"amount\": 1200\n" +
            "\t},\n" +
            "\t\t{\n" +
            "\t\t\"id\": 100010,\n" +
            "\t\t\"first_name\": \"Mikola\",\n" +
            "\t\t\"last_name\": \"Tesla\",\n" +
            "\t\t\"gender\": \"M\",\n" +
            "\t\t\"currency\": \"EUR\",\n" +
            "\t\t\"amount\": 1600\n" +
            "\t}\n" +
            " ]\n" +
            "}";

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
/*
        ArrayList<Employee> staff =new ArrayList<>();
        staff.add(getEmployee());
        staff.add(getEmployee());
        staff.add(getEmployee());
        staff.add(getEmployee());
        staff.add(getEmployee());

        Company company = new Company();
        company.setStaff(staff);
        System.out.printf(gson.toJson(company));*/
        Company company = gson.fromJson(file, Company.class);
        System.out.println(gson.toJson(company));
    }

/*    private static Employee getEmployee() {
        Employee employee = new Employee();

        Random rand = new Random();
        employee.setId(rand.nextInt(100000));
        employee.setFirstName("Max");
        employee.setLastName("Mad");
        employee.setGender("M");
        employee.setCurrency("USD");
        employee.setAmount(rand.nextInt(5000));
        return employee;
    }*/
}
