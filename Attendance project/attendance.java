import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
class attendance implements ActionListener {
	static int s=0, abs=0;
	static String listabs="<br>Absent Students are : ", subject = "";
	static int nos = 0;
	static File[] studentslist;
	static JFrame frame = new JFrame();
	static Container c;
	static JLabel name = new JLabel(""),
				resulttext = new JLabel("");
	static JButton p = new JButton("Present"),
				a = new JButton("Absent"),
				resultbtn = new JButton("Show Result"),
				done = new JButton("Done");
	static JComboBox<String> subjects = new JComboBox<>();
	public static void main(String[] args) {
		TakeAtt("Ali");
	}
	public static void TakeAtt(String teacher) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50,50,500,400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle(teacher);
		c = new Container();
		c = frame.getContentPane();
		
		File fld = new File("Teachers/"+teacher);
        File subjectlist[] = fld.listFiles();
        int n = subjectlist.length;
        for (int s=0;s<n;s++) {
            subjects.addItem(subjectlist[s].getName());
        }
        if (n==0) {
            subjects.addItem("No data found");
        }
		Font f = new Font("Agency FB", Font.BOLD, 20);
		p.setBounds(100,300,100,30);
		a.setBounds(220, 300, 100, 30);
		name.setBounds(50,10,300,40);
		subjects.setBounds(50,50,250,30);
		done.setBounds(50,150,100,20);
		resulttext.setBounds(30,10,480,300);
		resultbtn.setBounds(120,160,150,30);
		p.setFont(f);
		a.setFont(f);
		resultbtn.setFont(f);

		name.setFont(new Font("Agency FB", Font.BOLD, 26));
		resulttext.setFont(f);
		c.add(subjects);
		c.add(done);
		frame.setBounds(50,50,501,400);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					subject = subjects.getSelectedItem().toString();
				String batch = "", semester = "";
				try {
					semester = getData.sem(teacher, subject);
				}
				catch (IOException ex) {}
				try {
					batch = getData.batch(teacher, subject);
				}
				catch (IOException ex) {}
				File students = new File("Students/Batch "+batch+"/Semester "+semester);
				studentslist = students.listFiles();
				nos = studentslist.length;
				name.setText("Roll no."+studentslist[s].getName());
				donem();
				}
				catch (Exception er) {
					
				}

			}
		});
		
		

		p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(s<nos-1) {
					s++;
					String sName = studentslist[s].getName();
					name.setText("Roll no." +sName);
				}
				else
				{
					name.setVisible(false);
					s++;
					resultbtn.setVisible(true);
					p.setVisible(false);
					a.setVisible(false);
				}
			}
		});
		
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s<nos-1)
				{
					listabs = listabs +"Roll no."+ studentslist[s].getName()+" - ";
					s++;
					String sName = studentslist[s].getName();
					name.setText("Roll no." +sName);
					abs++;
				}
				else {
					listabs = listabs +"Roll no."+ studentslist[s].getName()+" - " ;
					name.setVisible(false);
					s++;
					abs++;
					resultbtn.setVisible(true);
					p.setVisible(false);
					a.setVisible(false);
				}
			}
		});

		resultbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int present = nos-abs;
				int per1 = present * 100;
    			int per2 = abs * 100;
  	 			float attper = (float)per1 / nos;
   				float absper = (float)per2 / nos;
   				Date dateobj = new Date();
				DateFormat sdt = new SimpleDateFormat("yyyy-MM-dd, kk.mm a");
				String date = sdt.format(dateobj);
				String sum = "<html>*Summary of attendance at "+date+"<br>Total Students: "+nos+"*<br>Present Students: "+present+"<br>Absent Students: "+abs+"<br>Attendace percentage: "+attper+"%<br>Absence percentage: "+absper+"%<br>"+listabs+"</html>";
				resulttext.setText(sum);
				resulttext.setVisible(true);
				resultbtn.setVisible(false);
				try {
					saveAtt(date, sum, teacher);
				}
				catch (IOException err) {
					System.out.println("ERRORR");
				}

			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {}
	static void donem() {
		c.remove(subjects);
		c.remove(done);
		c.add(p);
		c.add(a);
		c.add(resulttext);
		c.add(resultbtn);
		c.add(name);
		resultbtn.setVisible(false);
		frame.setBounds(50,50,500,400);
	}
	static void saveAtt(String date, String sum, String teacher) throws IOException {
		FileWriter fr = new FileWriter("Teachers/"+teacher+"/"+subject+"/"+date+".txt");
        fr.write(sum);
  		fr.close();
	}

}

class getData {
	static String sem(String teacher, String subject) throws IOException {
		FileReader fr = new FileReader("Teachers/"+teacher+"/"+subject+"/data/semester.txt");
		int c=0; String semester="";
		while ((c=fr.read())!=-1)
			semester = semester + String.valueOf((char)c);
		fr.close();
		return(semester);
	}
	static String batch(String teacher, String subject) throws IOException {
		FileReader fr = new FileReader("Teachers/"+teacher+"/"+subject+"/data/batch.txt");
		int c=0; String batch="";
		while ((c=fr.read())!=-1)
			batch = batch + String.valueOf((char)c);
		fr.close();
		return(batch);
	}
}