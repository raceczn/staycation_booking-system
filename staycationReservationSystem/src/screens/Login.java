package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dashboard.FrameDashboard;
import jComponents.Button;
import jComponents.CustomizedFrame;
import jComponents.PasswordField;
import jComponents.TextField;

public class Login extends JFrame{

	String msg = ""; //wrong credentials message
	private String username = "Hatdog";
	private String password = "Hatdog12";
	
	String text = "Welcome", 
		   text1 = "Please enter your credentials";
	
	public Login() {
		
		int widthOfFrame = 400;
		int heightOfFrame = 500;
		int widthOfField = 200;
		int heightOfField = 60;
		int buttonWidth = 150;
		int buttonHeight = 30;
		
		
		FrameDashboard frame = new FrameDashboard();
		CustomizedFrame mainFrame = new CustomizedFrame(widthOfFrame, heightOfFrame);
		TextField txtfld = new TextField();
		PasswordField passfld = new PasswordField();
		Button loginButton = new Button();
		
		setSize(widthOfFrame, heightOfFrame);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		
		JPanel panel = new JPanel() {

			public void paintComponent(Graphics g) {
				// getting the width and height of the text
				
				
				Image logo = new ImageIcon(getClass().getResource("/images/logo.png")).getImage();
				
				AffineTransform affinetransform = new AffineTransform();
				FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
				Font font = new Font("Arial", Font.PLAIN, 25);
				Font font1 = new Font("Arial", Font.PLAIN, 13);
				int textwidth = (int) (font.getStringBounds(text, frc).getWidth());
				int textwidth1 = (int) (font1.getStringBounds(text1, frc).getWidth());
				int textheight = (int) (font.getStringBounds(text, frc).getHeight());

				Graphics2D g2 = (Graphics2D) g;
				
				int widthOfLogo = logo.getWidth(null);

				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.black);
				g2.setFont(font);
				g2.drawString(text, widthOfFrame / 2 - textwidth / 2, heightOfFrame / 5);
				g2.setFont(font1);
				g2.drawString(text1, widthOfFrame / 2 - textwidth1 / 2, heightOfFrame / 5 + textheight);
				g2.drawImage(logo, widthOfFrame / 2 - widthOfLogo /2, 40, null);
				
				super.paintComponent(g);
			}

		};
		txtfld.setBounds(widthOfFrame / 2 - widthOfField / 2, heightOfFrame / 3, widthOfField, heightOfField);
		txtfld.setLabelText("Username");
		
		passfld.setBounds(widthOfFrame / 2 - widthOfField / 2, heightOfFrame / 3 + heightOfField + 30, widthOfField, heightOfField);
		passfld.setLabelText("Password");
		
		loginButton.setBounds(widthOfFrame / 2 - buttonWidth / 2, heightOfFrame - (buttonHeight + 120), buttonWidth, buttonHeight);
		loginButton.setText("Login");
		
		panel.add(loginButton);
		panel.add(txtfld);
		panel.add(passfld);
		panel.setOpaque(false);
		panel.setBounds(0, 0, widthOfFrame, heightOfFrame);
		panel.setLayout(null);
		add(panel);
		add(mainFrame);
		
		
		
		
		//conditions for logging in
		
		
		loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
            	String userName = txtfld.getText();
        		String passWord = passfld.getText();
        		
        		
        		
        		if(!userName.isBlank() || !passWord.isBlank()) {
        			if (userName != username || passWord != password) {
            			text1 = "Wrong Credentials";
            			repaint();
            		}
        			if(userName.isBlank() || passWord.isBlank()) {
            			text1 = "Kumpletuhin mo naman bhie";
            			repaint();
            		}
        			if(userName.equals(username) && passWord.equals(password)) {
            			text1 = "Logging in na gurl";
            			repaint();
            			frame.setVisible(true);
            			dispose();
            		}
        		}
        		if(userName.isBlank() && passWord.isBlank()) {
        			text1 = "Fleece lang lagyan mo baliw to eh";
        			repaint();
        		}
        		
        		
        		
            	
            }
        });
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}
