package jComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class CustomizedFrame extends JPanel{

	int width, height;
	
	
	//login
	public CustomizedFrame(int width, int height) {
		this.width = width;
		this.height = height;
		
		setOpaque(false);
		setBounds(0, 0, width, height);
		setBackground(Color.black);
		
	}
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.white);
		g2.fillRoundRect(0, 0, width, height, 20, 20);
		super.paintComponent(g);
	}
	//askdjdf
	
}
