package helpers;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationHelperImpl implements RegistrationHelper {
    @Override
    public void register(User user) throws SQLException, ClassNotFoundException {
        try {
            ConnectorImpl connector = new ConnectorImpl();
            Connection conn = connector.connect();
            String sql = "INSERT INTO auth (email, password) Values (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
