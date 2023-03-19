package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class Call extends JFrame
{
    Call(File f1, ObjectOutputStream std_write, ObjectInputStream std_read,ArrayList<Book> a1, ArrayList<Student> a2)
    {
        JFrame frame = new JFrame();
        setSize(1500, 700);
        setLocation(0, 0);
        setLayout(null);
getContentPane().setBackground(Color.cyan);
        JLabel label=new JLabel("Fill  the  Student  Roll  Number",JLabel.CENTER);
        label.setFont(new Font("SansSerif",Font.BOLD,20));
        label.setBackground(Color.BLUE);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setBounds(0,0,1300,35);
        label.setOpaque(true);
        add(label);

        JLabel label2=new JLabel("Roll No:");
        label2.setBounds(400,250,100,20);
        label2.setFont(new Font("SansSerif",Font.BOLD,15));
        add(label2);
        JTextField text=new JTextField();
        text.setBounds(550,248,300,30);
        add(text);
        JButton button=new JButton("Proceed");
        button.setFont(new Font("SansSerif",Font.BOLD,15));
        button.setBounds(800,400,150,50);

        add(button);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(text.getText().equals(""))){

                    new Check(f1,std_write,std_read,a1,a2,text.getText());
                    setVisible(false);

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
        button2.setFont(new Font("SansSerif",Font.BOLD,15));
        button2.setBounds(350,400,150,50);
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
    }

}
public class Check extends JFrame {
    Check(File f1, ObjectOutputStream std_write, ObjectInputStream std_read, ArrayList<Book> a1, ArrayList<Student> a2, String rollno) {
        JFrame frame = new JFrame("Check Data Panel");
        setSize(1500, 700);
        //setLocation(150, 60);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        //getContentPane().setBackground(Color.WHITE);


        JLabel label = new JLabel("CHECK  STUDENT  DATA", JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 15));
        label.setBackground(Color.BLUE);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setBounds(0, 0, 1300, 30);
        label.setOpaque(true);
        add(label);

        JLabel label1 = new JLabel("Name \t:");
        label1.setFont(new Font("SansSerif", Font.BOLD, 15));
        label1.setBounds(450, 50, 100, 20);
        add(label1);
        JTextField text = new JTextField();
        text.setBounds(550, 50, 300, 30);
        add(text);

