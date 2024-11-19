package com.pf.mvc.views.empleado;

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
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Index extends JPanel {
	public JTable table;
	public JTextField tBuscar;
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public JButton btnEliminar;
	public JButton btnEditar;
	public JButton btnNuevo;
	public JComboBox cbxFinca;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setPreferredSize(new Dimension(10, 70));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(24, 25, 48, 20);
		panel_2.add(lblBuscar);
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));

		tBuscar = new JTextField();
		tBuscar.setBounds(91, 22, 370, 26);
		panel_2.add(tBuscar);
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setColumns(10);

		cbxFinca = new JComboBox();
		cbxFinca.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Todas" }));
		cbxFinca.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFinca.setBounds(552, 22, 112, 26);
		panel_2.add(cbxFinca);

		JLabel lblFinca = new JLabel("Finca: ");
		lblFinca.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblFinca.setBounds(500, 25, 42, 20);
		panel_2.add(lblFinca);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(10);
		panel_3.add(panel_4, BorderLayout.SOUTH);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setPreferredSize(new Dimension(90, 40));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBorder(null);
		btnNuevo.setBackground(new Color(39, 174, 96));
		panel_4.add(btnNuevo);

		btnEditar = new JButton("Editar");
		btnEditar.setBorder(null);
		btnEditar.setFocusPainted(false);
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
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
		btnEliminar.setBounds(30, 340, 107, 42);
		// btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_4.add(btnEliminar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_3.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setBorder(null);
		table.setRowSorter(filtro);
		table.setModel(modelo);

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.BOLD, 16));
		header.setBackground(new Color(62, 85, 40));
		scrollPane.setViewportView(table);
	}
}
