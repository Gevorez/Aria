package wyklady;

import java.awt.EventQueue;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;



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
	 * Create the application.
	 */
	
	public menu_glowne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIkona = new JLabel("ikona");
		lblIkona.setBounds(46, 30, 46, 14);
		frame.getContentPane().add(lblIkona);
		
		JButton btnShop = new JButton("shop");
		btnShop.setBounds(10, 90, 89, 23);
		frame.getContentPane().add(btnShop);
		
		JButton btnHome = new JButton("home");
		btnHome.setBounds(61, 124, 89, 23);
		frame.getContentPane().add(btnHome);
		
		JButton btnNewest = new JButton("newest");
		btnNewest.setBounds(61, 158, 89, 23);
		frame.getContentPane().add(btnNewest);
		
		JButton btnBrowse = new JButton("browse");
		btnBrowse.setBounds(61, 192, 89, 23);
		frame.getContentPane().add(btnBrowse);
		
		JButton btnYourLibrary = new JButton("your library");
		btnYourLibrary.setBounds(10, 248, 89, 23);
		frame.getContentPane().add(btnYourLibrary);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(160, 0, 1094, 606);
		frame.getContentPane().add(panel);
		
		
	}
	}


