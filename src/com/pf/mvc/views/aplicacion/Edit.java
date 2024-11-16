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
import javax.swing.border.EmptyBorder;

public class Edit extends JPanel {
	public JButton btnActualizar;
	public JButton btnCancelar;
	public DefaultTableModel modelo;
	public JTextField tUnidades;
	public JSpinner tPeriodoMPS;
	public JComboBox cbxLote;
	public JComboBox cbxVariedad;
	public JComboBox cbxLabor;
	public JComboBox cbxTrabajador;
	public JComboBox cbxFitoFerti;
	public JSpinner tCantidad;
	public JSpinner tWK;
	public JDateChooser tFecha;
	public JButton btnLotes;
	public JButton btnVariedades;
	public JButton btnTrabajadores;
	public JButton btnLabores;
	public JButton btnProductos;

	/**
	 * Create the panel.
	 */
	public Edit() {
		setPreferredSize(new Dimension(1080, 768));
		setLayout(new BorderLayout(0, 0));

		modelo = new DefaultTableModel();

		JPanel panelRegistro = new JPanel();
		add(panelRegistro, BorderLayout.CENTER);
		panelRegistro.setPreferredSize(new Dimension(10, 400));
		panelRegistro.setMinimumSize(new Dimension(10, 200));
		panelRegistro.setLayout(null);

		JLabel label = new JLabel("Perido MPS");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(20, 11, 80, 20);
		panelRegistro.add(label);

		tPeriodoMPS = new JSpinner();
		tPeriodoMPS.setPreferredSize(new Dimension(60, 20));
		tPeriodoMPS.setFont(new Font("Calibri", Font.PLAIN, 16));
		tPeriodoMPS.setBounds(125, 11, 60, 20);
		panelRegistro.add(tPeriodoMPS);

		JLabel label_1 = new JLabel("WK");
		label_1.setFont(new Font("Calibri", Font.BOLD, 16));
		label_1.setBounds(220, 11, 34, 20);
		panelRegistro.add(label_1);

		tWK = new JSpinner();
		tWK.setPreferredSize(new Dimension(60, 20));
		tWK.setFont(new Font("Calibri", Font.PLAIN, 16));
		tWK.setBounds(276, 11, 60, 20);
		panelRegistro.add(tWK);

		JLabel label_2 = new JLabel("Fecha");
		label_2.setFont(new Font("Calibri", Font.BOLD, 16));
		label_2.setBounds(362, 11, 49, 20);
		panelRegistro.add(label_2);

		tFecha = new JDateChooser();
		tFecha.setPreferredSize(new Dimension(100, 20));
		tFecha.setMinimumSize(new Dimension(80, 20));
		tFecha.setFont(new Font("Calibri", Font.PLAIN, 16));
		tFecha.setBounds(428, 11, 100, 20);
		panelRegistro.add(tFecha);

		JLabel label_3 = new JLabel("Lote");
		label_3.setFont(new Font("Calibri", Font.BOLD, 16));
		label_3.setBounds(20, 47, 80, 20);
		panelRegistro.add(label_3);

		cbxLote = new JComboBox();
		cbxLote.setPreferredSize(new Dimension(110, 20));
		cbxLote.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLote.setBounds(125, 47, 151, 20);
		panelRegistro.add(cbxLote);

		btnLotes = new JButton("Ver lista de lotes");
		btnLotes.setPreferredSize(new Dimension(145, 23));
		btnLotes.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnLotes.setFocusable(false);
		btnLotes.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnLotes.setBackground(SystemColor.inactiveCaptionBorder);
		btnLotes.setBounds(533, 46, 169, 23);
		panelRegistro.add(btnLotes);

		JLabel label_4 = new JLabel("Variedad");
		label_4.setFont(new Font("Calibri", Font.BOLD, 16));
		label_4.setBounds(20, 92, 80, 20);
		panelRegistro.add(label_4);

		cbxVariedad = new JComboBox();
		cbxVariedad.setPreferredSize(new Dimension(110, 20));
		cbxVariedad.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxVariedad.setBounds(125, 92, 150, 20);
		panelRegistro.add(cbxVariedad);

		btnVariedades = new JButton("Ver lista de variedades");
		btnVariedades.setPreferredSize(new Dimension(170, 23));
		btnVariedades.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnVariedades.setFocusable(false);
		btnVariedades.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnVariedades.setBackground(SystemColor.inactiveCaptionBorder);
		btnVariedades.setBounds(533, 91, 169, 23);
		panelRegistro.add(btnVariedades);

		btnTrabajadores = new JButton("Ver lista de trabajadores");
		btnTrabajadores.setPreferredSize(new Dimension(170, 23));
		btnTrabajadores.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnTrabajadores.setFocusable(false);
		btnTrabajadores.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnTrabajadores.setBackground(SystemColor.inactiveCaptionBorder);
		btnTrabajadores.setBounds(533, 136, 169, 23);
		panelRegistro.add(btnTrabajadores);

		cbxTrabajador = new JComboBox();
		cbxTrabajador.setPreferredSize(new Dimension(340, 20));
		cbxTrabajador.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTrabajador.setBounds(125, 137, 340, 20);
		panelRegistro.add(cbxTrabajador);

		JLabel label_5 = new JLabel("Trabajador");
		label_5.setFont(new Font("Calibri", Font.BOLD, 16));
		label_5.setBounds(20, 137, 80, 20);
		panelRegistro.add(label_5);

		JLabel label_6 = new JLabel("Labor");
		label_6.setFont(new Font("Calibri", Font.BOLD, 16));
		label_6.setBounds(20, 182, 80, 20);
		panelRegistro.add(label_6);

		cbxLabor = new JComboBox();
		cbxLabor.setPreferredSize(new Dimension(340, 20));
		cbxLabor.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLabor.setBounds(125, 182, 340, 20);
		panelRegistro.add(cbxLabor);

		btnLabores = new JButton("Ver lista de labores");
		btnLabores.setPreferredSize(new Dimension(145, 23));
		btnLabores.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnLabores.setFocusable(false);
		btnLabores.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnLabores.setBackground(SystemColor.inactiveCaptionBorder);
		btnLabores.setBounds(533, 181, 169, 23);
		panelRegistro.add(btnLabores);

		btnProductos = new JButton("Ver lista de productos");
		btnProductos.setPreferredSize(new Dimension(150, 23));
		btnProductos.setFont(new Font("Calibri", Font.ITALIC, 16));
		btnProductos.setFocusable(false);
		btnProductos.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.DARK_GRAY, null));
		btnProductos.setBackground(SystemColor.inactiveCaptionBorder);
		btnProductos.setBounds(533, 226, 169, 23);
		panelRegistro.add(btnProductos);

		cbxFitoFerti = new JComboBox();
		cbxFitoFerti.setPreferredSize(new Dimension(300, 20));
		cbxFitoFerti.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFitoFerti.setBounds(215, 227, 249, 20);
		panelRegistro.add(cbxFitoFerti);

		JLabel label_7 = new JLabel("Fitosanitario - Fertilizante");
		label_7.setFont(new Font("Calibri", Font.BOLD, 16));
		label_7.setBounds(20, 227, 175, 20);
		panelRegistro.add(label_7);

		JLabel label_8 = new JLabel("Cantidad");
		label_8.setFont(new Font("Calibri", Font.BOLD, 16));
		label_8.setBounds(20, 274, 80, 20);
		panelRegistro.add(label_8);

		tCantidad = new JSpinner();
		tCantidad.setPreferredSize(new Dimension(60, 20));
		tCantidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tCantidad.setBounds(125, 274, 60, 20);
		panelRegistro.add(tCantidad);

		JLabel label_9 = new JLabel("Unidades");
		label_9.setFont(new Font("Calibri", Font.BOLD, 16));
		label_9.setBounds(215, 274, 63, 20);
		panelRegistro.add(label_9);

		tUnidades = new JTextField();
		tUnidades.setFont(new Font("Calibri", Font.PLAIN, 16));
		tUnidades.setEditable(false);
		tUnidades.setColumns(10);
		tUnidades.setBounds(304, 271, 126, 26);
		panelRegistro.add(tUnidades);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(25, 334, 100, 40);
		panelRegistro.add(btnActualizar);
		btnActualizar.setFocusPainted(false);
		btnActualizar.setBorder(null);
		btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
		btnActualizar.setPreferredSize(new Dimension(100, 40));
		btnActualizar.setBackground(new Color(39, 174, 96));
		btnActualizar.setForeground(Color.WHITE);
		// btnAgregar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY,
		// null, Color.DARK_GRAY, null));
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(148, 334, 100, 40);
		panelRegistro.add(btnCancelar);
		btnCancelar.setBorder(null);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancelar.setPreferredSize(new Dimension(100, 40));
		btnCancelar.setBackground(new Color(52, 108, 175));
		btnCancelar.setForeground(Color.WHITE);
		// btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY,
		// null, Color.DARK_GRAY, null));
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 16));

	}

	public void setBtnLote(String imgButton) {

		ImageIcon imgBtn = new ImageIcon(getClass().getResource(imgButton));

		ImageIcon iconImgBtn = new ImageIcon(imgBtn.getImage().getScaledInstance(37, 34, Image.SCALE_DEFAULT));

	}
}
