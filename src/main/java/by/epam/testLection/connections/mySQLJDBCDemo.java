package main.java.by.epam.testLection.connections;

/**
 * Created by Siarhei_Rabchykau on 5/3/2016.
 */
public class mySQLJDBCDemo {

    public static void main(String[] args) {
        String url      = "jdbc:mysql://localhost:3306/motodb";
        String login    = "root";
        String pass     = "root";
        String sql      = "select * from moto";


/*

        try (
            Connection connection = DriverManager.getConnection(url, login, pass);
            PreparedStatement statement = connection.preparedStatement(sql);
        ) {
            statement.setInt(1, 5);
            ResultSet resultSet = statement.executeQuery();

            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int i =1; i<=columnCount ;i++){
                    resultSet.getMetaData().getColumnName(i);
                    resultSet.getString(i);
                }

            }

        } catch
         (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
