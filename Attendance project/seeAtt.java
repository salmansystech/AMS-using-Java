import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class seeAtt {
    static JFrame f = new JFrame();
    static JTextField name, fname, roll, contact;
    static JComboBox<String> sub = new JComboBox<>(),
                             att = new JComboBox<>();
    static Container cont;
    public static void main(String[] args) {
        studentdata();
    }
    public static void studentdata() {
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        f.setTitle("My JFrame");
        f.setLayout(null);
        f.setBounds(100,100,451,400);
        cont = f.getContentPane();


        JButton backbtn, searchbtn;
        JLabel lsub, logo, latt;

        File fld = new File("Teachers/Ali/");
        File sublist[] = fld.listFiles();
        int n = sublist.length;
        for (int s=0;s<n;s++) {
            sub.addItem(sublist[s].getName());
        }
        if (n==0)
            sub.addItem("No data found");

       
        latt = new JLabel("Select Att");
        lsub = new JLabel("sub");
        searchbtn = new JButton("Add");
        logo = new JLabel("See Attendance");
        backbtn = new JButton("Back");

        Font fnt = new Font("Agency FB", 1, 18);
        Font tf = new Font("Calibri", 1, 18);
        logo.setFont(new Font("Agency FB", 1, 24));
        att.setFont(new java.awt.Font("Calibri", 1, 18));
        logo.setBounds(140,20,200,40);
        sub.setBounds(170,100,200,30);
        latt.setBounds(50,200,80,30);
        att.setBounds(170,200,200,30);
        lsub.setBounds(50,250,80,30);
        sub.setBounds(170,250,200,30);
        searchbtn.setBounds(90,300,80,30);
        backbtn.setBounds(220,300,80,30);
        cont.add(backbtn);
        cont.add(searchbtn);
        cont.add(sub);
        cont.add(latt);
        cont.add(att);
        cont.add(logo);
        cont.add(lsub);
        cont.add(sub);

        f.setBounds(100,100,450,400);
        searchbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
            
            }
        });

        backbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                admin.adminPanel("OK");
                f.dispose();
            }
        });
    }
}