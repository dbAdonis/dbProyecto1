package com.pf.mvc.views.producto;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class Index extends JPanel {
    public JTextField tBuscar;
    public JTable table;
    public DefaultTableModel modelo;
    public TableRowSorter<DefaultTableModel> filtro;
    public JButton btnNuevo;
    public JButton btnEliminar;
    public JButton btnEditar;

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
        lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16)); 
        lblBuscar.setBounds(10, 21, 67, 26);
        panel.add(lblBuscar);
        
        tBuscar = new JTextField();
        tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
        tBuscar.setBounds(71, 21, 801, 26);
        panel.add(tBuscar);
        tBuscar.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane, BorderLayout.CENTER);
        
        modelo = new DefaultTableModel();
        filtro = new TableRowSorter<DefaultTableModel>(modelo);
        table = new JTable();
        table.setModel(modelo);
        table.setRowHeight(30);
        table.setRowSorter(filtro);
        table.setFont(new Font("Calibri", Font.PLAIN, 16));  
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 16));
        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setHgap(10);
        add(panel_2, BorderLayout.SOUTH);
        
        btnNuevo = new JButton("Nuevo Producto");
        btnNuevo.setFocusPainted(false);
        btnNuevo.setBorder(null);
        btnNuevo.setPreferredSize(new Dimension(150, 40));
        btnNuevo.setBackground(new Color(39, 174, 96));
        btnNuevo.setForeground(Color.WHITE);;
        //btnAgregarProducto.setBackground(SystemColor.inactiveCaptionBorder);
        //btnAgregarProducto.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnNuevo.setFont(new Font("Calibri", Font.BOLD, 16)); 
        panel_2.add(btnNuevo);
        
        btnEditar = new JButton("Editar");
        btnEditar.setBorder(null);
        btnEditar.setFocusPainted(false);
        btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
        //btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
        //btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_2.add(btnEditar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorder(null);
        btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
        //btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
        //btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_2.add(btnEliminar);
    }
}
