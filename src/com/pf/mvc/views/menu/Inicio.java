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

public class Inicio extends JPanel {
    public JLabel lblImagen;
    private JPanel panel;
    private JPanel panel_1;

    /**
     * Create the panel.
     */
    
    public Inicio() {
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
        panel.setPreferredSize(new Dimension(10, 400));
        panel_1.add(panel, BorderLayout.CENTER);
        
        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(400, 400));
        lblImagen.setBorder(null);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setFont(new Font("Calibri", Font.BOLD, 16)); // Estilo Calibri 16 para el encabezado
        ImageIcon iconImgLogo = new ImageIcon(imgLogo.getImage().getScaledInstance(
                (int) lblImagen.getPreferredSize().getWidth(), (int) lblImagen.getPreferredSize().getHeight(), Image.SCALE_DEFAULT));
        panel.setLayout(new BorderLayout(0, 0));
        lblImagen.setIcon(iconImgLogo);
        panel.add(lblImagen);
        
        ImageIcon iconImgPersonal = new ImageIcon(imgPersonal.getImage().getScaledInstance(90, 81, Image.SCALE_DEFAULT));
        ImageIcon iconImgForm = new ImageIcon(imgForm.getImage().getScaledInstance(90, 75, Image.SCALE_DEFAULT));
        ImageIcon iconImgProductos = new ImageIcon(imgProductos.getImage().getScaledInstance(90, 75, Image.SCALE_DEFAULT));
    }
}
