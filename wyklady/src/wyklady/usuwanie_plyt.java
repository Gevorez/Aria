package wyklady;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class usuwanie_plyt extends JFrame {

	private JPanel contentPane;
	private JTextField plyta;
	private JTextField artysta;
	private JTextField Data_wydania;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuwanie_plyt frame = new usuwanie_plyt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public usuwanie_plyt() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		plyta = new JTextField();
		plyta.setBounds(45, 104, 127, 20);
		contentPane.add(plyta);
		plyta.setColumns(10);
		
		artysta = new JTextField();
		artysta.setBounds(45, 153, 124, 20);
		contentPane.add(artysta);
		artysta.setColumns(10);
		
		Data_wydania = new JTextField();
		Data_wydania.setBounds(45, 200, 124, 20);
		contentPane.add(Data_wydania);
		Data_wydania.setColumns(10);
		
		JButton usun = new JButton("Usun");
		usun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
				Statement stmt=con.createStatement();
				String sql="DELETE FROM plyty WHERE (Nazwa_plyty, Data_wydania, Artysta) ="
						+ " ('"+plyta.getText()+"','"+artysta.getText()+"','"+Data_wydania.getText()+"')";
						
				int rs=stmt.executeUpdate(sql);
				if(rs==1)
					JOptionPane.showMessageDialog(null, "Plyta zostala usunieta");
				else 
					JOptionPane.showMessageDialog(null, "Bledne dane");
				con.close();
			} catch(Exception e1)
			{
				System.out.println(e1);
				}
		}
	});
			
		
		usun.setBounds(58, 251, 89, 23);
		contentPane.add(usun);
		
		JLabel nazw_plyt = new JLabel("Nazwa plyty");
		nazw_plyt.setBounds(45, 85, 127, 23);
		contentPane.add(nazw_plyt);
		
		JLabel art = new JLabel("Artysta");
		art.setBounds(45, 134, 127, 22);
		contentPane.add(art);
		
		JLabel Dat_wyd = new JLabel("Data wydania");
		Dat_wyd.setBounds(45, 184, 124, 20);
		contentPane.add(Dat_wyd);
		
		JLabel lblNewLabel_3 = new JLabel("       Usuwanie plyt");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(0, 24, 234, 50);
		contentPane.add(lblNewLabel_3);
	}
}
