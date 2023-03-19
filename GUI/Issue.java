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

public class Issue extends JFrame{
    Issue(File f1, ObjectOutputStream std_write, ObjectInputStream std_read,ArrayList<Book> a1, ArrayList<Student> a2)
    {
        JFrame frame = new JFrame("Issue Book Panel");
        setSize(1500, 700);
        //setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);



        JLabel label=new JLabel("ISSUE  BOOK  FORM",JLabel.CENTER);
        label.setFont(new Font("SansSerif",Font.BOLD,20));
        label.setBackground(Color.blue);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setBounds(1,1,1300,35);
        label.setOpaque(true);
        add(label);


        JLabel label1=new JLabel("Name \t:");
        label1.setFont(new Font("SansSerif",Font.BOLD,15));
        label1.setBounds(450,150,100,20);
        add(label1);

        JLabel label2=new JLabel("Roll No :");
        label2.setBounds(450,200,100,20);
        label2.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label2);

        JLabel label3=new JLabel("Book Name :");
        label3.setBounds(450,250,100,20);
        label3.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label3);

        JLabel label4=new JLabel("Author :");
        label4.setBounds(450,300,100,20);
        label4.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label4);

        JLabel label5=new JLabel("Book No :");
        label5.setBounds(450,350,100,20);
        label5.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label5);


        JTextField text=new JTextField();
        text.setBounds(600,150,250,30);
        add(text);

        JTextField text2=new JTextField();
        text2.setBounds(600,200,250,30);
        add(text2);

        JTextField text3=new JTextField();
        text3.setBounds(600,250,250,30);
        add(text3);
        JTextField text4=new JTextField();
        text4.setBounds(600,300,250,30);
        add(text4);
        JTextField text5=new JTextField();
        text5.setBounds(600,350,250,30);
        text5.setFont(new Font("SansSerif",Font.BOLD,15));
        add(text5);


        JButton button=new JButton("Issue");
        button.setBounds(800,500,100,40);
        add(button);
        button.setFont(new Font("SansSerif",Font.BOLD,16));
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(text.getText().equals("")||text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals("")||text5.getText().equals("")))
                {
                    boolean check=false;
                    for(Student ele:a2)
                    {
                        if(text2.getText().equalsIgnoreCase(ele.roll)&&ele.quantity<4)//if a registered then can isssue
                        {
                            check=true;
                            try
                            {
                                ele.issued_book.add(new Book(text3.getText(),text4.getText(),text5.getText()));
                                ele.quantity++;
                                issue(f1,a2,std_write);
                                JOptionPane.showMessageDialog(null,"Congratulations! book issued successfully");
                                setVisible(false);
                                new Managementpannel(f1, std_write, std_read,a1, a2).setVisible(true);
                                break;
                            }catch (Exception E){
                                System.out.print(E);
                            }
                        }

                    }
                    if(check==false)
                    {

                        try {
                            JOptionPane.showMessageDialog(null, "Sorry! not a registered student or the student has already issued 3 books");
                            setVisible(false);
                            new Managementpannel(f1, std_write, std_read, a1, a2);

                        } catch (Exception a) {
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
    void issue(File f1,ArrayList<Student> a1,ObjectOutputStream std_write)
    {
        try
        {
            std_write=new ObjectOutputStream(new FileOutputStream(f1));
            std_write.writeObject(a1);
            std_write.close();
            //JOptionPane.showMessageDialog(null,"Congratulations! book issued successfully");
        }catch(Exception e)
        {
            System.out.print(e);
        }
    }

}
