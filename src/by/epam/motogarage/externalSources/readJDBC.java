package by.epam.motogarage.externalSources;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class readJDBC implements GetDataFromExternalSources{
    private static final String URL = "jdbc:mysql://localhost:3306/motodb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Cannot download driver");
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//            System.out.println(connection.isClosed());