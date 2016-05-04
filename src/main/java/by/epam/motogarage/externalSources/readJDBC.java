package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.sql.*;
import java.util.ArrayList;

public class ReadJDBC implements GetDataFromExternalSources{
    private static final String URL = "jdbc:mysql://localhost:3306/motodb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static ArrayList<Mototechnics> readFromDB (ArrayList<Mototechnics> arrayMoto){

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from moto");

            while (resultSet.next()){

                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int weight = resultSet.getInt("weight");
                int maxSpeed = resultSet.getInt("max_Speed");
                int power = resultSet.getInt("power");
                int wheels= resultSet.getInt("wheel");
                int case_cap= resultSet.getInt("case_cap");
                int cost = resultSet.getInt("cost");

                Mototechnics newMotoFromDB;
                if (case_cap > 0) {
                    if (wheels > 3) {
                        newMotoFromDB = new ATV(brand, model, maxSpeed, weight, power, case_cap, cost);
                    } else {
                        newMotoFromDB = new TouristBike(brand, model, maxSpeed, weight, power, wheels, case_cap, cost);
                    }
                } else {
                    newMotoFromDB = new SportBikes(brand, model, maxSpeed, weight, power, cost);
                }
                arrayMoto.add(newMotoFromDB);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB");
        }

        return arrayMoto;
    }
}