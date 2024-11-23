package com.pf.mvc.views.aplicacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.pf.mvc.models.vo.Finca;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class Index extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField tBuscar;
	public JTable table;
	public DefaultTableModel modelo;
	public JButton btnNuevo;
	public JButton btnEliminar;
	public JButton btnEditar;
	public TableRowSorter<DefaultTableModel> filtro;
	public JComboBox cbxBusqueda;
	public JComboBox<Finca> cbxFinca;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(1033, 595));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 80));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar: ");
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblBuscar.setBounds(10, 32, 70, 20);
		panel.add(lblBuscar);

		tBuscar = new JTextField();
		tBuscar.setBorder(null);
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setBounds(79, 30, 268, 26);
		panel.add(tBuscar);
		tBuscar.setColumns(10);

		JLabel lblCriterioDeBsqueda = new JLabel("Criterio de b\u00FAsqueda:");
		lblCriterioDeBsqueda.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCriterioDeBsqueda.setBounds(365, 32, 182, 20);
		panel.add(lblCriterioDeBsqueda);

		cbxBusqueda = new JComboBox();
		cbxBusqueda.setBorder(null);
		cbxBusqueda.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Periodo MPS", "Semana", "Fecha",
				"Lote", "Variedad", "Trabajador", "Labor", "Fitosanitario - Fertilizante" }));
		cbxBusqueda.setSelectedIndex(0);
		cbxBusqueda.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbxBusqueda.setBounds(559, 29, 190, 26);
		panel.add(cbxBusqueda);

		AutoCompleteDecorator.decorate(cbxBusqueda);

		JLabel lblOrdenarPorFinca = new JLabel("Ordenar por finca:");
		lblOrdenarPorFinca.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblOrdenarPorFinca.setBounds(761, 32, 158, 20);
		panel.add(lblOrdenarPorFinca);

		cbxFinca = new JComboBox();
		cbxFinca.setBorder(null);
		cbxFinca.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Todas" }));
		cbxFinca.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbxFinca.setBounds(921, 29, 112, 26);
		panel.add(cbxFinca);

		AutoCompleteDecorator.decorate(cbxFinca);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBorder(new EmptyBorder(7, 7, 7, 7));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; 
	        }
	    };
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable(modelo);
		table.setFont(new Font("Calibri", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.setRowSorter(filtro);

		ajustarColumnasYExpandirTabla(table);
		table.setModel(modelo);

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.BOLD, 19));
		header.setBackground(new Color(201, 224, 154));
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(new Rectangle(10, 0, 0, 0));
		panel_2.setBackground(new Color(220, 220, 220));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		add(panel_2, BorderLayout.SOUTH);

		btnNuevo = new JButton("Nuevo Reporte");
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		btnNuevo.setPreferredSize(new Dimension(150, 40));
		btnNuevo.setBackground(new Color(39, 174, 96));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBounds(30, 340, 107, 42);
		btnNuevo.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_2.add(btnNuevo);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setFocusPainted(false);
		btnEditar.setBorder(new LineBorder(new Color(255, 140, 0), 3));
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_2.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(30, 340, 107, 42);
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 20));
		panel_2.add(btnEliminar);

	}

	public void ajustarColumnasYExpandirTabla(JTable tabla) {
		int tableWidth = tabla.getWidth();
		int margin = 10;

		int[] columnWidths = new int[tabla.getColumnCount()];
		int totalColumnWidth = 0;

		for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
			TableColumn tableColumn = tabla.getColumnModel().getColumn(columna);
			int anchoMaximo = 0;

			Object headerValue = tableColumn.getHeaderValue();
			if (headerValue != null) {
				int anchoEncabezado = tabla.getFontMetrics(tabla.getTableHeader().getFont())
						.stringWidth(headerValue.toString());
				anchoMaximo = Math.max(anchoMaximo, anchoEncabezado);
			}

			for (int fila = 0; fila < tabla.getRowCount(); fila++) {
				Object valorCelda = tabla.getValueAt(fila, columna);
				if (valorCelda != null) {
					int anchoCelda = tabla.getFontMetrics(tabla.getFont()).stringWidth(valorCelda.toString());
					anchoMaximo = Math.max(anchoMaximo, anchoCelda);
				}
			}

			columnWidths[columna] = anchoMaximo + margin;
			totalColumnWidth += columnWidths[columna];
		}

		if (totalColumnWidth < tableWidth) {
			int extraWidth = (tableWidth - totalColumnWidth) / tabla.getColumnCount();

			for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
				columnWidths[columna] += extraWidth;
			}
		}

		for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
			tabla.getColumnModel().getColumn(columna).setPreferredWidth(columnWidths[columna]);
		}

		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

	}
}
