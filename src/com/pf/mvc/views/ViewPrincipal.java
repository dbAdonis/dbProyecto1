package com.pf.mvc.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnGestionarPersonal;
	public JButton btnReportesDiarios;
	public JPanel contenido;
	public JLabel lblTitulo;
	public JButton btnProductos;
	private JPanel panelBtnReportes;
	public JButton btnLotes;
	public JButton btnVariedades;
	public JButton btnLabores;
	private JPanel panel;
	public JButton btnFincas;

	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 566);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(900, 600));
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_3.setBackground(new Color(33, 51, 40));
		panel_3.setPreferredSize(new Dimension(0, 50));
		panel_2.add(panel_3, BorderLayout.NORTH);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_3.add(lblTitulo);

		contenido = new JPanel();
		panel_2.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel_2.add(panel, BorderLayout.WEST);
		panel.setPreferredSize(new Dimension(200, 10));
		panel.setBackground(new Color(62, 85, 40));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

		btnGestionarPersonal = new JButton("Gestionar Personal");
		btnGestionarPersonal.setIconTextGap(10);
		btnGestionarPersonal.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGestionarPersonal.setPreferredSize(new Dimension(200, 45));
		panel.add(btnGestionarPersonal);
		btnGestionarPersonal.setFocusPainted(false);
		btnGestionarPersonal.setBorder(null);
		btnGestionarPersonal.setForeground(Color.WHITE);
		btnGestionarPersonal.setBackground(new Color(62, 85, 40));


		btnReportesDiarios = new JButton("Reportes Diarios");
		btnReportesDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnReportesDiarios.setPreferredSize(new Dimension(200, 45));
		panel.add(btnReportesDiarios);
		btnReportesDiarios.setFocusPainted(false);
		btnReportesDiarios.setBorder(null);
		btnReportesDiarios.setForeground(Color.WHITE);
		btnReportesDiarios.setBackground(new Color(62, 85, 40));

		panelBtnReportes = new JPanel();
		panelBtnReportes.setPreferredSize(new Dimension(200, 135));
		FlowLayout fl_panelBtnReportes = (FlowLayout) panelBtnReportes.getLayout();
		fl_panelBtnReportes.setVgap(0);
		panel.add(panelBtnReportes);

		btnLotes = new JButton("Gestionar lotes");
		btnLotes.setMaximumSize(new Dimension(200, 23));
		btnLotes.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnLotes.setHorizontalAlignment(SwingConstants.LEFT);
		btnLotes.setIconTextGap(10);
		btnLotes.setPreferredSize(new Dimension(200, 45));
		btnLotes.setForeground(Color.WHITE);
		btnLotes.setFocusPainted(false);
		btnLotes.setBorder(null);
		btnLotes.setBackground(new Color(62, 85, 40));
		panelBtnReportes.add(btnLotes);

		btnVariedades = new JButton("Gestionar variedades");
		btnVariedades.setMaximumSize(new Dimension(200, 23));
		btnVariedades.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnVariedades.setIconTextGap(10);
		btnVariedades.setHorizontalAlignment(SwingConstants.LEFT);
		btnVariedades.setPreferredSize(new Dimension(200, 45));
		btnVariedades.setForeground(Color.WHITE);
		btnVariedades.setFocusPainted(false);
		btnVariedades.setBorder(null);
		btnVariedades.setBackground(new Color(62, 85, 40));
		panelBtnReportes.add(btnVariedades);

		btnLabores = new JButton("Gestionar labores");
		btnLabores.setMaximumSize(new Dimension(200, 23));
		btnLabores.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnLabores.setIconTextGap(10);
		btnLabores.setHorizontalAlignment(SwingConstants.LEFT);
		btnLabores.setPreferredSize(new Dimension(200, 45));
		btnLabores.setForeground(Color.WHITE);
		btnLabores.setFocusPainted(false);
		btnLabores.setBorder(null);
		btnLabores.setBackground(new Color(62, 85, 40));
		panelBtnReportes.add(btnLabores);

		btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnProductos.setPreferredSize(new Dimension(200, 45));
		panel.add(btnProductos);
		btnProductos.setFocusPainted(false);
		btnProductos.setBorder(null);
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setBackground(new Color(62, 85, 40));

		ImageIcon imgFlecha = new ImageIcon(getClass().getResource("/resources/line.png"));

		ImageIcon iconImgFlecha = new ImageIcon(imgFlecha.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT));

		btnLotes.setIcon(iconImgFlecha);
		btnVariedades.setIcon(iconImgFlecha);
		btnLabores.setIcon(iconImgFlecha);
		
		btnFincas = new JButton("Fincas");
		btnFincas.setPreferredSize(new Dimension(200, 45));
		btnFincas.setForeground(Color.WHITE);
		btnFincas.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnFincas.setFocusPainted(false);
		btnFincas.setBorder(null);
		btnFincas.setBackground(new Color(62, 85, 40));
		panel.add(btnFincas);
	}

	public void setContenido(JComponent c, String titulo) {

		lblTitulo.setText(titulo);

		contenido.removeAll();

		if (c != null) {
			contenido.add(c, BorderLayout.CENTER);
		}

		contenido.repaint();
		contenido.revalidate();

	}

	public void init() {
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

		this.setExtendedState(MAXIMIZED_BOTH);
		ocultarPanelBtnReportes();
	}

	public void desplegarPanelBtnReportes() {
		int alto = panelBtnReportes.getHeight();

		if (alto == 0) {

			panelBtnReportes.setPreferredSize(new Dimension(200, 135));
			panel.repaint();
			panel.revalidate();
		}
	}

	public void ocultarPanelBtnReportes() {

		int alto = panelBtnReportes.getHeight();

		if (alto > 0) {

			panelBtnReportes.setPreferredSize(new Dimension(150, 0));
			panel.repaint();
			panel.revalidate();
		}
	}

}
