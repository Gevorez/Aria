package wyklady;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class przypomnienie_hasla {

	private JFrame frame;
	private JTextField pomoc;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pomoc = new JTextField();
		pomoc.setBounds(54, 67, 296, 19);
		frame.getContentPane().add(pomoc);
		pomoc.setColumns(10);
		
		JLabel lblPrzypomnienieHasla = new JLabel("Podaj odpowiedz na pytanie pomocnicze");
		lblPrzypomnienieHasla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrzypomnienieHasla.setBounds(54, 24, 355, 33);
		frame.getContentPane().add(lblPrzypomnienieHasla);
		
		JButton btnPrzypomnij = new JButton("Przypomnij");
		btnPrzypomnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
						Statement stmt=con.createStatement();
						String test=pomoc.getText();
						
						String sql3="Select Haslo, pytanie_pomoc from login where pytanie_pomoc ='"+test+"'";
						ResultSet rs3=stmt.executeQuery(sql3);
						rs3.next();
						String pomoc = rs3.getString("pytanie_pomoc");
						String haslo = rs3.getString("Haslo");
						
							
						if(pomoc != test)
							JOptionPane.showMessageDialog(null, "Twoje has³o to: "+ haslo);
						
						
						con.close();
						}
					 catch(Exception e1){JOptionPane.showMessageDialog(null, "B³êdna odpowiedz");}
			}
		});
		btnPrzypomnij.setBounds(265, 96, 85, 21);
		frame.getContentPane().add(btnPrzypomnij);
	}
}
