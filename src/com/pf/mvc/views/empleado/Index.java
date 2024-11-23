package com.pf.mvc.views.empleado;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.views.borde.BotonRedondeado;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JPanel {
	public JTable table;
	public JTextField tBuscar;
	public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
	public BotonRedondeado btnEliminar;
	public BotonRedondeado btnEditar;
	public BotonRedondeado btnNuevo;
	public JComboBox<Finca> cbxFinca;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setPreferredSize(new Dimension(10, 80));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(48, 28, 67, 20);
		panel_2.add(lblBuscar);
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 20));

		tBuscar = new JTextField();
		tBuscar.setBorder(null);
		tBuscar.setBounds(117, 23, 370, 33);
		panel_2.add(tBuscar);
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setColumns(10);

		cbxFinca = new JComboBox<Finca>();
		cbxFinca.setBorder(null);
		cbxFinca.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Todas" }));
		cbxFinca.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbxFinca.setBounds(583, 21, 112, 34);
		panel_2.add(cbxFinca);

		AutoCompleteDecorator.decorate(cbxFinca);

		JLabel lblFinca = new JLabel("Finca: ");
		lblFinca.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblFinca.setBounds(518, 28, 53, 20);
		panel_2.add(lblFinca);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.text);
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 220, 220));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(10);
		panel_3.add(panel_4, BorderLayout.SOUTH);

		btnNuevo = new BotonRedondeado("Nuevo",20);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setPreferredSize(new Dimension(90, 40));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		btnNuevo.setBackground(new Color(39, 174, 96));
		panel_4.add(btnNuevo);

		btnEditar = new BotonRedondeado("Editar",20);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBorder(new LineBorder(new Color(255, 140, 0), 3));
		btnEditar.setFocusPainted(false);
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_4.add(btnEditar);

		btnEliminar = new BotonRedondeado("Eliminar",20);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		btnEliminar.setFocusPainted(false);
		btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(30, 340, 107, 42);
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
		table.setFont(new Font("Calibri", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.setBorder(null);
		table.setRowSorter(filtro);
		table.setModel(modelo);

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.BOLD, 19));
		header.setBackground(new Color(201, 224, 154));
		scrollPane.setViewportView(table);
	}
}
