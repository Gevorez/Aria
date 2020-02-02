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
import javax.swing.border.BevelBorder;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import wyklady.main;


public class menu_glowne {

	JFrame frame;
	private JTextField usun;
	private JTextField zmiana;

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
		//dqwdqwdwqdqwd
		//WEFWEFWEFWE
		//thbeawfubewhfuhbewhbffewhbju
		
		Image ikona1 = ImageIO.read(new File("logo.png"));
		ImageIcon tlo = new ImageIcon("tlo.png");
		ImageIcon logo2 = new ImageIcon("logo2.png");
		ImageIcon studio_guziczek = new ImageIcon("studio_guziczek.png");
		ImageIcon lib_guziczek = new ImageIcon("lib_guziczek.png"); 
		ImageIcon sklep_guziczek = new ImageIcon("sklep_guziczek.png");
		ImageIcon zmien_guziczek = new ImageIcon("zmien_guziczek.png");
		ImageIcon usun_guziczek = new ImageIcon("usun_guziczek.png");
		ImageIcon nirvana = new ImageIcon("nirvana_guzik.png");
		ImageIcon metallica = new ImageIcon("metallica_guzik.png");
		ImageIcon daftpunk = new ImageIcon("daftpunk_guzik.png");
		ImageIcon beatles = new ImageIcon("beatles_guzik.png");
		ImageIcon greenday = new ImageIcon("green_day_guzik.png");
		ImageIcon plusik = new ImageIcon("plusik.png");
		
		
		frame = new JFrame();
		
