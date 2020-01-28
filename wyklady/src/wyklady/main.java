package wyklady;

import java.sql.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

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

public class main {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	
	

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		new splash();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
					
					
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
	private void initialize() throws IOException {
		
		//PRÓBUJE ZMIENIÆ KURSOR NA GUZIKACH - KAMIL
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
		
		
		user = new JTextField();
		user.setBounds(1028, 181, 181, 29);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(1028, 153, 68, 29);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(1028, 238, 88, 29);
		frame.getContentPane().add(lblPassword);

		JButton btnLoginIn = new JButton("Login in");
		btnLoginIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String xd=pass.getText();
					
					/*String sql2="Select Haslo from login where Login='"+user.getText()+"'";
					ResultSet rs2=stmt.executeQuery(sql2);
					rs2.next();
					String haslo = rs2.getString("Haslo");
					System.out.println(haslo);*/
					
					String sql="Select Login, Haslo from login where Login='"+user.getText()+"'and Haslo=SHA1('"+xd+ "')";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						frame.setVisible(false);
						menu_glowne window = new menu_glowne();
						window.frame.setVisible(true);
					}
					else 
						JOptionPane.showMessageDialog(null, "Bledny login lub haslo");
				
					
					
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			}
		});
		btnLoginIn.setBounds(1128, 336, 108, 29);
		btnLoginIn.setIcon(loginguzik);
		btnLoginIn.setBorderPainted(false);
		btnLoginIn.setFocusPainted(false);
		btnLoginIn.setContentAreaFilled(false);
		frame.getContentPane().add(btnLoginIn);
		
		
		JButton btnNewButton_3 = new JButton("Register");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rejestracja okno = new rejestracja();
				okno.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(1151, 376, 85, 21);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton_3);
		
		pass = new JPasswordField();
		pass.setBounds(1028, 268, 181, 29);
		frame.getContentPane().add(pass);
		
		JLabel tlolabel = new JLabel("");
		tlolabel.setBounds(0, 0, 1280, 720);
		tlolabel.setIcon(tlo);
		frame.getContentPane().add(tlolabel);
	}
}