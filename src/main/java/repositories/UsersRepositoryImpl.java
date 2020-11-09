//package repositories;
//
//import models.User;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class UsersRepositoryImpl implements UsersRepository  {
//    private DataSource dataSource;
//    private static final String SQL_FIND_ALL = "select* from auth";
//    @Override
//    public void save(User entity) {
//
//    }
//
//    @Override
//    public void update(User entity) {
//
//    }
//
//    @Override
//    public void delete(User entity) {
//
//    }
//
//    @Override
//    public Optional<User> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<User> findAll() {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = dataSource.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(SQL_FIND_ALL);
//            List<User> users = new ArrayList<>();
//            while (resultSet.next()) {
//                User user = User.builder()
//                        .email(resultSet.getString("email"))
//                        .build();
//                users.add(user);
//            }
//            return users;
//
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException ignore) {
//                }
//                if (statement != null) {
//                    try {
//                        statement.close();
//                    } catch (SQLException ignore) {
//                    }
//                    if (connection != null) {
//                        try {
//                            connection.close();
//                        } catch (SQLException ignore) {
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
