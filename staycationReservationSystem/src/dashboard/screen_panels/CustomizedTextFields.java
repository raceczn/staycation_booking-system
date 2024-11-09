package dashboard.screen_panels;

import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

public class CustomizedTextFields extends JTextField {

    private static final int ARC_WIDTH = 20;
    private static final int ARC_HEIGHT = 20;
    
    private static final Color BORDER_COLOR = new Color(0, 0, 0);
    private static final Color PLACEHOLDER_COLOR = new Color(169, 169, 169);

    private String placeholder;

    public CustomizedTextFields() {
        // Set the text field to be transparent
        setOpaque(false);
        // Set the border to a rounded border using the inner class RoundedTextFieldBorder
        setBorder(new RoundedTextFieldBorder());
    }

    // Set the placeholder text
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    // Override to paint the placeholder text
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // If the text is empty and a placeholder is set, paint the placeholder text
        if (getText().isEmpty() && placeholder != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(PLACEHOLDER_COLOR);

            Font font = new Font("Arial", Font.PLAIN, 9);
            g2d.setFont(font);

            // Draw the placeholder text
            g2d.drawString(placeholder, getInsets().left,
                    (getHeight() - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent());
            g2d.dispose();
        }
    }

    // Inner class for defining the rounded border
    private class RoundedTextFieldBorder implements Border {
        // Paint the rounded border
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(BORDER_COLOR);
            g2d.drawRoundRect(x, y, width - 1, height - 1, ARC_WIDTH, ARC_HEIGHT);
            g2d.dispose();
        }

        // Get insets for the border
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(2, 7, 2, 2);
        }

        // Indicate whether the border is opaque
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
}
