package com.pf.mvc.views;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Frame;

public class ViewPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contenido;
	public JLabel lEstado;
	public JLabel lTitulo;
	

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 736);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(33, 51, 40));
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		panel_2.setPreferredSize(new Dimension(10, 50));
		panel_1.add(panel_2, BorderLayout.NORTH);

		lTitulo = new JLabel("Titulo");
		lTitulo.setForeground(Color.WHITE);
		lTitulo.setFont(new Font("SansSerif", Font.PLAIN, 24));
		panel_2.add(lTitulo);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 10, 0, 10));
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(10, 30));
		panel_1.add(panel_3, BorderLayout.SOUTH);

		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblEstado);

		lEstado = new JLabel("...");
		lEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_3.add(lEstado);

		contenido = new JPanel();
		contenido.setBackground(new Color(240, 247, 244));
		contenido.setPreferredSize(new Dimension(900, 600));
		contenido.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new BorderLayout(0, 0));
	}

	
	public void init() {
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void cerrarVentana() {
		
		System.exit(0);
		
	}

	public void setContenido(JComponent c, String titulo) {

		lTitulo.setText(titulo);

		contenido.removeAll();

		if(c != null) {
			contenido.add(c, BorderLayout.CENTER);
		}

		contenido.repaint();
		contenido.revalidate();

	}


















}
