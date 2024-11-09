package dashboard.screen_panels;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;

public class PanelHome extends JPanel {
	// Path to image resources
	private static final String IMAGE_PATH = "src/assets/panelhome_imgs/";

	// Paths to font resources
	private static final String FONT_PATH_BOLD = "src/assets/fonts/Poppins-Bold.ttf";
	private static final String FONT_PATH_REGULAR = "src/assets/fonts/Poppins-Regular.ttf";

	// ImageIcons for various elements
	private ImageIcon topImg = new ImageIcon(IMAGE_PATH + "bg.png");
	private ImageIcon img1 = new ImageIcon(IMAGE_PATH + "standard_room.png");
	private ImageIcon img2 = new ImageIcon(IMAGE_PATH + "deluxe.png");
	private ImageIcon img3 = new ImageIcon(IMAGE_PATH + "family_suite.png");
	private ImageIcon img4 = new ImageIcon(IMAGE_PATH + "exclusive_suite.png");
	private ImageIcon profile = new ImageIcon(IMAGE_PATH + "profile.png");

	private Font poppins = loadFont(FONT_PATH_BOLD, Font.BOLD, 14);
	private Font poppins12 = loadFont(FONT_PATH_REGULAR, Font.PLAIN, 12);

	public PanelHome() {
		setAppearance();
	}

	private void setAppearance() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 747, 650);
		setLayout(null);
		setVisible(true);

		JButton bookNow = new JButton("Book now");
		bookNow.setBounds(525, 255, 130, 40);
		bookNow.setFont(poppins);
		bookNow.setBackground(new Color(23, 107, 135));
		bookNow.setForeground(Color.WHITE);
		bookNow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bookNow.setHorizontalAlignment(SwingConstants.CENTER);
		bookNow.setFocusPainted(false);

		add(bookNow);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		RoundRectangle2D roundRect = new RoundRectangle2D.Double(35, 100, 660, 220, 40, 40);
		g2d.setClip(roundRect);

		// transparency for the background image
		float alpha = 0.3f;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

		setRenderingHints(g2d);

		g2d.drawImage(topImg.getImage(), 35, 100, 660, 220, this);

		// Drawing various text and images on the panel
		drawLabelText(g2d, "Rediscover Relaxation", 60, 160, "Poppins-Bold.ttf", Font.BOLD, 16,
				new Color(23, 107, 135));
		drawLabelText(g2d, "Your Ultimate Staycation Oasis!", 60, 192, "Poppins-Bold.ttf", Font.BOLD, 28,
				new Color(9, 38, 53));
		drawMultiLineText(g2d,
				"Escape to our staycation resort, where tranquility meets modern comfort. Unwind in \n"
						+ "stylish rooms, lounge by the pool, and indulge in diverse amenities.",
				60, 213, "Arial", Font.PLAIN, 13, new Color(0, 0, 0));

		g2d.setClip(null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

		drawImages(g2d);

		drawLabelText(g2d, "Room-specific Amenities", 200, 375, "Poppins-Bold.ttf", Font.BOLD, 26,
				new Color(9, 38, 53));
		drawLabelText(g2d, "Administrator", 545, 70, "Poppins-Bold.ttf", Font.BOLD, 12, new Color(9, 38, 53));

		drawHorizontalLines(g2d);

		drawRoundedRectangles(g2d);
		
		
	}

	private void drawImages(Graphics2D g2d) {
		g2d.drawImage(img1.getImage(), 38, 410, 155, 180, this);
		g2d.drawImage(img2.getImage(), 207, 410, 155, 180, this);
		g2d.drawImage(img3.getImage(), 375, 410, 150, 180, this);
		g2d.drawImage(img4.getImage(), 540, 410, 150, 180, this);
		g2d.drawImage(profile.getImage(), 655, 45, 35, 35, this);
	}

	// Draw horizontal lines on the panel
	private void drawHorizontalLines(Graphics2D g2d) {
		int lineStartX1 = 0;
		int lineEndX1 = 190;
		int lineY1 = 365;
		int lineWidth1 = 2;
		g2d.fillRect(lineStartX1, lineY1 - lineWidth1 / 2, lineEndX1 - lineStartX1, lineWidth1);

		int lineStartX2 = 550;
		int lineEndX2 = 750;
		int lineY2 = 365;
		int lineWidth2 = 2;
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(lineStartX2, lineY2 - lineWidth2 / 2, lineEndX2 - lineStartX2, lineWidth2);
	}

	// Draw rounded rectangles for specific elements on the panel
	private void drawRoundedRectangles(Graphics2D g2d) {
		drawRoundedRectangle(g2d, 38, 560, 130, 30, 10, 10, "Standard Room");
		drawRoundedRectangle(g2d, 207, 560, 130, 30, 10, 10, "Deluxe Room");
		drawRoundedRectangle(g2d, 375, 560, 130, 30, 10, 10, "Family Suite");
		drawRoundedRectangle(g2d, 540, 560, 130, 30, 10, 10, "Exclusive Suite");
	}

	private void drawRoundedRectangle(Graphics2D g2d, int x, int y, int width, int height, int arcWidth, int arcHeight,
			String label) {
		g2d.setColor(new Color(39, 80, 93, 250));
		g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

		int labelX = x + 10;
		int labelY = y + 20;
		g2d.setFont(poppins12);
		g2d.setColor(new Color(255, 255, 255));
		g2d.drawString(label, labelX, labelY);
	}

	// Rendering for smooth graphics
	private void setRenderingHints(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	}

	private void drawLabelText(Graphics2D g2d, String text, int x, int y, String fontName, int fontStyle,
			float fontSize, Color color) {
		try {
			Font font = loadFont("src/assets/fonts/" + fontName, fontStyle, fontSize);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.setFont(font);
			g2d.setColor(color);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
			g2d.drawString(text, x, y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Draw multiline text with specified attributes on the panel
	private void drawMultiLineText(Graphics2D g2d, String text, int x, int y, String fontName, int fontStyle,
			float fontSize, Color color) {
		try {
			Font font = new Font(fontName, fontStyle, (int) fontSize);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.setFont(font);
			g2d.setColor(color);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

			String[] lines = text.split("\n");
			for (int i = 0; i < lines.length; i++) {
				g2d.drawString(lines[i], x, y + i * font.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Load a custom font from a file with specified style and size
	private Font loadFont(String filePath, int style, float size) {
		try {
			File fontFile = new File(filePath);
			try (FileInputStream fis = new FileInputStream(fontFile)) {
				return Font.createFont(Font.TRUETYPE_FONT, fis).deriveFont(style, size);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Font("Arial", Font.PLAIN, 12);
		}
	}
}
