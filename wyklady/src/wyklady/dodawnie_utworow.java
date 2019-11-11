package wyklady;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class dodawnie_utworow {

	private JFrame frame;
	private JTextField tytu;
	private JTextField wyko;
	private JTextField data_publi;
	private JTextField albu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dodawnie_utworow window = new dodawnie_utworow();
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
	public dodawnie_utworow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 192);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDodawanieNowegoUtworu = new JLabel("Dodawanie nowego utworu");
		lblDodawanieNowegoUtworu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDodawanieNowegoUtworu.setBounds(25, 11, 275, 33);
		frame.getContentPane().add(lblDodawanieNowegoUtworu);
		
		JLabel tyt = new JLabel("Tytu\u0142");
		tyt.setBounds(25, 82, 86, 14);
		frame.getContentPane().add(tyt);
		
		JLabel wyk = new JLabel("Wykonawca");
		wyk.setBounds(150, 82, 86, 14);
		frame.getContentPane().add(wyk);
		
		JLabel alb = new JLabel("Album");
		alb.setBounds(281, 82, 86, 14);
		frame.getContentPane().add(alb);
		
		JLabel data_pub = new JLabel("Data_publikacji");
		data_pub.setBounds(401, 82, 86, 14);
		frame.getContentPane().add(data_pub);
		
		tytu = new JTextField();
		tytu.setBounds(25, 107, 86, 20);
		frame.getContentPane().add(tytu);
		tytu.setColumns(10);
		
		wyko = new JTextField();
		wyko.setBounds(150, 107, 86, 20);
		frame.getContentPane().add(wyko);
		wyko.setColumns(10);
		
		albu = new JTextField();
		albu.setColumns(10);
		albu.setBounds(281, 107, 86, 20);
		frame.getContentPane().add(albu);
		
		data_publi = new JTextField();
		data_publi.setColumns(10);
		data_publi.setBounds(401, 107, 86, 20);
		frame.getContentPane().add(data_publi);
		
		JButton btnDodaj = new JButton("dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String sql="INSERT INTO utwory (Tytul, Wykonawca, Album, Data_publikacji) "
							+ "VALUES('"+tytu.getText()+"','"+wyko.getText()+"','"+albu.getText()+"','"+data_publi.getText()+"')";
					int rs=stmt.executeUpdate(sql);
					if(rs==1)
						JOptionPane.showMessageDialog(null, "Utwór został dodany");
					else 
						JOptionPane.showMessageDialog(null, "B³êdny login lub haslo");
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			}
		});
		
		btnDodaj.setBounds(533, 106, 89, 23);
		frame.getContentPane().add(btnDodaj);
	}
}
