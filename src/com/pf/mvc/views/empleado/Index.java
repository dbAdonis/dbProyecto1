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

import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class Index extends JPanel {
    public JTable tableEmpleados;
    public JTextField tBuscar;
    public JTextField tNombre;
    public DefaultTableModel modelo;
	public TableRowSorter<DefaultTableModel> filtro;
    public JButton btnRegresar;
    public JButton btnEliminar;
    public JButton btnEditar;
    public JButton btnAgregar;
    public JLabel lblTitulo;
    public JButton btnActualizar;
    public JButton btnCancelar;

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
        panel_2.setPreferredSize(new Dimension(10, 70));
        panel_1.add(panel_2, BorderLayout.NORTH);
         panel_2.setLayout(null);
         
         JLabel lblBuscar = new JLabel("Buscar:");
         lblBuscar.setBounds(24, 25, 48, 20);
         panel_2.add(lblBuscar);
         lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
         
         tBuscar = new JTextField();
         tBuscar.setBounds(91, 22, 370, 26);
         panel_2.add(tBuscar);
         tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
         tBuscar.setColumns(10);
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4, BorderLayout.SOUTH);
        
        btnEditar = new JButton("Editar");
        btnEditar.setBorder(null);
        btnEditar.setFocusPainted(false);
        btnEditar.setPreferredSize(new Dimension(90, 40));
        btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBounds(30, 340, 107, 42);
        //btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
        //btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_4.add(btnEditar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(30, 340, 107, 42);
        //btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
        //btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_4.add(btnEliminar);
        
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(52, 108, 175));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBounds(30, 340, 107, 42);
        //btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
        //btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_4.add(btnRegresar);
        
        JScrollPane scrollPane = new JScrollPane();
        panel_3.add(scrollPane, BorderLayout.CENTER);
        
        modelo = new DefaultTableModel();
        filtro = new TableRowSorter<DefaultTableModel>(modelo);
        tableEmpleados = new JTable();
        tableEmpleados.setFont(new Font("Calibri", Font.PLAIN, 16));
        tableEmpleados.setRowHeight(30);
        tableEmpleados.setRowSorter(filtro);
        tableEmpleados.setModel(modelo);
        
        JTableHeader header = tableEmpleados.getTableHeader();
        header.setFont(new Font("Calibri", Font.BOLD, 16)); 
        scrollPane.setViewportView(tableEmpleados);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.setPreferredSize(new Dimension(10, 200));
        add(panel, BorderLayout.NORTH);
        panel.setLayout(null);
        
        lblTitulo = new JLabel("Registrar nuevo empleado");
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 16));
        lblTitulo.setBounds(10, 11, 880, 30);
        panel.add(lblTitulo);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblNombre.setBounds(10, 56, 70, 25);
        panel.add(lblNombre);
        
        tNombre = new JTextField();
        tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        tNombre.setColumns(10);
        tNombre.setBounds(85, 54, 380, 30);
        panel.add(tNombre);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(280, 106, 110, 30);
        panel.add(btnCancelar);
        btnCancelar.setBorder(null);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setPreferredSize(new Dimension(100, 40));
        btnCancelar.setBackground(new Color(52, 108, 175));
        btnCancelar.setForeground(Color.WHITE);
        //btnCancelar.setBounds(30, 340, 107, 42);
        //btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
        //btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnCancelar.setEnabled(false);
        btnCancelar.setVisible(false);
        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 16));
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(145, 106, 110, 30);
        panel.add(btnActualizar);
        btnActualizar.setBorder(null);
        btnActualizar.setFocusPainted(false);
        btnActualizar.setPreferredSize(new Dimension(200, 40));
        btnActualizar.setBackground(new Color(39, 174, 96));
        btnActualizar.setForeground(Color.WHITE);
        // btnActualizar.setBounds(30, 340, 107, 42);
         //btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
         //btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
         btnActualizar.setEnabled(false);
         btnActualizar.setVisible(false);
         btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
         
         btnAgregar = new JButton("Agregar");
         btnAgregar.setBounds(10, 106, 110, 30);
         panel.add(btnAgregar);
         btnAgregar.setFocusPainted(false);
         btnAgregar.setBorder(null);
         btnAgregar.setPreferredSize(new Dimension(200, 40));
         btnAgregar.setBackground(new Color(39, 174, 96));
         btnAgregar.setForeground(Color.WHITE);
         //btnAgregar.setBounds(30, 340, 107, 42);
         //btnAgregar.setBackground(SystemColor.inactiveCaptionBorder);
         //btnAgregar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
         btnAgregar.setFont(new Font("Calibri", Font.BOLD, 16));
    }
}
