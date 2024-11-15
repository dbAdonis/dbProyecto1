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
    public JTable tableProductos;
    public DefaultTableModel modelo;
    public TableRowSorter<DefaultTableModel> filtro;
    public JButton btnAgregarProducto;
    public JButton btnEliminar;
    public JButton btnEditar;
    public JButton btnRegresar;

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
        tableProductos = new JTable();
        tableProductos.setModel(modelo);
        tableProductos.setRowHeight(30);
        tableProductos.setRowSorter(filtro);
        tableProductos.setFont(new Font("Calibri", Font.PLAIN, 16));  
        tableProductos.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 16));
        scrollPane.setViewportView(tableProductos);
        
        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setHgap(10);
        add(panel_2, BorderLayout.SOUTH);
        
        btnAgregarProducto = new JButton("Agregar producto");
        btnAgregarProducto.setFocusPainted(false);
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.setPreferredSize(new Dimension(200, 40));
        btnAgregarProducto.setBackground(new Color(39, 174, 96));
        btnAgregarProducto.setForeground(Color.WHITE);;
        //btnAgregarProducto.setBackground(SystemColor.inactiveCaptionBorder);
        //btnAgregarProducto.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnAgregarProducto.setFont(new Font("Calibri", Font.BOLD, 16)); 
        panel_2.add(btnAgregarProducto);
        
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
        
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(52, 108, 175));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBounds(30, 340, 107, 42);
        btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16)); 
        //btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        //btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
        panel_2.add(btnRegresar);
    }
}
