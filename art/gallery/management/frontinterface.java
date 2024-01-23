package art.gallery.management;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Separate class for Upcoming Exhibitions
class UpcomingExhibitions {
    public UpcomingExhibitions() {
        System.out.println("Upcoming Exhibitions constructor called.");
        // Add your code here for handling upcoming exhibitions
    }
}

public class frontinterface {

    public frontinterface() {
        JFrame frame = new JFrame("Art Exhibition Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 500, 500);
        Container container = frame.getContentPane();
        container.setLayout(null);

        JButton btn1 = new JButton("Upcoming Exhibitions");
        btn1.setBounds(150, 130, 200, 40);
        container.add(btn1);

        // Link the button to the UpcomingExhibitions constructor
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new upcmexhb();
            }
        });

        JButton btn2 = new JButton("Ongoing Exhibitions");
        btn2.setBounds(150, 190, 200, 40);
        container.add(btn2);
        
        // Link the button to the UpcomingExhibitions constructor
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ongoexbh();
            }
        });

        JButton btn3 = new JButton("Previous Exhibitions");
        btn3.setBounds(150, 250, 200, 40);
        container.add(btn3);
        
        // Link the button to the UpcomingExhibitions constructor
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new prevexbh();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        frontinterface obj = new frontinterface();
    }
}
