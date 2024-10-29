import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class teacher implements ActionListener {
	JFrame f = new JFrame();
	void teacherPanel(String verifier, String getName) {
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setTitle("Welcome "+getName);
		f.setBounds(170,170,330,350);
		f.setBackground(Color.RED);
		//
		Container c = f.getContentPane();
		JLabel error = new JLabel("You need to login first.");
		JLabel welcome = new JLabel("Welcome "+getName);
		JButton takeAtt = new JButton("Take Attendance");
		JButton seeAtt = new JButton("See Old Attendance");
		JButton logout = new JButton("Logout");
		takeAtt.setBounds(70,60,150,40);
		seeAtt.setBounds(70,120,150,40);
		logout.setBounds(90,180,100,40);
		error.setBounds(100,50,200,50);
		welcome.setBounds(100,10,200,50);
		if (verifier.equals("OK")) {
			c.add(welcome);
			c.add(takeAtt);
			c.add(seeAtt);
			c.add(logout);
			// Add more code here for admin panel
		}
		else {
			f.setTitle("Error :( ");
			c.add(error);
			
		}
		

		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			login.main(null);
			f.dispose();
			}
		});

		takeAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attendance.TakeAtt(getName);
			}
		});
		seeAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeAttendance.seeAttend("OK", getName);
			}
		});
	}

	public static void main(String[] args) {
		teacher x = new teacher();
		x.teacherPanel("OK", " ");
	}
		public void actionPerformed(ActionEvent e) {}
}

