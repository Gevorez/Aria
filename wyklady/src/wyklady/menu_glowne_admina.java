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
import java.util.ResourceBundle;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class menu_glowne_admina {

	JFrame frame;
	private JTextField tytu;
	private JTextField wyko;
	private JTextField albu;
	private JTextField data_publi;
	private JTextField usun;
	private JTextField zmiana;
	private JTextField textField;
	private JTextField textField_1;
	static ResourceBundle res;

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
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("EN");
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
		ImageIcon usun_guziczek = new ImageIcon("usun_guziczek.png");
		ImageIcon dodaj_guziczek = new ImageIcon("dodaj_guziczek.png");
		ImageIcon zmien_guziczek = new ImageIcon("zmien_guziczek.png");
		
		frame = new JFrame();
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 200, 50);
		frame.getContentPane().add(popupMenu);
		
		JButton btnNewButton = new JButton(res.getString("LogOut"));
		btnNewButton.addMouseListener(new MouseAdapter() {
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
		popupMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(res.getString("ChangePassword"));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.setVisible(true);

				
				
				przypomnienie_hasla window;
				window = new przypomnienie_hasla();
				window.frame.setVisible(true);
				
				
			}
		});
		popupMenu.add(btnNewButton_1);
		
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger())
				{
					popupMenu.show(e.getComponent(),e.getX(),e.getY());
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
		
		JPanel STUDIO = new JPanel();
		layeredPane.add(STUDIO, "name_68613709652399");
		STUDIO.setBackground(Color.BLACK);
		STUDIO.setOpaque(true);
		STUDIO.setLayout(null);
		
		tytu = new JTextField();
		tytu.setBounds(174, 201, 152, 20);
		STUDIO.add(tytu);
		tytu.setColumns(10);
		tytu.setForeground(Color.WHITE);
		tytu.setBackground(Color.BLACK);
		tytu.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		tytu.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		
		wyko = new JTextField();
		wyko.setBounds(174, 241, 152, 20);
		STUDIO.add(wyko);
		wyko.setColumns(10);
		wyko.setForeground(Color.WHITE);
		wyko.setBackground(Color.BLACK);
		wyko.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		wyko.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		
		albu = new JTextField();
		albu.setBounds(174, 276, 152, 20);
		STUDIO.add(albu);
		albu.setColumns(10);
		albu.setForeground(Color.WHITE);
		albu.setBackground(Color.BLACK);
		albu.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		albu.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		
		data_publi = new JTextField();
		data_publi.setBounds(174, 316, 152, 20);
		STUDIO.add(data_publi);
		data_publi.setColumns(10);
		data_publi.setForeground(Color.WHITE);
		data_publi.setBackground(Color.BLACK);
		data_publi.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		data_publi.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		
		JLabel lblTytu = new JLabel(res.getString("title"));
		lblTytu.setForeground(Color.WHITE);
		lblTytu.setBounds(52, 203, 65, 23);
		STUDIO.add(lblTytu);
		
		JLabel lblWykonawca = new JLabel(res.getString("Performer"));
		lblWykonawca.setForeground(Color.WHITE);
		lblWykonawca.setBounds(52, 237, 112, 34);
		STUDIO.add(lblWykonawca);
		
		JLabel lblAlbum = new JLabel("ALBUM");
		lblAlbum.setForeground(Color.WHITE);
		lblAlbum.setBounds(52, 282, 46, 14);
		STUDIO.add(lblAlbum);
		
		JLabel lblDatapublikacji = new JLabel(res.getString("Data"));
		lblDatapublikacji.setForeground(Color.WHITE);
		lblDatapublikacji.setBounds(52, 322, 112, 14);
		STUDIO.add(lblDatapublikacji);
		
		JButton btnDodaj = new JButton(res.getString("Add"));
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
						JOptionPane.showMessageDialog(null, res.getString("Added"));
					else 
						JOptionPane.showMessageDialog(null, res.getString("Zle"));
					}
					con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, res.getString("Exists"));}
				wyko.setText(null);
				tytu.setText(null);
				albu.setText(null);
				data_publi.setText(null);
			}
			
		});
		btnDodaj.setBounds(237, 370, 300, 21);
		btnDodaj.setIcon(dodaj_guziczek);
		btnDodaj.setBorderPainted(false);
		btnDodaj.setFocusPainted(false);
		btnDodaj.setContentAreaFilled(false);
		STUDIO.add(btnDodaj);
		
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
						JOptionPane.showMessageDialog(null, res.getString("NameChanged"));
						textArea2.setText(null);
						
						
					
					}
					else 
						JOptionPane.showMessageDialog(null, res.getString("wrong"));
					
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
		label.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		BIBLIOTEKA.add(label);
		
		JLabel label_1 = new JLabel("Wykonawca");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(359, 17, 112, 34);
		label_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		BIBLIOTEKA.add(label_1);
		
		JLabel label_2 = new JLabel("Album");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(207, 27, 46, 14);
		label_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		BIBLIOTEKA.add(label_2);
		
		JLabel lblDataPublikacji = new JLabel("Data publikacji");
		lblDataPublikacji.setForeground(Color.WHITE);
		lblDataPublikacji.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		lblDataPublikacji.setBounds(692, 27, 98, 14);
		BIBLIOTEKA.add(lblDataPublikacji);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setBounds(196, 51, 721, 325);
		BIBLIOTEKA.add(textArea);
		usun = new JTextField();
		
		
	
		usun.setBounds(20, 591, 221, 19);
		usun.setForeground(Color.WHITE);
		usun.setBackground(Color.BLACK);
		usun.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.DARK_GRAY, null));
		usun.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
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
						JOptionPane.showMessageDialog(null, res.getString("Zle"));
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
		
		JLabel lblPodajTytulUsuwanego = new JLabel(res.getString("Podaj"));
		lblPodajTytulUsuwanego.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPodajTytulUsuwanego.setForeground(Color.WHITE);
		lblPodajTytulUsuwanego.setBounds(20, 561, 257, 23);
		BIBLIOTEKA.add(lblPodajTytulUsuwanego);

		
		textArea2.setBackground(Color.BLACK);
		textArea2.setForeground(Color.WHITE);
		textArea2.setBounds(471, 27, 449, 46);
		textArea2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		STUDIO.add(textArea2);
		
		JLabel lblWitajWStudiu = new JLabel(res.getString("Welcome"));
		lblWitajWStudiu.setForeground(Color.WHITE);
		lblWitajWStudiu.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		lblWitajWStudiu.setBounds(525, 11, 98, 14);
		STUDIO.add(lblWitajWStudiu);
		
		JLabel lblDodajUtwrDo = new JLabel(res.getString("DodajUtwor"));
		lblDodajUtwrDo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblDodajUtwrDo.setForeground(Color.WHITE);
		lblDodajUtwrDo.setBounds(52, 158, 294, 14);
		STUDIO.add(lblDodajUtwrDo);
		
		JLabel lblZmienNazweSwojego = new JLabel(res.getString("ZmienNazwe"));
		lblZmienNazweSwojego.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblZmienNazweSwojego.setForeground(Color.WHITE);
		lblZmienNazweSwojego.setBounds(52, 448, 328, 14);
		STUDIO.add(lblZmienNazweSwojego);
		
		JPanel UPRAWNIENIA = new JPanel();
		UPRAWNIENIA.setBackground(Color.BLACK);
		layeredPane.add(UPRAWNIENIA, "name_483368143025700");
		UPRAWNIENIA.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		textArea_1.setBackground(Color.BLACK);
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setBounds(83, 110, 946, 263);
		UPRAWNIENIA.add(textArea_1);
		
		JLabel lblListaAktualnychUytkownik = new JLabel("LISTA AKTUALNYCH U\u017BYTKOWNIK\u00D3W");
		lblListaAktualnychUytkownik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblListaAktualnychUytkownik.setForeground(Color.WHITE);
		lblListaAktualnychUytkownik.setBounds(438, 51, 347, 14);
		UPRAWNIENIA.add(lblListaAktualnychUytkownik);
		
		textField = new JTextField();
		textField.setBounds(810, 529, 86, 20);
		UPRAWNIENIA.add(textField);
		textField.setColumns(10);
		
		JLabel lblDajAdminaDla = new JLabel("DAJ ADMINA DLA (WPISZ LOGIN)");
		lblDajAdminaDla.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblDajAdminaDla.setForeground(Color.WHITE);
		lblDajAdminaDla.setBounds(624, 531, 176, 14);
		UPRAWNIENIA.add(lblDajAdminaDla);
		
	
		
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
					
					
					
					/*JLabel lblNewLabel = new JLabel(nazwa_studia);
					lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(333, 11, 449, 46);
					lblNewLabel.setForeground(Color.white);
					STUDIO.add(lblNewLabel);*/
					
					if(rs2.next()) {
						
						
						
					}
					
					
					
							con.close();
				} catch(Exception e1){JOptionPane.showMessageDialog(null, "cos sie popsulo");}
			}
		
		});
		btnShop.setIcon(studio_guziczek);
		btnShop.setBorderPainted(false);
		btnShop.setFocusPainted(false);
		btnShop.setContentAreaFilled(false);
		btnShop.setBounds(10, 93, 165, 25);
		frame.getContentPane().add(btnShop);
		
		JButton btnYourLibrary = new JButton(res.getString("library"));
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
						
							while(rs2.next() &&  i<999) {
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
		btnYourLibrary.setBounds(10, 129, 165, 23);
		frame.getContentPane().add(btnYourLibrary);
		
		JButton btnUprawnienia = new JButton(res.getString("permissions"));
		btnUprawnienia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(UPRAWNIENIA);
				layeredPane.repaint();
				layeredPane.revalidate();
				textArea_1.setText(null);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
					String sql2="Select Imie,Nazwisko,Login,Admin from login";
					ResultSet rs2=stmt.executeQuery(sql2);
					int i=0;
						
							while(rs2.next() &&  i<999) {
					         //Retrieve by column name
					         String Imie  = rs2.getString("Imie");
					         String Nazwisko = rs2.getString("Nazwisko");
					         String Login = rs2.getString("Login");
					         String Admin = rs2.getString("Admin");
					      
					         
					        
					         i++;
					         
					         //Display values
					        textArea_1.append(i +" "+Imie+"\t\t "   +Nazwisko+ "\t\t"+Login+" \t\t  "+Admin+"\n"); 
					        
					        
							}
							
							
					
				
							con.close();
				} catch(Exception e1){System.out.print(e1);}
			}
		});
		JButton btnZatwierd = new JButton("POTWIERDZ");
		btnZatwierd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
		
					
					String sql="Update login "
							+ "set Admin='1'"
									+ "where Login='"+textField.getText()+"'";
					int rs = stmt.executeUpdate(sql);
					String sql2="Select Imie,Nazwisko,Login,Admin from login";
					ResultSet rs2=stmt.executeQuery(sql2);
					
					
							
					if(rs==1) {
						
						JOptionPane.showMessageDialog(null, "Poprawnie nadales uprawnienia");
						
					
	
					}
					
					else 
						JOptionPane.showMessageDialog(null, "Zly login");
					
				
			        
					
					

							con.close();
				} catch(Exception e1){System.out.print(e1);}
				
			}
		});
		btnZatwierd.setBounds(796, 561, 119, 23);
		UPRAWNIENIA.add(btnZatwierd);
		
		JLabel lblZabierzAdminawpisz = new JLabel("ZABIERZ ADMINA (WPISZ LOGIN)");
		lblZabierzAdminawpisz.setForeground(Color.WHITE);
		lblZabierzAdminawpisz.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblZabierzAdminawpisz.setBounds(30, 531, 176, 14);
		UPRAWNIENIA.add(lblZabierzAdminawpisz);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(240, 529, 86, 20);
		UPRAWNIENIA.add(textField_1);
		
		JButton button = new JButton("POTWIERDZ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wypozyczalnia","root","");
					Statement stmt=con.createStatement();
				
					
					
					String sql2="Select Admin_head,Admin from login where Admin_head=1 ";
					ResultSet rs2=stmt.executeQuery(sql2);
					rs2.next();
					 String head  = rs2.getString("Admin_head");
					System.out.print(head);
					
					int result = Integer.parseInt(head);	
					 String sql="Update login "
								+ "set Admin='0'"
										+ "where Login='"+textField_1.getText()+"' and Admin_head=0";
						int rs = stmt.executeUpdate(sql);
					
						
					
					if(rs==1) {
						
						JOptionPane.showMessageDialog(null, res.getString("Poprawniezabralesuprawnienia"));
	
					}
					
					else 
						JOptionPane.showMessageDialog(null, res.getString("null"));
					
					 
			       
					

							con.close();
				} catch(Exception e1){System.out.print(e1);}
			}
		});
		button.setBounds(226, 561, 119, 23);
		UPRAWNIENIA.add(button);
		
		btnUprawnienia.setIcon(lib_guziczek);
		btnUprawnienia.setBorderPainted(false);
		btnUprawnienia.setFocusPainted(false);
		btnUprawnienia.setContentAreaFilled(false);
		btnUprawnienia.setBounds(10, 621, 165, 23);
		frame.getContentPane().add(btnUprawnienia);
		
		JLabel tlolabel = new JLabel("");
		tlolabel.setBounds(0, 0, 1280, 720);
		tlolabel.setIcon(tlo);
		frame.getContentPane().add(tlolabel);
		
		
		
	}
	}


