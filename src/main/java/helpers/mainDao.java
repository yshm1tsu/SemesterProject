package helpers;

import java.sql.*;

public class mainDao {
    String dbName = "jdbc:postgresql://localhost:5432/auth";
    String dbDriver = "org.postgresql.Driver";
    String userName = "postgres";
    String password = "hutrdew4921";
    public ResultSet query(String sql){
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbName, userName, password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            return statement.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}