import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class login implements ActionListener {
	public static void main(String args[]) {
		
		//Creating frame
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setTitle("Login");
		frame.setBounds(100,100,401,401);
		frame.setResizable(true);
		Container c = frame.getContentPane();

		//Creating labels and buttons
		ImageIcon img = new ImageIcon("bg.jpg");
		JLabel logo = new JLabel("LOGIN");
		JLabel name = new JLabel("Username");
		JLabel pass = new JLabel("Password:");
		JTextField userin = new JTextField();
		JPasswordField passin = new JPasswordField();
		JLabel result = new JLabel();
		JButton loginbtn = new JButton("LOGIN");
		JButton exitbtn = new JButton("EXIT");
		JCheckBox box = new JCheckBox("Login as admin");
		JLabel bg = new JLabel("",img,JLabel.CENTER);

		//Setting Positions
		bg.setBounds(0,0,400,400);
		logo.setBounds(150,20,90,25);
		name.setBounds(40,100,90,28);
		pass.setBounds(40,200,90,28);
		userin.setBounds(140,100,140,28);
		passin.setBounds(140,200,140,28);
		result.setBounds(100,250,250,28);
		loginbtn.setBounds(220,340,100,30);
		box.setBounds(120,290,150,25);
		exitbtn.setBounds(100,340,100,30);
		//
		Font f = new Font("Agency FB", Font.BOLD, 22);
		logo.setFont(new Font("Agency FB", Font.BOLD, 32));
		logo.setForeground(Color.RED);
		name.setFont(f);
		pass.setFont(f);
		userin.setFont(f);
		passin.setFont(f);
		box.setFont(f);
		result.setFont(f);
		loginbtn.setFont(f);
		exitbtn.setFont(f);

		loginbtn.setForeground(Color.WHITE);
		loginbtn.setBackground(Color.RED);
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setBackground(Color.RED);
		name.setForeground(Color.WHITE);
		pass.setForeground(Color.WHITE);
		result.setForeground(Color.WHITE);
		
		//Adding
		
		c.add(logo);
		c.add(name);
		c.add(pass);
		c.add(userin);
		c.add(passin);
		c.add(box);
		c.add(loginbtn);
		c.add(exitbtn);
		c.add(result);
		c.add(bg);
		frame.setBounds(100,100,400,430);
		//Login
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				String un = userin.getText();
				@SuppressWarnings("deprecation")
				String up = passin.getText();
				
				if (box.isSelected()) {
					if(un.equals("admin") && up.equals("1234")) {
					admin a = new admin();
					a.adminPanel("OK");
					frame.dispose();
					}
					else {
						result.setText("Wrong username or Password");
					}
				}

				else {
					
					Validiator obj = new Validiator();
					String cname = "", cpass ="";
					try {
						cpass = obj.passCheck(un);
						cname = obj.userCheck(un);
					}
					catch(IOException e) {
						result.setText("User Not Found");
					}
					
						

					if (up.equals(cpass)) {
						if (up.equals("")) {
							result.setText("Fill all the fields");
						}
						else {
							teacher t= new teacher();
							t.teacherPanel("OK", cname);
							frame.dispose();
						}
					}
					else if(un.equals("") && up.equals("null")) {
						result.setText("User Not Found");
					}

					else {
						result.setText("Wrong Username or Password");
					}

				}
			}
		});
		exitbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {}
	
}
	
 // Class To Verify Passwords
class Validiator {

	String passCheck(String getName) throws IOException {
		FileReader fr = new FileReader("Teachers/0data/"+getName+"/pass.txt");
		int c=0; String pass="";
		while ((c=fr.read())!=-1)
		pass = pass + String.valueOf((char)c);
		fr.close();
		return(pass);
	}

	String userCheck(String getName) throws IOException {
		FileReader fr = new FileReader("Teachers/0data/"+getName+"/name.txt");
		int c=0; String name="";
		while ((c=fr.read())!=-1)
		name = name + String.valueOf((char)c);
		fr.close();
		return(name);
	}

	
}