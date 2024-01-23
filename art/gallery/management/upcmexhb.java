package art.gallery.management;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Separate class for Exhibition 1
class Exhibition1 {
    public Exhibition1() {
        System.out.println("Exhibition 1 constructor called.");
        // Add your code here for handling Exhibition 1
    }
}

public class upcmexhb {

    public upcmexhb() {
        JFrame frame = new JFrame("Art Exhibition Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 500, 500);
        Container container = frame.getContentPane();
        container.setLayout(null);

        JButton btn1 = new JButton("Exhibition 1");
        btn1.setBounds(150, 130, 200, 40);
        container.add(btn1);

        // Link the button to the Exhibition1 constructor
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new exhb1("Exhibition 1");
            }
        });

        JButton btn2 = new JButton("Exhibition 2");
        btn2.setBounds(150, 190, 200, 40);
        container.add(btn2);
        // Link the button to the Exhibition1 constructor
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new exhb2("Exhibition 1");
            }
        });

        JButton btn3 = new JButton("Exhibition 3");
        btn3.setBounds(150, 250, 200, 40);
        container.add(btn3);
        // Link the button to the Exhibition1 constructor
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new exhb3();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        upcmexhb obj = new upcmexhb();
    }
}
