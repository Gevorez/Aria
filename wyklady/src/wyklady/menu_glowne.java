package wyklady;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;



public class menu_glowne {

	JFrame frame;
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
					menu_glowne window = new menu_glowne();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	
	public menu_glowne() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		//WEDEWDW
		//dqwdqwdwqdqw
		//WEFWEFWEFWE
		//thbeawfubewhfuhbewhbffewhbju
		
		Image ikona1 = ImageIO.read(new File("logo.png"));
		ImageIcon tlo = new ImageIcon("tlo.png");
		ImageIcon logo2 = new ImageIcon("logo2.png");
		ImageIcon studio_guziczek = new ImageIcon("studio_guziczek.png");
		ImageIcon lib_guziczek = new ImageIcon("lib_guziczek.png"); 
		ImageIcon sklep_guziczek = new ImageIcon("sklep_guziczek.png");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(ikona1);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		
		
		
		JLabel lblIkona = new JLabel("ikona");
		lblIkona.setBounds(55, 11, 80, 80);
		lblIkona.setIcon(logo2);
		frame.getContentPane().add(lblIkona);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(185, 0, 1095, 634);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		/*JLabel lblNewLabel = new JLabel("a");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(333, 11, 449, 46);
		STUDIO.add(lblNewLabel);*/
		//dsjnfskjd
		
		JPanel SKLEP = new JPanel();
		layeredPane.add(SKLEP, "name_68648280148399");
		SKLEP.setBackground(Color.DARK_GRAY);
		SKLEP.setOpaque(true);
		SKLEP.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SKLEP");
		lblNewLabel_1.setBounds(450, 245, 171, 117);
		SKLEP.add(lblNewLabel_1);
		
		JPanel STUDIO = new JPanel();
		layeredPane.add(STUDIO, "name_68613709652399");
		STUDIO.setBackground(Color.DARK_GRAY);
		STUDIO.setOpaque(true);
		STUDIO.setLayout(null);
		
		tytu = new JTextField();
		tytu.setBounds(52, 187, 152, 20);
		STUDIO.add(tytu);
		tytu.setColumns(10);
		
		wyko = new JTextField();
		wyko.setBounds(52, 263, 152, 20);
		STUDIO.add(wyko);
		wyko.setColumns(10);
		
		albu = new JTextField();
		albu.setBounds(52, 338, 152, 20);
		STUDIO.add(albu);
		albu.setColumns(10);
		
		data_publi = new JTextField();
		data_publi.setBounds(52, 405, 152, 20);
		STUDIO.add(data_publi);
		data_publi.setColumns(10);
		
		JLabel lblTytu = new JLabel("Tytu\u0142");
		lblTytu.setForeground(Color.WHITE);
		lblTytu.setBounds(52, 168, 65, 23);
		STUDIO.add(lblTytu);
		
		JLabel lblWykonawca = new JLabel("Wykonawca");
		lblWykonawca.setForeground(Color.WHITE);
		lblWykonawca.setBounds(52, 237, 112, 34);
		STUDIO.add(lblWykonawca);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setForeground(Color.WHITE);
		lblAlbum.setBounds(52, 324, 46, 14);
		STUDIO.add(lblAlbum);
		
		JLabel lblDatapublikacji = new JLabel("Data_publikacji");
		lblDatapublikacji.setForeground(Color.WHITE);
		lblDatapublikacji.setBounds(52, 391, 98, 14);
		STUDIO.add(lblDatapublikacji);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					if(tytu.getText().isEmpty()||wyko.getText().isEmpty()||albu.getText().isEmpty()||data_publi.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nie podales wszystkich informacji");
					}
					else {
					String sql="INSERT INTO utwory (Tytul, Wykonawca, Album, Data_publikacji) "
							+ "VALUES('"+tytu.getText()+"','"+wyko.getText()+"','"+albu.getText()+"','"+data_publi.getText()+"')";
					int rs=stmt.executeUpdate(sql);
					if(rs==1)
						JOptionPane.showMessageDialog(null, "Utwor zostal dodany");
					else 
						JOptionPane.showMessageDialog(null, "Bledny login lub haslo");
					}
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			}
		});
		btnDodaj.setBounds(52, 483, 89, 23);
		STUDIO.add(btnDodaj);
		
		JPanel BIBLIOTEKA = new JPanel();
		layeredPane.add(BIBLIOTEKA, "name_68702683888800");
		BIBLIOTEKA.setBackground(Color.DARK_GRAY);
		BIBLIOTEKA.setOpaque(true);
		BIBLIOTEKA.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BIBLIOTEKA");
		lblNewLabel_2.setBounds(475, 315, 134, 96);
		BIBLIOTEKA.add(lblNewLabel_2);
		
		JButton btnHome = new JButton("SKLEP");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(SKLEP);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnHome.setIcon(sklep_guziczek);
		btnHome.setBorderPainted(false);
		btnHome.setFocusPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBounds(10, 90, 165, 23);
		frame.getContentPane().add(btnHome);
		
		JButton btnShop = new JButton("STUDIO");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(STUDIO);
				layeredPane.repaint();
				layeredPane.revalidate();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
					String sql2="Select nazwa_studia from login where  Login='"+main.user.getText()+"'";
					ResultSet rs2=stmt.executeQuery(sql2);
					rs2.next();
					String nazwa_studia = rs2.getString("nazwa_studia");
					
					JLabel lblNewLabel = new JLabel(nazwa_studia);
					lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(333, 11, 449, 46);
					lblNewLabel.setForeground(Color.white);
					STUDIO.add(lblNewLabel);
					
					if(rs2.next()) {
						
						
						
					}
					
					
					
							con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, "Prosze wybrac inny login");}
			}
		
		});
		btnShop.setIcon(studio_guziczek);
		btnShop.setBorderPainted(false);
		btnShop.setFocusPainted(false);
		btnShop.setContentAreaFilled(false);
		btnShop.setBounds(10, 124, 165, 25);
		frame.getContentPane().add(btnShop);
		
		JButton btnYourLibrary = new JButton("BIBLIOTEKA");
		btnYourLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(BIBLIOTEKA);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnYourLibrary.setIcon(lib_guziczek);
		btnYourLibrary.setBorderPainted(false);
		btnYourLibrary.setFocusPainted(false);
		btnYourLibrary.setContentAreaFilled(false);
		btnYourLibrary.setBounds(10, 158, 165, 23);
		frame.getContentPane().add(btnYourLibrary);
		
		JLabel tlolabel = new JLabel("");
		tlolabel.setBounds(0, 0, 1280, 720);
		tlolabel.setIcon(tlo);
		frame.getContentPane().add(tlolabel);
		
		
		
	}
	}


