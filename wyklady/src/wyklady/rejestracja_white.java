package wyklady;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class rejestracja_white extends JFrame {

	private JPanel contentPane;
	private JTextField imie;
	private JTextField nazwisko;
	private JTextField email;
	private JTextField telefon;
	private JTextField login;
	private JPasswordField haslo;
	private JTextField pomocnicze;
	private JTextField pytan_pomoc;
	private ComboBoxModel patternExamples;
	private JTextField nazwa_str;
	static ResourceBundle res;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rejestracja_white frame = new rejestracja_white();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public rejestracja_white() {
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("EN");
		
		
		ImageIcon rejtlo = new ImageIcon("jasne/rej_tlo_jasne.png");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1000, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setForeground(Color.BLACK);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUser.setBounds(10, 10, 52, 21);
		contentPane.add(lblUser);
		
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
		JButton btnbtn = new JButton(res.getString("Register"));
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
				btnbtn.doClick();
				
			}
		});
		haslo.setBounds(10, 321, 275, 19);
		contentPane.add(haslo);
		
		JLabel lblName = new JLabel(res.getString("Name"));
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(10, 47, 68, 21);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel(res.getString("Surname"));
		lblSurname.setForeground(Color.BLACK);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSurname.setBounds(10, 97, 97, 21);
		contentPane.add(lblSurname);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(10, 149, 97, 21);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel(res.getString("Phonenumber"));
		lblPhoneNumber.setForeground(Color.BLACK);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhoneNumber.setBounds(10, 201, 147, 21);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(10, 238, 97, 31);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel(res.getString("Password"));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(10, 298, 97, 19);
		contentPane.add(lblPassword);
		
		
		progressBar.setMaximum(15);
		progressBar.setBounds(10, 370, 275, 11);
		contentPane.add(progressBar);
		
		pomocnicze = new JTextField();
		pytan_pomoc = new JTextField();
		JLabel lblPasswordStrength = new JLabel(res.getString("PasswordStrength"));
		lblPasswordStrength.setForeground(Color.BLACK);
		lblPasswordStrength.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPasswordStrength.setBounds(10, 349, 184, 21);
		contentPane.add(lblPasswordStrength);
		
		
		
		
		
		btnbtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnbtn.setBounds(295, 673, 161, 42);
		contentPane.add(btnbtn);
		
		btnNewButton.setVisible(false);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(372, 14, 0, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblPyranie = new JLabel(res.getString("AuxiliaryQuestion"));
		lblPyranie.setForeground(Color.BLACK);
		lblPyranie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPyranie.setBounds(10, 385, 253, 21);
		contentPane.add(lblPyranie);
		
		
		pomocnicze.setBounds(11, 475, 274, 19);
		contentPane.add(pomocnicze);
		pomocnicze.setColumns(10);
		
		
		pytan_pomoc.setBounds(10, 416, 275, 19);
		pytan_pomoc.setVisible(false);
		contentPane.add(pytan_pomoc);
		pytan_pomoc.setColumns(10);
		
		JLabel label = new JLabel(res.getString("AnswerAuxiliaryQuestion"));
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(10, 445, 253, 21);
		contentPane.add(label);
		
		JButton btnRodo = new JButton("RODO");
		btnRodo.setForeground(Color.CYAN);
		btnRodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRodo.setBounds(225, 586, 89, 23);
		btnRodo.setBorderPainted(false);
		btnRodo.setFocusPainted(false);
		btnRodo.setContentAreaFilled(false);
		btnRodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RODO okno = new RODO();
				okno.setVisible(true);
			}
		});
		contentPane.add(btnRodo);
		
		JLabel lblIAcceptThe = new JLabel(res.getString("IAcceptTheTermsAndCnditionsOf"));
		lblIAcceptThe.setForeground(Color.BLACK);
		lblIAcceptThe.setBounds(10, 590, 253, 14);
		contentPane.add(lblIAcceptThe);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
			
		
		chckbxNewCheckBox.setBounds(6, 567, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 416, 275, 21);
		contentPane.add(comboBox);
		comboBox.addItem(res.getString("JakNazywaSieTwojPies"));
		comboBox.addItem(res.getString("JakiJestNunmerTwojejKartyKredytowej"));
		comboBox.addItem(res.getString("JakiMaszNumerButa"));
		
		nazwa_str=new JTextField();
		nazwa_str.setVisible(false);
		contentPane.add(nazwa_str);
		nazwa_str.setColumns(10);
		
			
		
		btnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					/*	String x = login.getText();					 
					String sql2="Select Login from login";
					ResultSet rs2=stmt.executeQuery(sql2);
					String sql4="Select Login from login where Login="+x;
					ResultSet rs4=stmt.executeQuery(sql4)
					rs*/
					
					 if(login.getText().isEmpty()||haslo.getText().isEmpty()||email.getText().isEmpty()||telefon.getText().isEmpty()||nazwisko.getText().isEmpty()||pomocnicze.getText().isEmpty())
						
					 {
						JOptionPane.showMessageDialog(null, res.getString("NiePodalesWszystkichInformacji"));
					}
						
						
					else {	
						String sql2="SELECT count(*) as total from login ";
						ResultSet rs2=stmt.executeQuery(sql2);
						rs2.next();
						int xd=rs2.getInt("total");
						if(xd==0 ) {
							if (chckbxNewCheckBox.isSelected() ) {
							String sql3="INSERT INTO login (Login, Haslo, Email, Telefon, Imie,Nazwisko,pytanie_pomoc,pytanie_pomoc_tresc,nazwa_studia,Admin,Admin_head) "
									+ "VALUES('"+login.getText()+"',SHA1('"+haslo.getText()+"'),'"+email.getText()+"','"+telefon.getText()+"','"+imie.getText()+"','"+nazwisko.getText()+"','"+pomocnicze.getText()+"','"+pytan_pomoc.getText()+"','"+nazwa_str.getText()+"',1,1)";
							
							int rs=stmt.executeUpdate(sql3);
							dispose();
							}
						} else 
							if (chckbxNewCheckBox.isSelected() ) {
						{
							String sql="INSERT INTO login (Login, Haslo, Email, Telefon, Imie,Nazwisko,pytanie_pomoc,pytanie_pomoc_tresc,nazwa_studia,Admin,Admin_head) "
							+ "VALUES('"+login.getText()+"',SHA1('"+haslo.getText()+"'),'"+email.getText()+"','"+telefon.getText()+"','"+imie.getText()+"','"+nazwisko.getText()+"','"+pomocnicze.getText()+"','"+pytan_pomoc.getText()+"','"+nazwa_str.getText()+"',0,0)";
							
							
								
					int rs3=stmt.executeUpdate(sql);
					dispose();
						
						
							
						}
					}
							else {
								chckbxNewCheckBox.setSelected(false);
								JOptionPane.showMessageDialog(null,res.getString("ZaakceptujRODO"));
							}
					}
					
					
							con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
			}
		});
		
		
		JLabel rej_tlo = new JLabel("");
		rej_tlo.setBounds(0, 0, 484, 761);
		rej_tlo.setIcon(rejtlo);
		contentPane.add(rej_tlo);
	           
 
	
	}
}
