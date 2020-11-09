package helpers;

import models.User;

import java.sql.SQLException;

public interface RegistrationHelper {
    public void register(User user) throws SQLException, ClassNotFoundException;
}
