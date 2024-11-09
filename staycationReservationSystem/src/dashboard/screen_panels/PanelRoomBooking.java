package dashboard.screen_panels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class PanelRoomBooking extends JPanel {

    // Declare labels, text fields, radio buttons, and other components
	private JLabel firstNameLabel, lastNameLabel, emailLabel, contactLabel, addressLabel, cityLabel, countryLabel;
	private CustomizedTextFields firstNameTextField, lastNameTextField, contactTextField, emailTextField, addressTextField,
			cityTextField, countryTextField;
	private JLabel roomTypeLabel;
	private JRadioButton standardRadioButton, fsuiteRadioButton, deluxeRadioButton, esuiteRadioButton;
	private JLabel roomCapacityLabel;
	private JRadioButton pax1_2RadioButton, pax1_3RadioButton, pax1_5RadioButton, pax1_4RadioButton;
	private JLabel priceLabel;
	private JTextField priceTextField;

    // Declare button groups for radio buttons
	private ButtonGroup roomTypeGroup;
	private ButtonGroup roomCapacityGroup;

    // fonts using custom font files
	private final Font poppins = loadFont("src/assets/fonts/Poppins-Bold.ttf", Font.BOLD, 14);

    // Constructor for PanelRoomBooking
	public PanelRoomBooking() {
		setPanelAttributes();
		initializeButtonGroups(); // Initialize button groups 
		addLabelsAndTextFields();
		addRoomTypeComponents();
		addRoomCapacityComponents();
		addPriceComponents();
	}
	
	private void setPanelAttributes() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 747, 650);
		setLayout(null);
	}

	private void addLabelsAndTextFields() {
		// Add labels and text fields for personal information
		firstNameLabel = createLabel("First Name:", 70, 171);
		lastNameLabel = createLabel("Last Name:", 70, 215);
		emailLabel = createLabel("Email:", 70, 300);
		contactLabel = createLabel("Contact #:", 70, 259);
		addressLabel = createLabel("Address:", 70, 347);
		cityLabel = createLabel("City:", 70, 391);
		countryLabel = createLabel("Country:", 70, 435);

		firstNameTextField = createRoundedTextField(154, 175);
		firstNameTextField.setPlaceholder("First Name");
		
		lastNameTextField = createRoundedTextField(154, 215);
		lastNameTextField.setPlaceholder("Last Name");
		
		contactTextField = createRoundedTextField(154, 259);
		contactTextField.setPlaceholder("Contact number");
		
		emailTextField = createRoundedTextField(154, 303);
		emailTextField.setPlaceholder("Email address");
		
		addressTextField = createRoundedTextField(154, 351);
		addressTextField.setPlaceholder("Home Address");
		
		cityTextField = createRoundedTextField(154, 395);
		cityTextField.setPlaceholder("Your City");
		
		countryTextField = createRoundedTextField(154, 435);
		countryTextField.setPlaceholder("Your country");
	}

	private void addRoomTypeComponents() {
		// Add components related to room type
		roomTypeLabel = createLabel("Room Type:", 401, 180);

		standardRadioButton = createRadioButton("Standard", 500, 176);
		fsuiteRadioButton = createRadioButton("F. Suite", 585, 176);
		deluxeRadioButton = createRadioButton("Deluxe", 500, 205);
		esuiteRadioButton = createRadioButton("E.Suite", 585, 205);

		// Add radio buttons to the group
		roomTypeGroup.add(standardRadioButton);
		roomTypeGroup.add(fsuiteRadioButton);
		roomTypeGroup.add(deluxeRadioButton);
		roomTypeGroup.add(esuiteRadioButton);
	}

	private void addRoomCapacityComponents() {
		// Add components related to room capacity
		roomCapacityLabel = createLabel("Room Capacity:", 401, 250);

		pax1_2RadioButton = createRadioButton("1-2 pax", 500, 250);
		pax1_3RadioButton = createRadioButton("1-3 pax", 585, 250);
		pax1_5RadioButton = createRadioButton("1-5 pax", 585, 279);
		pax1_4RadioButton = createRadioButton("1-4 pax", 500, 279);

		// Add radio buttons to the group
		roomCapacityGroup.add(pax1_2RadioButton);
		roomCapacityGroup.add(pax1_3RadioButton);
		roomCapacityGroup.add(pax1_5RadioButton);
		roomCapacityGroup.add(pax1_4RadioButton);
	}

	private void addPriceComponents() {
		// Add components related to price
		priceLabel = createLabel("Price:", 401, 330);
		priceTextField = createRoundedTextField(500, 337);

	}

	private void initializeButtonGroups() {
		// Initialize the button groups
		roomTypeGroup = new ButtonGroup();
		roomCapacityGroup = new ButtonGroup();
	}

	private JLabel createLabel(String text, int x, int y) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, 106, 33);
		add(label);
		return label;
	}

    private CustomizedTextFields createRoundedTextField(int x, int y) {
    	CustomizedTextFields textField = new CustomizedTextFields();
        textField.setBounds(x, y, 160, 27);
        add(textField);
        textField.setColumns(10);
        return textField;
    }
	
	private JRadioButton createRadioButton(String text, int x, int y) {
		JRadioButton radioButton = new JRadioButton(text);
		radioButton.setBounds(x, y, 83, 23);

		radioButton.setBackground(null); // Remove background color
		radioButton.setFocusable(false); // Set focusable to false

		add(radioButton);

		return radioButton;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(new Color(39, 39, 39));

		// rectangles with black borders
		drawRectangle(g, 35, 150, 330, 400);
		drawRectangle(g, 375, 150, 330, 400);

		// filled rectangles
		g.setColor(new Color(39, 39, 39));
		g.fillRect(35, 110, 175, 40);
		g.fillRect(375, 110, 175, 40);

		drawText(g, poppins, 60, 135, "Personal Data");
		drawText(g, poppins.deriveFont(Font.BOLD, 14), 400, 135, "Room Data");
	}

	private void drawRectangle(Graphics g, int x, int y, int width, int height) {
		g.drawRect(x, y, width - 1, height - 1);
	}

	private void drawText(Graphics g, Font font, int x, int y, String text) {
		g.setFont(font);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(new Color(255, 255, 255));
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
