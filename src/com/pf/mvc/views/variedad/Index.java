package com.pf.mvc.views.variedad;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Index extends JPanel {
	
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public JTable table;
	
	public JButton btnNuevo;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JTextField tBuscar;
	public JButton btnBuscar;

	
	public Index() {
		setPreferredSize(new Dimension(500, 500));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
        table = new JTable(modelo);
        table.setRowSorter(filtro);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBackground(new Color(0, 132, 179));
		panel.add(btnNuevo);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(new Color(217, 162, 1));
		panel.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(217, 1, 1));
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		tBuscar = new JTextField();
		tBuscar.setText("Buscar..");
		tBuscar.setBounds(new Rectangle(0, 20, 0, 0));
		tBuscar.setPreferredSize(new Dimension(100, 22));
		panel_1.add(tBuscar, BorderLayout.CENTER);
		tBuscar.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		panel_1.add(btnBuscar, BorderLayout.EAST);
		btnBuscar.setBackground(new Color(1, 104, 140));

	}

}
