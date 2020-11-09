package helpers;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class WatchlistHelper{
    String dbName = "jdbc:postgresql://localhost:5432/auth";
    String dbDriver = "org.postgresql.Driver";
    String userName = "postgres";
    String password = "hutrdew4921";

    public void createItem(String title, String add_date, String user_email, String rating, String status) throws ClassNotFoundException{
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbName, userName, password);
            String sql = "INSERT INTO watchlist (title, add_date, user_email, rating, status) Values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setDate(2, Date.valueOf(add_date));
            preparedStatement.setString(3, user_email);
            preparedStatement.setString(4, rating);
            preparedStatement.setString(5, status);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
