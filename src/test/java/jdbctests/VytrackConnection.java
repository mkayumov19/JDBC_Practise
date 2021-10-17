package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class VytrackConnection {

    String dbUrl1 = "jdbc:mysql://3.87.155.124:3306/bitnami_orocrm";
    String dbUserName1 = "qa_user";
    String dbPassword1 = "qa_user";

    @Test
    public void test3() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl1, dbUserName1, dbPassword1);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM orocrm_contact");

        resultSet.next();
        System.out.println(resultSet.getString(1));
//        while (resultSet.next()) {
//            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
//        }

            resultSet.close();
            statement.close();
            connection.close();
    }
}
