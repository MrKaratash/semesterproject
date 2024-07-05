package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {
    private static final String URL = "jdbc:mysql://localhost:3306/java_project";
    private static final String USERNAME = "root"; 
    private static final String PASSWORD = "K!1e2r3e4m5;"; 
    public static boolean authenticate(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return false;
    }

    public static boolean registerUser(String username, String password) {
        String query = "INSERT INTO user (username, password) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
