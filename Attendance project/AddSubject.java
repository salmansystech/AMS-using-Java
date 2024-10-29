import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class AddSubject {
	static JFrame f = new JFrame();
	static JTextField name, fname, roll, contact;
    public static void main(String[] args) {
        addSub(" ");
    }
    public static void addSub(String ver) {
    	f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setTitle("My JFrame");
		f.setLayout(null);
		f.setBounds(100,100,451,400);
		Container c = f.getContentPane();
     	JButton backbtn, addbtn;
     	JLabel lbatch, lcontact, lfname, lname, logo, lrollno, lsemester, ltname;
     	String[] list = {"Select", "1", "2", "3", "4", "5", "6", "7", "8"};
		JComboBox<String> sem = new JComboBox<>(list);
        File fld = new File("Teachers");
        File teacherslist[] = fld.listFiles();
        int n = teacherslist.length;
        JComboBox<String> teachers = new JComboBox<>();
        teachers.addItem("Select Teacher");
        for (int s=1;s<n;s++) {
            teachers.addItem(teacherslist[s].getName());
        }
        if (n==1) {
            teachers.addItem("No data found");
        }
        ltname = new JLabel("Teacher");
        lname = new JLabel("Subject name");
        lsemester = new JLabel("Semester");
        lbatch = new JLabel("Batch");
        addbtn = new JButton("Add");
        name = new JTextField();
        SpinnerModel batchList = new SpinnerNumberModel(1,1,100,1);
        JSpinner batch = new JSpinner(batchList);
        logo = new JLabel("Add Subject");
        backbtn = new JButton("Back");

 		Font fnt = new Font("Agency FB", 1, 18);
        addbtn.setToolTipText("Add");
        Font tf = new Font("Calibri", 1, 18);
        logo.setFont(new Font("Agency FB", 1, 24));
        sem.setFont(new java.awt.Font("Calibri", 1, 18));
        logo.setBounds(140,20,200,40);
        ltname.setBounds(50,100,80,30);
        teachers.setBounds(170,100,200,30);
        lname.setBounds(50,150,200,30);
        name.setBounds(170,150,200,30);
        lsemester.setBounds(50,200,80,30);
        sem.setBounds(170,200,200,30);
        lbatch.setBounds(50,250,80,30);
        batch.setBounds(170,250,200,30);
        addbtn.setBounds(90,300,80,30);
        backbtn.setBounds(220,300,80,30);


        c.add(logo);
        if(ver=="OK") {
            c.add(backbtn);
            c.add(addbtn);
            c.add(lname);
            c.add(name);
            c.add(ltname);
            c.add(teachers);
            c.add(lsemester);
            c.add(sem);
            c.add(lbatch);
            c.add(batch);
        }
        else {
            logo.setText("LOGIN TO OPEN THIS");
        }
        

		f.setBounds(100,100,450,400);
		addbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				AddSubject  z = new AddSubject();
                String n = name.getText(), s= sem.getSelectedItem().toString(), b = String.valueOf(batch.getValue()), tname= teachers.getSelectedItem().toString();
                try {
                    z.saveData(n, b, s, tname);
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

   void saveData (String n, String b, String s, String t) throws IOException {
        String path = "Teachers/"+t+"/"+n;
        File dir = new File(path);
        if (dir.isDirectory()) {}
        else
        	dir.mkdir();
        dir = new File(path+"/data");
        if (dir.isDirectory()) {}
        else
        	dir.mkdir();
        FileWriter fr = new FileWriter(path+"/data/"+"batch.txt");
        fr.write(b);
        fr.close();
        fr = new FileWriter(path+"/data/"+"semester.txt");
        fr.write(s);
        fr.close();
        name.setText("");
    }
}
