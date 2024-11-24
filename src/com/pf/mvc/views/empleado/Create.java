package com.pf.mvc.views.empleado;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.views.borde.BotonRedondeado;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Create extends JPanel {
    public JTextField tNombre;
    public BotonRedondeado btnGuardar;
    public JLabel lblTitulo;
    public BotonRedondeado btnCancelar;
    public JComboBox<Finca> cbxFincas;

    /**
     * Create the panel.
     */
    public Create() {
        setPreferredSize(new Dimension(900, 580));
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 48, 504, 393);
        panel.setPreferredSize(new Dimension(10, 150));
        add(panel);
        panel.setLayout(null);
        
        lblTitulo = new JLabel("Titulo");
        lblTitulo.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 30));
        lblTitulo.setBounds(27, 13, 448, 47);
        panel.add(lblTitulo);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Calibri", Font.BOLD, 21));
        lblNombre.setBounds(27, 100, 83, 25);
        panel.add(lblNombre);
        
        tNombre = new JTextField();
        tNombre.setBorder(null);
        tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
        tNombre.setColumns(10);
        tNombre.setBounds(112, 99, 380, 30);
        panel.add(tNombre);
        
        btnCancelar = new BotonRedondeado("Cancelar",20);
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCancelar.setBounds(157, 230, 110, 30);
        panel.add(btnCancelar);
        btnCancelar.setBorder(new LineBorder(new Color(72, 61, 139), 3));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setPreferredSize(new Dimension(100, 40));
        btnCancelar.setBackground(new Color(0, 0, 139));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 19));
         
         btnGuardar = new BotonRedondeado("Guardar",20);
         btnGuardar.setBounds(27, 230, 110, 30);
         panel.add(btnGuardar);
         btnGuardar.setFocusPainted(false);
         btnGuardar.setBorder(new LineBorder(new Color(0, 128, 0), 3));
         btnGuardar.setPreferredSize(new Dimension(200, 40));
         btnGuardar.setBackground(new Color(39, 174, 96));
         btnGuardar.setForeground(Color.WHITE);
         btnGuardar.setFont(new Font("Calibri", Font.BOLD, 19));
         
         JLabel lblFinca = new JLabel("Finca");
         lblFinca.setFont(new Font("Calibri", Font.BOLD, 21));
         lblFinca.setBounds(27, 163, 83, 25);
         panel.add(lblFinca);
         
         cbxFincas = new JComboBox<Finca>();
         cbxFincas.setFont(new Font("Calibri", Font.PLAIN, 16));
         cbxFincas.setBounds(112, 165, 135, 25);
         panel.add(cbxFincas);
         
         AutoCompleteDecorator.decorate(cbxFincas);
    }
}
