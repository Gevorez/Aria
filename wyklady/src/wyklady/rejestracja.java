package wyklady;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class rejestracja extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public rejestracja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 533);
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
		
		textField = new JTextField();
		textField.setBounds(10, 105, 275, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 151, 275, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 195, 275, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 247, 275, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 292, 275, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 344, 275, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(10, 78, 68, 21);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSurname.setBounds(10, 128, 97, 21);
		contentPane.add(lblSurname);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(10, 172, 97, 21);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhoneNumber.setBounds(10, 224, 147, 21);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(10, 261, 97, 31);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(10, 321, 97, 19);
		contentPane.add(lblPassword);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 396, 275, 11);
		contentPane.add(progressBar);
		
		JLabel lblPasswordStrength = new JLabel("Password strength");
		lblPasswordStrength.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPasswordStrength.setBounds(10, 373, 184, 21);
		contentPane.add(lblPasswordStrength);
	}

}
