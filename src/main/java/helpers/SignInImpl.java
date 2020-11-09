package helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SignInImpl implements SignInHelper{
    @Override
    public boolean signIn(String email, String password) {
        ResultSet rs = null;
        String passwordFromDB = null;
        String emailFromDB = null;
        try {
            Hasher hasher = new Hasher();
            ConnectorImpl connector = new ConnectorImpl();
            Connection conn = connector.connect();
            String sql = " SELECT email, password from auth where email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                emailFromDB = rs.getString(1);
                passwordFromDB = rs.getString(2);
            }
            if (emailFromDB == null){
                return false;
            }
            return hasher.match(passwordFromDB, password);
        } catch (SQLException | ClassNotFoundException exception) {
            throw new IllegalStateException(exception);

        }
    }
}
