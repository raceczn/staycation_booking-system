package dashboard;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import dashboard.screen_panels.PanelCancelBooking;
import dashboard.screen_panels.PanelDashboard;
import dashboard.screen_panels.PanelGuest;
import dashboard.screen_panels.PanelHome;
import dashboard.screen_panels.PanelRoomBooking;
import dashboard.screen_panels.PanelRooms;
import javax.swing.Icon;

public class FrameDashboard extends JFrame {

	// Declare and initialize ImageIcon
	private ImageIcon homeicon = new ImageIcon(
			new ImageIcon("src/assets/home.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	private ImageIcon dbicon = new ImageIcon(
			new ImageIcon("src/assets/dashboard-icon.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
	private ImageIcon rbicon = new ImageIcon(
			new ImageIcon("src/assets/rbooking.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
	private ImageIcon cancelbicon = new ImageIcon(
			new ImageIcon("src/assets/cancel-icon.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
	private ImageIcon room_icon = new ImageIcon(
			new ImageIcon("src/assets/room_icon.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
	private ImageIcon guests_icon = new ImageIcon(
			new ImageIcon("src/assets/guest_icon.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	private ImageIcon setting_img = new ImageIcon(
			new ImageIcon("src/assets/setting.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
	private ImageIcon logout_img = new ImageIcon(
			new ImageIcon("src/assets/logout.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));


	// Declare screen panels
	private PanelHome panelhome;
	private PanelDashboard paneldashboard;
	private PanelRoomBooking panelroomb;
	private PanelCancelBooking panelcancelb;
	private PanelRooms panelrooms;
	private PanelGuest panelguest;

	// Declare JLabel variables for different sections
	private JLabel home_label, dashboard_label, roombooking_label, cancel_label, room_label, guest_label, logout,
			settings;

	// Declare JPanels for labels
	private JPanel home_pane, dashboard_pane, roombpane, cancelb_pane, rooms_pane, guestpane;

	// Declare JLabel for icons
	private JLabel hm_icon, dashb_icon, cb_icon, rooms_icon, guest_icon, setting_icon, logout_icon;

	int screenWidth = 1000;
	int screenHeight = 650;
	
	public FrameDashboard() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, screenWidth, screenHeight);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 0));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBackground(new Color(255,255,255));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		// Initialize panels
		panelhome = new PanelHome();
		paneldashboard = new PanelDashboard();
		panelroomb = new PanelRoomBooking();
		panelcancelb = new PanelCancelBooking();
		panelrooms = new PanelRooms();
		panelguest = new PanelGuest();

		//setting bounds for Panels
		panelrooms.setBounds(0,0,screenWidth - 253, screenHeight);
		
		// Creating a JPanel for the main content area
		JPanel panelMainContent = new JPanel();
		panelMainContent.setLayout(null);
		panelMainContent.setBounds(253, 0, 747, 650);
		panel.add(panelMainContent);

		// Adding various subpanels to the main content panel
		panelMainContent.add(panelhome);
		panelMainContent.add(paneldashboard);
		panelMainContent.add(panelroomb);
		panelMainContent.add(panelcancelb);
		panelMainContent.add(panelrooms);
		panelMainContent.add(panelguest);

		menuClicked(panelhome);

		// Rounded menu panel board
		RoundedPanel board = new RoundedPanel(30); 
		board.setBounds(0, 0, 254, 650);
		board.setBackground(new Color(9, 38, 53));
		panel.add(board);
		board.setLayout(null);

		// Initialize and configure home, dash board, room booking, cancel booking,
		// rooms and guest panel
		home_pane = new JPanel();
		home_pane.setBounds(0, 129, 253, 42);
		home_pane.setBackground(new Color(9, 38, 53));
		home_pane.setLayout(null);
		home_pane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		board.add(home_pane);
		home_pane.addMouseListener(new PanelButtonMouseAdapter(home_pane) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelhome);
			}
		});

		dashboard_pane = new JPanel();
		dashboard_pane.setLayout(null);
		dashboard_pane.setBackground(new Color(9, 38, 53));
		dashboard_pane.setBounds(0, 174, 253, 42);
		dashboard_pane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		board.add(dashboard_pane);
		dashboard_pane.addMouseListener(new PanelButtonMouseAdapter(dashboard_pane) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneldashboard);
			}
		});

		roombpane = new JPanel();
		roombpane.setBackground(new Color(9, 38, 53));
		roombpane.setBounds(0, 219, 253, 42);
		roombpane.setLayout(null);
		roombpane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		board.add(roombpane);
		roombpane.addMouseListener(new PanelButtonMouseAdapter(roombpane) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelroomb);
			}
		});

		cancelb_pane = new JPanel();
		cancelb_pane.setBackground(new Color(9, 38, 53));
		cancelb_pane.setBounds(0, 264, 253, 42);
		cancelb_pane.setLayout(null);
		cancelb_pane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		board.add(cancelb_pane);
		cancelb_pane.addMouseListener(new PanelButtonMouseAdapter(cancelb_pane) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelcancelb);
			}
		});

		rooms_pane = new JPanel();
		rooms_pane.setBackground(new Color(9, 38, 53));
		rooms_pane.setBounds(0, 309, 253, 42);
		rooms_pane.setLayout(null);
		rooms_pane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		board.add(rooms_pane);
		rooms_pane.addMouseListener(new PanelButtonMouseAdapter(rooms_pane) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelrooms);
			}
		});

		guestpane = new JPanel();
		guestpane.setBackground(new Color(9, 38, 53));
		guestpane.setBounds(0, 354, 253, 42);
		guestpane.setLayout(null);
		guestpane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		board.add(guestpane);
		guestpane.addMouseListener(new PanelButtonMouseAdapter(guestpane) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelguest);
			}
		});

		// Labels with customized font:Poppins
		try {
			// Load your custom fonts
			File fontFile_PBold = new File("src/fonts/Poppins-Bold.ttf");
			File fontFile_PRegular = new File("src/fonts/Poppins-Regular.ttf");
			
			Font poppinsb = Font.createFont(Font.TRUETYPE_FONT, fontFile_PBold).deriveFont(Font.BOLD, 14);
			Font poppinsR = Font.createFont(Font.TRUETYPE_FONT, fontFile_PRegular).deriveFont(Font.BOLD, 12);

			home_label = new JLabel("HOME");
			home_label.setForeground(new Color(102,102,102));
			home_label.setFont(poppinsb);
			home_label.setBounds(83, 14, 46, 14);
			home_pane.add(home_label);

			dashboard_label = new JLabel("DASHBOARD");
			dashboard_label.setFont(poppinsb);
			dashboard_label.setForeground(new Color(102,102,102));
			dashboard_label.setBounds(83, 13, 134, 14);
			dashboard_pane.add(dashboard_label);

			roombooking_label = new JLabel("ROOM BOOKING");
			roombooking_label.setBounds(83, 13, 134, 14);
			roombooking_label.setFont(poppinsb);
			roombooking_label.setForeground(new Color(102,102,102));
			roombpane.add(roombooking_label);

			cancel_label = new JLabel("CANCEL BOOKING");
			cancel_label.setFont(poppinsb);
			cancel_label.setForeground(new Color(102,102,102));
			cancel_label.setBounds(83, 14, 143, 14);
			cancelb_pane.add(cancel_label);

			room_label = new JLabel("ROOMS");
			room_label.setFont(poppinsb);
			room_label.setForeground(new Color(102,102,102));
			room_label.setBounds(83, 13, 94, 14);
			rooms_pane.add(room_label);

			guest_label = new JLabel("GUESTS");
			guest_label.setFont(poppinsb);
			guest_label.setForeground(new Color(102,102,102));
			guest_label.setBounds(83, 13, 94, 14);
			guestpane.add(guest_label);

			settings = new JLabel("SETTINGS");
			settings.setForeground(new Color(138, 138, 138));
			settings.setFont(poppinsR);
			settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			settings.setBounds(83, 552, 94, 14);
			board.add(settings);

			logout = new JLabel("LOG OUT");
			logout.setForeground(new Color(255, 87, 87));
			logout.setFont(poppinsR);
			logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			logout.setBounds(83, 580, 94, 14);
			board.add(logout);
			logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {

						// Terminate the system
						System.exit(0);
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Call this method for each panel-label pair to enable mouse hover effects
		setupMouseListeners(home_pane, home_label);
		setupMouseListeners(dashboard_pane, dashboard_label);
		setupMouseListeners(roombpane, roombooking_label);
		setupMouseListeners(cancelb_pane, cancel_label);
		setupMouseListeners(rooms_pane, room_label);
		setupMouseListeners(guestpane, guest_label);

		// icons
		hm_icon = new JLabel(homeicon);
		hm_icon.setBounds(50, 7, 25, 25);
		home_pane.add(hm_icon);

		dashb_icon = new JLabel(dbicon);
		dashb_icon.setBounds(52, 7, 25, 25);
		dashboard_pane.add(dashb_icon);

		JLabel rb_icon = new JLabel(rbicon);
		rb_icon.setBounds(53, 8, 20, 20);
		roombpane.add(rb_icon);

		cb_icon = new JLabel(cancelbicon);
		cb_icon.setBounds(53, 10, 20, 20);
		cancelb_pane.add(cb_icon);

		rooms_icon = new JLabel(room_icon);
		rooms_icon.setBounds(53, 8, 20, 20);
		rooms_pane.add(rooms_icon);

		guest_icon = new JLabel(guests_icon);
		guest_icon.setBounds(53, 8, 20, 20);
		guestpane.add(guest_icon);

		setting_icon = new JLabel((setting_img));
		setting_icon.setBounds(53, 549, 20, 20);
		board.add(setting_icon);

		logout_icon = new JLabel((logout_img));
		logout_icon.setBounds(53, 576, 20, 20);
		board.add(logout_icon);

		// seperator
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(232, 232, 232));
		separator.setBounds(40, 500, 180, 4);
		board.add(separator);
		
	

	}

	// Hides all panels and displays the specified panel when a menu panelbutton is clicked
	private void menuClicked(JPanel panel) {
		panelhome.setVisible(false);
		paneldashboard.setVisible(false);
		panelroomb.setVisible(false);
		panelcancelb.setVisible(false);
		panelrooms.setVisible(false);
		panelguest.setVisible(false);

		panel.setVisible(true);

	}

	// Set up mouse listeners for a JPanel-Label pair to handle color changes on
	// mouse hover
	private void setupMouseListeners(JPanel panel, JLabel label) {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(new Color(255, 255, 255));
			}

			public void mouseExited(MouseEvent e) {
				label.setForeground(new Color(102,102,102));
			}
		});
	}

	// MouseAdapter
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(23, 107, 135));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(9, 38, 53));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(23, 107, 135));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(9, 38, 53));
		}
	}

}
