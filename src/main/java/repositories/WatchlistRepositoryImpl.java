package repositories;

import models.User;
import models.Watchlist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WatchlistRepositoryImpl implements WatchlistRepository{
    private DataSource dataSource;
    String dbName = "jdbc:postgresql://localhost:5432/auth";
    String dbDriver = "org.postgresql.Driver";
    String userName = "postgres";
    String password = "hutrdew4921";
    @Override
    public List<Watchlist> findAllByUser(String email) {
        final String SQL_FIND_ALL_BY_USER = "select* from watchlist where user_email = '"+email+"'";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbName, userName, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL_BY_USER);
            List<Watchlist> watchlists = new ArrayList<>();
            while (resultSet.next()) {
                Watchlist watchlist = Watchlist.builder()
                        .title(resultSet.getString("title"))
                        .add_date(resultSet.getString("add_date"))
                        .rating(resultSet.getString("rating"))
                        .status(resultSet.getString("status"))
                        .build();
                watchlists.add(watchlist);
            }
            return watchlists;

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
    public void save(Watchlist entity) {

    }

    @Override
    public void update(Watchlist entity) {

    }

    @Override
    public void delete(Watchlist entity) {

    }

    @Override
    public Optional<Watchlist> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Watchlist> findAll() {
        return null;
    }
}
