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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.models.vo.Labor;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Producto;
import com.pf.mvc.models.vo.Supervisor;
import com.pf.mvc.models.vo.Variedad;
import com.toedter.calendar.JDateChooser;

import java.awt.Insets;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;

public class Form extends JPanel {
	public JButton btnGuardar;
	public JButton btnCancelar;
	public JTextField tUnidades;
	public JSpinner tWK;
	public JSpinner tPeriodoMPS;
	public JDateChooser tFecha;
	public JComboBox<Variedad> cbxVariedades;
	public JComboBox<Empleado> cbxTrabajadores;
	public JComboBox<Labor> cbxLabores;
	public JComboBox<Producto> cbxFitoFerti;
	public JSpinner tCantidad;
	public JComboBox<Lote> cbxLotes;
	public JComboBox<Finca> cbxFinca;
	public JComboBox<Supervisor> cbxSupervisor;

	/**
	 * Create the panel.
	 */
	public Form() {
		setPreferredSize(new Dimension(1080, 768));
		setLayout(new BorderLayout(0, 0));

		JPanel panelRegistro = new JPanel();
		add(panelRegistro, BorderLayout.CENTER);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setPreferredSize(new Dimension(10, 400));
		panelRegistro.setMinimumSize(new Dimension(10, 200));
		panelRegistro.setLayout(null);

		JLabel label = new JLabel("Perido MPS");
		label.setFont(new Font("Calibri", Font.BOLD, 19));
		label.setBounds(20, 11, 93, 20);
		panelRegistro.add(label);

		tPeriodoMPS = new JSpinner();
		tPeriodoMPS.setPreferredSize(new Dimension(60, 20));
		tPeriodoMPS.setFont(new Font("Calibri", Font.PLAIN, 16));
		tPeriodoMPS.setBounds(125, 9, 60, 26);
		panelRegistro.add(tPeriodoMPS);

		JLabel label_1 = new JLabel("WK");
		label_1.setFont(new Font("Calibri", Font.BOLD, 19));
		label_1.setBounds(220, 11, 34, 20);
		panelRegistro.add(label_1);

		tWK = new JSpinner();
		tWK.setPreferredSize(new Dimension(60, 20));
		tWK.setFont(new Font("Calibri", Font.PLAIN, 16));
		tWK.setBounds(274, 9, 60, 26);
		panelRegistro.add(tWK);

		JLabel label_2 = new JLabel("Fecha");
		label_2.setFont(new Font("Calibri", Font.BOLD, 19));
		label_2.setBounds(362, 11, 60, 20);
		panelRegistro.add(label_2);

		tFecha = new JDateChooser();
		tFecha.setPreferredSize(new Dimension(100, 20));
		tFecha.setMinimumSize(new Dimension(80, 20));
		tFecha.setFont(new Font("Calibri", Font.PLAIN, 16));
		tFecha.setBounds(428, 11, 113, 26);
		panelRegistro.add(tFecha);

		JLabel label_3 = new JLabel("Lote");
		label_3.setFont(new Font("Calibri", Font.BOLD, 19));
		label_3.setBounds(20, 47, 80, 20);
		panelRegistro.add(label_3);

		cbxLotes = new JComboBox<Lote>();
		cbxLotes.setPreferredSize(new Dimension(110, 20));
		cbxLotes.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLotes.setBounds(125, 47, 151, 26);
		panelRegistro.add(cbxLotes);

		AutoCompleteDecorator.decorate(cbxLotes);

		JLabel label_4 = new JLabel("Variedad");
		label_4.setFont(new Font("Calibri", Font.BOLD, 19));
		label_4.setBounds(20, 92, 80, 20);
		panelRegistro.add(label_4);

		cbxVariedades = new JComboBox<Variedad>();
		cbxVariedades.setPreferredSize(new Dimension(110, 20));
		cbxVariedades.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxVariedades.setBounds(125, 92, 150, 26);
		panelRegistro.add(cbxVariedades);

		AutoCompleteDecorator.decorate(cbxVariedades);

		cbxTrabajadores = new JComboBox<Empleado>();
		cbxTrabajadores.setPreferredSize(new Dimension(340, 20));
		cbxTrabajadores.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTrabajadores.setBounds(125, 137, 340, 26);
		panelRegistro.add(cbxTrabajadores);

		AutoCompleteDecorator.decorate(cbxTrabajadores);

		JLabel label_5 = new JLabel("Trabajador");
		label_5.setFont(new Font("Calibri", Font.BOLD, 19));
		label_5.setBounds(20, 137, 93, 20);
		panelRegistro.add(label_5);

		JLabel label_6 = new JLabel("Labor");
		label_6.setFont(new Font("Calibri", Font.BOLD, 19));
		label_6.setBounds(20, 182, 80, 20);
		panelRegistro.add(label_6);

		cbxLabores = new JComboBox<Labor>();
		cbxLabores.setPreferredSize(new Dimension(340, 20));
		cbxLabores.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxLabores.setBounds(125, 182, 340, 26);
		panelRegistro.add(cbxLabores);

		AutoCompleteDecorator.decorate(cbxLabores);

		cbxFitoFerti = new JComboBox<Producto>();
		cbxFitoFerti.setPreferredSize(new Dimension(300, 20));
		cbxFitoFerti.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFitoFerti.setBounds(251, 225, 249, 26);
		panelRegistro.add(cbxFitoFerti);

		AutoCompleteDecorator.decorate(cbxFitoFerti);

		JLabel label_7 = new JLabel("Fitosanitario - Fertilizante");
		label_7.setFont(new Font("Calibri", Font.BOLD, 19));
		label_7.setBounds(20, 227, 221, 20);
		panelRegistro.add(label_7);

		JLabel label_8 = new JLabel("Cantidad");
		label_8.setFont(new Font("Calibri", Font.BOLD, 19));
		label_8.setBounds(20, 274, 80, 20);
		panelRegistro.add(label_8);

		tCantidad = new JSpinner();
		tCantidad.setPreferredSize(new Dimension(60, 20));
		tCantidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tCantidad.setBounds(125, 272, 60, 26);
		panelRegistro.add(tCantidad);

		JLabel label_9 = new JLabel("Unidades");
		label_9.setFont(new Font("Calibri", Font.BOLD, 19));
		label_9.setBounds(215, 274, 77, 20);
		panelRegistro.add(label_9);

		tUnidades = new JTextField();
		tUnidades.setFont(new Font("Calibri", Font.PLAIN, 16));
		tUnidades.setEditable(false);
		tUnidades.setColumns(10);
		tUnidades.setBounds(302, 272, 126, 26);
		panelRegistro.add(tUnidades);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(25, 334, 100, 40);
		panelRegistro.add(btnGuardar);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(SystemColor.inactiveCaptionBorder);
		btnGuardar.setPreferredSize(new Dimension(100, 40));
		btnGuardar.setBackground(new Color(39, 174, 96));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Calibri", Font.BOLD, 19));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(148, 334, 100, 40);
		panelRegistro.add(btnCancelar);
		btnCancelar.setBorder(null);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancelar.setPreferredSize(new Dimension(100, 40));
		btnCancelar.setBackground(new Color(52, 108, 175));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 19));

		JLabel lblFinca = new JLabel("Finca");
		lblFinca.setFont(new Font("Calibri", Font.BOLD, 19));
		lblFinca.setBounds(553, 11, 47, 20);
		panelRegistro.add(lblFinca);

		cbxFinca = new JComboBox<Finca>();
		cbxFinca.setPreferredSize(new Dimension(110, 20));
		cbxFinca.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFinca.setBounds(612, 11, 151, 26);
		panelRegistro.add(cbxFinca);

		AutoCompleteDecorator.decorate(cbxFinca);

		cbxSupervisor = new JComboBox<Supervisor>();
		cbxSupervisor.setPreferredSize(new Dimension(110, 20));
		cbxSupervisor.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxSupervisor.setBounds(889, 12, 151, 26);
		panelRegistro.add(cbxSupervisor);

		AutoCompleteDecorator.decorate(cbxSupervisor);

		JLabel lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setFont(new Font("Calibri", Font.BOLD, 19));
		lblSupervisor.setBounds(786, 11, 91, 20);
		panelRegistro.add(lblSupervisor);

	}

	public void setBtnLote(String imgButton) {

		ImageIcon imgBtn = new ImageIcon(getClass().getResource(imgButton));

		ImageIcon iconImgBtn = new ImageIcon(imgBtn.getImage().getScaledInstance(37, 34, Image.SCALE_DEFAULT));

	}
}