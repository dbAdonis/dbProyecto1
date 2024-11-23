package com.pf.mvc.views.general;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.pf.mvc.views.borde.BotonRedondeado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormGeneral extends JPanel {
    public JTextField tNombre;
    public BotonRedondeado btnRegistrar;
    public JTable table;
    public DefaultTableModel modelo;
    public BotonRedondeado btnEliminar;
    public BotonRedondeado btnEditar;
    public JLabel lblTitulo;
    public BotonRedondeado btnCancelar;
    public BotonRedondeado btnActualizar;

    /**
     * Create the panel.
     */
    public FormGeneral() {
        setPreferredSize(new Dimension(500, 300));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 40));
        panel_2.add(panel_1, BorderLayout.NORTH);

        lblTitulo = new JLabel("Titulo");
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 16));
        panel_1.add(lblTitulo);

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_3.add(scrollPane, BorderLayout.CENTER);

        modelo = new DefaultTableModel();
        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 16));
        table.setRowHeight(30);
        table.setModel(modelo);
        scrollPane.setViewportView(table);

        JPanel panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 45));
        panel_3.add(panel_5, BorderLayout.NORTH);
        panel_5.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 9, 56, 18);
        panel_5.add(lblNombre);
        lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));

        tNombre = new JTextField();
        tNombre.setBounds(70, 8, 166, 21);
        panel_5.add(tNombre);
        tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        tNombre.setColumns(10);

        btnRegistrar = new BotonRedondeado("Registrar",20);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setPreferredSize(new Dimension(300, 40));
        btnRegistrar.setBackground(new Color(39, 174, 96));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBounds(246, 7, 109, 23);
        panel_5.add(btnRegistrar);
        //btnRegistrar.setBounds(30, 340, 107, 42);
        //btnRegistrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        //btnRegistrar.setBackground(SystemColor.inactiveCaptionBorder);
        btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 16));

        btnCancelar = new BotonRedondeado("Cancelar",20);
        //btnCancelar.setBorder(null);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setEnabled(false);
        btnCancelar.setVisible(false);
        btnCancelar.setPreferredSize(new Dimension(100, 40));
        btnCancelar.setBackground(new Color(52, 108, 175));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 16));
        //btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        //btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
        btnCancelar.setBounds(364, 7, 95, 23);
        panel_5.add(btnCancelar);

        btnActualizar = new BotonRedondeado("Actualizar",20);
        btnActualizar.setFocusPainted(false);
        //btnActualizar.setBorder(null);
        btnActualizar.setEnabled(false);
        btnActualizar.setVisible(false);
        btnActualizar.setPreferredSize(new Dimension(200, 40));
        btnActualizar.setBackground(new Color(39, 174, 96));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
        //btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        //btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
        btnActualizar.setBounds(246, 7, 109, 23);
        panel_5.add(btnActualizar);

        JPanel panel_4 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
        flowLayout.setHgap(15);
        panel_2.add(panel_4, BorderLayout.SOUTH);

        btnEditar = new BotonRedondeado("Editar",20);
        btnEditar.setFocusPainted(false);
        //btnEditar.setBorder(null);
        btnEditar.setPreferredSize(new Dimension(90, 40));
		btnEditar.setBackground(new Color(204, 153, 0));
		btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
       // btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        //btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.add(btnEditar);

        btnEliminar = new BotonRedondeado("Eliminar",20);
        //btnEliminar.setBorder(null);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setPreferredSize(new Dimension(90, 40));
		btnEliminar.setBackground(new Color(153, 0, 0));
		btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
       // btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        //btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.add(btnEliminar);
    }
}
