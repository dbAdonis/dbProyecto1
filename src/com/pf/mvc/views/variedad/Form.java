package com.pf.mvc.views.variedad;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Form extends JPanel {
	public JTextField tNombre;
	public JTable tableProductos;
	public JButton btnAgregar;
	public JButton btnRegresar;

	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar);
		
		btnRegresar = new JButton("Regresar");
		panel.add(btnRegresar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 10));
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(null);
		
		JLabel lblCdigo = new JLabel("Nombre");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCdigo.setBounds(10, 145, 230, 14);
		panel_2.add(lblCdigo);
		
		tNombre = new JTextField();
		tNombre.setColumns(10);
		tNombre.setBounds(10, 184, 230, 29);
		panel_2.add(tNombre);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		tableProductos = new JTable();
		scrollPane.setViewportView(tableProductos);

		
	}
}
