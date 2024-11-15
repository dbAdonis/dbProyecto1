package com.pf.mvc.views.producto;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class EditCopia extends JPanel {
	public JButton btnActualizar;
	public JButton btnRegresar;
	public JPanel contenido;
	public JTextField tNombre;
	public JTextField tCodigo;
	public JTextField tUnidad;
	public JComboBox cbxProductos;
	public JButton btnProductos;
	public JButton btnTipos;
	public JButton btnCategorias;

	/**
	 * Create the panel.
	 */
	public EditCopia() {
		setPreferredSize(new Dimension(1081, 665));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_4.setPreferredSize(new Dimension(10, 300));
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("Producto");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(10, 30, 65, 20);
		panel_4.add(label);
		
		cbxProductos = new JComboBox();
		cbxProductos.setPreferredSize(new Dimension(200, 20));
		cbxProductos.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxProductos.setBounds(98, 30, 173, 20);
		panel_4.add(cbxProductos);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Calibri", Font.BOLD, 16));
		label_1.setBounds(10, 75, 65, 20);
		panel_4.add(label_1);
		
		tNombre = new JTextField();
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		tNombre.setColumns(30);
		tNombre.setBounds(98, 72, 366, 26);
		panel_4.add(tNombre);
		
		JLabel label_11 = new JLabel("Agregar nuevo en la lista");
		label_11.setFont(new Font("Calibri", Font.ITALIC, 16));
		label_11.setBounds(324, 30, 161, 20);
		panel_4.add(label_11);
		
		btnProductos = new JButton("");
		btnProductos.setPreferredSize(new Dimension(35, 23));
		btnProductos.setFont(new Font("Calibri", Font.BOLD, 16));
		btnProductos.setBackground(SystemColor.scrollbar);
		btnProductos.setBounds(509, 27, 35, 23);
		panel_4.add(btnProductos);
		
		tCodigo = new JTextField();
		tCodigo.setFont(new Font("Calibri", Font.PLAIN, 16));
		tCodigo.setColumns(15);
		tCodigo.setBounds(592, 72, 186, 26);
		panel_4.add(tCodigo);
		
		JLabel label_12 = new JLabel("C\u00F3digo");
		label_12.setFont(new Font("Calibri", Font.BOLD, 16));
		label_12.setBounds(509, 75, 47, 20);
		panel_4.add(label_12);
		
		JLabel label_13 = new JLabel("Unidad de medida");
		label_13.setFont(new Font("Calibri", Font.BOLD, 16));
		label_13.setBounds(809, 76, 125, 20);
		panel_4.add(label_13);
		
		btnTipos = new JButton("");
		btnTipos.setPreferredSize(new Dimension(35, 23));
		btnTipos.setFont(new Font("Calibri", Font.BOLD, 16));
		btnTipos.setBackground(SystemColor.scrollbar);
		btnTipos.setBounds(509, 125, 35, 23);
		panel_4.add(btnTipos);
		
		JLabel label_14 = new JLabel("Agregar nuevo en la lista");
		label_14.setFont(new Font("Calibri", Font.ITALIC, 16));
		label_14.setBounds(324, 128, 161, 20);
		panel_4.add(label_14);
		
		JComboBox cbxTipos = new JComboBox();
		cbxTipos.setPreferredSize(new Dimension(150, 20));
		cbxTipos.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTipos.setBounds(98, 125, 173, 20);
		panel_4.add(cbxTipos);
		
		JLabel label_15 = new JLabel("Tipo");
		label_15.setFont(new Font("Calibri", Font.BOLD, 16));
		label_15.setBounds(10, 125, 65, 20);
		panel_4.add(label_15);
		
		JLabel label_16 = new JLabel("Categor\u00EDa");
		label_16.setFont(new Font("Calibri", Font.BOLD, 16));
		label_16.setBounds(10, 170, 65, 20);
		panel_4.add(label_16);
		
		JComboBox cbxCategorias = new JComboBox();
		cbxCategorias.setPreferredSize(new Dimension(150, 20));
		cbxCategorias.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxCategorias.setBounds(98, 170, 173, 20);
		panel_4.add(cbxCategorias);
		
		JLabel label_17 = new JLabel("Agregar nuevo en la lista");
		label_17.setFont(new Font("Calibri", Font.ITALIC, 16));
		label_17.setBounds(324, 170, 161, 20);
		panel_4.add(label_17);
		
		btnCategorias = new JButton("");
		btnCategorias.setPreferredSize(new Dimension(35, 23));
		btnCategorias.setFont(new Font("Calibri", Font.BOLD, 16));
		btnCategorias.setBackground(SystemColor.scrollbar);
		btnCategorias.setBounds(509, 170, 35, 23);
		panel_4.add(btnCategorias);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(24, 232, 100, 40);
		panel_4.add(btnActualizar);
		btnActualizar.setFocusPainted(false);
		btnActualizar.setBorder(null);
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16)); // Fuente Calibri 16
		btnActualizar.setPreferredSize(new Dimension(100, 40));
		btnActualizar.setBackground(new Color(39, 174, 96));
		btnActualizar.setForeground(Color.WHITE);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(149, 232, 100, 40);
		panel_4.add(btnRegresar);
		btnRegresar.setFocusPainted(false);
		btnRegresar.setBorder(null);
		btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16)); // Fuente Calibri 16
		btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(52, 108, 175));
		btnRegresar.setForeground(Color.WHITE);
		
		tUnidad = new JTextField();
		tUnidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tUnidad.setColumns(15);
		tUnidad.setBounds(959, 73, 186, 26);
		panel_4.add(tUnidad);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_9.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		contenido = new JPanel();
		panel_2.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new BorderLayout(0, 0));
		
		
		ImageIcon imgBtn = new ImageIcon(getClass().getResource("/resources/ButtonOff.png"));
		
		ImageIcon iconImgBtn = new ImageIcon(imgBtn.getImage().getScaledInstance(30, 27, Image.SCALE_DEFAULT));
		
		btnProductos.setIcon(iconImgBtn);
		btnTipos.setIcon(iconImgBtn);
		btnCategorias.setIcon(iconImgBtn);
		
	}
	
	public void setContenido(JComponent c) {

		

		contenido.removeAll();

		if(c != null) {
			contenido.add(c, BorderLayout.CENTER);
		}

		contenido.repaint();
		contenido.revalidate();

	}
	
}
