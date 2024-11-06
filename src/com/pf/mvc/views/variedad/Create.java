package com.pf.mvc.views.variedad;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class Create extends JPanel {
	public JTextField txtNombre;
	public JButton btnGuardar;

	
	public Create() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNombre.setBounds(30, 24, 90, 27);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(30, 66, 249, 43);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(30, 158, 107, 42);
		btnGuardar.setBackground(new Color(0, 140, 35));
		add(btnGuardar);

	}
}
