package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Siarhei_Rabchykau on 5/13/2016.
 */
public class IReaderJDBC implements IReader {

    public ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto, String url, String username, String password) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mototest");

            while (resultSet.next()) {

                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int maxSpeed = resultSet.getInt("max_speed");
                int weight = resultSet.getInt("weight");
                int power = resultSet.getInt("power");
                int wheels = resultSet.getInt("wheel");
                int case_cap = resultSet.getInt("case_cap");
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
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB");
            e.printStackTrace();
        }
        return arrayMoto;
    }
}
