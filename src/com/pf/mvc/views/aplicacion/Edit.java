package com.pf.mvc.views.aplicacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Insets;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class Edit extends JPanel {
	public JComboBox cbxVariedad;
	public JComboBox cbxTrabajador;
	public JButton btnActualizar;
	public JButton btnRegresar;
	public JComboBox cbxLote;
	public JComboBox cbxLabor;
	public JComboBox cbxFitoFerti;
	public JDateChooser tFecha;
	public JTextField tUnidades;
	public JSpinner tPeriodoMPS;
	public JSpinner tWK;
	public JSpinner tCantidad;
	public DefaultTableModel modelo;
	public JTable table;
	public JButton btnLotes;
	public JButton btnVariedades;
	public JButton btnEmpleados;
	public JButton btnLabores;
	public JButton btnProductos;

	/**
	 * Create the panel.
	 */
	public Edit() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBorder(null);
		btnActualizar.setBorderPainted(false);
		//btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
		btnActualizar.setPreferredSize(new Dimension(130, 40));
		btnActualizar.setBackground(new Color(39, 174, 96));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBounds(30, 340, 107, 42);
		//btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel.add(btnActualizar);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setBorder(null);
		btnRegresar.setBorderPainted(false);
		//btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
		btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(52, 108, 175));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBounds(30, 340, 107, 42);
		//btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel.add(btnRegresar);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(12);
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_5.setPreferredSize(new Dimension(10, 45));
		panel_4.add(panel_5, BorderLayout.NORTH);

		JLabel lblNombre = new JLabel("Perido MPS");
		panel_5.add(lblNombre);
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));

		tPeriodoMPS = new JSpinner();
		tPeriodoMPS.setFont(new Font("Calibri", Font.PLAIN, 16));
		tPeriodoMPS.setPreferredSize(new Dimension(60, 20));
		panel_5.add(tPeriodoMPS);

		JLabel lblCdigo = new JLabel("WK");
		panel_5.add(lblCdigo);
		lblCdigo.setFont(new Font("Calibri", Font.BOLD, 16));

		tWK = new JSpinner();
		tWK.setFont(new Font("Calibri", Font.PLAIN, 16));
		tWK.setPreferredSize(new Dimension(60, 20));
		panel_5.add(tWK);

		JLabel lblUnidadDeMedida = new JLabel("Fecha");
		panel_5.add(lblUnidadDeMedida);
		lblUnidadDeMedida.setFont(new Font("Calibri", Font.BOLD, 16));

		tFecha = new JDateChooser();
		tFecha.setFont(new Font("Calibri", Font.PLAIN, 16));
		tFecha.setMinimumSize(new Dimension(80, 20));
		panel_5.add(tFecha);
		tFecha.setPreferredSize(new Dimension(100, 20));

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		flowLayout_1.setVgap(12);
		flowLayout_1.setHgap(20);
		panel_7.setPreferredSize(new Dimension(10, 45));
		panel_6.add(panel_7, BorderLayout.NORTH);

		JLabel lblUnidadDeMedida_1 = new JLabel("Lote");
		panel_7.add(lblUnidadDeMedida_1);
		lblUnidadDeMedida_1.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxLote = new JComboBox();
		cbxLote.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLote.setPreferredSize(new Dimension(110, 20));
		panel_7.add(cbxLote);

		btnLotes = new JButton("Ver lista de lotes");
		btnLotes.setBackground(SystemColor.inactiveCaptionBorder);
		btnLotes.setFocusable(false);
		btnLotes.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnLotes.setPreferredSize(new Dimension(145, 23));
		btnLotes.setFont(new Font("Calibri", Font.ITALIC, 16));
		panel_7.add(btnLotes);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_9.setPreferredSize(new Dimension(10, 45));
		FlowLayout flowLayout_2 = (FlowLayout) panel_9.getLayout();
		flowLayout_2.setVgap(12);
		flowLayout_2.setHgap(20);
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		panel_8.add(panel_9, BorderLayout.NORTH);

		JLabel lblTipo = new JLabel("Variedad");
		panel_9.add(lblTipo);
		lblTipo.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxVariedad = new JComboBox();
		cbxVariedad.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxVariedad.setPreferredSize(new Dimension(150, 20));
		panel_9.add(cbxVariedad);

		btnVariedades = new JButton("Ver lista de variedades");
		btnVariedades.setBackground(SystemColor.inactiveCaptionBorder);
		btnVariedades.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnVariedades.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnVariedades.setFocusable(false);
		btnVariedades.setPreferredSize(new Dimension(170, 23));
		panel_9.add(btnVariedades);

		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_11.setPreferredSize(new Dimension(10, 45));
		FlowLayout flowLayout_3 = (FlowLayout) panel_11.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEADING);
		flowLayout_3.setVgap(12);
		flowLayout_3.setHgap(20);
		panel_10.add(panel_11, BorderLayout.NORTH);

		JLabel lblCategora = new JLabel("Trabajador");
		panel_11.add(lblCategora);
		lblCategora.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxTrabajador = new JComboBox();
		cbxTrabajador.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTrabajador.setPreferredSize(new Dimension(340, 20));
		panel_11.add(cbxTrabajador);

		btnEmpleados = new JButton("Ver lista de trabajadores");
		btnEmpleados.setBackground(SystemColor.inactiveCaptionBorder);
		btnEmpleados.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnEmpleados.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnEmpleados.setFocusable(false);
		btnEmpleados.setPreferredSize(new Dimension(170, 23));
		panel_11.add(btnEmpleados);

		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_13.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		FlowLayout flowLayout_4 = (FlowLayout) panel_13.getLayout();
		flowLayout_4.setVgap(12);
		flowLayout_4.setHgap(20);
		flowLayout_4.setAlignment(FlowLayout.LEADING);
		panel_13.setPreferredSize(new Dimension(10, 45));
		panel_12.add(panel_13, BorderLayout.NORTH);

		JLabel lblLabor = new JLabel("Labor");
		panel_13.add(lblLabor);
		lblLabor.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxLabor = new JComboBox();
		cbxLabor.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLabor.setPreferredSize(new Dimension(340, 20));
		panel_13.add(cbxLabor);

		btnLabores = new JButton("Ver lista de labores");
		btnLabores.setBackground(SystemColor.inactiveCaptionBorder);
		btnLabores.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnLabores.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnLabores.setFocusable(false);
		btnLabores.setPreferredSize(new Dimension(145, 23));
		panel_13.add(btnLabores);

		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_15.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		FlowLayout flowLayout_5 = (FlowLayout) panel_15.getLayout();
		flowLayout_5.setVgap(12);
		flowLayout_5.setHgap(20);
		flowLayout_5.setAlignment(FlowLayout.LEADING);
		panel_15.setPreferredSize(new Dimension(10, 45));
		panel_14.add(panel_15, BorderLayout.NORTH);

		JLabel lblFito = new JLabel("Fitosanitario - Fertilizante");
		panel_15.add(lblFito);
		lblFito.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxFitoFerti = new JComboBox();
		cbxFitoFerti.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFitoFerti.setPreferredSize(new Dimension(300, 20));
		panel_15.add(cbxFitoFerti);

		btnProductos = new JButton("Ver lista de productos");
		btnProductos.setBackground(SystemColor.inactiveCaptionBorder);
		btnProductos.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnProductos.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnProductos.setFocusable(false);
		btnProductos.setPreferredSize(new Dimension(150, 23));
		panel_15.add(btnProductos);

		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		panel_17.setOpaque(false);
		panel_17.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		FlowLayout flowLayout_6 = (FlowLayout) panel_17.getLayout();
		flowLayout_6.setVgap(12);
		flowLayout_6.setHgap(20);
		flowLayout_6.setAlignment(FlowLayout.LEADING);
		panel_17.setPreferredSize(new Dimension(10, 45));
		panel_16.add(panel_17, BorderLayout.NORTH);

		JLabel lblCantidad = new JLabel("Cantidad");
		panel_17.add(lblCantidad);
		lblCantidad.setFont(new Font("Calibri", Font.BOLD, 16));

		tCantidad = new JSpinner();
		tCantidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tCantidad.setPreferredSize(new Dimension(60, 20));
		panel_17.add(tCantidad);

		JLabel lblUnidades = new JLabel("Unidades");
		panel_17.add(lblUnidades);
		lblUnidades.setFont(new Font("Calibri", Font.BOLD, 16));

		tUnidades = new JTextField();
		tUnidades.setEditable(false);
		tUnidades.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_17.add(tUnidades);
		tUnidades.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_16.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_3.add(lblTitulo);

		JPanel panelContenido = new JPanel();
		panel_2.add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelContenido.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();

		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);

	}

	public void setBtnLote(String imgButton) {

		ImageIcon imgBtn = new ImageIcon(getClass().getResource(imgButton));

		ImageIcon iconImgBtn = new ImageIcon(imgBtn.getImage().getScaledInstance(37, 34, Image.SCALE_DEFAULT));

	}
}
