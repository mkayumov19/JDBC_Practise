package jdbctests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;
import java.sql.*;

public class LibraryConnection {

    @Test
    public void test1() throws SQLException {
        String dbUrl = "jdbc:mysql://3.89.251.99:3306/library1";
        String dbUsername = "library1_client";
        String dbPassword = "WVF4NdGXCKHeE6VQ";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        //once you set up connection default pointer looks for 0
        //next() --> move pointer to first row
        resultSet.next();
        System.out.println(resultSet.getString(2));

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test2() {
        String dbUrl = "jdbc:mysql://3.89.251.99:3306/library1";
        String dbUsername = "library1_client";
        String dbPassword = "WVF4NdGXCKHeE6VQ";

        DBUtils.createConnection(dbUrl, dbUsername, dbPassword);

        DBUtils.destroy();

    }
}