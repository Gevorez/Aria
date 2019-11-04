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

public class asd {

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
					asd window = new asd();
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
	public asd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		user = new JTextField();
		user.setBounds(503, 112, 108, 19);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(503, 73, 68, 29);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(503, 141, 88, 29);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(503, 26, 46, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(558, 26, 46, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnLoginIn = new JButton("Login in");
		btnLoginIn.addActionListener(new ActionListener() {
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
						JOptionPane.showMessageDialog(null, "B³êdny login lub haslo");
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			}
		});
		btnLoginIn.setBounds(558, 236, 85, 21);
		frame.getContentPane().add(btnLoginIn);
		
		JButton btnNewButton_2 = new JButton("logo");
		btnNewButton_2.setBounds(53, 52, 352, 269);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Register");
		btnNewButton_3.setBounds(558, 266, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		pass = new JPasswordField();
		pass.setBounds(503, 188, 108, 19);
		frame.getContentPane().add(pass);
	}
}
