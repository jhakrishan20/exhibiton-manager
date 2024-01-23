package art.gallery.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    public MainPage() {
        setTitle("Art Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exhibitionButton = new JButton("Exhibition Management");
        JButton catalogButton = new JButton("Artwork Catalog");
        JButton interactiveButton = new JButton("Interactive Viewing Experience");
        JButton salesButton = new JButton("Sales and Transactions");
        JButton artistsButton = new JButton("Artist's Corner");

        setLayout(new GridLayout(5, 1));

        add(exhibitionButton);
        add(catalogButton);
        add(interactiveButton);
        add(salesButton);
        add(artistsButton);

         // Link the button to the UpcomingExhibitions constructor
         exhibitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new frontinterface();
            }
        });
         // Link the button to the UpcomingExhibitions constructor
         interactiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                SwingUtilities.invokeLater(GalleryViewer::new);
            }
        });
         // Link the button to the UpcomingExhibitions constructor
         salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            showTable frame = new showTable();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
         // Link the button to the UpcomingExhibitions constructor
         artistsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ArtExhibitionOrganizer().setVisible(true);
                    }
                });
            }
        });
        // Add action listeners for other buttons
        catalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for the Artwork Catalog button
                // You can open a new frame or perform other actions
                
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArtworkCatalog().setVisible(true);
            }
        });
            }
        });

        interactiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for the Interactive Viewing Experience button
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
}
