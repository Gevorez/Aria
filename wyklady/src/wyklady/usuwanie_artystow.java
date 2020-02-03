package wyklady;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class usuwanie_artystow extends JFrame {

	private JPanel contentPane;
	private JTextField arty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuwanie_artystow frame = new usuwanie_artystow();
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
	public usuwanie_artystow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("       Usuwanie artystow");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(0, 22, 234, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Artysta");
		lblNewLabel_1.setBounds(43, 115, 123, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Usun");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String sql="DELETE FROM artysci WHERE (Artysta) ="
							+ " ('"+arty.getText()+"')";
							
					int rs=stmt.executeUpdate(sql);
					if(rs==1)
						JOptionPane.showMessageDialog(null, "Artysta zostal usuniety");
					else 
						JOptionPane.showMessageDialog(null, "Bledne dane");
					con.close();
				} catch(Exception e1)
				{
					System.out.println(e1);
					}
			}
		});
			
			
		
		btnNewButton.setBounds(71, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		arty = new JTextField();
		arty.setBounds(43, 136, 131, 20);
		contentPane.add(arty);
		arty.setColumns(10);
	}

}
