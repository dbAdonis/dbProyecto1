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
		panel_2.setPreferredSize(new Dimension(10, 250));
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 330));
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(100);
		flowLayout_1.setVgap(200);
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		btnFincaUno = new JButton("Finca 1");
		btnFincaUno.setBackground(SystemColor.inactiveCaptionBorder);
		btnFincaUno.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnFincaUno.setFocusable(false);
		btnFincaUno.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFincaUno.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFincaUno.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFincaUno.setPreferredSize(new Dimension(170, 111));
		btnFincaUno.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		panel_3.add(btnFincaUno);
		
		btnFincaDos = new JButton("Finca 2");
		btnFincaDos.setBackground(SystemColor.inactiveCaptionBorder);
		btnFincaDos.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnFincaDos.setFocusable(false);
		btnFincaDos.setMinimumSize(new Dimension(70, 23));
		btnFincaDos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFincaDos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFincaDos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFincaDos.setPreferredSize(new Dimension(170, 111));
		btnFincaDos.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 75));
		
		lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(150, 150));
		
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_2.add(lblLogo);
		
		panel_3.add(btnFincaDos);
		
		btnMenu = new JButton("Men\u00FA");
		btnMenu.setFocusable(false);
		btnMenu.setBackground(SystemColor.inactiveCaptionBorder);
		btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenu.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnMenu.setFont(new Font("SansSerif", Font.BOLD, 14));
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
		
		ImageIcon iconImgLogo = new ImageIcon(imgLogo.getImage().getScaledInstance((int) lblLogo.getPreferredSize().getWidth(), 
				(int) lblLogo.getPreferredSize().getHeight(), Image.SCALE_DEFAULT));
		
		ImageIcon imgFincaUno = new ImageIcon(getClass().getResource(fincaUno));
		
		ImageIcon iconImgFincaUno = new ImageIcon(imgFincaUno.getImage().getScaledInstance(90, 81, Image.SCALE_DEFAULT));
		
		ImageIcon imgFincaDos = new ImageIcon(getClass().getResource(fincaDos));
		
		ImageIcon iconImgFincaDos = new ImageIcon(imgFincaDos.getImage().getScaledInstance(90, 81, Image.SCALE_DEFAULT));
		btnFincaDos.setIcon(iconImgFincaDos);
		
		lblLogo.setIcon(iconImgLogo);
		
		btnFincaUno.setIcon(iconImgFincaUno);
		
		btnFincaDos.setIcon(iconImgFincaDos);
		
	}

}
