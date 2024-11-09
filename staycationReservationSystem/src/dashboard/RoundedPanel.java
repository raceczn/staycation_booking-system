package dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        
        // Create a custom shape for the rounded right corner
        Path2D path = new Path2D.Float();
        path.moveTo(0, 0);
        path.lineTo(width - cornerRadius, 0);
        path.quadTo(width, 0, width, cornerRadius);
        path.lineTo(width, height - cornerRadius);
        path.quadTo(width, height, width - cornerRadius, height);
        path.lineTo(0, height);

        g2d.setColor(getBackground());
        g2d.fill(path);

        g2d.setColor(getForeground());
        g2d.draw(path);

        g2d.dispose();
    }
    
    
}
