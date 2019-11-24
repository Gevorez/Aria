package wyklady;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class rejestracja extends JFrame {

	private JPanel contentPane;
	private JTextField imie;
	private JTextField nazwisko;
	private JTextField email;
	private JTextField telefon;
	private JTextField login;
	private JPasswordField haslo;
	private JTextField pomocnicze;
	private JTextField pytan_pomoc;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rejestracja frame = new rejestracja();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the framee
	 */
	public rejestracja() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUser.setBounds(10, 10, 52, 21);
		contentPane.add(lblUser);
		
		JButton btnCreator = new JButton("Creator");
		btnCreator.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCreator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreator.setBounds(72, 10, 110, 21);
		contentPane.add(btnCreator);
		
		imie = new JTextField();
		imie.setBounds(10, 74, 275, 19);
		contentPane.add(imie);
		imie.setColumns(10);
		
		nazwisko = new JTextField();
		nazwisko.setBounds(10, 120, 275, 19);
		contentPane.add(nazwisko);
		nazwisko.setColumns(10);
		
		email = new JTextField();
		email.setBounds(10, 172, 275, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		telefon = new JTextField();
		telefon.setBounds(10, 224, 275, 19);
		contentPane.add(telefon);
		telefon.setColumns(10);
		
		login = new JTextField();
		login.setBounds(10, 269, 275, 19);
		contentPane.add(login);
		login.setColumns(10);
		JProgressBar progressBar = new JProgressBar();
		JButton btnNewButton = new JButton("New button");
		JButton btnRegister = new JButton("Register");
		haslo = new JPasswordField();
		haslo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int s= haslo.getText().length();
				progressBar.setValue(s);
				btnNewButton.doClick();
				
				
			}
		});
		haslo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s= haslo.getText().length();
				progressBar.setValue(s);
				btnRegister.doClick();
				
			}
		});
		haslo.setBounds(10, 321, 275, 19);
		contentPane.add(haslo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(10, 47, 68, 21);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSurname.setBounds(10, 97, 97, 21);
		contentPane.add(lblSurname);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(10, 149, 97, 21);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhoneNumber.setBounds(10, 201, 147, 21);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(10, 238, 97, 31);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(10, 298, 97, 19);
		contentPane.add(lblPassword);
		
		
		progressBar.setMaximum(15);
		progressBar.setBounds(10, 370, 275, 11);
		contentPane.add(progressBar);
		
		pomocnicze = new JTextField();
		pytan_pomoc = new JTextField();
		JLabel lblPasswordStrength = new JLabel("Password strength");
		lblPasswordStrength.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPasswordStrength.setBounds(10, 349, 184, 21);
		contentPane.add(lblPasswordStrength);
		
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					/*	String x = login.getText();					 
					String sql2="Select Login from login";
					ResultSet rs2=stmt.executeQuery(sql2);
					String sql4="Select Login from login where Login="+x;
					ResultSet rs4=stmt.executeQuery(sql4);
					rs*/
					String sql="INSERT INTO login (Login, Haslo, Email, Telefon, Imie,Nazwisko,pytanie_pomoc,pytanie_pomoc_tresc) "
							+ "VALUES('"+login.getText()+"','"+haslo.getText()+"','"+email.getText()+"','"+telefon.getText()+"','"+imie.getText()+"','"+nazwisko.getText()+"','"+pomocnicze.getText()+"','"+pytan_pomoc.getText()+"')";               
					int rs=stmt.executeUpdate(sql);
					if(rs == 1)
						JOptionPane.showMessageDialog(null, "Udało sie zarejestrowaĉ");
					else 
					
						JOptionPane.showMessageDialog(null, "Nie udało sie zarejestrowaĉ");
							con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, "Prosze wybrać inny login");}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRegister.setBounds(267, 496, 115, 42);
		contentPane.add(btnRegister);
		
		btnNewButton.setVisible(false);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(372, 14, 0, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblPyranie = new JLabel("Auxiliary question");
		lblPyranie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPyranie.setBounds(10, 385, 253, 21);
		contentPane.add(lblPyranie);
		
		
		pomocnicze.setBounds(11, 475, 274, 19);
		contentPane.add(pomocnicze);
		pomocnicze.setColumns(10);
		
		
		pytan_pomoc.setBounds(10, 416, 275, 19);
		contentPane.add(pytan_pomoc);
		pytan_pomoc.setColumns(10);
		
		JLabel label = new JLabel("Answer Auxiliary question");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(10, 445, 253, 21);
		contentPane.add(label);
	}
}
