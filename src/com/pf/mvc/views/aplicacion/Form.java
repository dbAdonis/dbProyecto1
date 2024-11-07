package com.pf.mvc.views.aplicacion;

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

public class Form extends JPanel {
	public JTextField tWK;
	public JTable tableProductos;
	public JComboBox cbxVariedad;
	public JComboBox cbxTrabajador;
	public JButton btnAgregar;
	public JButton btnRegresar;
	private JTextField tPeriodoMPS;
	private JTextField tCantidad;
	private JComboBox cbxFecha;
	private JComboBox cbxLote;
	private JComboBox cbxLabor;
	private JComboBox cbxFitoFerti;
	private JComboBox cbxUnidades;
	private JComboBox cbxControl;

	/**
	 * Create the panel.
	 */
	public Form() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar);
		
		btnRegresar = new JButton("Regresar");
		panel.add(btnRegresar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 10));
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(null);
		
		JLabel lblNombre = new JLabel("Perido MPS");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(10, 11, 230, 14);
		panel_2.add(lblNombre);
		
		JLabel lblCdigo = new JLabel("WK");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCdigo.setBounds(10, 64, 230, 14);
		panel_2.add(lblCdigo);
		
		tWK = new JTextField();
		tWK.setColumns(10);
		tWK.setBounds(10, 86, 230, 20);
		panel_2.add(tWK);
		
		JLabel lblUnidadDeMedida = new JLabel("Fecha");
		lblUnidadDeMedida.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnidadDeMedida.setBounds(10, 117, 230, 14);
		panel_2.add(lblUnidadDeMedida);
		
		JLabel lblUnidadDeMedida_1 = new JLabel("Lote");
		lblUnidadDeMedida_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnidadDeMedida_1.setBounds(10, 170, 230, 14);
		panel_2.add(lblUnidadDeMedida_1);
		
		JLabel lblTipo = new JLabel("Variedad");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo.setBounds(10, 223, 230, 14);
		panel_2.add(lblTipo);
		
		JLabel lblCategora = new JLabel("Trabajador");
		lblCategora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategora.setBounds(10, 276, 230, 14);
		panel_2.add(lblCategora);
		
		cbxVariedad = new JComboBox();
		cbxVariedad.setBounds(10, 245, 230, 20);
		panel_2.add(cbxVariedad);
		
		cbxTrabajador = new JComboBox();
		cbxTrabajador.setBounds(10, 297, 230, 20);
		panel_2.add(cbxTrabajador);
		
		JLabel lblLabor = new JLabel("Labor");
		lblLabor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLabor.setBounds(10, 330, 230, 14);
		panel_2.add(lblLabor);
		
		JLabel lblFito = new JLabel("Fitosanitario - Fertilizante");
		lblFito.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFito.setBounds(10, 392, 230, 14);
		panel_2.add(lblFito);
		
		cbxLabor = new JComboBox();
		cbxLabor.setBounds(10, 357, 230, 20);
		panel_2.add(cbxLabor);
		
		cbxFitoFerti = new JComboBox();
		cbxFitoFerti.setBounds(10, 419, 230, 20);
		panel_2.add(cbxFitoFerti);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(10, 452, 230, 14);
		panel_2.add(lblCantidad);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnidades.setBounds(10, 512, 230, 14);
		panel_2.add(lblUnidades);
		
		cbxUnidades = new JComboBox();
		cbxUnidades.setBounds(10, 539, 230, 20);
		panel_2.add(cbxUnidades);
		
		JLabel lblControl = new JLabel("Control");
		lblControl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblControl.setBounds(10, 572, 230, 14);
		panel_2.add(lblControl);
		
		cbxControl = new JComboBox();
		cbxControl.setBounds(10, 619, 230, 20);
		panel_2.add(cbxControl);
		
		tPeriodoMPS = new JTextField();
		tPeriodoMPS.setColumns(10);
		tPeriodoMPS.setBounds(10, 31, 230, 20);
		panel_2.add(tPeriodoMPS);
		
		tCantidad = new JTextField();
		tCantidad.setColumns(10);
		tCantidad.setBounds(10, 479, 230, 20);
		panel_2.add(tCantidad);
		
		cbxFecha = new JComboBox();
		cbxFecha.setBounds(10, 144, 230, 20);
		panel_2.add(cbxFecha);
		
		cbxLote = new JComboBox();
		cbxLote.setBounds(10, 190, 230, 20);
		panel_2.add(cbxLote);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 586, 230, 20);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		tableProductos = new JTable();
		scrollPane.setViewportView(tableProductos);

		
	}
}