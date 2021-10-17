package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBC_Examples {

    String dbUrl = "jdbc:oracle:thin:@44.193.18.240:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM departments");

        //display departments table in 10 - Administration - 200 - 1700 format
        resultSet.next();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2)
                        + " - " + resultSet.getInt(3) + " - " + resultSet.getInt(4));
        }
    }
//=========================================================================================================

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * FROM departments");

        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        resultSet.beforeFirst();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

    }

//=========================================================================================================
//                              ===========M E T A D A=========
    @Test
    public void test25() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * FROM employees");

        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());

//                            ===========R E S U L T S E T M E T A D A=========
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        int colCount = rsMetadata.getColumnCount();
        System.out.println(colCount);
        System.out.println(rsMetadata.getColumnName(1));
        System.out.println(rsMetadata.getColumnName(2));

        for(int i=1; i<=colCount; i++){
            System.out.println(rsMetadata.getColumnName(i));
        }

//        int temp = 1;
//        while (temp <= rsMetadata.getColumnCount()) {
//            System.out.println(rsMetadata.getColumnName(temp++));
//        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
