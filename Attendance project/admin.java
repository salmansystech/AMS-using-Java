import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class admin implements ActionListener {
	static JFrame f = new JFrame();
	public static void adminPanel(String verifier) {
		
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setTitle("Admin");
		f.setBounds(100,100,320,370);
		f.setBackground(Color.RED);
		//
		Container c = f.getContentPane();
		JLabel error = new JLabel("You need to login first.");
		JLabel welcome = new JLabel("Welcome Admin");
		JButton addTeacher = new JButton("Add Teacher");
		JButton addSubject = new JButton("Add Subject");
		JButton addStudent = new JButton("Add Student");
		JButton seeRecord = new JButton("See Student Data");
		JButton logout = new JButton("Logout");
		//
		addTeacher.setForeground(Color.WHITE);
		addTeacher.setBackground(Color.RED);
		addSubject.setForeground(Color.WHITE);
		addSubject.setBackground(Color.RED);
		addStudent.setForeground(Color.WHITE);
		addStudent.setBackground(Color.RED);
		seeRecord.setForeground(Color.WHITE);
		seeRecord.setBackground(Color.RED);
		logout.setForeground(Color.WHITE);
		logout.setBackground(Color.RED);
		
		addTeacher.setBounds(70,60,150,40);
		addSubject.setBounds(70,120,150,40);
		addStudent.setBounds(70,180,150,40);
		seeRecord.setBounds(70,240,150,40);
		error.setBounds(100,50,200,50);
		welcome.setBounds(100,10,200,50);
		logout.setBounds(90,240,100,30);
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			login.main(null);
			f.dispose();
		}
		});
		addTeacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddTeacher.addTeacher("OK");
				f.dispose();
			}
		});
		addSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubject.addSub("OK");
				f.dispose();
			}
		});
		seeRecord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				stuData.sData("OK");
				f.dispose();
			}
		});

		addStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddStudent.main(null);
				f.dispose();
			}
		});

		if (verifier.equals("OK")) {
			c.add(welcome);
			c.add(addTeacher);
			c.add(addSubject);
			c.add(addStudent);
			c.add(seeRecord);
			c.add(logout);
			// Add more code here for admin panel
		}
		else {
			c.add(error);
			f.setTitle("Error :(");
		}
	}
public void actionPerformed(ActionEvent e) {
	
	}
	public static void main(String[] args) {
		admin x = new admin();
		x.adminPanel("OK");
	}
}

