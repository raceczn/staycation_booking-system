package dashboard.screen_panels;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;

public class CustomRadioButtonUI extends BasicRadioButtonUI {
    private static final Color SELECTED_COLOR = new Color(23, 107, 135);
    private static final Color UNSELECTED_COLOR = new Color(200, 200, 200);

    @Override
    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setOpaque(false);
        b.setFont(new Font("Poppins", Font.PLAIN, 14));
        b.setForeground(Color.BLACK);
        b.setBackground(new Color(255, 255, 255));
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        // Do nothing to avoid painting the focus rectangle
    }

    @Override
    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();

        if (!model.isEnabled()) {
            g.setColor(UIManager.getColor("RadioButton.shadow"));
        } else {
            g.setColor(button.getForeground());
        }

        if (model.isSelected()) {
            // Draw a filled circle with a gradient for the selected state
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setPaint(new GradientPaint(iconRect.x, iconRect.y, SELECTED_COLOR,
                    iconRect.x + iconRect.width, iconRect.y + iconRect.height, Color.WHITE));
            g2d.fillOval(iconRect.x, iconRect.y, iconRect.width, iconRect.height);
        } else {
            // Draw an outlined circle for the unselected state
            g.drawOval(iconRect.x, iconRect.y, iconRect.width, iconRect.height);
        }
    }

    public static ComponentUI createUI(JComponent c) {
        return new CustomRadioButtonUI();
    }
}
