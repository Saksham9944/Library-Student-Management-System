package GUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Student implements Serializable
{
    String name, roll,email,Branch;
    ArrayList<Book> issued_book=new ArrayList<Book>();
    int quantity=0;
    Student(String name,String email,String roll,String Branch)
    {
        this.name=name;
        this.roll=roll;
        this.email=email;
        this.Branch=Branch;

    }

}
class Book implements Serializable {
    String name, author;
    String number;

    Book(String name, String author,String number) {
        this.name = name;
        this.author = author;
        this.number=number;
    }


}

public class Library {



    public static void main(String[] args)throws Exception{
        File f1 = new File("File1.txt");


        ArrayList<Book> a1 = new ArrayList<Book>();
        ArrayList<Student> a2 = new ArrayList<Student>();

        ObjectOutputStream std_write = null;
        ObjectInputStream std_read = null;


        if (f1.isFile()) { //if file exist

            try{
                std_read = new ObjectInputStream(new FileInputStream(f1));
                a2 = (ArrayList<Student>) std_read.readObject();//reading student arraylist from the file
                std_read.close();
            }
            catch (Exception e)
            {
                System.out.print(e);
            }
        }
        Managementpannel o1=new Managementpannel(f1,std_write,std_read,a1,a2);
    }

}

