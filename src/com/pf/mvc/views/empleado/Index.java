package com.pf.mvc.views.empleado;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class Index extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton btnNuevo;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JTextField tBuscar;
	
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public JTable table;
	
	private JPanel panel;
	private JPanel panel_1;
	

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable(modelo);
		table.setBounds(273, 195, 1, 1);
		table.setRowSorter(filtro);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(620, 300));
		add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("+Nueva");
		panel.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_1, BorderLayout.NORTH);
		
		JLabel lblBuscar = new JLabel("Buscar");
		panel_1.add(lblBuscar);
		
		tBuscar = new JTextField();
		panel_1.add(tBuscar);
		tBuscar.setColumns(10);

	}
}
