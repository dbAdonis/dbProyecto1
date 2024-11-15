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

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormGeneral extends JPanel {
    public JTextField tNombre;
    public JButton btnRegistrar;
    public JTable table;
    public DefaultTableModel modelo;
    public JButton btnEliminar;
    public JButton btnEditar;
    public JLabel lblTitulo;
    public JButton btnCancelar;
    public JButton btnActualizar;

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

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(246, 7, 70, 23);
        panel_5.add(btnRegistrar);
        btnRegistrar.setPreferredSize(new Dimension(70, 23));
        btnRegistrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnRegistrar.setBackground(SystemColor.inactiveCaptionBorder);
        btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 16));

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setVisible(false);
        btnCancelar.setPreferredSize(new Dimension(70, 23));
        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
        btnCancelar.setBounds(336, 7, 70, 23);
        panel_5.add(btnCancelar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.setVisible(false);
        btnActualizar.setPreferredSize(new Dimension(70, 23));
        btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
        btnActualizar.setBounds(246, 7, 70, 23);
        panel_5.add(btnActualizar);

        JPanel panel_4 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
        flowLayout.setHgap(15);
        panel_2.add(panel_4, BorderLayout.SOUTH);

        btnEditar = new JButton("Editar");
        btnEditar.setPreferredSize(new Dimension(70, 23));
        btnEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.add(btnEditar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(70, 23));
        btnEliminar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
        panel_4.add(btnEliminar);
    }
}
