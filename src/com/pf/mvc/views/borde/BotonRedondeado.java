package com.pf.mvc.views.borde;

import javax.swing.*;
import java.awt.*;

public class BotonRedondeado extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radioEsquina;

    public BotonRedondeado(String text, int radio) {
        super(text);
        this.radioEsquina = radio;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setRolloverEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radioEsquina, radioEsquina);

        Color borderColor = getBackground().darker();

        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(3)); 
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, radioEsquina, radioEsquina);

        FontMetrics fm = g.getFontMetrics();
        Rectangle textBounds = fm.getStringBounds(getText(), g).getBounds();
        int textX = (getWidth() - textBounds.width) / 2;
        int textY = (getHeight() - textBounds.height) / 2 + fm.getAscent();
        g.setColor(getForeground());
        g.drawString(getText(), textX, textY);
    }
}
