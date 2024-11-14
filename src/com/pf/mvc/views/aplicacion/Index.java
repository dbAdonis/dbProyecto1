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
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Index extends JPanel {
	public JTextField tBuscar;
	public JTable tableConsumo;
	public DefaultTableModel modelo;
	public JButton btnAgregarConsumo;
	public JButton btnEliminar;
	public JButton btnEditar;
	public JButton btnRegresar;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 70));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblBuscar.setBounds(10, 41, 54, 14);
		panel.add(lblBuscar);
		
		tBuscar = new JTextField();
		tBuscar.setBounds(61, 39, 235, 20);
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
		
		btnAgregarConsumo = new JButton("Realizar nuevo reporte");
		btnAgregarConsumo.setPreferredSize(new Dimension(145, 23));
		btnAgregarConsumo.setBackground(SystemColor.inactiveCaptionBorder);
		btnAgregarConsumo.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnAgregarConsumo.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnAgregarConsumo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setPreferredSize(new Dimension(80, 23));
		btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setPreferredSize(new Dimension(80, 23));
		btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnEliminar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setPreferredSize(new Dimension(80, 23));
		btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
		btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnRegresar.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnRegresar);

	}
}
