package wyklady;

import java.awt.Color;
import wyklady.main;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class nazwa_studia {
	  JFrame frame;//Creating object of JFrame
	  JLabel image=new JLabel(new ImageIcon("tlo.png"));
	  JLabel text=new JLabel("TUTORIALS FIELD");
	    JProgressBar progressBar=new JProgressBar();
	    JLabel message=new JLabel();//Crating a JLabel for displaying the message
	    private JTextField nazwa_std;
	    nazwa_studia()
	    {
	    	createGUI();
	       
	    }
	    public void createGUI(){
	        frame=new JFrame();
	        frame.getContentPane().setLayout(null);
	        frame.setSize(600,300);
	        frame.setUndecorated(true);
	        frame.setLocationRelativeTo(null);
	        frame.getContentPane().setBackground(Color.black);
	        
	        nazwa_std = new JTextField();
	        nazwa_std.setBounds(113, 93, 348, 43);
	        frame.getContentPane().add(nazwa_std);
	        nazwa_std.setColumns(10);
	        
	        JLabel lblTwojaNazwaStudia = new JLabel("Twoja nazwa studia:");
	        lblTwojaNazwaStudia.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblTwojaNazwaStudia.setForeground(Color.WHITE);
	        lblTwojaNazwaStudia.setBounds(187, 26, 218, 43);
	        frame.getContentPane().add(lblTwojaNazwaStudia);
	        
	        JButton btnKliku = new JButton("kliku");
	        btnKliku.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
						Statement stmt=con.createStatement();
						
						
						if(nazwa_std.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Nie podales nazwy studia");
						}
						else {
						String sql="Update login "
								+ "set nazwa_studia='"+nazwa_std.getText()+"'"
										+ "where Login='"+main.user.getText()+"'";               
						int rs=stmt.executeUpdate(sql);
						if(rs == 1)
							JOptionPane.showMessageDialog(null, "Udalo sie zarejestrowac");
						else 
						
							JOptionPane.showMessageDialog(null, "Nie udalo sie zarejestrowac");
						}
				
	        		
								con.close();
					} catch(Exception e1){JOptionPane.showMessageDialog(null, "cos poszlo nie tak");}
				}
			});
	        	
	        
	        btnKliku.setBounds(472, 206, 89, 23);
	        frame.getContentPane().add(btnKliku);
	        frame.setVisible(true);

	    }
}
