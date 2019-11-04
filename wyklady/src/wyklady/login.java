package wyklady;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 239, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogowanie = new JLabel("Logowanie");
		lblLogowanie.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogowanie.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblLogowanie.setBounds(10, 11, 203, 31);
		frame.getContentPane().add(lblLogowanie);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 83, 48, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblHaso = new JLabel("Has\u0142o");
		lblHaso.setBounds(10, 150, 48, 14);
		frame.getContentPane().add(lblHaso);
		
		user = new JTextField();
		user.setBounds(10, 108, 203, 31);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(10, 171, 203, 31);
		frame.getContentPane().add(pass);
		
		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from login where Login='"+user.getText()+"'and Haslo='"+pass.getText().toString()+ "'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Uda³o sie zalogowac");
					else 
						JOptionPane.showMessageDialog(null, "B³êdny login lub has³o");
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			}
		});
		btnZaloguj.setBounds(10, 213, 89, 23);
		frame.getContentPane().add(btnZaloguj);
	}
}
