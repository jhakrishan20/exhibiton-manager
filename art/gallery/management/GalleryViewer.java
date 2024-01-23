package art.gallery.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GalleryViewer extends JFrame {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private JLabel titleLabel, descriptionLabel;
    private JButton nextButton, prevButton;

    public GalleryViewer() {
        // Connect to the database
        connectToDatabase();

        // Initialize UI components
        titleLabel = new JLabel();
        descriptionLabel = new JLabel();
        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(descriptionLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up event handlers
        nextButton.addActionListener(e -> showNextArtwork());
        prevButton.addActionListener(e -> showPreviousArtwork());

        // Set frame properties
        setTitle("Gallery Viewer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Display the first artwork
        showNextArtwork();
    }

    private void connectToDatabase() {
        try {
            // Replace the following parameters with your database information
            String url = "jdbc:mysql://localhost:3306/art_gallery";
            String user = "root";
            String password = "1234";

            connection = DriverManager.getConnection(url, user, password);

            // Initialize the statement with your SQL query
            statement = connection.prepareStatement("SELECT * FROM artworks");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void showNextArtwork() {
        try {
            if (resultSet == null || !resultSet.next()) {
                // If there are no more artworks, loop back to the first one
                resultSet = statement.executeQuery();
                resultSet.next();
            }
            displayArtwork();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showPreviousArtwork() {
        try {
            if (resultSet == null || !resultSet.previous()) {
                // If at the first artwork, move to the last one
                resultSet = statement.executeQuery("SELECT * FROM artworks ORDER BY id DESC");
                resultSet.next();
            }
            displayArtwork();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayArtwork() {
        try {
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");

            titleLabel.setText(title);
            descriptionLabel.setText(description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GalleryViewer::new);
    }
}
