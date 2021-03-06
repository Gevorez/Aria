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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class usuwanie_utworow {

	private JFrame frame;
	private JTextField tytu;
	private JTextField wyko;
	private JTextField albu;
	private JTextField data_publi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuwanie_utworow window = new usuwanie_utworow();
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
	public usuwanie_utworow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 372);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuwanieUtworu = new JLabel("     Usuwanie uworu");
		lblUsuwanieUtworu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUsuwanieUtworu.setBounds(10, 11, 260, 51);
		frame.getContentPane().add(lblUsuwanieUtworu);
		
		tytu = new JTextField();
		tytu.setBounds(48, 84, 123, 20);
		frame.getContentPane().add(tytu);
		tytu.setColumns(10);
		
		wyko = new JTextField();
		wyko.setBounds(48, 135, 123, 20);
		frame.getContentPane().add(wyko);
		wyko.setColumns(10);
		
		albu = new JTextField();
		albu.setBounds(48, 185, 123, 20);
		frame.getContentPane().add(albu);
		albu.setColumns(10);
		
		data_publi = new JTextField();
		data_publi.setBounds(48, 236, 123, 20);
		frame.getContentPane().add(data_publi);
		data_publi.setColumns(10);
		
		JButton btnUsun = new JButton("usun");
		btnUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String sql="DELETE FROM utwory WHERE (Tytul, Wykonawca, Album, Data_publikacji) ="
							+ " ('"+tytu.getText()+"','"+wyko.getText()+"','"+albu.getText()+"','"+data_publi.getText()+"')";
							
					int rs=stmt.executeUpdate(sql);
					if(rs==1)
						JOptionPane.showMessageDialog(null, "utwor zostal usuniety");
					else 
						JOptionPane.showMessageDialog(null, "Bledne dane");
					con.close();
				} catch(Exception e1)
				{
					System.out.println(e1);
					}
			}
		});
		
		btnUsun.setBounds(64, 286, 89, 23);
		frame.getContentPane().add(btnUsun);
		
		JLabel tyt = new JLabel("Tytu\u0142");
		tyt.setBounds(48, 67, 123, 20);
		frame.getContentPane().add(tyt);
		
		JLabel wyk = new JLabel("Wykonawca");
		wyk.setBounds(48, 116, 123, 20);
		frame.getContentPane().add(wyk);
		
		JLabel alb = new JLabel("Album");
		alb.setBounds(48, 166, 123, 20);
		frame.getContentPane().add(alb);
		
		JLabel dat_pub = new JLabel("Data publikacji");
		dat_pub.setBounds(48, 216, 123, 20);
		frame.getContentPane().add(dat_pub);
	}
}
