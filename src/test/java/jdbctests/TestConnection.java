package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@44.193.18.240:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM regions");

        resultSet.next();

//        System.out.println(resultSet.getString("region_id") + " | " + resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println(resultSet.getString("region_id") + " | " + resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println(resultSet.getString("region_id") + " | " + resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println(resultSet.getString("region_id") + " | " + resultSet.getString("region_name"));

        while(resultSet.next()){
            System.out.println(resultSet.getString("region_id") + " | " + resultSet.getString("region_name"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
