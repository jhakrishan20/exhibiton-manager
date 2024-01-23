package art.gallery.management;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

public class prevexbh{

    public prevexbh() {
        JFrame frame = new JFrame("Art Exhibition Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0 ,0,500,500);
        Container container = frame.getContentPane();
        container.setLayout(null);

        JButton btn1 = new JButton("Exhibition 1");
        btn1.setBounds(150,130,200,40);
        container.add(btn1);

        JButton btn2 = new JButton("Exhibition 2");
        btn2.setBounds(150,190,200,40);
        container.add(btn2);

        JButton btn3 = new JButton("Exhibition 3");
        btn3.setBounds(150,250,200,40);
        container.add(btn3);

         frame.setVisible(true);
    }

    public static void main(String args[]){
        frontinterface obj = new frontinterface();
    }
}