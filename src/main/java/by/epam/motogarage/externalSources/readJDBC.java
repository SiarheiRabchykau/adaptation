package main.java.by.epam.motogarage.externalSources;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class readJDBC implements GetDataFromExternalSources{
    private static final String URL = "jdbc:mysql://localhost:3306/motodb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public readJDBC() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Cannot download driver");
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement() ) {
        //System.out.println(connection.isClosed());
/*            statement.execute("INSERT INTO moto(brand,model,weight,max_speed,power,wheel,case_capacity,cost)" +
                    "VALUES('Honda','dio',60,55,5,2,0,520)");*/
/*            int res = statement.executeUpdate("UPDATE moto SET model='Dio2' where id=1 ");
            System.out.println(res);*/
//            ResultSet res = statement.executeQuery("SELECT * FROM moto");
            statement.addBatch("INSERT INTO moto(brand,model,weight,max_speed,power,wheel,case_capacity,cost) VALUES('Honda','CB600F',240,120,240,2,0,3000)");
            statement.addBatch("INSERT INTO moto(brand,model,weight,max_speed,power,wheel,case_capacity,cost) VALUES('Ducati','1198r',200,300,170,2,0,30000)");
            statement.addBatch("INSERT INTO moto(brand,model,weight,max_speed,power,wheel,case_capacity,cost) VALUES('Yamaha','YZF-R1',220,295,175,2,0,4500)");

            statement.executeBatch();

            statement.clearBatch();

            boolean status = statement.isClosed();
            System.out.println(status);
            statement.getConnection();
            statement.close();




        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}