import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class seeAttendance {

	static JFrame f = new JFrame();
    static JComboBox<String> sub = new JComboBox<>(),
                             att = new JComboBox<>();
    static Container c;
    static JLabel info;
    static int s = 0;
	static String atts="", subs="";

	public static void main(String[] args) {
		seeAttend("", "");
	}

	public static void seeAttend(String ver, String teacher) {
		f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        f.setTitle("My JFrame");
        f.setLayout(null);
		f.setBounds(100,100,451,400);
        c = f.getContentPane();

        JButton backbtn, searchbtn;
        JLabel lsub, logo, latt;

        latt = new JLabel("Select Att:");
        lsub = new JLabel("Select Subject:");
        searchbtn = new JButton("Search");
        logo = new JLabel("See Attendance");
        backbtn = new JButton("Back");
        info = new JLabel("");

        logo.setBounds(140,20,200,40);
        lsub.setBounds(50,100,120,30);
        sub.setBounds(170,100,200,30);
        latt.setBounds(50,150,80,30);
        att.setBounds(170,150,200,30);
        searchbtn.setBounds(90,200,80,30);
        backbtn.setBounds(220,200,80,30);
        info.setBounds(400,10,400,200);

        File fld = new File("Teachers/"+teacher);
        File sublist[] = fld.listFiles();
        int n = sublist.length;
        for (int s=0;s<n;s++) {
            sub.addItem(sublist[s].getName());
        }
        if (n==0)
            sub.addItem("No data found");

        c.add(backbtn);
        c.add(searchbtn);
        c.add(sub);
        c.add(latt);
        c.add(att);
        c.add(logo);
        c.add(lsub);
        c.add(sub);
        c.add(info);

		f.setBounds(100,100,700,400);

		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				try {
					subs = sub.getSelectedItem().toString();
					File attlist = new File("Teachers/"+teacher+"/"+subs);
    	   			File attend[] = attlist.listFiles();
 			        int n = attend.length;
 		    	    att.removeAllItems();
 		        	att.addItem("Select Attendance");
 		        	for (s=0;s<n-1;s++) {
	 	            	att.addItem(attend[s].getName());
    		  		}
      		    	if (n==0) {
            			att.addItem("No data found");
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
					System.out.println("Error Occured");
				}
			}
		});

	}

	static void getData() throws IOException {
		atts = att.getSelectedItem().toString();
		FileReader fr = new FileReader("Teachers/Ali/Maths/"+atts);
		int c=0; String data="";
		while ((c=fr.read())!=-1)
		data = data + String.valueOf((char)c);
		fr.close();
		info.setText(data);
	}
}