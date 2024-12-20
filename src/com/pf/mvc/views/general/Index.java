package com.pf.mvc.views.general;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.pf.mvc.views.borde.BotonRedondeado;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class Index extends JPanel {
	public JTable table;
	public JTextField tBuscar;
	public JTextField tNombre;
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public BotonRedondeado btnEliminar;
	public BotonRedondeado btnEditar;
	public BotonRedondeado btnGuardar;
	public JLabel lblTitulo;
	public JButton btnActualizar;
	public JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(1015, 645));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 70));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setPreferredSize(new Dimension(41, 14));
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblBuscar.setBounds(10, 27, 61, 19);
		panel_2.add(lblBuscar);

		tBuscar = new JTextField();
		tBuscar.setBorder(null);
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setBounds(77, 19, 456, 32);
		panel_2.add(tBuscar);
		tBuscar.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(7, 7, 7, 7));
		panel_3.setBackground(SystemColor.text);
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 220, 220));
		panel_4.setBorder(new EmptyBorder(10, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(10);
		panel_3.add(panel_4, BorderLayout.SOUTH);

		btnEditar = new BotonRedondeado("Editar", 20);
		//btnEditar.setBorder(new LineBorder(new Color(255, 140, 0), 3));
		//btnEditar.setBorder(new BotonRedondeado(20));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setFocusPainted(false);
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		// btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_4.add(btnEditar);

		btnEliminar = new BotonRedondeado("Eliminar",20);
		//btnEliminar.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		btnEliminar.setFocusPainted(false);
		btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
		// btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_4.add(btnEliminar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_3.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; 
	        }
	    };
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(modelo);
		table.setRowSorter(filtro);
		table.setFont(new Font("Calibri", Font.PLAIN, 18));

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.PLAIN, 19));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("ColorChooser.background"));
		panel.setBorder(new LineBorder(new Color(211, 211, 211), 3));
		panel.setPreferredSize(new Dimension(450, 105));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBorder(new LineBorder(SystemColor.controlHighlight, 3));
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTitulo.setBounds(27, 38, 411, 51);
		panel.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNombre.setBounds(12, 142, 73, 22);
		panel.add(lblNombre);

		tNombre = new JTextField();
		tNombre.setBorder(null);
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		tNombre.setColumns(10);
		tNombre.setBounds(97, 135, 334, 39);
		panel.add(tNombre);

		btnGuardar = new BotonRedondeado("Guardar",20);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
		btnGuardar.setPreferredSize(new Dimension(200, 40));
		btnGuardar.setBackground(new Color(39, 174, 96));
		btnGuardar.setForeground(Color.WHITE);
		// btnRegistrar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnRegistrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnGuardar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnGuardar.setBounds(63, 230, 119, 33);
		panel.add(btnGuardar);

		btnActualizar = new BotonRedondeado("Actualizar",20);
		btnActualizar.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		// btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
		// null, Color.BLACK, null));
		btnActualizar.setEnabled(false);
		btnActualizar.setVisible(false);
		btnActualizar.setPreferredSize(new Dimension(200, 40));
		btnActualizar.setBackground(new Color(39, 174, 96));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnActualizar.setBounds(63, 230, 119, 33);
		panel.add(btnActualizar);

		btnCancelar = new BotonRedondeado("Cancelar",20);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 139), 3));
		// btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnCancelar.setEnabled(false);
		btnCancelar.setVisible(false);
		btnCancelar.setPreferredSize(new Dimension(100, 40));
		btnCancelar.setBackground(new Color(52, 108, 175));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCancelar.setBounds(264, 230, 119, 33);
		panel.add(btnCancelar);
		

		JTableHeader headerr = table.getTableHeader();
		headerr.setFont(new Font("Calibri", Font.BOLD, 18));
		headerr.setForeground(Color.BLACK);
		headerr.setBackground(new Color(201, 224, 154));
		scrollPane.setViewportView(table);
	}
}
