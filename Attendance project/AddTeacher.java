import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.*;
class AddTeacher implements ActionListener {

    public static void main(String args[]) {
        addTeacher("");
    }

    public static void addTeacher(String ver) {
    	JFrame frame = new JFrame("Add Teacher");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setBounds(100,100,420,451);
    	frame.setLayout(null);

    	Container c = new Container();
    	c= frame.getContentPane();
    	JTextField contact;
   		JButton backbtn;
    	JButton addbtn;
    	JLabel logotxt;
    	JSeparator jSeparator1;
    	JLabel lcontact;
    	JLabel lname;
    	JLabel lpass;
    	JLabel lusername;
    	JTextField name;
    	JPasswordField pass;
    	JTextField uname;
        logotxt = new JLabel("ADD TEACHER");
        lname = new JLabel("Name");
        lusername = new JLabel("Username");
        lpass = new JLabel("Password");
        lcontact = new JLabel("Contact");
        backbtn = new JButton("Back");
        addbtn = new JButton("Add");
        name = new JTextField();
        uname = new JTextField();
        pass = new JPasswordField();
        contact = new JTextField();
        jSeparator1 = new JSeparator();

        Font f = new Font("Agency FB", 1, 20);
        Font tf = new Font("Calibri", 1, 18);
        logotxt.setFont(new Font("Agency FB", 1, 24));

        lname.setFont(f);
        lusername.setFont(f); 
        lpass.setFont(f); 
        lcontact.setFont(f);
        backbtn.setFont(f);
        addbtn.setFont(f);
        name.setFont(tf);
        uname.setFont(tf);
        pass.setFont(tf);
        contact.setFont(tf);

        logotxt.setBounds(140,20,200,40);
        lname.setBounds(50,100,80,30);
        lusername.setBounds(50,160,80,30);
        lpass.setBounds(50,220,80,30);
        lcontact.setBounds(50,280,80,30);
        name.setBounds(170,100,200,30);
        uname.setBounds(170,160,200,30);
        pass.setBounds(170,220,200,30);
        contact.setBounds(170,280,200,30);
        addbtn.setBounds(90,340,80,30);
        backbtn.setBounds(220,340,80,30);

        Border b = BorderFactory.createLineBorder(new Color(0, 0, 0), 1, true);
        backbtn.setBorder(b);
        addbtn.setBorder(b);

        c.add(logotxt);
        if(ver=="OK") {
            c.add(lname);
            c.add(lusername); 
            c.add(lpass); 
            c.add(lcontact);
            c.add(backbtn);
            c.add(addbtn);
            c.add(name);
            c.add(uname);
            c.add(pass);
            c.add(contact);
        }
        else {
            logotxt.setText("Login To Open This Page");
        }
        frame.setBounds(100,100,430,480);

        backbtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                admin.adminPanel("OK");
        		frame.dispose();
        	}
        });
        addbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                AddTeacher  z = new AddTeacher();
                @SuppressWarnings("deprecation")
                String fn = name.getText(), un =  uname.getText(), up= pass.getText(), c=contact.getText();
                try {
                    z.saveData(fn, un, up, c);
                }
                catch(IOException e) {}
            }
        });
        
    }
    
    void saveData (String fn, String un, String up, String c) throws IOException {
        String path= "Teachers/0data/"+un;
        File dir = new File("Teachers/"+fn);
        dir.mkdir();
        
        dir = new File(path);
        dir.mkdir();

        FileWriter fr = new FileWriter(path+"/"+"name.txt");
        fr.write(fn);
        fr.close();

        fr = new FileWriter(path+"/"+"pass.txt");
        fr.write(up);
        fr.close();

        fr = new FileWriter(path+"/"+"contact.txt");
        fr.write(c);
        fr.close();
    }
    public void actionPerformed(ActionEvent e) {}
}
