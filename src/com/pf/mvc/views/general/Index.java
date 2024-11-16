package com.pf.mvc.views.general;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Index extends JPanel {
	public JTable table;
	public JTextField tBuscar;
	public JTextField tNombre;
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public JButton btnRegresar;
	public JButton btnEliminar;
	public JButton btnEditar;
	public JButton btnGuardar;
	public JLabel lblTitulo;
	public JButton btnActualizar;
	public JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 70));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setPreferredSize(new Dimension(41, 14));
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBuscar.setBounds(10, 27, 55, 14);
		panel_2.add(lblBuscar);

		tBuscar = new JTextField();
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setBounds(75, 25, 390, 20);
		panel_2.add(tBuscar);
		tBuscar.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.SOUTH);

		btnEditar = new JButton("Editar");
		btnEditar.setBorder(null);
		btnEditar.setFocusPainted(false);
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		// btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_4.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBorder(null);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
		// btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_4.add(btnEliminar);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setBorder(null);
		btnRegresar.setFocusPainted(false);
		btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(52, 108, 175));
		btnRegresar.setForeground(Color.WHITE);
		// btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_4.add(btnRegresar);

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable();
		table.setModel(modelo);
		table.setRowSorter(filtro);
		table.setFont(new Font("Calibri", Font.PLAIN, 16));

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.PLAIN, 16));

		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 105));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 880, 17);
		panel.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNombre.setBounds(10, 56, 55, 14);
		panel.add(lblNombre);

		tNombre = new JTextField();
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		tNombre.setColumns(10);
		tNombre.setBounds(75, 54, 390, 20);
		panel.add(tNombre);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFocusPainted(false);
		btnGuardar.setBorder(null);
		btnGuardar.setPreferredSize(new Dimension(200, 40));
		btnGuardar.setBackground(new Color(39, 174, 96));
		btnGuardar.setForeground(Color.WHITE);
		// btnRegistrar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnRegistrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnGuardar.setFont(new Font("Calibri", Font.BOLD, 16));
		btnGuardar.setBounds(486, 53, 94, 25);
		panel.add(btnGuardar);

		btnActualizar = new JButton("Actualizar");
		// btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
		// null, Color.BLACK, null));
		btnActualizar.setEnabled(false);
		btnActualizar.setVisible(false);
		btnActualizar.setPreferredSize(new Dimension(200, 40));
		btnActualizar.setBackground(new Color(39, 174, 96));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
		btnActualizar.setBounds(486, 53, 94, 25);
		panel.add(btnActualizar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(null);
		// btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnCancelar.setEnabled(false);
		btnCancelar.setVisible(false);
		btnCancelar.setPreferredSize(new Dimension(100, 40));
		btnCancelar.setBackground(new Color(52, 108, 175));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 16));
		btnCancelar.setBounds(593, 53, 94, 25);
		panel.add(btnCancelar);
	}
}
