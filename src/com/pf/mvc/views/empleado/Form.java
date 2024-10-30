package com.pf.mvc.views.empleado;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.pf.mvc.models.vo.Empleado;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Form extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	public JButton btnRegistrar;
	public JButton btnEliminarDetalle;
	public JLabel lblTotal;
	public JTextField txtFecha;
	public JTextField txtCliente;
	public JButton btnNuevaFactura;
	public JComboBox<Empleado> cbxProducto;
	public JTextField txtCantidad;
	public JTable table;
	public JButton btnActualizar;
	public JButton btnEliminar;
	public JButton btnAgregarDetalle;
	public DefaultTableModel modelo;

	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 180, 144);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnNuevaFactura = new JButton("Nueva Factura");
		btnNuevaFactura.setBounds(10, 11, 160, 23);
		panel_4.add(btnNuevaFactura);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 45, 46, 14);
		panel_4.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(10, 61, 160, 23);
		panel_4.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 95, 46, 14);
		panel_4.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(10, 111, 160, 23);
		panel_4.add(txtCliente);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 166, 180, 262);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblDetallesDeLa = new JLabel("Detalles de la Factura");
		lblDetallesDeLa.setBounds(10, 11, 160, 14);
		panel_5.add(lblDetallesDeLa);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 34, 46, 14);
		panel_5.add(lblProducto);
		
		cbxProducto = new JComboBox<Empleado>();
		cbxProducto.setBounds(10, 59, 160, 20);
		panel_5.add(cbxProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 98, 46, 14);
		panel_5.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(10, 123, 160, 20);
		panel_5.add(txtCantidad);
		
		btnAgregarDetalle = new JButton("AGREGAR DETALLE");
		btnAgregarDetalle.setBounds(10, 194, 160, 23);
		panel_5.add(btnAgregarDetalle);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnRegistrar = new JButton("Registrar");
		panel_1.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		panel_1.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		panel_1.add(btnEliminar);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		btnEliminarDetalle = new JButton("Eliminar Detalle");
		panel_3.add(btnEliminarDetalle);
		
		JLabel lblTrxto = new JLabel("Total: ");
		panel_3.add(lblTrxto);
		
		lblTotal = new JLabel("0");
		panel_3.add(lblTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

	}
}
