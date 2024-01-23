package art.gallery.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

public class ArtworkDetailPanel extends JFrame {
    private JLabel titleLabel;
    private JLabel artistLabel;
    private JLabel mediumLabel;
    private JLabel dimensionsLabel;
    private JLabel creationDateLabel;
    private JLabel priceLabel;
    private JLabel imageLabel;
    private int initialArtworkID;


    public ArtworkDetailPanel() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        String userInput = JOptionPane.showInputDialog("Enter Artwork ID:");
    try {
        // Try to parse the user input to an integer
        initialArtworkID = Integer.parseInt(userInput);
    } catch (NumberFormatException e) {
        // Handle invalid input (non-integer)
        JOptionPane.showMessageDialog(this, "Invalid Artwork ID. Please enter a valid integer.");
        // Set a default artwork ID (you can modify this as needed)
        initialArtworkID = 1;
    }
        setTitle("Art Gallery Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:/Users/DELL/OneDrive/Desktop/New folder (2)/2.jpg");

        // Create a JLabel and set the ImageIcon as its icon
        JLabel label = new JLabel(icon);

        // Create a JPanel and add the JLabel to it
        JPanel panel = new JPanel();
        panel.add(label);

        // Add the JPanel to the JFrame
        add(panel);


        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBackground(new Color(240, 240, 240));

        JPanel artworkListPanel = new JPanel();
        // Add components related to artwork catalog here

