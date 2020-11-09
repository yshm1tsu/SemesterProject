package repositories;

import lombok.Builder;
import models.Review;
import models.User;
import models.Watchlist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewsRepositoryImpl implements ReviewsRepository{
    private DataSource dataSource;
    String dbName = "jdbc:postgresql://localhost:5432/auth";
    String dbDriver = "org.postgresql.Driver";
    String userName = "postgres";
    String password = "hutrdew4921";
    @Override
    public List<Review> findAllByUser(String email) {
        final String SQL_FIND_ALL_BY_USER = "select* from review where user_email = '"+email+"'";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbName, userName, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL_BY_USER);
            List<Review> reviews = new ArrayList<>();
            while (resultSet.next()) {
                Review review = new Review();
                review.setTitle(resultSet.getString("title"));
                review.setContent(resultSet.getString("content"));
                reviews.add(review);
            }
            return reviews;

        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ignore) {
                    }
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException ignore) {
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<Review> findAllByTitle(String title) {
        final String SQL_FIND_ALL_BY_USER = "select* from review where title = '"+title+"'";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbName, userName, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL_BY_USER);
            List<Review> reviews = new ArrayList<>();
            while (resultSet.next()) {
                Review review = new Review();
                review.setTitle(resultSet.getString("title"));
                review.setContent(resultSet.getString("content"));
                reviews.add(review);
            }
            return reviews;

        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ignore) {
                    }
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException ignore) {
                        }
                    }
                }
            }
        }

    }

    @Override
    public void save(Review entity) {

    }

    @Override
    public void update(Review entity) {

    }

    @Override
    public void delete(Review entity) {

    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Review> findAll() {
        return null;
    }
}
