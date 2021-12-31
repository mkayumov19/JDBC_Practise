package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicList {

    String dbUrl = "jdbc:oracle:thin:@44.195.19.167:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        ResultSetMetaData rsmd = resultSet.getMetaData();
        resultSet.next();
        List<Map<String,Object>> queryData = new ArrayList<>();

        int colCount = rsmd.getColumnCount();
        while (resultSet.next()){
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= colCount; i++) {
                row.put(rsmd.getColumnName(i), resultSet.getObject(i));
            }
            queryData.add(row);
        }

        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
