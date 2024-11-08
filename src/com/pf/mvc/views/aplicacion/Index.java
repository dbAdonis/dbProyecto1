package com.pf.mvc.views.aplicacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;

public class Index extends JPanel {
	public JTextField tBuscar;
	public JTable tableConsumo;
	public DefaultTableModel modelo;
	public JButton btnAgregarConsumo;
	public JButton btnEliminar;
	public JButton btnEditar;

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 70));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscar.setBounds(10, 11, 155, 14);
		panel.add(lblBuscar);
		
		tBuscar = new JTextField();
		tBuscar.setBounds(10, 36, 683, 20);
		panel.add(tBuscar);
		tBuscar.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		
		tableConsumo = new JTable();
		tableConsumo.setModel(modelo);
		scrollPane.setViewportView(tableConsumo);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		btnAgregarConsumo = new JButton("Agregar Consumo");
		panel_2.add(btnAgregarConsumo);
		
		btnEditar = new JButton("Editar");
		panel_2.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		panel_2.add(btnEliminar);

	}
}
