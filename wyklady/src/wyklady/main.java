package wyklady;

import java.sql.*;
import java.util.ResourceBundle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main {

	 JFrame frame;
	public static JTextField user;
	private JPasswordField pass;
	static ResourceBundle res;

	
	

	/**
	 * Launch the applicationd
	 */
	public static void main(String[] args) {
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("EN");
		new splash();
		user = new JTextField();
		user.setHorizontalAlignment(SwingConstants.LEFT);
		user.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		user.setForeground(Color.WHITE);
		user.setBackground(Color.BLACK);
		user.setBounds(1013, 198, 210, 29);
		user.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
	 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
					Statement stmt=con.createStatement();
					int my=stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS wypozyczalnia ");
					con.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public main() throws IOException {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws IOExceptio
	 */
	public void initialize() throws IOException {
		
		//PRÃ“BUJE ZMIENIÃ† KURSOR NA GUZIKACH - KAMIL
		//Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
		//Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
		
		ImageIcon loginguzik = new ImageIcon("guziczek.png");
		ImageIcon tlo = new ImageIcon("tlo.png");
		Image ikona = ImageIO.read(new File("logo.png"));
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(ikona);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton(res.getString("EN"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(GlobalVariables.jezyk==1) {GlobalVariables.jezyk=0;}
                else {GlobalVariables.jezyk=1;}
                final Frame[] frames = Frame.getFrames();
                if (frames != null)
                    for (final Frame f : frames)
                    {
                        f.dispose();
                    }
               		try {
						new main();
					} catch (IOException e1) {
						// TODO Automatycznie wygenerowany blok „catch”
						e1.printStackTrace();
					}
					 String[] errorSoon = new String[1];
		                main.main(errorSoon);
				
				
               
			}
		});
		btnNewButton.setBounds(1162, 27, 68, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblLogin = new JLabel(res.getString("Login"));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(1013, 169, 68, 29);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel(res.getString("Password"));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(1013, 233, 88, 29);
		frame.getContentPane().add(lblPassword);
		
		JButton btnForgotPassword = new JButton(res.getString("ForgetPassword"));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				przypomnienie_hasla window = new przypomnienie_hasla();
				window.frame.setVisible(true);
			}
		});
	    
		btnForgotPassword.setForeground(Color.WHITE);
		btnForgotPassword.setFocusPainted(false);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBorderPainted(false);
		btnForgotPassword.setBounds(1050, 365, 189, 21);
		frame.getContentPane().add(btnForgotPassword);
	
	
		JButton btnLoginIn = new JButton(res.getString("LogIn"));
		btnLoginIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String xd=pass.getText();
					
					
					String sql12="Select Login, Haslo,Admin from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "') and Admin=1";
					ResultSet rs12=stmt.executeQuery(sql12);
					
				
					
					 
					
					if(rs12.next()) {
						
						String sql="Select Login, Haslo from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
						ResultSet rs=stmt.executeQuery(sql);
						frame.setVisible(false);
						menu_glowne_admina window = new menu_glowne_admina();
						window.frame.setVisible(true);
						
					}
					else {
						
					
					
					String sql="Select Login, Haslo from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
					ResultSet rs=stmt.executeQuery(sql);
				
					String sql2="Select nazwa_studia from login where  Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
					ResultSet rs2=stmt.executeQuery(sql2);
					rs2.next();
					String nazwa_studia = rs2.getString("nazwa_studia");
					System.out.println(nazwa_studia);
					
					
						
					if(nazwa_studia.isEmpty()) {
						frame.setVisible(false);
						nazwa_studia window2 = new nazwa_studia();
						window2.frame.setVisible(true);
						
												}
					else 
					{
						
						frame.setVisible(false);
						menu_glowne window = new menu_glowne();
						window.frame.setVisible(true);
					}
					
					}
					
					con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, res.getString("wrong"));}
			
			}
		});
		btnLoginIn.setBounds(1113, 302, 108, 29);
		btnLoginIn.setIcon(loginguzik);
		btnLoginIn.setBorderPainted(false);
		btnLoginIn.setFocusPainted(false);
		btnLoginIn.setContentAreaFilled(false);
		frame.getContentPane().add(btnLoginIn);
		
		
		JButton btnNewButton_3 = new JButton(res.getString("Register"));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rejestracja okno = new rejestracja();
				okno.setVisible(true);
	try {
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					
				String sqlo=" "
						+ "CREATE TABLE IF NOT EXISTS login (" + 
						"  Login varchar(255) NOT NULL," + 
						"  Haslo varchar(255) NOT NULL," + 
						"  Email varchar(255) NOT NULL," + 
						"  Telefon varchar(255) NOT NULL," + 
						"  Imie varchar(255) NOT NULL," + 
						"  Nazwisko varchar(255) NOT NULL," + 
						"  pytanie_pomoc varchar(255) NOT NULL," + 
						"  pytanie_pomoc_tresc varchar(255) NOT NULL," + 
						"  nazwa_studia varchar(255) NOT NULL," + 
						"  Admin int(1) NOT NULL, Admin_head int(1) NOT NULL," + 
						"  UNIQUE KEY uniq (Login))";
						
				int rsb=stmt.executeUpdate(sqlo);
				String solo2="CREATE TABLE IF NOT EXISTS `utwory` (\r\n" + 
						"  `Tytul` varchar(255) NOT NULL,\r\n" + 
						"  `Wykonawca` varchar(255) NOT NULL,\r\n" + 
						"  `Album` varchar(255) NOT NULL,\r\n" + 
						"  `Data_publikacji` varchar(255) NOT NULL,\r\n" + 
						"  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
						"  PRIMARY KEY (`id`)\r\n, UNIQUE KEY uniq (`Tytul`)"  + 
						")";
				int rsbb=stmt.executeUpdate(solo2);
				con.close();
	} catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}

			}
		});
		btnNewButton_3.setBounds(1123, 342, 100, 21);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton_3);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		pass.setForeground(Color.WHITE);
		pass.setBackground(Color.BLACK);
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
						Statement stmt=con.createStatement();
						String xd=pass.getText();
						
						
						String sql12="Select Login, Haslo,Admin from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "') and Admin=1";
						ResultSet rs12=stmt.executeQuery(sql12);
						
					
						
						 
						
						if(rs12.next()) {
							
							String sql="Select Login, Haslo from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
							ResultSet rs=stmt.executeQuery(sql);
							frame.setVisible(false);
							menu_glowne_admina window = new menu_glowne_admina();
							window.frame.setVisible(true);
							
						}
						else {
							
						
						
						String sql="Select Login, Haslo from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
						ResultSet rs=stmt.executeQuery(sql);
					
						String sql2="Select nazwa_studia from login where  Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
						ResultSet rs2=stmt.executeQuery(sql2);
						rs2.next();
						String nazwa_studia = rs2.getString("nazwa_studia");
						System.out.println(nazwa_studia);
						
						
							
						if(nazwa_studia.isEmpty()) {
							frame.setVisible(false);
							nazwa_studia window2 = new nazwa_studia();
							window2.frame.setVisible(true);
							
													}
						else 
						{
							
							frame.setVisible(false);
							menu_glowne window = new menu_glowne();
							window.frame.setVisible(true);
						}
						
						}
						
						con.close();
					} catch(Exception e1){JOptionPane.showMessageDialog(null, res.getString("wrong"));}
		
				}
			}
		});
		pass.setBounds(1013, 262, 210, 29);
		pass.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		frame.getContentPane().add(pass);
		
		JLabel tlolabel = new JLabel("");
		tlolabel.setBounds(0, 0, 1280, 720);
		tlolabel.setIcon(tlo);
		frame.getContentPane().add(tlolabel);
	}

	protected void setVisible(boolean b) {
		// TODO Automatycznie wygenerowany zacz¹tek metody
		
	}
}