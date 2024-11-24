package com.pf.mvc.views.producto;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.pf.mvc.views.borde.BotonRedondeado;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Index extends JPanel {
    public JTextField tBuscar;
    public JTable table;
    public DefaultTableModel modelo;
    public TableRowSorter<DefaultTableModel> filtro;
    public BotonRedondeado btnNuevo;
    public BotonRedondeado btnEliminar;
    public BotonRedondeado btnEditar;

    /**
     * Create the panel.
     */
    public Index() {
        setPreferredSize(new Dimension(900, 580));
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 70));
        add(panel, BorderLayout.NORTH);
        panel.setLayout(null);
        
        JLabel lblBuscar = new JLabel("Buscar");
        lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 20)); 
        lblBuscar.setBounds(12, 25, 67, 26);
        panel.add(lblBuscar);
        
        tBuscar = new JTextField();
        tBuscar.setBorder(null);
        tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
        tBuscar.setBounds(71, 21, 801, 30);
        panel.add(tBuscar);
        tBuscar.setColumns(10);
        
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
        table = new JTable();
        table.setModel(modelo);
        table.setRowHeight(30);
        table.setRowSorter(filtro);
        table.setFont(new Font("Calibri", Font.PLAIN, 18));  
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 19));
        table.getTableHeader().setBackground(new Color(201, 224, 154));
        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(220, 220, 220));
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setHgap(10);
        add(panel_2, BorderLayout.SOUTH);
        
        btnNuevo = new BotonRedondeado("Nuevo Producto",20);
        btnNuevo.setFocusPainted(false);
        btnNuevo.setBorder(new LineBorder(new Color(0, 128, 0), 3));
        btnNuevo.setPreferredSize(new Dimension(150, 40));
        btnNuevo.setBackground(new Color(39, 174, 96));
        btnNuevo.setForeground(Color.WHITE);;
        btnNuevo.setFont(new Font("Calibri", Font.BOLD, 20)); 
        panel_2.add(btnNuevo);
        
        btnEditar = new BotonRedondeado("Editar",20);
        btnEditar.setBorder(new LineBorder(new Color(255, 140, 0), 3));
        btnEditar.setFocusPainted(false);
        btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(new Font("Calibri", Font.BOLD, 20));
        panel_2.add(btnEditar);
        
        btnEliminar = new BotonRedondeado("Eliminar",20);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorder(new LineBorder(new Color(220, 20, 60), 3));
        btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Calibri", Font.BOLD, 20));
        panel_2.add(btnEliminar);
    }
}
