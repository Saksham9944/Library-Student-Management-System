package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class Registration extends JFrame{
    Registration (File f1, ObjectOutputStream std_write, ObjectInputStream std_read, ArrayList<Book> a1, ArrayList<Student> a2)//it takes student data and save it into the file
    {
        JFrame frame = new JFrame("REGISTRATION FORM");
        setSize(1500, 700);
        //setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);



        JLabel label=new JLabel("FILL  REGISTRATION  FORM",JLabel.CENTER);
        label.setFont(new Font("SansSerif",Font.BOLD,20));
        label.setBackground(Color.blue);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setBounds(0,0,1300,35);
        label.setOpaque(true);
        add(label);


        JLabel label1=new JLabel("Name \t:");
        label1.setFont(new Font("SansSerif",Font.BOLD,15));
        label1.setBounds(450,150,100,20);
        add(label1);

        JLabel label2=new JLabel("Email :");
        label2.setBounds(450,200,100,20);
        label2.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label2);

        JLabel label3=new JLabel("Roll No :");
        label3.setBounds(450,250,100,20);
        label3.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label3);

        JLabel label4=new JLabel("Branch :");
        label4.setBounds(450,300,100,20);
        label4.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label4);

        JTextField text=new JTextField();
        text.setBounds(600,150,200,30);
        add(text);

        JTextField text2=new JTextField();
        text2.setBounds(600,200,200,30);
        add(text2);

        JTextField text3=new JTextField();
        text3.setBounds(600,250,200,30);
        add(text3);
        JTextField text4=new JTextField();
        text4.setBounds(600,300,200,30);
        add(text4);

        JButton button=new JButton("Submit");
        button.setBounds(750,450,100,40);
        add(button);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   if(!(text.getText().equals("")||text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals(""))) {

                       try {
                           a2.add(new Student(text.getText(),text2.getText(),text3.getText(),text4.getText()));

                                     registration(f1,std_write,a2);//now by adding data of the student in the arraylist simply gives to regis. method with the same std file and same outputstream object
                       //if we not take the f1 file and std object then what we pass to regi. method so that it can save in the same file
                           JOptionPane.showMessageDialog(null,"Registration completed successfully!");
                           setVisible(false);
                           new Managementpannel(f1, std_write, std_read, a1, a2).setVisible(true);
                       }
                       catch (Exception b)
                       {
                           System.out.print(b);
                       }

                    }
                   else {
                        try {
                            JOptionPane.showMessageDialog(null, "Please! fill the complete entry");
                        } catch (Exception a) {
                            System.out.print(a);
                        }
                    }


                }
            });


        JButton button2=new JButton("Back");
        button2.setBounds(400,450,100,40);
        add(button2);
        button2.setBackground(Color.YELLOW);
        //button2.setForeground(Color.RED);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Managementpannel(f1, std_write, std_read, a1, a2).setVisible(true);
            }
        });

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void registration(File f1, ObjectOutputStream std_write, ArrayList<Student> a2)
    {
        try
        {
            std_write=new ObjectOutputStream(new FileOutputStream(f1));
            std_write.writeObject(a2);
            std_write.close();
        }catch(Exception e)
        {
            System.out.print(e);
        }

    }

}
