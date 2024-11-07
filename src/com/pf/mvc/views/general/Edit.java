package com.pf.mvc.views.general;

import javax.swing.JPanel;
import java.awt.BorderLayout;
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
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(105, 98, 57, 14);
		panel.add(lblNombre);
		
		tNombre = new JTextField();
		tNombre.setBounds(105, 123, 247, 20);
		panel.add(tNombre);
		tNombre.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(194, 154, 65, 23);
		panel.add(btnEditar);

	}

}
