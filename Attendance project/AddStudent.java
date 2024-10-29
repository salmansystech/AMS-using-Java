import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class AddStudent {
	static JFrame f = new JFrame();
	static JTextField name, fname, roll, contact, batch;
    public static void main(String args[]) {
    	f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setTitle("My JFrame");
		f.setLayout(null);
		f.setBounds(100,100,500,500);
		Container c = f.getContentPane();
     	JButton backbtn, addbtn;
     	JLabel lbatch, lcontact, lfname, lname, logo, lrollno, lsemester;
     	String[] list = {"Select", "1", "2", "3", "4", "5", "6", "7", "8"};
		JComboBox<String> sem = new JComboBox<>(list);

        lname = new JLabel("Name");
        lfname = new JLabel("Father name");
        lrollno = new JLabel("Roll no.");
        lsemester = new JLabel("Semester");
        lbatch = new JLabel("Batch");
        lcontact = new JLabel("Contact");
        addbtn = new JButton("Add");
        name = new JTextField();
        fname = new JTextField();
        roll = new JTextField();
        batch = new JTextField();
        contact = new JTextField();
        logo = new JLabel("Add Student");
        backbtn = new JButton("Back");

 		Font fnt = new Font("Agency FB", 1, 18);
        addbtn.setToolTipText("Add");
        Font tf = new Font("Calibri", 1, 18);
        logo.setFont(new Font("Agency FB", 1, 24));
        logo.setText("ADD STUDENT");
        sem.setFont(new java.awt.Font("Calibri", 1, 18));
        logo.setBounds(140,20,200,40);
        lname.setBounds(50,100,80,30);
        name.setBounds(170,100,200,30);
        lfname.setBounds(50,150,80,30);
        fname.setBounds(170,150,200,30);
        lrollno.setBounds(50,200,80,30);
        roll.setBounds(170,200,200,30);
        lsemester.setBounds(50,250,80,30);
        sem.setBounds(170,250,200,30);
        lbatch.setBounds(50,300,80,30);
        batch.setBounds(170,300,200,30);
        lcontact.setBounds(50,350,80,30);
        contact.setBounds(170,350,200,30);
        addbtn.setBounds(90,390,80,30);
        backbtn.setBounds(220,390,80,30);
        
        c.add(backbtn);
     	c.add(addbtn);
     	c.add(lname);
     	c.add(lfname);
     	c.add(lrollno);
     	c.add(lsemester);
     	c.add(logo);
     	c.add(lbatch);
     	c.add(lcontact);
     	c.add(name);
     	c.add(fname);
     	c.add(roll);
     	c.add(contact);
     	c.add(batch);
     	c.add(sem);

		f.setBounds(100,100,501,500);
		addbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				AddStudent  z = new AddStudent();
                String n = name.getText(), fn =  fname.getText(), s= sem.getSelectedItem().toString(), c=contact.getText(), r = roll.getText(), b = batch.getText();
                try {
                    z.saveData(n, fn, r, b, s, c);
                }
                catch(IOException e) {}
			}
		});
		backbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				admin.adminPanel("OK");
				f.dispose();
			}
		});
   }

   void saveData (String n, String fn, String r, String b, String s, String c) throws IOException {
        String path = "Students/Batch "+b;
        File dir = new File(path);
        if (dir.isDirectory()) {}
        else
        	dir.mkdir();
        dir = new File(path+"/Semester "+s);
        if (dir.isDirectory()) {}
        else
        	dir.mkdir();
        if(Integer.parseInt(r)<10) {
			path= "Students/Batch "+b+"/Semester "+s+"/0"+r+" "+n;
        }
        else {
			path= "Students/Batch "+b+"/Semester "+s+"/"+r+" "+n;
        }
        File student = new File(path);
        student.mkdir();
        FileWriter fr = new FileWriter(path+"/"+"data.txt");
        fr.write("<html>Name : "+n+"<br>Father Name : "+fn+"<br>Roll no. :"+r+"<br>Batch : "+b+"<br>Semester : "+s+"<br>Contact : "+c+"</html>");
        fr.close();
        name.setText("");
        roll.setText("");
        fname.setText("");
        contact.setText("");
    }
}
