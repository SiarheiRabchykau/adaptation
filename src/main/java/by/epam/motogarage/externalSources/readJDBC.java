package main.java.by.epam.motogarage.externalSources;

import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.sql.*;
import java.util.ArrayList;

public class ReadJDBC implements GetDataFromExternalSources {
    private static final String URL = "jdbc:mysql://localhost:3306/motodb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto)  {

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM moto");

            while (resultSet.next()) {

                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int weight = resultSet.getInt("weight");
                int maxSpeed = resultSet.getInt("max_Speed");
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

    public static void write(ArrayList<Mototechnics> arrayMoto) {

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String SQL = "INSERT INTO moto (brand, model, weight, max_speed, power, wheel, case_cap, cost) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(SQL);
            connection.setAutoCommit(false);


            for(int i = 0; i < arrayMoto.size(); i++){
                statement.setString(1, arrayMoto.get(i).getBrand());
                statement.setString(2, arrayMoto.get(i).getModel());
                statement.setInt(3, arrayMoto.get(i).getMaxSpeed());
                statement.setInt(4, arrayMoto.get(i).getWeight());
                statement.setInt(5, arrayMoto.get(i).getWheels());
                statement.setInt(6, arrayMoto.get(i).getPower());
                statement.setInt(7, arrayMoto.get(i).getCaseCapacity());
                statement.setDouble(8, arrayMoto.get(i).getCost());
            statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB for write");
            e.printStackTrace();
        }
    }
}