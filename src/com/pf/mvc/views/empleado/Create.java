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

import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Create extends JPanel {
    public JTextField tNombre;
    public JButton btnGuardar;
    public JLabel lblTitulo;
    public JButton btnCancelar;
    public JComboBox<Finca> cbxFincas;

    /**
     * Create the panel.
     */
    public Create() {
        setPreferredSize(new Dimension(900, 580));
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 200));
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        lblTitulo = new JLabel("Titulo");
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 30));
        lblTitulo.setBounds(27, 11, 847, 30);
        panel.add(lblTitulo);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Calibri", Font.BOLD, 21));
        lblNombre.setBounds(27, 70, 83, 25);
        panel.add(lblNombre);
        
        tNombre = new JTextField();
        tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        tNombre.setColumns(10);
        tNombre.setBounds(118, 69, 380, 30);
        panel.add(tNombre);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCancelar.setBounds(157, 177, 110, 30);
        panel.add(btnCancelar);
        btnCancelar.setBorder(null);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setPreferredSize(new Dimension(100, 40));
        btnCancelar.setBackground(new Color(52, 108, 175));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 19));
         
         btnGuardar = new JButton("Guardar");
         btnGuardar.setBounds(27, 177, 110, 30);
         panel.add(btnGuardar);
         btnGuardar.setFocusPainted(false);
         btnGuardar.setBorder(null);
         btnGuardar.setPreferredSize(new Dimension(200, 40));
         btnGuardar.setBackground(new Color(39, 174, 96));
         btnGuardar.setForeground(Color.WHITE);
         btnGuardar.setFont(new Font("Calibri", Font.BOLD, 19));
         
         JLabel lblFinca = new JLabel("Finca");
         lblFinca.setFont(new Font("Calibri", Font.BOLD, 21));
         lblFinca.setBounds(27, 121, 83, 25);
         panel.add(lblFinca);
         
         cbxFincas = new JComboBox<Finca>();
         cbxFincas.setFont(new Font("Calibri", Font.PLAIN, 16));
         cbxFincas.setBounds(118, 123, 135, 25);
         panel.add(cbxFincas);
         
         AutoCompleteDecorator.decorate(cbxFincas);
    }
}
