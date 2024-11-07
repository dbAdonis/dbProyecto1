package com.pf.mvc.views.general;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JPanel {
	private JTextField tNombre;

	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(113, 92, 75, 15);
		panel.add(lblNombre);
		
		tNombre = new JTextField();
		tNombre.setBounds(113, 118, 240, 20);
		panel.add(tNombre);
		tNombre.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBounds(180, 161, 89, 23);
		panel.add(btnRegistrar);

	}
}
