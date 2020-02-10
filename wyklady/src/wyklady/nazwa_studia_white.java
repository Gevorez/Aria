package wyklady;

import java.awt.Color;
import wyklady.main_white;
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
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class nazwa_studia_white {
	  JFrame frame;//Creating object of JFrame
	  JLabel image=new JLabel(new ImageIcon("tlo.png"));
	  JLabel text=new JLabel("TUTORIALS FIELD");
	    JProgressBar progressBar=new JProgressBar();
	    JLabel message=new JLabel();//Crating a JLabel for displaying the message
	    private JTextField nazwa_std;
	    static ResourceBundle res;
	    nazwa_studia_white()
	    {
	    	createGUI();
	       
	    }
	    public void createGUI(){
	    	if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("PL");
			if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("EN");
	    	ImageIcon tlo = new ImageIcon("jasne/tlo_jasne.png");
	    	
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
	        
	        JLabel lblTwojaNazwaStudia = new JLabel(res.getString("Studio"));
	        lblTwojaNazwaStudia.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblTwojaNazwaStudia.setForeground(Color.WHITE);
	        lblTwojaNazwaStudia.setBounds(187, 26, 218, 43);
	        frame.getContentPane().add(lblTwojaNazwaStudia);
	        
	        JButton btnKliku = new JButton(res.getString("kliku"));
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
										+ "where Login='"+main_white.user.getText()+"'";               
						int rs=stmt.executeUpdate(sql);
						
						
						String sql2="create table zakupione_"+main_white.user.getText()+" (tytul varchar(255),"
								+ "wykonawca varchar(255),"
								+ "album varchar(255),"
								+ "data_publikacji varchar(255),"
								+ "id int(255) NOT NULL AUTO_INCREMENT,"
								+ "UNIQUE KEY uniq (tytul),"
								+ "PRIMARY KEY (id))"; 
						int rs2 =stmt.executeUpdate(sql2);
						
						frame.setVisible(false);
						menu_glowne_white window2 = new menu_glowne_white();
						window2.frame.setVisible(true);
						
						}
				
	        		
								con.close();
					} catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
				}
			});
	        	
	        
	        btnKliku.setBounds(472, 206, 89, 23);
	        frame.getContentPane().add(btnKliku);
	        
	        JLabel tlostudio = new JLabel("New label");
	        tlostudio.setBounds(-675, -400, 1280, 720);
	        frame.getContentPane().add(tlostudio);
	        tlostudio.setIcon(tlo);
	        frame.setVisible(true);

	    }
}
