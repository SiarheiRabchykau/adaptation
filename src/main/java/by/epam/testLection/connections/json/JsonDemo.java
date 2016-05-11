package main.java.by.epam.testLection.connections.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Siarhei_Rabchykau on 5/4/2016.
 */
public class JsonDemo {

    static String file = "{\n" +
            "\t\"staff\": [\n" +
            "{\n" +
            "\"id\": 100001,\n" +
            "\"firstName\": \"gabriel\" \n" +
            "\"lastName\": \"goodovich\"\n" +
            "\"gender\": \"M\"\n" +
            "\"salary\": {\n" +
            "   \"currency\": \"USD\"\n" +
            "   \"amount\": \"1200\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "\"id\": 100010,\n" +
            "\"firstName\": \"Nikola\"\n" +
            "\"lastName\": \"Tesla\"\n" +
            "\"gender\": \"M\"\n" +
            "\"salary\": {\n" +
            "   \"currency\": \"EUR\"\n" +
            "   \"amount\": \"1600\"\n" +
            "}\n" +
            "}\n" +
            "]\n" +
            "}";

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        ArrayList<Employee> staff = new ArrayList<>();
//        staff.add(getEmployee());
//        staff.add(getEmployee());
//        staff.add(getEmployee());
//        staff.add(getEmployee());
//        staff.add(getEmployee());
//        Company company = new Company();
//        company.setStaff(staff);
//        System.out.println(gson.toJson(company));

/*        main.java.by.epam.testLection.connections.json.Company company = gson.fromJson(file, Company.class);
        System.out.println(gson.toJson(company));*/
    }

/*    private static main.java.by.epam.testLection.connections.json.Employee getEmployee() {
        main.java.by.epam.testLection.connections.json.Employee employee = new Employee();

        Random random = new Random();
        employee.setId(random.nextInt(100000));
        employee.setFirstName("Max");
        employee.setLastName("Mad");
        employee.setGender("M");

        Salary salary = new Salary();
        salary.setCurrency("USD");
        salary.setAmount(random.nextInt(5000));

        employee.setSalary(salary);
        return employee;
    }*/
}
