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

public class Return extends JFrame{
    Return(File f1, ObjectOutputStream std_write, ObjectInputStream std_read,  ArrayList<Book> a1, ArrayList<Student> a2)
    {
        JFrame frame = new JFrame("Return Book Panel");
        setSize(1500, 700);
        //setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);



        JLabel label=new JLabel("RETURN  BOOK FORM",JLabel.CENTER);
        label.setFont(new Font("SansSerif",Font.BOLD,20));
        label.setBackground(Color.blue);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setBounds(0,0,1300,35);
        label.setOpaque(true);
        add(label);



        JLabel label2=new JLabel("Roll No :");
        label2.setBounds(450,200,100,20);
        label2.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label2);


        JLabel label5=new JLabel("Book No :");
        label5.setBounds(450,300,100,20);
        label5.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label5);

        JTextField text2=new JTextField();
        text2.setBounds(600,200,250,30);
        add(text2);


        JTextField text5=new JTextField();
        text5.setBounds(600,300,250,30);
        text5.setFont(new Font("SansSerif",Font.BOLD,15));
        add(text5);


        JButton button=new JButton("Return");
        button.setBounds(800,500,100,40);
        add(button);
        button.setFont(new Font("SansSerif",Font.BOLD,16));
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(text2.getText().equals("")||text5.getText().equalsIgnoreCase("")))
                {
                    boolean check=false;//check issued to the book to be return
                    for(Student ele:a2)
                    {
                        if(ele.roll.equalsIgnoreCase(text2.getText())) {
                            for (Book ele2 : ele.issued_book) {
                                  if(ele2.number.equals(text5.getText()))
                                  {
                                      check=true;
                                      ele.issued_book.remove(ele2);
                                      ele.quantity--;
                                      Return(f1,std_write,a2);
                                     setVisible(false);
                                     new Managementpannel(f1,std_write,std_read,a1,a2).setVisible(true);
                                     break;
                                  }

                            }
                        }
                    }
                   if(check==false) {
                    try {
                        JOptionPane.showMessageDialog(null, "Book not Found!");
                        setVisible(false);
                        new Managementpannel(f1, std_write, std_read, a1, a2);
                    }
                    catch (Exception a) {
                        System.out.print(a);
                    }
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
        button2.setBounds(400,500,100,40);
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
    void Return(File f1,ObjectOutputStream std_write,ArrayList<Student> a2)
    {
        try
        {
            std_write=new ObjectOutputStream(new FileOutputStream(f1));
            std_write.writeObject(a2);
            std_write.close();
            JOptionPane.showMessageDialog(null,"Book returned successfully!");

        }
        catch(Exception exception)
        {
            System.out.print(exception);
        }
    }
}
