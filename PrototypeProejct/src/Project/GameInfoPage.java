package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameInfoPage {
    private static final String URL = "jdbc:mysql://localhost:3306/java_project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Information");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel infoLabel = new JLabel("Click on a game name to see details.");
        infoLabel.setBounds(50, 30, 300, 25);
        frame.add(infoLabel);

        JButton refreshButton = new JButton("Refresh Games");
        refreshButton.setBounds(220, 30, 150, 25);
        frame.add(refreshButton);

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadGameButtons(frame);
            }
        });

        loadGameButtons(frame);

        frame.setVisible(true);
    }

    private static void loadGameButtons(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel infoLabel = new JLabel("Click on a game name to see details.");
        infoLabel.setBounds(50, 30, 300, 25);
        frame.add(infoLabel);

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT name FROM games";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int yPosition = 60;
            while (resultSet.next()) {
                String gameName = resultSet.getString("name");
                JButton gameButton = new JButton(gameName);
                gameButton.setBounds(50, yPosition, 150, 25);
                frame.add(gameButton);

                gameButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showGameDetails(gameName);
                    }
                });

                yPosition += 30;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        frame.revalidate();
    }

    private static void showGameDetails(String gameName) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM games WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, gameName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String details = "Name: " + resultSet.getString("name") + "\n"
                        + "Genre: " + resultSet.getString("genre") + "\n"
                        + "Platform: " + resultSet.getString("platform") + "\n"
                        + "Release Year: " + resultSet.getInt("release_year");

                JOptionPane.showMessageDialog(null, details, "Game Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Game details not found", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
