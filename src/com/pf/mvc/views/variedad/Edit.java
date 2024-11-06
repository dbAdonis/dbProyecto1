package com.pf.mvc.views.variedad;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class Edit extends JPanel {
	public JTextField txtNombre;
	public JButton btnGuardar;
	public JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public Edit() {
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
		btnGuardar.setBounds(30, 162, 107, 42);
		btnGuardar.setBackground(new Color(0, 140, 35));
		add(btnGuardar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(217, 1, 1));
		btnEliminar.setBounds(149, 162, 107, 42);
		add(btnEliminar);

	}
}
