
package dashboard.screen_panels;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;

public class PanelGuest extends JPanel {
	// Path to image resources
	private static final String IMAGE_PATH = "src/assets/panelguest_imgs/";
	private ImageIcon searchIcon = new ImageIcon(IMAGE_PATH + "searchIcon.png");

	// Fonts using custom font files
	private final Font poppins = loadFont("src/assets/fonts/Poppins-Bold.ttf", Font.BOLD, 14);
	private final Font poppinsR = loadFont("src/assets/fonts/Poppins-Regular.ttf", Font.BOLD, 14);

	private final Color darkGray = new Color(39, 39, 39);
	private final Color whiteColor = new Color(255, 255, 255);

	private CustomizedTextFields fName_tfield;
	private CustomizedTextFields lName_tfield;
	private CustomizedTextFields roomID_tfield;
	private CustomizedTextFields contact_tfield;
	private CustomizedTextFields emailAddress_tfield;
	private CustomizedTextFields search;

	public PanelGuest() {
		setPanelProperties();

		fName_tfield = createRoundedTextField(540, 190);
		fName_tfield.setPlaceholder("First name");

		lName_tfield = createRoundedTextField(540, 235);
		lName_tfield.setPlaceholder("Last name");
		roomID_tfield = createRoundedTextField(540, 280);
		roomID_tfield.setPlaceholder("Room number");

		contact_tfield = createRoundedTextField(540, 325);
		contact_tfield.setPlaceholder("Contact number");

		emailAddress_tfield = createRoundedTextField(540, 370);
		emailAddress_tfield.setPlaceholder("Email Address");

		add(createRoundedButton("Refresh", 560, 475, new Color(64, 45, 141)));
		add(createRoundedButton("Add", 415, 428, new Color(23, 107, 135)));
		add(createRoundedButton("Edit", 560, 428, new Color(9, 38, 53)));
		add(createRoundedButton("Delete", 415, 475, new Color(216, 65, 65)));

		search = new CustomizedTextFields();
		search.setPlaceholder("Search...");
		search.setBounds(500, 120, 200, 30);
		search.setBackground(new Color(250, 250, 250));
		add(search);

	}

	private void setPanelProperties() {
		setBackground(whiteColor);
		setBounds(0, 0, 747, 650);
		setLayout(null);
	}

	private RoundedButton createRoundedButton(String label, int x, int y, Color backgroundColor) {
		RoundedButton button = new RoundedButton(label);
		button.setBounds(x, y, 140, 35);
		button.setBackground(backgroundColor);
		return button;
	}

	private CustomizedTextFields createRoundedTextField(int x, int y) {
		CustomizedTextFields textField = new CustomizedTextFields();
		textField.setBounds(x, y, 160, 30);
		add(textField);
		textField.setColumns(10);
		return textField;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Filled rectangles
		g.setColor(darkGray);
		fillRect(g, 414, 190, 120, 37);
		fillRect(g, 414, 235, 120, 37);
		fillRect(g, 414, 280, 120, 37);
		fillRect(g, 414, 325, 120, 37);
		fillRect(g, 414, 370, 120, 37);

		drawText(g, poppins.deriveFont(Font.BOLD, 10), 425, 210, "FIRST NAME:");
		drawText(g, poppins.deriveFont(Font.BOLD, 10), 425, 255, "LAST NAME:");
		drawText(g, poppins.deriveFont(Font.BOLD, 10), 425, 300, "ROOM NUMBER:");
		drawText(g, poppins.deriveFont(Font.BOLD, 10), 425, 347, "CONTACT #:");
		drawText(g, poppins.deriveFont(Font.BOLD, 10), 425, 393, "EMAIL ADDRESS:");

		g.setFont(poppinsR.deriveFont(Font.PLAIN, 12));
		g.setColor(new Color(36, 36, 36));
		g.drawString("Search:", 415, 140);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(searchIcon.getImage(), 675, 125, 16, 16, this);

	}

	private void fillRect(Graphics g, int x, int y, int width, int height) {
		g.fillRect(x, y, width, height);
	}

	private void drawText(Graphics g, Font font, int x, int y, String text) {
		g.setFont(font);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(whiteColor);
		g.drawString(text, x, y);
	}

	// Load a custom font from a file with specified style and size
	private Font loadFont(String filePath, int style, float size) {
		try {
			File fontFile = new File(filePath);
			FileInputStream fis = new FileInputStream(fontFile);
			return Font.createFont(Font.TRUETYPE_FONT, fis).deriveFont(style, size);
		} catch (Exception e) {
			e.printStackTrace();
			return new Font("Arial", Font.PLAIN, 12);
		}
	}
}
