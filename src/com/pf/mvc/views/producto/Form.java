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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Producto;
import com.pf.mvc.models.vo.Tipo;

public class Form extends JPanel {
	public JButton btnAgregar;
	public JButton btnCancelar;
	public JPanel contenido;
	public JTextField tNombre;
	public JTextField tCodigo;
	public JTextField tUnidad;
	public JComboBox<Naturaleza> cbxProductos;
	public JComboBox<Tipo> cbxTipos;
	public JComboBox<Categoria> cbxCategorias;

	/**
	 * Create the panel.
	 */
	public Form() {
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
		panel_4.setPreferredSize(new Dimension(10, 400));
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("Producto");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		label.setBounds(21, 33, 142, 20);
		panel_4.add(label);
		
		cbxProductos = new JComboBox<Naturaleza>();
		cbxProductos.setPreferredSize(new Dimension(200, 20));
		cbxProductos.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxProductos.setBounds(204, 33, 173, 26);
		panel_4.add(cbxProductos);
		
		AutoCompleteDecorator.decorate(cbxProductos);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Calibri", Font.BOLD, 20));
		label_1.setBounds(21, 78, 142, 20);
		panel_4.add(label_1);
		
		tNombre = new JTextField();
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		tNombre.setColumns(30);
		tNombre.setBounds(204, 75, 366, 26);
		panel_4.add(tNombre);
		
		tCodigo = new JTextField();
		tCodigo.setFont(new Font("Calibri", Font.PLAIN, 16));
		tCodigo.setColumns(15);
		tCodigo.setBounds(204, 120, 173, 26);
		panel_4.add(tCodigo);
		
		JLabel label_12 = new JLabel("C\u00F3digo");
		label_12.setFont(new Font("Calibri", Font.BOLD, 20));
		label_12.setBounds(21, 123, 142, 20);
		panel_4.add(label_12);
		
		JLabel label_13 = new JLabel("Unidad de medida");
		label_13.setFont(new Font("Calibri", Font.BOLD, 20));
		label_13.setBounds(21, 171, 160, 20);
		panel_4.add(label_13);
		
		cbxTipos = new JComboBox<Tipo>();
		cbxTipos.setPreferredSize(new Dimension(150, 20));
		cbxTipos.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTipos.setBounds(204, 222, 173, 26);
		panel_4.add(cbxTipos);
		
		AutoCompleteDecorator.decorate(cbxTipos);
		
		JLabel label_15 = new JLabel("Tipo");
		label_15.setFont(new Font("Calibri", Font.BOLD, 20));
		label_15.setBounds(21, 222, 142, 20);
		panel_4.add(label_15);
		
		JLabel label_16 = new JLabel("Categor\u00EDa");
		label_16.setFont(new Font("Calibri", Font.BOLD, 20));
		label_16.setBounds(21, 264, 142, 20);
		panel_4.add(label_16);
		
		cbxCategorias = new JComboBox<Categoria>();
		cbxCategorias.setPreferredSize(new Dimension(150, 20));
		cbxCategorias.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxCategorias.setBounds(204, 264, 173, 26);
		panel_4.add(cbxCategorias);
		
		AutoCompleteDecorator.decorate(cbxCategorias);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(28, 334, 100, 40);
		panel_4.add(btnAgregar);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setBorder(null);
		btnAgregar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnAgregar.setPreferredSize(new Dimension(100, 40));
		btnAgregar.setBackground(new Color(39, 174, 96));
		btnAgregar.setForeground(Color.WHITE);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(156, 334, 100, 40);
		panel_4.add(btnCancelar);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnCancelar.setPreferredSize(new Dimension(100, 40));
		btnCancelar.setBackground(new Color(52, 108, 175));
		btnCancelar.setForeground(Color.WHITE);
		
		tUnidad = new JTextField();
		tUnidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tUnidad.setColumns(15);
		tUnidad.setBounds(204, 168, 173, 26);
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
