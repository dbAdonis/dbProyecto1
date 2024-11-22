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
	public JPanel panelBtnProductos;
	public JButton btnGestionarNaturalezas;
	public JButton btnGestionarTipos;
	public JButton btnGestionarCategorias;
	public JButton btnSupervisor;

	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 720);
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
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
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
		btnGestionarPersonal.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarPersonal.setIconTextGap(10);
		btnGestionarPersonal.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnGestionarPersonal.setPreferredSize(new Dimension(200, 45));
		panel.add(btnGestionarPersonal);
		btnGestionarPersonal.setFocusPainted(false);
		btnGestionarPersonal.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnGestionarPersonal.setForeground(Color.WHITE);
		btnGestionarPersonal.setBackground(new Color(62, 85, 40));


		btnReportesDiarios = new JButton("Reportes Diarios");
		btnReportesDiarios.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportesDiarios.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnReportesDiarios.setPreferredSize(new Dimension(200, 45));
		panel.add(btnReportesDiarios);
		btnReportesDiarios.setFocusPainted(false);
		btnReportesDiarios.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnReportesDiarios.setForeground(Color.WHITE);
		btnReportesDiarios.setBackground(new Color(62, 85, 40));

		panelBtnReportes = new JPanel();
		panelBtnReportes.setPreferredSize(new Dimension(200, 135));
		FlowLayout fl_panelBtnReportes = (FlowLayout) panelBtnReportes.getLayout();
		fl_panelBtnReportes.setVgap(0);
		panel.add(panelBtnReportes);

		btnLotes = new JButton("Gestionar lotes");
		btnLotes.setMaximumSize(new Dimension(200, 23));
		btnLotes.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnLotes.setHorizontalAlignment(SwingConstants.LEFT);
		btnLotes.setIconTextGap(10);
		btnLotes.setPreferredSize(new Dimension(200, 45));
		btnLotes.setForeground(Color.WHITE);
		btnLotes.setFocusPainted(false);
		btnLotes.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnLotes.setBackground(new Color(62, 85, 40));
		panelBtnReportes.add(btnLotes);

		btnVariedades = new JButton("Gestionar variedades");
		btnVariedades.setMaximumSize(new Dimension(200, 23));
		btnVariedades.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnVariedades.setIconTextGap(10);
		btnVariedades.setHorizontalAlignment(SwingConstants.LEFT);
		btnVariedades.setPreferredSize(new Dimension(200, 45));
		btnVariedades.setForeground(Color.WHITE);
		btnVariedades.setFocusPainted(false);
		btnVariedades.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnVariedades.setBackground(new Color(62, 85, 40));
		panelBtnReportes.add(btnVariedades);

		btnLabores = new JButton("Gestionar labores");
		btnLabores.setMaximumSize(new Dimension(200, 23));
		btnLabores.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnLabores.setIconTextGap(10);
		btnLabores.setHorizontalAlignment(SwingConstants.LEFT);
		btnLabores.setPreferredSize(new Dimension(200, 45));
		btnLabores.setForeground(Color.WHITE);
		btnLabores.setFocusPainted(false);
		btnLabores.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnLabores.setBackground(new Color(62, 85, 40));
		panelBtnReportes.add(btnLabores);

		btnProductos = new JButton("Productos");
		btnProductos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProductos.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnProductos.setPreferredSize(new Dimension(200, 45));
		panel.add(btnProductos);
		btnProductos.setFocusPainted(false);
		btnProductos.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setBackground(new Color(62, 85, 40));

		ImageIcon imgLine = new ImageIcon(getClass().getResource("/resources/line.png"));

		ImageIcon iconImgLine = new ImageIcon(imgLine.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT));

		btnLotes.setIcon(iconImgLine);
		btnVariedades.setIcon(iconImgLine);
		btnLabores.setIcon(iconImgLine);
		
		panelBtnProductos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBtnProductos.getLayout();
		flowLayout.setVgap(0);
		panelBtnProductos.setPreferredSize(new Dimension(200, 135));
		panel.add(panelBtnProductos);
		
		btnGestionarNaturalezas = new JButton("Gestionar naturalezas");
		btnGestionarNaturalezas.setPreferredSize(new Dimension(200, 45));
		btnGestionarNaturalezas.setMaximumSize(new Dimension(200, 23));
		btnGestionarNaturalezas.setIconTextGap(10);
		btnGestionarNaturalezas.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarNaturalezas.setForeground(Color.WHITE);
		btnGestionarNaturalezas.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnGestionarNaturalezas.setFocusPainted(false);
		btnGestionarNaturalezas.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnGestionarNaturalezas.setBackground(new Color(62, 85, 40));
		panelBtnProductos.add(btnGestionarNaturalezas);
		
		btnGestionarTipos = new JButton("Gestionar tipos");
		btnGestionarTipos.setPreferredSize(new Dimension(200, 45));
		btnGestionarTipos.setMaximumSize(new Dimension(200, 23));
		btnGestionarTipos.setIconTextGap(10);
		btnGestionarTipos.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarTipos.setForeground(Color.WHITE);
		btnGestionarTipos.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnGestionarTipos.setFocusPainted(false);
		btnGestionarTipos.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnGestionarTipos.setBackground(new Color(62, 85, 40));
		panelBtnProductos.add(btnGestionarTipos);
		
		btnGestionarCategorias = new JButton("Gestionar categorias");
		btnGestionarCategorias.setPreferredSize(new Dimension(200, 45));
		btnGestionarCategorias.setMaximumSize(new Dimension(200, 23));
		btnGestionarCategorias.setIconTextGap(10);
		btnGestionarCategorias.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionarCategorias.setForeground(Color.WHITE);
		btnGestionarCategorias.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnGestionarCategorias.setFocusPainted(false);
		btnGestionarCategorias.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnGestionarCategorias.setBackground(new Color(62, 85, 40));
		panelBtnProductos.add(btnGestionarCategorias);
		
		btnFincas = new JButton("Fincas");
		btnFincas.setHorizontalAlignment(SwingConstants.LEFT);
		btnFincas.setPreferredSize(new Dimension(200, 45));
		btnFincas.setForeground(Color.WHITE);
		btnFincas.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnFincas.setFocusPainted(false);
		btnFincas.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnFincas.setBackground(new Color(62, 85, 40));
		
		btnGestionarNaturalezas.setIcon(iconImgLine);
		btnGestionarTipos.setIcon(iconImgLine);
		btnGestionarCategorias.setIcon(iconImgLine);
		panel.add(btnFincas);
		
		btnSupervisor = new JButton("Supervisores");
		btnSupervisor.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupervisor.setPreferredSize(new Dimension(200, 45));
		btnSupervisor.setForeground(Color.WHITE);
		btnSupervisor.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnSupervisor.setFocusPainted(false);
		btnSupervisor.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnSupervisor.setBackground(new Color(62, 85, 40));
		panel.add(btnSupervisor);
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
		ocultarPanelBtnProductos();
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
	
	public void desplegarPanelBtnProductos() {
		int alto = panelBtnProductos.getHeight();

		if (alto == 0) {

			panelBtnProductos.setPreferredSize(new Dimension(200, 135));
			panel.repaint();
			panel.revalidate();
		}
	}

	public void ocultarPanelBtnProductos() {

		int alto = panelBtnProductos.getHeight();

		if (alto > 0) {

			panelBtnProductos.setPreferredSize(new Dimension(150, 0));
			panel.repaint();
			panel.revalidate();
		}
	}

}
