package wyklady;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;



public class menu_glowne {

	JFrame frame;

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
		
		Image ikona1 = ImageIO.read(new File("logo.png"));
		ImageIcon tlo = new ImageIcon("tlo.png");
		ImageIcon logo2 = new ImageIcon("logo2.png");
		
		
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
		
		JButton btnNewest = new JButton("newest");
		btnNewest.setBounds(61, 440, 89, 23);
		frame.getContentPane().add(btnNewest);
		
		JButton btnBrowse = new JButton("browse");
		btnBrowse.setBounds(46, 477, 89, 23);
		frame.getContentPane().add(btnBrowse);
		
		JButton btnAlbums = new JButton("albums");
		btnAlbums.setBounds(61, 282, 89, 23);
		frame.getContentPane().add(btnAlbums);
		
		JButton btnArtists = new JButton("artists");
		btnArtists.setBounds(61, 316, 89, 23);
		frame.getContentPane().add(btnArtists);
		
		JButton btnPlaylists = new JButton("playlists");
		btnPlaylists.setBounds(61, 350, 89, 23);
		frame.getContentPane().add(btnPlaylists);
		
		JButton btnPlay = new JButton("play");
		btnPlay.setBounds(654, 647, 89, 23);
		frame.getContentPane().add(btnPlay);
		
		JButton btnBackward = new JButton("backward");
		btnBackward.setBounds(544, 647, 89, 23);
		frame.getContentPane().add(btnBackward);
		
		JButton btnForward = new JButton("forward");
		btnForward.setBounds(765, 647, 89, 23);
		frame.getContentPane().add(btnForward);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(185, 0, 1095, 634);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel STUDIO = new JPanel();
		layeredPane.add(STUDIO, "name_68613709652399");
		STUDIO.setBackground(Color.DARK_GRAY);
		STUDIO.setOpaque(true);
		STUDIO.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(333, 11, 449, 46);
		STUDIO.add(lblNewLabel);
		
		JPanel SKLEP = new JPanel();
		layeredPane.add(SKLEP, "name_68648280148399");
		SKLEP.setBackground(Color.DARK_GRAY);
		SKLEP.setOpaque(true);
		SKLEP.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SKLEP");
		lblNewLabel_1.setBounds(450, 245, 171, 117);
		SKLEP.add(lblNewLabel_1);
		
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
		btnHome.setBounds(10, 124, 165, 23);
		frame.getContentPane().add(btnHome);
		
		JButton btnShop = new JButton("STUDIO");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(STUDIO);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnShop.setBounds(10, 90, 165, 23);
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
		btnYourLibrary.setBounds(10, 158, 165, 23);
		frame.getContentPane().add(btnYourLibrary);
		
		JLabel tlolabel = new JLabel("");
		tlolabel.setBounds(0, 0, 1280, 720);
		tlolabel.setIcon(tlo);
		frame.getContentPane().add(tlolabel);
		
		
	}
	}


