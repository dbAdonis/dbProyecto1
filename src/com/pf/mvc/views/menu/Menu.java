package com.pf.mvc.views.menu;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class Menu extends JPanel {
    public JLabel lblImagen;
    public JButton btnReportesDiarios;
    public JButton btnGestionarPersonal;
    public JButton btnProductos;
    private JPanel panel;
    private JPanel panel_2;
    private JPanel panel_1;

    /**
     * Create the panel.
     */
    
    public Menu() {
        setPreferredSize(new Dimension(900, 600));
        setLayout(new BorderLayout(0, 0));
        
        panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel_1.setBackground(new Color(240, 247, 244));
        add(panel_1, BorderLayout.CENTER);
        
        ImageIcon imgLogo = new ImageIcon(getClass().getResource("/resources/Plantas.png"));
        panel_1.setLayout(new BorderLayout(0, 0));
        
        ImageIcon imgPersonal = new ImageIcon(getClass().getResource("/resources/Personal.png"));
        ImageIcon imgForm = new ImageIcon(getClass().getResource("/resources/Form.png"));
        ImageIcon imgProductos = new ImageIcon(getClass().getResource("/resources/Productos.png"));
        
        panel = new JPanel();
        //panel.setOpaque(false);
        panel.setBackground(new Color(194, 227, 187));
        FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
        flowLayout_1.setVgap(75);
        panel.setPreferredSize(new Dimension(10, 400));
        panel_1.add(panel, BorderLayout.NORTH);
        
        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(250, 250));
        lblImagen.setBorder(null);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setFont(new Font("Calibri", Font.BOLD, 16)); // Estilo Calibri 16 para el encabezado
        ImageIcon iconImgLogo = new ImageIcon(imgLogo.getImage().getScaledInstance(
                (int) lblImagen.getPreferredSize().getWidth(), (int) lblImagen.getPreferredSize().getHeight(), Image.SCALE_DEFAULT));
        lblImagen.setIcon(iconImgLogo);
        panel.add(lblImagen);
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(194, 227, 187));
        //panel_2.setOpaque(false);
        panel_2.setPreferredSize(new Dimension(10, 330));
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setVgap(50);
        flowLayout.setHgap(100);
        panel_1.add(panel_2, BorderLayout.CENTER);
        
        btnGestionarPersonal = new JButton("Gestionar personal");
        btnGestionarPersonal.setBackground(new Color(211, 211, 211));
        //btnGestionarPersonal.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        panel_2.add(btnGestionarPersonal);
        btnGestionarPersonal.setFocusable(false);
        btnGestionarPersonal.setFont(new Font("Calibri", Font.BOLD, 16)); 
        btnGestionarPersonal.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGestionarPersonal.setPreferredSize(new Dimension(170, 111));
        btnGestionarPersonal.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnGestionarPersonal.setVerticalAlignment(SwingConstants.BOTTOM);
        
        ImageIcon iconImgPersonal = new ImageIcon(imgPersonal.getImage().getScaledInstance(90, 81, Image.SCALE_DEFAULT));
        btnGestionarPersonal.setIcon(iconImgPersonal);
        
        btnReportesDiarios = new JButton("Reportes diarios");
        btnReportesDiarios.setBackground(new Color(211, 211, 211));
        btnReportesDiarios.setPreferredSize(new Dimension(170, 111));
        panel_2.add(btnReportesDiarios);
        btnReportesDiarios.setFocusable(false);
        btnReportesDiarios.setFont(new Font("Calibri", Font.BOLD, 16)); // Calibri 16
        //btnReportesDiarios.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
        btnReportesDiarios.setHorizontalTextPosition(SwingConstants.CENTER);
        btnReportesDiarios.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnReportesDiarios.setVerticalAlignment(SwingConstants.BOTTOM);
        ImageIcon iconImgForm = new ImageIcon(imgForm.getImage().getScaledInstance(90, 75, Image.SCALE_DEFAULT));
        btnReportesDiarios.setIcon(iconImgForm);
        
        btnProductos = new JButton("Productos");
        btnProductos.setBackground(new Color(211, 211, 211));
        //btnProductos.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
        btnProductos.setPreferredSize(new Dimension(170, 111));
        panel_2.add(btnProductos);
        btnProductos.setFocusable(false);
        btnProductos.setFont(new Font("Calibri", Font.BOLD, 16)); 
        btnProductos.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnProductos.setVerticalAlignment(SwingConstants.BOTTOM);
        ImageIcon iconImgProductos = new ImageIcon(imgProductos.getImage().getScaledInstance(90, 75, Image.SCALE_DEFAULT));
        btnProductos.setIcon(iconImgProductos);
    }
    
    public void setContenido(JComponent c) {
        panel_2.removeAll();
        if (c != null) {
            panel_2.add(c, BorderLayout.CENTER);
        }
        panel_2.repaint();
        panel_2.revalidate();
    }
}
