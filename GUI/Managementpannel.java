package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Managementpannel extends JFrame {
Managementpannel(File f1, ObjectOutputStream std_write, ObjectInputStream std_read,ArrayList<Book> a1,ArrayList<Student> a2)
{
    JFrame frame=new JFrame();
    //setForeground(Color.BLACK);
    setSize(1500,700);
    setLayout(null);
    setLocation(0,0);
getContentPane().setBackground(Color.white);

    JLabel label=new JLabel("Library  Management  System",JLabel.CENTER);
    label.setFont(new Font("SansSerif",Font.BOLD,25));
    label.setBackground(Color.BLUE);
    label.setForeground(Color.WHITE);
    label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
    label.setBounds(0,0,1300,35);
    label.setOpaque(true);
    add(label);

    JButton button=new JButton("REGISTRATION");
    button.setBounds(350,150,200,100);
    button.setFont(new Font("SansSerif",Font.BOLD,15));
    add(button);
    button.setBackground(Color.cyan);
   // button.setForeground(Color.WHITE);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Registration o1=new Registration(f1, std_write, std_read, a1, a2);
            o1.setVisible(true);
        }
    });
    JButton button2=new JButton("CHECK DATA");
    button2.setBounds(700,150,200,100);
    button2.setFont(new Font("SansSerif",Font.BOLD,15));
    add(button2);
    button2.setBackground(Color.cyan);
    //button2.setForeground(Color.WHITE);
    button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);

            new Call(f1, std_write, std_read, a1, a2).setVisible(true);
        }
    });

    JButton button3=new JButton("RETURN BOOK");
    button3.setBounds(350,350,200,100);
    button3.setFont(new Font("SansSerif",Font.BOLD,15));
    add(button3);
    button3.setBackground(Color.CYAN);
 //   button3.setForeground(Color.WHITE);
    button3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new Return(f1, std_write, std_read, a1, a2).setVisible(true);
        }
    });

    JButton button4=new JButton("ISSUE BOOK");
    button4.setBounds(700,350,200,100);
    button4.setFont(new Font("SansSerif",Font.BOLD,15));
    add(button4);
    button4.setBackground(Color.CYAN);
    //button4.setForeground(Color.WHITE);
    button4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Issue o1=new Issue(f1, std_write, std_read, a1, a2);
            o1.setVisible(true);
        }
    });


JLabel label2=new JLabel("Please!  choose  an  option  to  use  the  Management  System");
    label2.setFont(new Font("SansSerif",Font.BOLD,25));
label2.setForeground(Color.RED);
label2.setBounds(250,550,900,50);
add(label2);

    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}


}
