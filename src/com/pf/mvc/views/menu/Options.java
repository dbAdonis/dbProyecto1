package com.pf.mvc.views.menu;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class Options extends JPanel {
	public JButton btnMenu;
	public JButton btnFincaDos;
	public JButton btnFincaUno;
	private JLabel lblLogo;

	/**
	 * Create the panel.
	 */
	public Options() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(194, 227, 187));		
		panel_2.setPreferredSize(new Dimension(10, 400));
		panel_1.add(panel_2, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(194, 227, 187));
		panel_3.setPreferredSize(new Dimension(10, 330));
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(100);
		flowLayout_1.setVgap(50);
		panel_1.add(panel_3, BorderLayout.CENTER);

		Font calibriFont = new Font("Calibri", Font.BOLD, 16);

		btnFincaUno = new JButton("Finca 1");
		btnFincaUno.setFocusPainted(false);
		btnFincaUno.setBackground(new Color(211, 211, 211));
		//btnFincaUno.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnFincaUno.setFocusable(false);
		btnFincaUno.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFincaUno.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFincaUno.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFincaUno.setPreferredSize(new Dimension(170, 111));
		btnFincaUno.setFont(calibriFont);

		panel_3.add(btnFincaUno);

		btnFincaDos = new JButton("Finca 2");
		btnFincaDos.setFocusPainted(false);
		btnFincaDos.setBackground(new Color(211, 211, 211));
		//btnFincaDos.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnFincaDos.setFocusable(false);
		btnFincaDos.setMinimumSize(new Dimension(70, 23));
		btnFincaDos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFincaDos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFincaDos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFincaDos.setPreferredSize(new Dimension(170, 111));
		btnFincaDos.setFont(calibriFont);

		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 75));

		lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(250, 250));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(calibriFont);

		panel_2.add(lblLogo);

		panel_3.add(btnFincaDos);

		btnMenu = new JButton("Menú");
		btnMenu.setFocusPainted(false);
		btnMenu.setFocusable(false);
		btnMenu.setBackground(new Color(211, 211, 211));
		btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		//btnMenu.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnMenu.setFont(calibriFont);
		btnMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMenu.setPreferredSize(new Dimension(170, 111));

		ImageIcon imgMenu = new ImageIcon(getClass().getResource("/resources/Home.png"));

		ImageIcon iconImgMenu = new ImageIcon(imgMenu.getImage().getScaledInstance(90, 81, Image.SCALE_DEFAULT));

		btnMenu.setIcon(iconImgMenu);

		panel_3.add(btnMenu);
	}

	public void setImagesButtons(String logo, String fincaUno, String fincaDos) {

		ImageIcon imgLogo = new ImageIcon(getClass().getResource(logo));

		ImageIcon iconImgLogo = new ImageIcon(
				imgLogo.getImage().getScaledInstance((int) lblLogo.getPreferredSize().getWidth(),
						(int) lblLogo.getPreferredSize().getHeight(), Image.SCALE_DEFAULT));

		ImageIcon imgFincaUno = new ImageIcon(getClass().getResource(fincaUno));

		ImageIcon iconImgFincaUno = new ImageIcon(
				imgFincaUno.getImage().getScaledInstance(90, 75, Image.SCALE_DEFAULT));

		ImageIcon imgFincaDos = new ImageIcon(getClass().getResource(fincaDos));

		ImageIcon iconImgFincaDos = new ImageIcon(
				imgFincaDos.getImage().getScaledInstance(90, 75, Image.SCALE_DEFAULT));

		btnFincaDos.setIcon(iconImgFincaDos);

		lblLogo.setIcon(iconImgLogo);

		btnFincaUno.setIcon(iconImgFincaUno);

		btnFincaDos.setIcon(iconImgFincaDos);
	}
}
