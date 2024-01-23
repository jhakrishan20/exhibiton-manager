package art.gallery.management;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageExample extends JFrame {

    public ImageExample() {
        setTitle("Image Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Specify the absolute path to your image file
        ImageIcon icon = new ImageIcon("C:/Users/DELL/OneDrive/Desktop/New folder (2)/2.jpg");

        // Create a JLabel and set the ImageIcon as its icon
        JLabel label = new JLabel(icon);

        // Create a JPanel and add the JLabel to it
        JPanel panel = new JPanel();
        panel.add(label);

        // Add the JPanel to the JFrame
        add(panel);

        // Set the JFrame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            new ImageExample();
        });
    }
}
