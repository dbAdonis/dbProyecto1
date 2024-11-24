package com.pf.mvc.views.borde;

import javax.swing.*;
import java.awt.*;

public class PanelRedondeado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radioBorde;

	public PanelRedondeado(int radio) {
		this.radioBorde = radio;
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), radioBorde, radioBorde);

		g2.setColor(getForeground());
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radioBorde, radioBorde);
	}
}
