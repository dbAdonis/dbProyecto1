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
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

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
	public JComboBox cbxFinca;

	/**
	 * Create the panel.
	 */
	public Index() {
		setPreferredSize(new Dimension(950, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 70));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBuscar.setBounds(10, 32, 54, 20);
		panel.add(lblBuscar);

		tBuscar = new JTextField();
		tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		tBuscar.setBounds(74, 29, 235, 26);
		panel.add(tBuscar);
		tBuscar.setColumns(10);

		JLabel lblCriterioDeBsqueda = new JLabel("Criterio de b\u00FAsqueda:");
		lblCriterioDeBsqueda.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCriterioDeBsqueda.setBounds(338, 32, 139, 20);
		panel.add(lblCriterioDeBsqueda);

		cbxBusqueda = new JComboBox();
		cbxBusqueda.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar" }));
		cbxBusqueda.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxBusqueda.setBounds(487, 29, 171, 26);
		panel.add(cbxBusqueda);

		JLabel lblOrdenarPorFinca = new JLabel("Ordenar por finca:");
		lblOrdenarPorFinca.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblOrdenarPorFinca.setBounds(695, 32, 123, 20);
		panel.add(lblOrdenarPorFinca);

		cbxFinca = new JComboBox();
		cbxFinca.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Todas" }));
		cbxFinca.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxFinca.setBounds(828, 29, 112, 26);
		panel.add(cbxFinca);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		filtro = new TableRowSorter<DefaultTableModel>(modelo);
		table = new JTable(modelo);
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setRowSorter(filtro);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ajustarColumnasYExpandirTabla(table);
		table.setModel(modelo);

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.BOLD, 16));
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		//panel_2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		//panel_2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20, 0));
		add(panel_2, BorderLayout.SOUTH);

		btnNuevo = new JButton("Nuevo Reporte");
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBorder(null);
		btnNuevo.setPreferredSize(new Dimension(150, 40));
		btnNuevo.setBackground(new Color(39, 174, 96));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBounds(30, 340, 107, 42);
		// btnAgregarConsumo.setBackground(SystemColor.inactiveCaptionBorder);
		// btnAgregarConsumo.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
		// null, Color.BLACK, null));
		btnNuevo.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnNuevo);

		btnEditar = new JButton("Editar");
		btnEditar.setFocusPainted(false);
		btnEditar.setBorder(null);
		btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
		// btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorder(null);
		btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(30, 340, 107, 42);
		// btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
		// btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null,
		// Color.BLACK, null));
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_2.add(btnEliminar);

	}

	public void ajustarColumnasYExpandirTabla(JTable tabla) {
		int tableWidth = tabla.getWidth(); // Ancho total del contenedor
		int margin = 10; // Margen adicional para evitar texto cortado

		// Calcular los anchos necesarios
		int[] columnWidths = new int[tabla.getColumnCount()];
		int totalColumnWidth = 0;

		for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
			TableColumn tableColumn = tabla.getColumnModel().getColumn(columna);
			int anchoMaximo = 0;

			// Ancho del encabezado
			Object headerValue = tableColumn.getHeaderValue();
			if (headerValue != null) {
				int anchoEncabezado = tabla.getFontMetrics(tabla.getTableHeader().getFont())
						.stringWidth(headerValue.toString());
				anchoMaximo = Math.max(anchoMaximo, anchoEncabezado);
			}

			// Ancho del contenido en las celdas
			for (int fila = 0; fila < tabla.getRowCount(); fila++) {
				Object valorCelda = tabla.getValueAt(fila, columna);
				if (valorCelda != null) {
					int anchoCelda = tabla.getFontMetrics(tabla.getFont()).stringWidth(valorCelda.toString());
					anchoMaximo = Math.max(anchoMaximo, anchoCelda);
				}
			}

			columnWidths[columna] = anchoMaximo + margin; // Agregar margen
			totalColumnWidth += columnWidths[columna];
		}

		// Distribuir espacio restante proporcionalmente
		if (totalColumnWidth < tableWidth) {
			int extraWidth = (tableWidth - totalColumnWidth) / tabla.getColumnCount();

			for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
				columnWidths[columna] += extraWidth;
			}
		}

		// Aplicar los anchos calculados
		for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
			tabla.getColumnModel().getColumn(columna).setPreferredWidth(columnWidths[columna]);
		}

		// Hacer que la tabla ocupe todo el ancho disponible
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

	}
}
