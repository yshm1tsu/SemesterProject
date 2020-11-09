package helpers;

import models.Review;

import java.sql.*;

public class ReviewHelperImpl implements ReviewHelper {

    @Override
    public void createItem(Review review) {
        String dbName = "jdbc:postgresql://localhost:5432/auth";
        String dbDriver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "hutrdew4921";
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbName, userName, password);
            String sql = "INSERT INTO review (title, user_email, content) Values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, review.getTitle());
            preparedStatement.setString(2, review.getUser_email());
            preparedStatement.setString(3, review.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