        JLabel label2 = new JLabel("Email :");
        label2.setBounds(450, 100, 100, 20);
        label2.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label2);
        JTextField text2 = new JTextField();
        text2.setBounds(550, 100, 300, 30);
        add(text2);

        JLabel label3 = new JLabel("Roll No :");
        label3.setBounds(450, 150, 100, 20);
        label3.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label3);
        JTextField text3 = new JTextField();
        text3.setBounds(550, 150, 300, 30);
        add(text3);

        JLabel label4 = new JLabel("Branch :");
        label4.setBounds(450, 200, 100, 20);
        label4.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label4);
        JTextField text4 = new JTextField();
        text4.setBounds(550, 200, 300, 30);
        add(text4);

        JLabel label5 = new JLabel("BOOK 1", JLabel.CENTER);
        label5.setFont(new Font("SansSerif", Font.BOLD, 15));
        label5.setBackground(Color.YELLOW);
        label5.setForeground(Color.BLACK);
        label5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label5.setBounds(5, 290, 300, 30);
        label5.setOpaque(true);
        add(label5);


        JLabel label6 = new JLabel("Name :");
        label6.setBounds(10, 350, 100, 20);
        label6.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label6);
        JTextField text5 = new JTextField();
        text5.setBounds(100, 350, 200, 25);
        add(text5);


        JLabel label7 = new JLabel("Author :");
        label7.setBounds(10, 400, 100, 20);
        label7.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label7);
        JTextField text6 = new JTextField();
        text6.setBounds(100, 400, 200, 25);
        add(text6);

        JLabel label8 = new JLabel("Book No :");
        label8.setBounds(10, 450, 100, 20);
        label8.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label8);
        JTextField text7 = new JTextField();
        text7.setBounds(100, 450, 200, 25);
        add(text7);


        JLabel label9 = new JLabel("BOOK 2", JLabel.CENTER);
        label9.setFont(new Font("SansSerif", Font.BOLD, 15));
        label9.setBackground(Color.YELLOW);
        label9.setForeground(Color.BLACK);
        label9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label9.setBounds(330, 290, 300, 30);
        label9.setOpaque(true);
        add(label9);

        JLabel label10 = new JLabel("Name :");
        label10.setBounds(330, 350, 100, 20);
        label10.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label10);
        JTextField text8 = new JTextField();
        text8.setBounds(400, 350, 200, 25);
        add(text8);

        JLabel label11 = new JLabel("Author :");
        label11.setBounds(330, 400, 100, 20);
        label11.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label11);
        JTextField text9 = new JTextField();
        text9.setBounds(400, 400, 200, 25);
        add(text9);

        JLabel label12 = new JLabel("Book No:");
        label12.setBounds(330, 450, 100, 20);
        label12.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label12);
        JTextField text10 = new JTextField();
        text10.setBounds(400, 450, 200, 25);
        add(text10);

        JLabel label13 = new JLabel("BOOK 3", JLabel.CENTER);
        label13.setFont(new Font("SansSerif", Font.BOLD, 15));
        label13.setBackground(Color.YELLOW);
        label13.setForeground(Color.BLACK);
        label13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label13.setBounds(650, 290, 300, 30);
        label13.setOpaque(true);
        add(label13);

        JLabel label14 = new JLabel("Name :");
        label14.setBounds(650, 350, 100, 20);
        label14.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label14);
        JTextField text13 = new JTextField();
        text13.setBounds(730, 350, 200, 25);
        add(text13);

        JLabel label15 = new JLabel("Author :");
        label15.setBounds(650, 400, 100, 20);
        label15.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label15);
        JTextField text11 = new JTextField();
        text11.setBounds(730, 400, 200, 25);
        add(text11);

        JLabel label16 = new JLabel("Book No:");
        label16.setBounds(650, 450, 100, 20);
        label16.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label16);
        JTextField text12 = new JTextField();
        text12.setBounds(730, 450, 200, 25);
        add(text12);

        JLabel label17 = new JLabel("BOOK 4", JLabel.CENTER);
        label17.setFont(new Font("SansSerif", Font.BOLD, 15));
        label17.setBackground(Color.YELLOW);
        label17.setForeground(Color.BLACK);
        label17.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label17.setBounds(980, 290, 280, 30);
        label17.setOpaque(true);
        add(label17);

        JLabel label18 = new JLabel("Name :");
        label18.setBounds(980, 350, 100, 20);
        label18.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label18);
        JTextField text14 = new JTextField();
        text14.setBounds(1050, 350, 200, 25);
        add(text14);

        JLabel label19 = new JLabel("Author :");
        label19.setBounds(980, 400, 100, 20);
        label19.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label19);
        JTextField text15 = new JTextField();
        text15.setBounds(1050, 400, 200, 25);
        add(text15);

        JLabel label20 = new JLabel("Book No:");
        label20.setBounds(980, 450, 100, 20);
        label20.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(label20);
        JTextField text16 = new JTextField();
        text16.setBounds(1050, 450, 200, 25);
        add(text16);

        JButton button = new JButton("OK");
        button.setFont(new Font("SansSerif",Font.BOLD,15));
        button.setBounds(570, 550, 150, 40);
        add(button);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Managementpannel(f1, std_write, std_read, a1, a2).setVisible(true);
            }
        });


        boolean check = false;//if roll not found
        for (Student ele : a2) {
            if (ele.roll.equalsIgnoreCase(rollno)) {
                check = true;
                int i = 1;//for book upto 3
                text.setText(ele.name);
                text2.setText(ele.email);
                text3.setText(ele.roll);
                text4.setText(ele.Branch);
                for (Book ele2 : ele.issued_book) {
                    if (ele.issued_book != null) {

                        if (i == 1) {
                            //BOOK1
                            text5.setText(ele2.name);

                            text6.setText(ele2.author);

                            text7.setText(ele2.number);
                        } else if (i == 2) {
                            //Book2
                            text8.setText(ele2.name);
                            text9.setText(ele2.author);
                            text10.setText(ele2.number);
                        } else if (i == 3) {
                            text13.setText(ele2.name);
                            text11.setText(ele2.author);
                            text12.setText(ele2.number);

                        }
                        i++;
                    }
                }
            }

        }
        if (check == false) {
            try {
                JOptionPane.showMessageDialog(null, "Sorry! not a registered student");
                new Managementpannel(f1, std_write, std_read, a1, a2).setVisible(true);
            } catch (Exception e) {
                System.out.print(e);
            }
        } else {
            setVisible(true);
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}



