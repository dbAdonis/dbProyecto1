package com.pf.mvc.views.general;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Edit extends JPanel {
	private JTextField tNombre;

	/**
	 * Create the panel.
	 */
	public Edit() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNombre.setBounds(105, 98, 57, 14);
		panel.add(lblNombre);
		
		tNombre = new JTextField();
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		tNombre.setBounds(105, 123, 247, 20);
		panel.add(tNombre);
		tNombre.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFocusPainted(false);
		btnEditar.setBorder(null);
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
		btnEditar.setBounds(194, 154, 79, 23);
		panel.add(btnEditar);
	}
}
