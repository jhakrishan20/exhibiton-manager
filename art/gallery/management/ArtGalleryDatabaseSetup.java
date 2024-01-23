package art.gallery.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ArtGalleryDatabaseSetup {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String databaseName = "art_gallery";
        String username = "root";
        String password = "1234";

        try {
            // Load the MySQL Connector/J driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement statement = connection.createStatement()) {

                // Create the database
                String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + databaseName;
                statement.executeUpdate(createDatabaseQuery);

                // Switch to the newly created database
                String useDatabaseQuery = "USE " + databaseName;
                statement.executeUpdate(useDatabaseQuery);

                // Create Artists Table
                String createArtistsTable = "CREATE TABLE if not exists Artists (" +
                        "ArtistID INT PRIMARY KEY," +
                        "Name VARCHAR(255)," +
                        "Biography TEXT," +
                        "Portfolio TEXT," +
                        "ContactInfo VARCHAR(255)" +
                        ")";
                statement.executeUpdate(createArtistsTable);

                // Create Exhibitions Table
                String createExhibitionsTable = "CREATE TABLE if not exists Exhibitions (" +
                        "ExhibitionID INT PRIMARY KEY," +
                        "Title VARCHAR(255)," +
                        "StartDate DATE," +
                        "EndDate DATE" +
                        ")";
                statement.executeUpdate(createExhibitionsTable);

                // Create Artworks Table
                String createArtworksTable = "CREATE TABLE if not exists Artworks (" +
                        "ArtworkID INT PRIMARY KEY," +
                        "Title VARCHAR(255)," +
                        "ArtistID INT," +
                        "Medium VARCHAR(255)," +
                        "Dimensions VARCHAR(255)," +
                        "CreationDate DATE," +
                        "Price DECIMAL(10, 2)," +
                        "ImagePath VARCHAR(255)," +
                        "ExhibitionID INT," +
                        "FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID)," +
                        "FOREIGN KEY (ExhibitionID) REFERENCES Exhibitions(ExhibitionID)" +
                        ")";
                statement.executeUpdate(createArtworksTable);

                // Create Users Table
                String createUsersTable = "CREATE TABLE if not exists Users (" +
                        "UserID INT PRIMARY KEY," +
                        "Username VARCHAR(255)," +
                        "Password VARCHAR(255)," +
                        "Role VARCHAR(50)" +
                        ")";
                statement.executeUpdate(createUsersTable);

                // Create Transactions Table
                String createTransactionsTable = "CREATE TABLE if not exists Transactions (" +
                        "TransactionID INT PRIMARY KEY," +
                        "UserID INT," +
                        "ArtworkID INT," +
                        "TransactionDate DATE," +
                        "TransactionAmount DECIMAL(10, 2)," +
                        "FOREIGN KEY (UserID) REFERENCES Users(UserID)," +
                        "FOREIGN KEY (ArtworkID) REFERENCES Artworks(ArtworkID)" +
                        ")";
                statement.executeUpdate(createTransactionsTable);

                System.out.println("Database and tables created successfully.");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String jdbcUrl2 = "jdbc:mysql://localhost:3306/art_gallery";
        String username2 = "root";
        String password2 = "000000";
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(jdbcUrl2, username2, password2);
                 Statement statement = connection.createStatement()) {

                // Insert sample values into Artists Table
                for (int i = 1; i <= 10; i++) {
                    String insertArtistQuery = "INSERT INTO Artists VALUES (" +
                            i + ", 'Artist " + i + "', 'Biography " + i + "', 'Portfolio " + i + "', 'Contact " + i + "')";
                    statement.executeUpdate(insertArtistQuery);
                }

                // Insert sample values into Exhibitions Table
                for (int i = 1; i <= 10; i++) {
                    String insertExhibitionQuery = "INSERT INTO Exhibitions VALUES (" +
                            i + ", 'Exhibition " + i + "', '2022-01-01', '2022-02-01')";
                    statement.executeUpdate(insertExhibitionQuery);
                }

                // Insert sample values into Artworks Table
                for (int i = 1; i <= 10; i++) {
                    String insertArtworkQuery = "INSERT INTO Artworks VALUES (" +
                            i + ", 'Artwork " + i + "', " + i + ", 'Medium " + i + "', 'Dimensions " + i + "', '2022-01-01', 100.00, '/path/to/image" + i + ".jpg', " + i + ")";
                    statement.executeUpdate(insertArtworkQuery);
                }

                // Insert sample values into Users Table
                for (int i = 1; i <= 10; i++) {
                    String insertUserQuery = "INSERT INTO Users VALUES (" +
                            i + ", 'User" + i + "', 'password" + i + "', 'Role " + i + "')";
                    statement.executeUpdate(insertUserQuery);
                }

                // Insert sample values into Transactions Table
                for (int i = 1; i <= 10; i++) {
                    String insertTransactionQuery = "INSERT INTO Transactions VALUES (" +
                            i + ", " + i + ", " + i + ", '2022-01-01', 50.00)";
                    statement.executeUpdate(insertTransactionQuery);
                }

                System.out.println("Sample data inserted successfully.");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
