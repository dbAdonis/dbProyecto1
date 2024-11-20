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
	public JComboBox cbxTrabajadores;
	public JComboBox cbxFitoFerti;
	public JSpinner tCantidad;
	public JSpinner tWK;
	public JDateChooser tFecha;
	private JLabel label_10;
	public JComboBox cbxFinca;
	private JLabel label_11;
	public JComboBox cbxSupervisor;

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
		label.setFont(new Font("Dialog", Font.BOLD, 19));
		label.setBounds(20, 11, 116, 20);
		panelRegistro.add(label);

		tPeriodoMPS = new JSpinner();
		tPeriodoMPS.setPreferredSize(new Dimension(60, 20));
		tPeriodoMPS.setFont(new Font("Calibri", Font.PLAIN, 16));
		tPeriodoMPS.setBounds(148, 15, 60, 20);
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
		label_2.setFont(new Font("Calibri", Font.BOLD, 19));
		label_2.setBounds(362, 11, 49, 20);
		panelRegistro.add(label_2);

		tFecha = new JDateChooser();
		tFecha.setPreferredSize(new Dimension(100, 20));
		tFecha.setMinimumSize(new Dimension(80, 20));
		tFecha.setFont(new Font("Calibri", Font.PLAIN, 16));
		tFecha.setBounds(423, 11, 105, 24);
		panelRegistro.add(tFecha);

		JLabel label_3 = new JLabel("Lote");
		label_3.setFont(new Font("Calibri", Font.BOLD, 19));
		label_3.setBounds(20, 47, 80, 20);
		panelRegistro.add(label_3);

		cbxLote = new JComboBox();
		cbxLote.setPreferredSize(new Dimension(110, 20));
		cbxLote.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLote.setBounds(135, 54, 168, 26);
		panelRegistro.add(cbxLote);

		JLabel label_4 = new JLabel("Variedad");
		label_4.setFont(new Font("Dialog", Font.BOLD, 19));
		label_4.setBounds(20, 92, 105, 20);
		panelRegistro.add(label_4);

		cbxVariedad = new JComboBox();
		cbxVariedad.setPreferredSize(new Dimension(110, 20));
		cbxVariedad.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxVariedad.setBounds(135, 93, 168, 26);
		panelRegistro.add(cbxVariedad);

		cbxTrabajadores = new JComboBox();
		cbxTrabajadores.setPreferredSize(new Dimension(340, 20));
		cbxTrabajadores.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTrabajadores.setBounds(135, 141, 340, 26);
		panelRegistro.add(cbxTrabajadores);

		JLabel label_5 = new JLabel("Trabajador");
		label_5.setFont(new Font("Dialog", Font.BOLD, 19));
		label_5.setBounds(20, 137, 105, 20);
		panelRegistro.add(label_5);

		JLabel label_6 = new JLabel("Labor");
		label_6.setFont(new Font("Dialog", Font.BOLD, 19));
		label_6.setBounds(20, 182, 105, 20);
		panelRegistro.add(label_6);

		cbxLabor = new JComboBox();
		cbxLabor.setPreferredSize(new Dimension(340, 20));
		cbxLabor.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLabor.setBounds(135, 186, 340, 26);
		panelRegistro.add(cbxLabor);

		cbxFitoFerti = new JComboBox();
		cbxFitoFerti.setPreferredSize(new Dimension(300, 20));
		cbxFitoFerti.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFitoFerti.setBounds(279, 231, 249, 26);
		panelRegistro.add(cbxFitoFerti);

		JLabel label_7 = new JLabel("Fitosanitario - Fertilizante");
		label_7.setFont(new Font("Dialog", Font.BOLD, 19));
		label_7.setBounds(20, 227, 243, 20);
		panelRegistro.add(label_7);

		JLabel label_8 = new JLabel("Cantidad");
		label_8.setFont(new Font("Dialog", Font.BOLD, 19));
		label_8.setBounds(20, 274, 105, 20);
		panelRegistro.add(label_8);

		tCantidad = new JSpinner();
		tCantidad.setPreferredSize(new Dimension(60, 20));
		tCantidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tCantidad.setBounds(125, 274, 60, 23);
		panelRegistro.add(tCantidad);

		JLabel label_9 = new JLabel("Unidades");
		label_9.setFont(new Font("Dialog", Font.BOLD, 19));
		label_9.setBounds(215, 274, -90, 20);
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
		
		label_10 = new JLabel("Finca");
		label_10.setFont(new Font("Calibri", Font.BOLD, 19));
		label_10.setBounds(553, 11, 49, 20);
		panelRegistro.add(label_10);
		
		cbxFinca = new JComboBox();
		cbxFinca.setPreferredSize(new Dimension(110, 20));
		cbxFinca.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFinca.setBounds(612, 11, 151, 26);
		panelRegistro.add(cbxFinca);
		
		label_11 = new JLabel("Supervisor");
		label_11.setFont(new Font("Calibri", Font.BOLD, 19));
		label_11.setBounds(786, 11, 85, 20);
		panelRegistro.add(label_11);
		
		cbxSupervisor = new JComboBox();
		cbxSupervisor.setPreferredSize(new Dimension(110, 20));
		cbxSupervisor.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxSupervisor.setBounds(877, 11, 151, 24);
		panelRegistro.add(cbxSupervisor);
		
		JLabel label_12 = new JLabel("Unidades");
		label_12.setFont(new Font("Calibri", Font.BOLD, 19));
		label_12.setBounds(215, 277, 77, 20);
		panelRegistro.add(label_12);

	}

	public void setBtnLote(String imgButton) {

		ImageIcon imgBtn = new ImageIcon(getClass().getResource(imgButton));

		ImageIcon iconImgBtn = new ImageIcon(imgBtn.getImage().getScaledInstance(37, 34, Image.SCALE_DEFAULT));

	}
}