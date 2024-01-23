package art.gallery.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ArtworkCatalog extends JFrame {

    private JButton homeButton;
    private JTextField searchField;
    private JButton searchButton;
    private JTable dataTable;
    private JScrollPane scrollPane;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public ArtworkCatalog() {
        homeButton = new JButton("Home");
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        dataTable = new JTable();
        scrollPane = new JScrollPane(dataTable);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(homeButton);
        topPanel.add(new JLabel("Search: "));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Swing MySQL Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/art_gallery";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            loadTableData();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle home button action if needed
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                searchTableData(searchTerm);
            }
        });
    }

    private void loadTableData() {
        try {
            String query = "SELECT * FROM Artworks";
            resultSet = statement.executeQuery(query);

            displayResultSetInTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchTableData(String searchTerm) {
        try {
            String query = "SELECT * FROM artworks WHERE artwork LIKE '%" + searchTerm + "%'";
            resultSet = statement.executeQuery(query);

            displayResultSetInTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayResultSetInTable() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }

        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            model.addRow(rowData);
        }

        dataTable.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArtworkCatalog().setVisible(true);
            }
        });
    }
}
