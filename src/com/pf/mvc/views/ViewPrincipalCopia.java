package com.pf.mvc.views;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class ViewPrincipalCopia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnEmpleados;
	public JButton btnRoles;
	public JPanel contenido;
	public JLabel lblTitulo;
	public JButton btnReportes;

	public ViewPrincipalCopia() {
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
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblTitulo);
		
		contenido = new JPanel();
		panel_2.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.WEST);
		panel.setPreferredSize(new Dimension(150, 10));
		panel.setBackground(new Color(62, 85, 40));
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(150, 150));
		panel_1.setBackground((Color) null);
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnEmpleados = new JButton("Gestionar Personal");
		btnEmpleados.setFocusPainted(false);
		btnEmpleados.setBorder(null);
		btnEmpleados.setForeground(Color.WHITE);
		btnEmpleados.setBackground(new Color(62, 85, 40));
		panel_1.add(btnEmpleados);
		
		btnRoles = new JButton("Reportes Diarios");
		btnRoles.setFocusPainted(false);
		btnRoles.setBorder(null);
		btnRoles.setForeground(Color.WHITE);
		btnRoles.setBackground(new Color(62, 85, 40));
		panel_1.add(btnRoles);
		
		btnReportes = new JButton("Productos");
		btnReportes.setFocusPainted(false);
		btnReportes.setBorder(null);
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setBackground(new Color(62, 85, 40));
		panel_1.add(btnReportes);
	}
	
	public void setContenido(JComponent c, String titulo) {

		lblTitulo.setText(titulo);

		contenido.removeAll();

		if(c != null) {
			contenido.add(c, BorderLayout.CENTER);
		}

		contenido.repaint();
		contenido.revalidate();

	}
	
	public void init() {
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
