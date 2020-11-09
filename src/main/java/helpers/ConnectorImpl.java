package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorImpl implements Connector {
    String dbName = "jdbc:postgresql://localhost:5432/auth";
    String dbDriver = "org.postgresql.Driver";
    String userName = "postgres";
    String password = "hutrdew4921";
    Connection connection = null;
    Statement statement = null;
    @Override
    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbName, userName, password);
        return conn;
    }
}
