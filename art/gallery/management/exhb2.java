package art.gallery.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exhb2 extends JFrame {

    public exhb2(String exhibitionTitle) {
        setTitle("Art Exhibition Manager - " + exhibitionTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel titleLabel = new JLabel(exhibitionTitle);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Artwork Panel
        JPanel artworkPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        addArtwork("FALL IN LOVE", "Artist SAM", "1.jpg", artworkPanel);
        addArtwork("BOAT IN THE SEA", "Artist OLIVIA", "2.jpg", artworkPanel);
        addArtwork("THE OUTER SPACE", "Artist BARRY", "3.jpg", artworkPanel);
        addArtwork("THE DENSE FOREST", "Artist ALEXA", "4.jpg", artworkPanel);
        addArtwork("THE FARM HOUSE", "Artist SERRA", "6.jpg", artworkPanel);
        addArtwork("HOUSE NEAR SEA", "Artist JORDAN", "5.jpg", artworkPanel);

        JScrollPane scrollPane = new JScrollPane(artworkPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private void addArtwork(String title, String artist, String imagePath, JPanel artworkPanel) {
        JPanel cardPanel = new JPanel();
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardPanel.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        cardPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Title: " + title);
        JLabel artistLabel = new JLabel("Artist: " + artist);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(titleLabel);
        textPanel.add(artistLabel);

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement your details action here
                JOptionPane.showMessageDialog(null, "Painting :- " + title + " by " + artist);
            }
        });

        cardPanel.add(textPanel, BorderLayout.SOUTH);
        cardPanel.add(detailsButton, BorderLayout.PAGE_END);

        artworkPanel.add(cardPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new exhb2("Exhibition 2"));
    }
}
