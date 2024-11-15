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
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(10, 70));
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(null);
        
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblBuscar.setBounds(10, 27, 55, 20);
        panel_2.add(lblBuscar);
        
        tBuscar = new JTextField();
        tBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
        tBuscar.setBounds(86, 22, 377, 30);
        panel_2.add(tBuscar);
        tBuscar.setColumns(10);
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4, BorderLayout.SOUTH);
        
        btnEditar = new JButton("Editar");
        btnEditar.setPreferredSize(new Dimension(90, 30));
        btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
        btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_4.add(btnEditar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(90, 30));
        btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
        btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_4.add(btnEliminar);
        
        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(90, 30));
        btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
        btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
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
        panel.setPreferredSize(new Dimension(10, 105));
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
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(SystemColor.inactiveCaptionBorder);
        btnAgregar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnAgregar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAgregar.setBounds(485, 53, 110, 30);
        panel.add(btnAgregar);
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
        btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnActualizar.setEnabled(false);
        btnActualizar.setVisible(false);
        btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnActualizar.setBounds(605, 53, 110, 30);
        panel.add(btnActualizar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
        btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnCancelar.setEnabled(false);
        btnCancelar.setVisible(false);
        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnCancelar.setBounds(725, 53, 110, 30);
        panel.add(btnCancelar);
    }
}
