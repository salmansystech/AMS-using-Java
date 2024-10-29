import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class stuData {
	static JFrame f = new JFrame();
	static JComboBox<String> batch = new JComboBox<>(),
							 sem = new JComboBox<>(),
							 students = new JComboBox<>();
	static int s = 0, n = 0;
	static String sems="", b="", stu="";
	static JLabel info;
	public static void main(String[] args) {
		sData("OK");
	}

	public static void sData(String ver) {
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setTitle("My JFrame");
		f.setLayout(null);
		f.setBounds(100,100,451,400);
		Container c = f.getContentPane();
     	JLabel lbatch, logo, lsemester, lstudent;
     	JButton backbtn, searchbtn;

     	lsemester = new JLabel("Semester");
        lbatch = new JLabel("Batch");
        lstudent = new JLabel("Select Student");
        searchbtn = new JButton("Search");
        lsemester = new JLabel("Semester");
        lbatch = new JLabel("Batch");
        logo = new JLabel("Student Data");
        backbtn = new JButton("Back");
        info = new JLabel("");

        File fld = new File("Students");
        File batchlist[] = fld.listFiles();
        n = batchlist.length;
        batch.addItem("Select Batch");
        for (s=0;s<n;s++) {
            batch.addItem(batchlist[s].getName());
        }
        if (n==0) {
            batch.addItem("No data found");
        }
 		
        sem.addItem(" ");
        sem.addItem("Select batch first");
        students.addItem(" ");
        students.addItem("Select Batch and semester first");

        logo.setBounds(140,20,200,40);
        lbatch.setBounds(50,100,80,30);
        batch.setBounds(170,100,200,30);
        lsemester.setBounds(50,150,80,30);
        sem.setBounds(170,150,200,30);
        lstudent.setBounds(50,200,120,30);
        students.setBounds(170,200,200,30);
        info.setBounds(400,10,400,200);
        searchbtn.setBounds(90,300,80,30);
        backbtn.setBounds(220,300,80,30); 

        if (ver == "OK") {
        	c.add(backbtn);
	        c.add(searchbtn);
    	    c.add(batch);
        	c.add(lsemester);
	        c.add(lstudent);
    	    c.add(sem);
        	c.add(logo);
	        c.add(lbatch);
    	    c.add(batch);
        	c.add(students);
        	c.add(info);
        }
        else {
        	c.add(logo);
        	logo.setText("UNAUTHORIZED");
        }
        

        f.setBounds(100,100,700,400);

        batch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				try {
					b = batch.getSelectedItem().toString();
					File semesterlist = new File("Students/"+b);
    	   			File semesters[] = semesterlist.listFiles();
 			        n = semesters.length;
 		    	    sem.removeAllItems();
 		        	sem.addItem("Select Semester");
 		        	for (s=0;s<n;s++) {
	 	            	sem.addItem(semesters[s].getName());
    		  		}
      		    	if (n==0) {
            			sem.addItem("No data found");
        			}
        		}
        		catch (Exception err) {}
			}
		});

		sem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				try {
					sems = sem.getSelectedItem().toString();
					File studentlist = new File("Students/"+b+"/"+sems);
       				File studentsl[] = studentlist.listFiles();
	 		        n = studentsl.length;
 			        students.removeAllItems();
 			        students.addItem("Select Student");
 		    	    for (s=0;s<n;s++) {
 	            		students.addItem(studentsl[s].getName());
    	  			}
      	    		if (n==0) {
	            		students.addItem("No data found");
    	    		}
				}
				catch (Exception err) {}
			}
		});

		searchbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					getData();
				}
				catch (IOException err) {

				}
			}
		});
		backbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                admin.adminPanel("OK");
                f.dispose();
            }
        });
	}

	static void getData() throws IOException {
		stu = students.getSelectedItem().toString();
		FileReader fr = new FileReader("Students/"+b+"/"+sems+"/"+stu+"/data.txt");
		int c=0; String data="";
		while ((c=fr.read())!=-1)
		data = data + String.valueOf((char)c);
		fr.close();
		info.setText(data);
	}
}