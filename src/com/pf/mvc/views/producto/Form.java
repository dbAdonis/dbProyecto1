package com.pf.mvc.views.producto;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Tipo;
import com.pf.mvc.views.borde.BotonRedondeado;

import javax.swing.border.LineBorder;

public class Form extends JPanel {
	public BotonRedondeado btnAgregar;
	public BotonRedondeado btnCancelar;
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
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1081, 665);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1081, 665);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 13, 1023, 437);
		panel_4.setBorder(new LineBorder(new Color(220, 220, 220), 3));
		panel_4.setPreferredSize(new Dimension(10, 400));
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("Producto");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		label.setBounds(21, 33, 142, 20);
		panel_4.add(label);
		
		cbxProductos = new JComboBox<Naturaleza>();
		cbxProductos.setBorder(null);
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
		tNombre.setBorder(null);
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		tNombre.setColumns(30);
		tNombre.setBounds(204, 75, 366, 26);
		panel_4.add(tNombre);
		
		tCodigo = new JTextField();
		tCodigo.setBorder(null);
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
		cbxTipos.setBorder(null);
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
		label_16.setBounds(21, 270, 142, 20);
		panel_4.add(label_16);
		
		cbxCategorias = new JComboBox<Categoria>();
		cbxCategorias.setBorder(null);
		cbxCategorias.setPreferredSize(new Dimension(150, 20));
		cbxCategorias.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxCategorias.setBounds(204, 270, 173, 26);
		panel_4.add(cbxCategorias);
		
		AutoCompleteDecorator.decorate(cbxCategorias);
		
		btnAgregar = new BotonRedondeado("Agregar",20);
		btnAgregar.setBounds(21, 353, 100, 40);
		panel_4.add(btnAgregar);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		btnAgregar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnAgregar.setPreferredSize(new Dimension(100, 40));
		btnAgregar.setBackground(new Color(39, 174, 96));
		btnAgregar.setForeground(Color.WHITE);
		
		btnCancelar = new BotonRedondeado("Cancelar",20);
		btnCancelar.setBounds(149, 353, 100, 40);
		panel_4.add(btnCancelar);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 139), 3));
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnCancelar.setPreferredSize(new Dimension(100, 40));
		btnCancelar.setBackground(new Color(52, 108, 175));
		btnCancelar.setForeground(Color.WHITE);
		
		tUnidad = new JTextField();
		tUnidad.setBorder(null);
		tUnidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		tUnidad.setColumns(15);
		tUnidad.setBounds(204, 168, 173, 26);
		panel_4.add(tUnidad);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 400, 1081, 265);
		panel_3.add(panel_5);
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