		//POPUPMENU
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 200, 50);
		frame.getContentPane().add(popupMenu);
		
		JButton btnWyloguj = new JButton("WYLOGUJ");
		btnWyloguj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				frame.setVisible(false);
				
				try {
					main window;
					window = new main();
					window.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
		
			}
			
		});
		popupMenu.add(btnWyloguj);
		
		//POPUPMENU
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
				{
					popupMenu.show(arg0.getComponent(),arg0.getX(),arg0.getY());
				}
			}
		});
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
		SKLEP.setBackground(Color.BLACK);
		SKLEP.setOpaque(true);
		SKLEP.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(961, 46, 92, 22);
		SKLEP.add(textArea_1);
		
		JLabel lblStanKonta = new JLabel("STAN KONTA");
		lblStanKonta.setForeground(Color.WHITE);
		lblStanKonta.setBounds(961, 21, 92, 14);
		SKLEP.add(lblStanKonta);
		
		JButton saldo = new JButton("+");
		saldo.setIcon(plusik);
		saldo.setBorderPainted(false);
		saldo.setFocusPainted(false);
		saldo.setContentAreaFilled(false);
		saldo.setBounds(859, 45, 89, 23);
		SKLEP.add(saldo);
		
		JButton album1 = new JButton("New button");
		album1.setIcon(nirvana);
		album1.setBorderPainted(false);
		album1.setFocusPainted(false);
		album1.setContentAreaFilled(false);
		album1.setBounds(74, 161, 160, 130);
		SKLEP.add(album1);
		
		JButton album2 = new JButton("New button");
		album2.setIcon(metallica);
		album2.setBorderPainted(false);
		album2.setFocusPainted(false);
		album2.setContentAreaFilled(false);
		album2.setBounds(430, 161, 160, 130);
		SKLEP.add(album2);
		
		JButton album3 = new JButton("New button");
		album3.setIcon(daftpunk);
		album3.setBorderPainted(false);
		album3.setFocusPainted(false);
		album3.setContentAreaFilled(false);
		album3.setBounds(788, 161, 160, 130);
		SKLEP.add(album3);
		
		JButton album4 = new JButton("New button");
		album4.setIcon(beatles);
		album4.setBorderPainted(false);
		album4.setFocusPainted(false);
		album4.setContentAreaFilled(false);
		album4.setBounds(74, 371, 160, 130);
		SKLEP.add(album4);
		
		JButton album5 = new JButton("New button");
		album5.setIcon(greenday);
		album5.setBorderPainted(false);
		album5.setFocusPainted(false);
		album5.setContentAreaFilled(false);
		album5.setBounds(430, 371, 160, 130);
		SKLEP.add(album5);
		
		JButton album6 = new JButton("New button");
		album6.setBounds(788, 371, 160, 130);
		SKLEP.add(album6);
		
		JLabel lblShop = new JLabel("SHOP");
		lblShop.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 33));
		lblShop.setForeground(Color.WHITE);
		lblShop.setBounds(55, 46, 134, 71);
		SKLEP.add(lblShop);
		
		JLabel lblNirvana = new JLabel("Nirvana");
		lblNirvana.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNirvana.setForeground(Color.WHITE);
		lblNirvana.setBounds(84, 302, 120, 14);
		SKLEP.add(lblNirvana);
		
		JLabel lblMetallica = new JLabel("Metallica");
		lblMetallica.setForeground(Color.WHITE);
		lblMetallica.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblMetallica.setBounds(440, 303, 120, 14);
		SKLEP.add(lblMetallica);
		
		JLabel lblDaftPunk = new JLabel("Daft Punk");
		lblDaftPunk.setForeground(Color.WHITE);
		lblDaftPunk.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblDaftPunk.setBounds(798, 302, 120, 14);
		SKLEP.add(lblDaftPunk);
		
		JLabel lblBeatles = new JLabel("The Beatles");
		lblBeatles.setForeground(Color.WHITE);
		lblBeatles.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblBeatles.setBounds(84, 512, 120, 14);
		SKLEP.add(lblBeatles);
		
		JLabel lblGreenDay = new JLabel("Green Day");
		lblGreenDay.setForeground(Color.WHITE);
		lblGreenDay.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblGreenDay.setBounds(440, 512, 120, 14);
		SKLEP.add(lblGreenDay);
		
		JLabel lblinne = new JLabel("Inne");
		lblinne.setForeground(Color.WHITE);
		lblinne.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblinne.setBounds(798, 513, 120, 14);
		SKLEP.add(lblinne);
		
		JLabel lblDwdw = new JLabel("NEVERMIND");
		lblDwdw.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblDwdw.setForeground(Color.WHITE);
		lblDwdw.setBounds(94, 319, 95, 14);
		SKLEP.add(lblDwdw);
		
		JLabel lblMasterOfPuppets = new JLabel("MASTER OF PUPPETS");
		lblMasterOfPuppets.setForeground(Color.WHITE);
		lblMasterOfPuppets.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblMasterOfPuppets.setBounds(450, 320, 126, 14);
		SKLEP.add(lblMasterOfPuppets);
		
		JLabel lblRandomAccessMemories = new JLabel("RANDOM ACCESS MEMORIES");
		lblRandomAccessMemories.setForeground(Color.WHITE);
		lblRandomAccessMemories.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblRandomAccessMemories.setBounds(808, 320, 177, 14);
		SKLEP.add(lblRandomAccessMemories);
		
		JLabel lblAbbeyRoad = new JLabel("ABBEY ROAD");
		lblAbbeyRoad.setForeground(Color.WHITE);
		lblAbbeyRoad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblAbbeyRoad.setBounds(94, 531, 177, 14);
		SKLEP.add(lblAbbeyRoad);
		
		JLabel lblAmericanIdiot = new JLabel("AMERICAN IDIOT");
		lblAmericanIdiot.setForeground(Color.WHITE);
		lblAmericanIdiot.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblAmericanIdiot.setBounds(450, 532, 177, 14);
		SKLEP.add(lblAmericanIdiot);
		
		JPanel STUDIO = new JPanel();
		layeredPane.add(STUDIO, "name_68613709652399");
		STUDIO.setBackground(Color.BLACK);
		STUDIO.setOpaque(true);
		STUDIO.setLayout(null);
		
		zmiana = new JTextField();
		zmiana.setBounds(52, 473, 96, 19);
		STUDIO.add(zmiana);
		zmiana.setColumns(10);
		zmiana.setForeground(Color.WHITE);
		zmiana.setBackground(Color.BLACK);
		zmiana.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		zmiana.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		
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
		btnGuziczek.setBounds(237, 501, 300, 21);
		btnGuziczek.setIcon(zmien_guziczek);
		btnGuziczek.setBorderPainted(false);
		btnGuziczek.setFocusPainted(false);
		btnGuziczek.setContentAreaFilled(false);
		STUDIO.add(btnGuziczek);
		
		JPanel BIBLIOTEKA = new JPanel();
		layeredPane.add(BIBLIOTEKA, "name_68702683888800");
		BIBLIOTEKA.setBackground(Color.BLACK);
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
		
		JLabel label_3 = new JLabel("Data publikacji");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(692, 27, 98, 14);
		BIBLIOTEKA.add(label_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setBounds(196, 51, 721, 325);
		BIBLIOTEKA.add(textArea);
		
		usun = new JTextField();
		usun.setForeground(Color.WHITE);
		usun.setBackground(Color.BLACK);
		usun.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		
		
	
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
					String sql2="Select tytul,wykonawca,album,data_publikacji from zakupione_"+main.user.getText()+"";
					ResultSet rs2=stmt.executeQuery(sql2);
					int i=0;
						
							while(rs2.next() &&  i<10) {
					         //Retrieve by column name
					         String tyt  = rs2.getString("tytul");
					         String wyko = rs2.getString("wykonawca");
					         String Album = rs2.getString("album");
					         String Data_pb = rs2.getString("data publikacji");
					         
					        
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
		btnUsun.setBounds(265, 590, 300, 21);
		btnUsun.setIcon(usun_guziczek);
		btnUsun.setBorderPainted(false);
		btnUsun.setFocusPainted(false);
		btnUsun.setContentAreaFilled(false);
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

		
		textArea2.setBackground(Color.BLACK);
		textArea2.setForeground(Color.WHITE);
		textArea2.setBounds(471, 27, 449, 46);
		textArea2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		STUDIO.add(textArea2);
		
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
					
					textArea2.setText(nazwa_studia);
					
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

					String sql="Select nazwa_studia from login where  Login='"+main.user.getText()+"'";
					ResultSet rs3=stmt.executeQuery(sql);
					rs3.next();
					String nazwa_studia = rs3.getString("nazwa_studia");
					
					String sql2="Select tytul,wykonawca,album,data_publikacji from zakupione_"+main.user.getText()+"";
					ResultSet rs2=stmt.executeQuery(sql2);
					int i=0;
						
							while(rs2.next() &&  i<10) {
					         //Retrieve by column name
					         String tyt  = rs2.getString("tytul");
					         String wyko = rs2.getString("wykonawca");
					         String Album = rs2.getString("album");
					         String Data_pb = rs2.getString("data_publikacji");
					         
					        
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
		
		JLabel lblZmienNazweSwojego = new JLabel("ZMIEN NAZWE SWOJEGO STUDIA");
		lblZmienNazweSwojego.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblZmienNazweSwojego.setForeground(Color.WHITE);
		lblZmienNazweSwojego.setBounds(52, 448, 328, 14);
		STUDIO.add(lblZmienNazweSwojego);
		
		JLabel tlolabel = new JLabel("");
		tlolabel.setBounds(0, 0, 1280, 720);
		tlolabel.setIcon(tlo);
		frame.getContentPane().add(tlolabel);
		
		
	}
	}