        mainPanel.add(artworkListPanel);

        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new GridLayout(7, 1));

        titleLabel = new JLabel("Title: ");
        artistLabel = new JLabel("Artist: ");
        mediumLabel = new JLabel("Medium: ");
        dimensionsLabel = new JLabel("Dimensions: ");
        creationDateLabel = new JLabel("Creation Date: ");
        priceLabel = new JLabel("Price: ");
        imageLabel = new JLabel();

        detailPanel.add(titleLabel);
        detailPanel.add(artistLabel);
        detailPanel.add(mediumLabel);
        detailPanel.add(dimensionsLabel);
        detailPanel.add(creationDateLabel);
        detailPanel.add(priceLabel);
        detailPanel.add(imageLabel);

        mainPanel.add(detailPanel);

        add(mainPanel);

        JButton exampleButton = new JButton("Show Artwork Details");
        exampleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int artworkID = Integer.parseInt(JOptionPane.showInputDialog("Enter Artwork ID:"));
                displayArtworkDetails(artworkID, getConnection());
            }
        });
        add(exampleButton, BorderLayout.SOUTH);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
    Color labelColor = new Color(30, 30, 30);

    titleLabel.setFont(labelFont);
    titleLabel.setForeground(labelColor);

    artistLabel.setFont(labelFont);
    artistLabel.setForeground(labelColor);

    mediumLabel.setFont(labelFont);
    mediumLabel.setForeground(labelColor);

    dimensionsLabel.setFont(labelFont);
    dimensionsLabel.setForeground(labelColor);

    creationDateLabel.setFont(labelFont);
    creationDateLabel.setForeground(labelColor);

    priceLabel.setFont(labelFont);
    priceLabel.setForeground(labelColor);

    // Styling for the button
    JButton exampleButton2 = new JButton("Show Artwork Details");
    exampleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int artworkID = Integer.parseInt(JOptionPane.showInputDialog("Enter Artwork ID:"));
            displayArtworkDetails(artworkID, getConnection());
        }
    });

    // Set background color and padding
    exampleButton2.setBackground(new Color(50, 150, 50));
    exampleButton2.setOpaque(true);
    exampleButton2.setBorderPainted(false);
    exampleButton2.setForeground(Color.WHITE);
    exampleButton2.setFont(new Font("Arial", Font.BOLD, 14));
    exampleButton2.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

    Font labelFont2 = new Font("Arial", Font.PLAIN, 16);
    Color labelColor2 = new Color(30, 30, 30);

    titleLabel.setFont(labelFont2);
    titleLabel.setForeground(labelColor2);

    artistLabel.setFont(labelFont2);
    artistLabel.setForeground(labelColor2);

    mediumLabel.setFont(labelFont2);
    mediumLabel.setForeground(labelColor2);

    dimensionsLabel.setFont(labelFont2);
    dimensionsLabel.setForeground(labelColor2);

    creationDateLabel.setFont(labelFont2);
    creationDateLabel.setForeground(labelColor2);

    priceLabel.setFont(labelFont2);
    priceLabel.setForeground(labelColor2);

    // Styling for the "Show Artwork Details" button
    JButton showDetailsButton = new JButton("Show Artwork Details");
    showDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int artworkID = Integer.parseInt(JOptionPane.showInputDialog("Enter Artwork ID:"));
            displayArtworkDetails(artworkID, getConnection());
        }
    });

    showDetailsButton.setBackground(new Color(50, 150, 50));
    showDetailsButton.setOpaque(true);
    showDetailsButton.setBorderPainted(false);
    showDetailsButton.setForeground(Color.WHITE);
    showDetailsButton.setFont(new Font("Arial", Font.BOLD, 14));
    showDetailsButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

    // Styling for the "Home" button
    JButton homeButton = new JButton("Home");
    homeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add logic to handle the "Home" button action
            JOptionPane.showMessageDialog(ArtworkDetailPanel.this, "Home button clicked!");
        }
        
    });

    homeButton.setBackground(new Color(0, 123, 255));
    homeButton.setOpaque(true);
    homeButton.setBorderPainted(false);
    homeButton.setForeground(Color.WHITE);
    homeButton.setFont(new Font("Arial", Font.BOLD, 14));
    homeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

    // Create a panel to hold the buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(showDetailsButton);
    buttonPanel.add(homeButton);

    // Add the button panel to the main frame
    add(buttonPanel, BorderLayout.SOUTH);
    Font label2Font = new Font("Arial", Font.PLAIN, 16);
    Color labelTextColor = new Color(30, 30, 30);
    Color labelBackgroundColor = new Color(200, 200, 200);  // Set the background color for labels

    titleLabel.setFont(label2Font);
    titleLabel.setForeground(labelTextColor);
    titleLabel.setBackground(labelBackgroundColor);
    titleLabel.setOpaque(true);

    artistLabel.setFont(label2Font);
    artistLabel.setForeground(labelTextColor);
    artistLabel.setBackground(labelBackgroundColor);
    artistLabel.setOpaque(true);

    mediumLabel.setFont(label2Font);
    mediumLabel.setForeground(labelTextColor);
    mediumLabel.setBackground(labelBackgroundColor);
    mediumLabel.setOpaque(true);

    dimensionsLabel.setFont(label2Font);
    dimensionsLabel.setForeground(labelTextColor);
    dimensionsLabel.setBackground(labelBackgroundColor);
    dimensionsLabel.setOpaque(true);

    creationDateLabel.setFont(label2Font);
    creationDateLabel.setForeground(labelTextColor);
    creationDateLabel.setBackground(labelBackgroundColor);
    creationDateLabel.setOpaque(true);

    priceLabel.setFont(label2Font);
    priceLabel.setForeground(labelTextColor);
    priceLabel.setBackground(labelBackgroundColor);
    priceLabel.setOpaque(true);

    

    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/art_gallery";
        String username = "root";
        String password = "000000";

        displayArtworkDetails(initialArtworkID, getConnection());
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            displayArtworkDetails(1, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/art_gallery";
        String username = "root";
        String password = "000000";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void displayArtworkDetails(int artworkID, Connection connection) {
        String query = "SELECT * FROM Artworks WHERE ArtworkID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artworkID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                titleLabel.setText("Title: " + resultSet.getString("Title"));
                artistLabel.setText("Artist: " + getArtistName(resultSet.getInt("ArtistID"), connection));
                mediumLabel.setText("Medium: " + resultSet.getString("Medium"));
                dimensionsLabel.setText("Dimensions: " + resultSet.getString("Dimensions"));
                creationDateLabel.setText("Creation Date: " + resultSet.getString("CreationDate"));
                priceLabel.setText("Price: $" + resultSet.getDouble("Price"));
                // Load and display image (ImagePath column)
                // Load and display image (ImagePath column)
                String imagePath = resultSet.getString("ImagePath");
                if (imagePath != null && !imagePath.isEmpty()) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);
                    imageLabel.setIcon(imageIcon);
                } else {
                    // Load default image (2.jpg in the same folder as Java source files)
                    String defaultImagePath = System.getProperty("user.dir") + File.separator + "2.jpg";
                    ImageIcon defaultImageIcon = new ImageIcon(defaultImagePath);
                    Image defaultImage = defaultImageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    defaultImageIcon = new ImageIcon(defaultImage);
                    imageLabel.setIcon(defaultImageIcon);
                }

                // You can use an image library like ImageIcon to load and display images
                // imageLabel.setIcon(new ImageIcon(resultSet.getString("ImagePath")));
            } else {
                JOptionPane.showMessageDialog(this, "Artwork not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getArtistName(int artistID, Connection connection) {
        String query = "SELECT Name FROM Artists WHERE ArtistID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artistID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Unknown Artist";
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArtworkDetailPanel().setVisible(true);
            }
        });
    }
}
