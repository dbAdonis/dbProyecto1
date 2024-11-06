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

public class Edit extends JPanel {
	public JTextField tNombre;
	public JTextField tCodigo;
	public JTextField tUnidad;
	public JTable tableProductos;
	public JComboBox cbxProductos;
	public JComboBox cbxTipos;
	public JComboBox cbxCategorias;
	public JButton btnActualizar;
	public JButton btnRegresar;

	/**
	 * Create the panel.
	 */
	public Edit() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnActualizar = new JButton("Actualizar");
		panel.add(btnActualizar);
		
		btnRegresar = new JButton("Regresar");
		panel.add(btnRegresar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 10));
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(null);
		
		JLabel lblNombre = new JLabel("Producto");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 11, 230, 14);
		panel_2.add(lblNombre);
		
		JLabel lblCdigo = new JLabel("Nombre");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigo.setBounds(10, 64, 230, 14);
		panel_2.add(lblCdigo);
		
		tNombre = new JTextField();
		tNombre.setColumns(10);
		tNombre.setBounds(10, 86, 230, 20);
		panel_2.add(tNombre);
		
		JLabel lblUnidadDeMedida = new JLabel("C\u00F3digo");
		lblUnidadDeMedida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUnidadDeMedida.setBounds(10, 117, 230, 14);
		panel_2.add(lblUnidadDeMedida);
		
		tCodigo = new JTextField();
		tCodigo.setColumns(10);
		tCodigo.setBounds(10, 139, 230, 20);
		panel_2.add(tCodigo);
		
		JLabel lblUnidadDeMedida_1 = new JLabel("Unidad de medida");
		lblUnidadDeMedida_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUnidadDeMedida_1.setBounds(10, 170, 230, 14);
		panel_2.add(lblUnidadDeMedida_1);
		
		tUnidad = new JTextField();
		tUnidad.setColumns(10);
		tUnidad.setBounds(10, 192, 230, 20);
		panel_2.add(tUnidad);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(10, 223, 230, 14);
		panel_2.add(lblTipo);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategora.setBounds(10, 276, 230, 14);
		panel_2.add(lblCategora);
		
		cbxProductos = new JComboBox();
		cbxProductos.setBounds(10, 33, 230, 20);
		panel_2.add(cbxProductos);
		
		cbxTipos = new JComboBox();
		cbxTipos.setBounds(10, 245, 230, 20);
		panel_2.add(cbxTipos);
		
		cbxCategorias = new JComboBox();
		cbxCategorias.setBounds(10, 297, 230, 20);
		panel_2.add(cbxCategorias);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		tableProductos = new JTable();
		scrollPane.setViewportView(tableProductos);

		
	}
}
