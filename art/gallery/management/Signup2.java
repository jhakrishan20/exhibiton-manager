package art.gallery.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class Signup2 extends JFrame implements ActionListener {
    JTextField textName,textBio,textGit;
    JButton b1;
    Signup2() {
        JLabel label1 = new JLabel("Description:");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde",Font.BOLD,20));
        label1.setBounds(100,60,450,40);
        add(label1);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(100,100,600,80);
        add(textName);

        JLabel label2 = new JLabel("Bio:");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("AvantGarde",Font.BOLD,20));
        label2.setBounds(100,180,450,40);
        add(label2);

        textBio = new JTextField();
        textBio.setFont(new Font("Raleway",Font.BOLD,14));
        textBio.setBounds(100,220,600,80);
        add(textBio);

        JLabel label3 = new JLabel("Github Profile:");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("AvantGarde",Font.BOLD,20));
        label3.setBounds(100,300,450,40);
        add(label3);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(100,340,600,40);
        add(textName);

        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway",Font.BOLD,14));
        b1.setBackground(new Color(222,255,220));
        b1.setBackground(Color.GRAY);
        b1.setBounds(100,450,600,40);
        b1.addActionListener(this);
        add(b1);





        getContentPane().setBackground(new Color(211, 211, 211));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

    }



    public static void main(String[] args) {
        new Signup2();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
