package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String PROPERTIES_FILE = "db.properties";
    private static final String PROPERTY_URL = "db.url";
	private static final String PROPERTY_USERNAME = "db.username";
	private static final String PROPERTY_PASSWORD = "db.password";

    public static Connection getConnection() throws SQLException {
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            String url = properties.getProperty(PROPERTY_URL);
            String username = properties.getProperty(PROPERTY_USERNAME);
            String password = properties.getProperty(PROPERTY_PASSWORD);

            return DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            throw new SQLException("Failed to read database properties file: " + PROPERTIES_FILE, e);
        }
    }
}
