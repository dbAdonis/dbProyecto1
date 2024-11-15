package com.pf.mvc.views.aplicacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class Index extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField tBuscar;
	public JTable tableConsumo;
	public DefaultTableModel modelo;
	public JButton btnAgregarConsumo;
	public JButton btnEliminar;
	public JButton btnEditar;
	public JButton btnRegresar;
	public TableRowSorter<DefaultTableModel> filtro;

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
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBuscar.setBounds(10, 34, 54, 20);
		panel.add(lblBuscar);

		tBuscar = new JTextField();
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setBounds(74, 29, 235, 30);
		panel.add(tBuscar);
		tBuscar.setColumns(10);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		tableConsumo = new JTable(modelo);
		tableConsumo.setFont(new Font("Calibri", Font.PLAIN, 16));
		tableConsumo.setRowHeight(30);
		tableConsumo.setRowSorter(filtro);
		tableConsumo.setModel(modelo);

		JTableHeader header = tableConsumo.getTableHeader();
		header.setFont(new Font("Calibri", Font.BOLD, 16));
		scrollPane.setViewportView(tableConsumo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel_2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20, 0));
		add(panel_2, BorderLayout.SOUTH);

		btnAgregarConsumo = new JButton("Realizar nuevo reporte");
		btnAgregarConsumo.setPreferredSize(new Dimension(200, 40));
		btnAgregarConsumo.setBackground(new Color(0, 140, 35));
		btnAgregarConsumo.setForeground(Color.WHITE);
		btnAgregarConsumo.setBounds(30, 340, 107, 42);
		// btnAgregarConsumo.setBackground(SystemColor.inactiveCaptionBorder);
		// btnAgregarConsumo.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
		// null, Color.BLACK, null));
		btnAgregarConsumo.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnAgregarConsumo);

		btnEditar = new JButton("Editar");
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(255, 204, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
		// btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(217, 1, 1));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(30, 340, 107, 42);
		// btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnEliminar);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(100, 149, 237));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBounds(30, 340, 107, 42);
		// btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnRegresar);

	}
}
