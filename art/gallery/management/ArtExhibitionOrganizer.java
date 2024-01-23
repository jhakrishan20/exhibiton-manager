package art.gallery.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class ArtExhibitionOrganizer extends JFrame {

    private List<Exhibitor> exhibitors;

    private DefaultListModel<String> exhibitorListModel;
    private JList<String> exhibitorList;

    private JTextArea artworkDetailsTextArea;

    public ArtExhibitionOrganizer() {
        exhibitors = new ArrayList<>();
        exhibitorListModel = new DefaultListModel<>();

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Art Exhibition Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        // Exhibitor List Panel
        JPanel exhibitorListPanel = new JPanel(new BorderLayout());
        exhibitorList = new JList<>(exhibitorListModel);
        exhibitorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        exhibitorListPanel.add(new JScrollPane(exhibitorList), BorderLayout.CENTER);

        // Artwork Details Panel
        JPanel artworkDetailsPanel = new JPanel(new BorderLayout());
        artworkDetailsTextArea = new JTextArea();
        artworkDetailsPanel.add(new JScrollPane(artworkDetailsTextArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addExhibitorButton = new JButton("Add Exhibitor");
        JButton viewArtworksButton = new JButton("View Artworks");
        buttonPanel.add(addExhibitorButton);
        buttonPanel.add(viewArtworksButton);

        // Add components to the main frame
        add(exhibitorListPanel, BorderLayout.WEST);
        add(artworkDetailsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Exhibitor Button ActionListener
        addExhibitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExhibitor();
            }
        });

        // View Artworks Button ActionListener
        viewArtworksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewArtworks();
            }
        });
    }

    private void addExhibitor() {
        String exhibitorName = JOptionPane.showInputDialog(this, "Enter Exhibitor Name:");
        if (exhibitorName != null && !exhibitorName.isEmpty()) {
            Exhibitor exhibitor = new Exhibitor(exhibitorName);
            exhibitors.add(exhibitor);
            exhibitorListModel.addElement(exhibitorName);
        }
    }

    private void viewArtworks() {
        int selectedExhibitorIndex = exhibitorList.getSelectedIndex();
        if (selectedExhibitorIndex != -1) {
            Exhibitor selectedExhibitor = exhibitors.get(selectedExhibitorIndex);
            artworkDetailsTextArea.setText(selectedExhibitor.getArtworkDetails());
        } else {
            JOptionPane.showMessageDialog(this, "Please select an exhibitor.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArtExhibitionOrganizer().setVisible(true);
            }
        });
    }
}

class Exhibitor {
    private String name;
    private List<String> artworks;

    public Exhibitor(String name) {
        this.name = name;
        this.artworks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addArtwork(String artwork) {
        artworks.add(artwork);
    }

    public String getArtworkDetails() {
        StringBuilder details = new StringBuilder();
        for (String artwork : artworks) {
            details.append(artwork).append("\n");
        }
        return details.toString();
    }
}
