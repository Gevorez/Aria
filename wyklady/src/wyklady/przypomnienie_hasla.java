package wyklady;

import java.awt.EventQueue;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import wyklady.szyfrowanie;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.security.MessageDigest;
import java.awt.Color;
public class przypomnienie_hasla {

	JFrame frame;
	private JTextField pomoc;
	private JPasswordField password;
	private JTextField login;
	static ResourceBundle res;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					przypomnienie_hasla window = new przypomnienie_hasla();
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
	public przypomnienie_hasla() {
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("EN");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 485, 291);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pomoc = new JTextField();
		pomoc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		pomoc.setBackground(Color.BLACK);
		pomoc.setForeground(Color.WHITE);
		pomoc.setBounds(91, 152, 296, 19);
		frame.getContentPane().add(pomoc);
		pomoc.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(54, 259, 418, -252);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, -231, 347, 179);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(res.getString("enter"));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 276, 26);
		panel.add(lblNewLabel);
		
		JButton zmianka = new JButton(res.getString("change"));
		zmianka.setForeground(Color.WHITE);
		zmianka.setBackground(Color.BLACK);
		zmianka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					
					
						String sql="Update login "
								+ "set Haslo=SHA1('"+password.getText()+"')"
								+"where pytanie_pomoc='"+pomoc.getText()+"'";
						

						;
						
						
						int rs=stmt.executeUpdate(sql);
						if(rs==1) {
							JOptionPane.showMessageDialog(null, res.getString("pa"));
							password.setText(null);
						}
						
					
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			
				
			}
		});
		zmianka.setBounds(93, 94, 89, 23);
		panel.add(zmianka);
		
		password = new JPasswordField();
		password.setBackground(Color.BLACK);
		password.setForeground(Color.WHITE);
		password.setBounds(64, 62, 185, 20);
		panel.add(password);
		
		
		JLabel lblPrzypomnienieHasla = new JLabel(res.getString("po"));
		lblPrzypomnienieHasla.setForeground(Color.WHITE);
		lblPrzypomnienieHasla.setBounds(10, 0, 476, 74);
		lblPrzypomnienieHasla.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		frame.getContentPane().add(lblPrzypomnienieHasla);
		login = new JTextField();
		JButton btnPrzypomnij = new JButton(res.getString("change"));
		btnPrzypomnij.setBounds(170, 198, 121, 21);
		btnPrzypomnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
						Statement stmt=con.createStatement();
						String test=pomoc.getText();
						String loginek=login.getText();
						
						String sql3="Select  pytanie_pomoc,login from login where pytanie_pomoc ='"+test+"'and login ='"+loginek+"'";
						ResultSet rs3=stmt.executeQuery(sql3);
						rs3.next();
						String pomoc = rs3.getString("pytanie_pomoc");
						
						
							
						if(pomoc != test && pomoc !=loginek )
						{
					    layeredPane.removeAll();
						layeredPane.add(panel);
						layeredPane.repaint();
						layeredPane.revalidate();
						panel.setVisible(true);
						frame.setContentPane(panel);
						}
						
						con.close();
						}
					 catch(Exception e1){JOptionPane.showMessageDialog(null, res.getString("WrongAnswer"));}
			}
		});
		frame.getContentPane().add(btnPrzypomnij);
		
		
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		login.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		login.setBounds(91, 102, 296, 20);
		frame.getContentPane().add(login);
		login.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(21, 107, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblOdpowiedz = new JLabel(res.getString("Answer"));
		lblOdpowiedz.setForeground(Color.WHITE);
		lblOdpowiedz.setBounds(21, 157, 64, 14);
		frame.getContentPane().add(lblOdpowiedz);
		
		
	}
}
