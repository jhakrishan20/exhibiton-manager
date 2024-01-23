package art.gallery.management;
import art.gallery.management.Signup;
import art.gallery.management.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;

    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;
    login() {
        super("Art Gallery Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/art1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        label1 = new JLabel("WELCOME TO ART GALLERY");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde",Font.BOLD,20));
        label1.setBounds(250,110,450,40);
        add(label1);

        label2 = new JLabel("USERNAME: ");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.RED);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);



        label3 = new JLabel("PASSWORD:");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.RED);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,100,30);
        button3.addActionListener(this);
        add(button3);


        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/back.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0,0,850,480);
        add(iimage);


        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);






    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==button1) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MainPage().setVisible(true);
                    }
                });
                System.out.println("button1");
            }else if (e.getSource()== button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == button3) {
                 new Signup();

            }

        }catch(Exception E) {
            E.printStackTrace();
        }

    }
    public static void main(String[] args){
        new login();
    }



}
