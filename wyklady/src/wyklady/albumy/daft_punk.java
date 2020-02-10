package wyklady.albumy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import wyklady.main;

public class daft_punk {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					daft_punk window = new daft_punk();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public daft_punk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 498);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 26, 817, 336);
		frame.getContentPane().add(textArea);
		JTextField textField = new JTextField();
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 *
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
			     	String licznik=textField.getText();
					licznik=licznik+1;
				String sql1="Select Tytul,Wykonawca,Album,Data_publikacji,id from utwory where id="+textField.getText()+"";
				ResultSet rs2=stmt.executeQuery(sql1);
			
						rs2.next();
							
								  	String tyt  = rs2.getString("Tytul");
							         String wyko = rs2.getString("Wykonawca");
							         String Album = rs2.getString("Album");
							         String Data_pb = rs2.getString("Data_publikacji");
							        
							
							   
							        
							         
							String sql3="INSERT INTO zakupione_"+main.user.getText()+" (tytul,wykonawca,album,data_publikacji) "
									+ "VALUES('"+tyt+"','"+wyko+"','"+Album+"','"+Data_pb+"')";  
				         int rss=stmt.executeUpdate(sql3);
							
							
				con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, "Podales bledne ID lub juz posiadasz ten utwor w bazie");}
				
		}
		});
		btnNewButton.setBounds(254, 373, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Podaj id utworu, ktory chcesz kupic");
		lblNewLabel.setBounds(10, 377, 185, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		textField.setBounds(192, 374, 37, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
			Statement stmt=con.createStatement();
			int i=0;
			String sql2="Select Tytul,Wykonawca,Album,Data_publikacji,id from utwory where Wykonawca='Daft punk' or Wykonawca='daft punk'";
			ResultSet rs2=stmt.executeQuery(sql2);
			
				
					while(rs2.next() &&  i<999) {
			         //Retrieve by column name
			         String tyt  = rs2.getString("Tytul");
			         String wyko = rs2.getString("Wykonawca");
			         String Album = rs2.getString("Album");
			         String Data_pb = rs2.getString("Data_publikacji");
			         int id=rs2.getInt("id");
			        
			         i++;
			         
			         //Display values
			        textArea.append(id +" "+Album+"\t\t "   +wyko+ "\t\t"+tyt+" \t\t  "+Data_pb+"\n"); 
			        
			        
					}
					
					
			
		
					con.close();
		} catch(Exception e1){System.out.print(e1);}
	}
	}


