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
import javax.swing.JTextArea;



public class menu_glowne_admina {

	JFrame frame;
	private JTextField tytu;
	private JTextField wyko;
	private JTextField albu;
	private JTextField data_publi;
	private JTextField usun;
	private JTextField zmiana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_glowne_admina window = new menu_glowne_admina();
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
	
	public menu_glowne_admina() throws IOException {
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
				wyko.setText(null);
				tytu.setText(null);
				albu.setText(null);
				data_publi.setText(null);
			}
			
		});
		btnDodaj.setBounds(52, 483, 89, 23);
		STUDIO.add(btnDodaj);
		
		zmiana = new JTextField();
		zmiana.setBounds(647, 263, 96, 19);
		STUDIO.add(zmiana);
		zmiana.setColumns(10);
		JTextArea textArea2 = new JTextArea();
		
		JButton btnGuziczek = new JButton("guziczek");
		btnGuziczek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					
				
						
						String sql="Update login "
								+ "set nazwa_studia='"+zmiana.getText()+"'"
										+ "where Login='"+main.user.getText()+"'";
						
						
						
					int rs=stmt.executeUpdate(sql);
				
					if(rs==1) {
						JOptionPane.showMessageDialog(null, "nazwa zmieniona");
						textArea2.setText(null);
						
						
					
					}
					else 
						JOptionPane.showMessageDialog(null, "Bledny login lub haslo");
					
					textArea2.setText(zmiana.getText());
					
					
					
					
					con.close();
				} catch(Exception e1){System.out.println(e1);}
			
				
				/*String sql="Update login "
								+ "set nazwa_studia='"+nazwa_std.getText()+"'"
										+ "where Login='"+main.user.getText()+"'";*/
			}
		});
		btnGuziczek.setBounds(835, 262, 85, 21);
		STUDIO.add(btnGuziczek);
		
		JPanel BIBLIOTEKA = new JPanel();
		layeredPane.add(BIBLIOTEKA, "name_68702683888800");
		BIBLIOTEKA.setBackground(Color.DARK_GRAY);
		BIBLIOTEKA.setOpaque(true);
		BIBLIOTEKA.setLayout(null);
		
		JLabel label = new JLabel("Tytu\u0142");
		label.setForeground(Color.WHITE);
		label.setBounds(522, 23, 65, 23);
		BIBLIOTEKA.add(label);
		
		JLabel label_1 = new JLabel("Wykonawca");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(359, 17, 112, 34);
		BIBLIOTEKA.add(label_1);
		
		JLabel label_2 = new JLabel("Album");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(207, 27, 46, 14);
		BIBLIOTEKA.add(label_2);
		
		JLabel label_3 = new JLabel("Data_publikacji");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(692, 27, 98, 14);
		BIBLIOTEKA.add(label_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.WHITE);
		textArea.setBounds(196, 51, 721, 325);
		BIBLIOTEKA.add(textArea);
		usun = new JTextField();
		
		
	
		usun.setBounds(20, 591, 221, 19);
		BIBLIOTEKA.add(usun);
		usun.setColumns(10);
		
		JButton btnUsun = new JButton("Usun");
		btnUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
					String sql="DELETE FROM utwory WHERE Tytul ="
							+ " ('"+usun.getText()+"')";
							//ss
					int rs=stmt.executeUpdate(sql);
					if(rs==1) {
						JOptionPane.showMessageDialog(null, "utwor zostal usuniety");
					textArea.setText(null);
					String sql2="Select Tytul,Wykonawca,Album,Data_publikacji,id from utwory";
					ResultSet rs2=stmt.executeQuery(sql2);
					int i=0;
						
							while(rs2.next() &&  i<10) {
					         //Retrieve by column name
					         String tyt  = rs2.getString("Tytul");
					       
					         String wyko = rs2.getString("Wykonawca");
					         String Album = rs2.getString("Album");
					         String Data_pb = rs2.getString("Data_publikacji");
					         
					        
					         i++;
					         
					         //Display values
					        textArea.append(i +" "+Album+"\t\t "   +wyko+ "\t\t"+tyt+" \t\t  "+Data_pb+"\n"); 
					        
					        
							}
					
					
					}

					else 
						JOptionPane.showMessageDialog(null, "Bledne dane");
					con.close();
				} catch(Exception e1)
				{
					System.out.println(e1);
					}
			}
				});
		btnUsun.setBounds(265, 590, 85, 21);
		BIBLIOTEKA.add(btnUsun);
		
		JLabel lblPodajTytulUsuwanego = new JLabel("Podaj tytul usuwanego utworu");
		lblPodajTytulUsuwanego.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPodajTytulUsuwanego.setForeground(Color.WHITE);
		lblPodajTytulUsuwanego.setBounds(20, 561, 257, 23);
		BIBLIOTEKA.add(lblPodajTytulUsuwanego);
		
		
		
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

		
		textArea2.setBackground(Color.DARK_GRAY);
		textArea2.setForeground(Color.WHITE);
		textArea2.setBounds(333, 11, 449, 46);
		textArea2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		STUDIO.add(textArea2);
		
		JButton btnShop = new JButton("STUDIO");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(STUDIO);
				layeredPane.repaint();
				layeredPane.revalidate();
				wyko.setText(null);
				tytu.setText(null);
				albu.setText(null);
				data_publi.setText(null);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
					String sql2="Select nazwa_studia from login where  Login='"+main.user.getText()+"'";
					ResultSet rs2=stmt.executeQuery(sql2);
					rs2.next();
					
					String nazwa_studia = rs2.getString("nazwa_studia");
					
					textArea2.setText("To jest Admin");
					
					/*JLabel lblNewLabel = new JLabel(nazwa_studia);
					lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(333, 11, 449, 46);
					lblNewLabel.setForeground(Color.white);
					STUDIO.add(lblNewLabel);*/
					
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
				textArea.setText(null);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
					String sql2="Select Tytul,Wykonawca,Album,Data_publikacji from utwory";
					ResultSet rs2=stmt.executeQuery(sql2);
					int i=0;
						
							while(rs2.next() &&  i<10) {
					         //Retrieve by column name
					         String tyt  = rs2.getString("Tytul");
					         String wyko = rs2.getString("Wykonawca");
					         String Album = rs2.getString("Album");
					         String Data_pb = rs2.getString("Data_publikacji");
					         
					        
					         i++;
					         
					         //Display values
					        textArea.append(i +" "+Album+"\t\t "   +wyko+ "\t\t"+tyt+" \t\t  "+Data_pb+"\n"); 
					        
					        
							}
							
							
					
				
							con.close();
				} catch(Exception e1){System.out.print(e1);}
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

