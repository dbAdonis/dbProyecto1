package com.pf.mvc.views.producto;

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
import java.awt.FlowLayout;

public class Index extends JPanel {
	public JTextField tBuscar;
	public JTable tableProductos;
	public DefaultTableModel modelo;
	public JButton btnAgregarProducto;
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
		lblBuscar.setBounds(10, 11, 155, 14);
		panel.add(lblBuscar);
		
		tBuscar = new JTextField();
		tBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		tBuscar.setBounds(10, 36, 683, 20);
		panel.add(tBuscar);
		tBuscar.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		
		tableProductos = new JTable();
		tableProductos.setModel(modelo);
		scrollPane.setViewportView(tableProductos);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		add(panel_2, BorderLayout.SOUTH);
		
		btnAgregarProducto = new JButton("Agregar producto");
		btnAgregarProducto.setPreferredSize(new Dimension(120, 23));
		btnAgregarProducto.setBackground(SystemColor.inactiveCaptionBorder);
		btnAgregarProducto.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnAgregarProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnAgregarProducto);
		
		btnEditar = new JButton("Editar");
		btnEditar.setPreferredSize(new Dimension(70, 23));
		btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setPreferredSize(new Dimension(70, 23));
		btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_2.add(btnEliminar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setPreferredSize(new Dimension(70, 23));
		btnRegresar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.add(btnRegresar);

	}
}
