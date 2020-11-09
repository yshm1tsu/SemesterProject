package helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailExistingHelper implements ExistingHelper {
    @Override
    public boolean isExisting(String data) {
        ResultSet rs = null;
        boolean condition = false;
        try {
            ConnectorImpl connector = new ConnectorImpl();
            Connection connection = connector.connect();
            String sql = " select exists(select email from auth where email=?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, data);
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                condition = rs.getBoolean(1);
            }
            return condition;
        } catch (SQLException | ClassNotFoundException exception) {
            throw new IllegalStateException(exception);

        }
    }
}
