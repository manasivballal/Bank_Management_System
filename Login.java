package bank.management.system;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.lang.ClassLoader.getSystemResource;

    public class Login  extends JFrame  implements ActionListener {
        JLabel label1,label2,label3; // globally declared
        JTextField textField2; // text area
        JButton button1,button2,button3; // button to add on the frontend
        JPasswordField passwordField3; // password



        Login(){ // constructor
            super("Bank Management System");// shows the title
            // bank icon
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
            Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3= new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(350,10,100,100);
            add(image);

            // card icon
            ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
            Image ii2= ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon ii3= new ImageIcon(ii2);
            JLabel iimage = new JLabel(ii3);
            iimage.setBounds(630,350,100,100);
            add(iimage);


            // additional label for welcoming the user
            label1= new JLabel("Welcome to Online-Banking");// shows txt on our frame
            label1.setForeground(Color.white);
            label1.setFont( new Font("AvantGarde",Font.BOLD,25));
            label1.setBounds(250,125,450,40); // location setup from frame not screen
            add(label1);

            // setting label of card number
            label2 = new JLabel("Card-No:  ");
            label2.setFont(new Font("Railway",Font.BOLD,28));
            label2.setForeground(Color.white);
            label2.setBounds(150,190,375,30);
            add(label2);

            // setting card number field
            textField2=new JTextField(15);
            textField2.setBounds(325,190,230,30);
            textField2.setFont(new Font("Arial",Font.BOLD,14));
            add(textField2);

            // setting pin label
            label3= new JLabel("PIN: ");
            label3.setFont(new Font("Railway",Font.BOLD,28));
            label3.setForeground(Color.white);
            label3.setBounds(150,250,375,30);
            add(label3);

            // password entering field
            passwordField3= new JPasswordField(15);
            passwordField3.setBounds(325,250,230,30);
            passwordField3.setFont(new Font("Arial",Font.BOLD,14));
            add(passwordField3);



            button1= new JButton("SIGN IN");
            button1.setFont(new Font("Arial",Font.BOLD,14));
            button1.setForeground(Color.white);
            button1.setBackground(Color.black);
            button1.setBounds(300,300,100,30);
            button1.addActionListener(this);
            add(button1);

            button2= new JButton("Clear");
            button2.setFont(new Font("Arial",Font.BOLD,14));
            button2.setForeground(Color.white);
            button2.setBackground(Color.black);
            button2.setBounds(430,300,100,30);
            button2.addActionListener(this);
            add(button2);


            button3= new JButton("SIGN UP");
            button3.setFont(new Font("Arial",Font.BOLD,14));
            button3.setForeground(Color.white);
            button3.setBackground(Color.black);
            button3.setBounds(300,350,230,30);
            button3.addActionListener(this);
            add(button3);



            // background of frame
            ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
            Image iii2= iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
            ImageIcon iii3= new ImageIcon(iii2);
            JLabel iiimage = new JLabel(iii3);
            iiimage.setBounds(0,0,850,480);
            add(iiimage);



            setLayout(null); // frame layout default is border..
            setSize(850,480);// screen size
            setLocation(250,80); // frame to be opened from centre
            setUndecorated(true);
            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) { // method present in jframe.
            try{
                if(e.getSource()==button1){
                Con c = new Con();
                String cardno=textField2.getText();
                String pin=passwordField3.getText();
                String q ="select * from login where card_number='"+cardno+"'and pin= '"+pin+"'";
                ResultSet resultset=c.statement.executeQuery(q);
                if(resultset.next()){
                    setVisible(false);
                    new main_Class(pin);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect card no or pin");
                }


                }
                else if(e.getSource()==button2){
                    textField2.setText("");
                    passwordField3.setText("");
                }
                else if(e.getSource()==button3){
                 new Signup();
                 setVisible(false);
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }

        public static void main(String[] args) {

            new Login();

        }
    }


