package by.epam.testLection.connections;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;

/**
 * Created by Siarhei_Rabchykau on 5/3/2016.
 */
public class DerbyDemo {
    private String url      = "jdbc:mysql://localhost:3306/motodb";
    private String login    = "root";
    private String pass     = "root";
    private String sql      = "select * from moto";

    public static void main(String[] args) throws SQLException{
        DriverManager.registerDriver(new EmbeddedDriver());
        Connection connection = DriverManager.getConnection("jdbc:derby:my_db;create=true;user=me;password=mine");
        Statement statement = connection.createStatement();

//        statement.execute("CREATE TABLE hosts2 ( ID int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME varchar(255) NOT NULL, IP varchar(255) )");
//        statement.addBatch("INSERT INTO hosts2 (NAME, IP) VALUES ('localhost', '127.0.0.1')");
//        statement.addBatch("INSERT INTO hosts2 (NAME, IP) VALUES ('modem', '192.168.1.1')");
//        statement.addBatch("INSERT INTO hosts2 (NAME, IP) VALUES ('something', '254.254.254.254')");
//        statement.executeBatch();

        ResultSet resultSet = statement.executeQuery("SELECT* FROM hosts2");
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            System.out.println("===========");
            for (int i = 1, columnCount = metaData.getColumnCount(); i <= columnCount; i++ ) {
                System.out.println(String.format("'%s : '%S'", metaData.getColumnName(i), resultSet.getString(i)));
            }
            System.out.println("===========");
        }
    }
}
