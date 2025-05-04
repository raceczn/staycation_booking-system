package jComponents;

import java.awt.Color;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.Timer;
import org.jdesktop.animation.timing.Animator;

public class TextfieldForInfo extends JTextField {

    

    public void setHint(String hint) {
        this.hint = hint;
    }

    float alpha = 0.5f;
    float animatSize = 0;
    int targetSize = 300;
    Animator animator;
    Timer timer;
    int addTime = 0;
    int addSize = 15;
    int size = 5;
    private String hint = "";

    public TextfieldForInfo() {
    	setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 10));
        setForeground(Color.decode("#7A8C8D"));
        setFont(new java.awt.Font("sansserif", 0, 13));
        setSelectionColor(new Color(75, 175, 152));
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(228, 223, 213));//
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.decode("#092635"));
        
        int px = 1;
        
        g2.fillRect(0, 0, px, getHeight()); // Border WEST
        g2.fillRect(getWidth() - px, 0, px, getHeight()); // Border EAST
        g2.fillRect(0, 0, getWidth(), px); // Border NORTH
        g2.fillRect(0, getHeight() - px, getWidth(), px); // Border SOUTH
        
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(180, 180, 180));
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
    public void paintBorder(Graphics2D g) {
    	super.paintBorder(g);
    	g.setColor(Color.red);
    	g.drawRect(5, 0, getWidth() - 6, getHeight());
    }
    
	
}
