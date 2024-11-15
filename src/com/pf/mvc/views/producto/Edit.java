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

public class Edit extends JPanel {
	public JTextField tNombre;
	public JTextField tCodigo;
	public JTextField tUnidad;
	public JComboBox cbxProductos;
	public JComboBox cbxTipos;
	public JComboBox cbxCategorias;
	public JButton btnActualizar;
	public JButton btnRegresar;
	private JPanel contenido;
	public JButton btnCategorias;
	public JButton btnTipos;
	public JButton btnProductos;

	/**
	 * Create the panel.
	 */
	public Edit() {
		setPreferredSize(new Dimension(900, 580));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		add(panel, BorderLayout.SOUTH);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFocusPainted(false);
		btnActualizar.setBorder(null);
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 16));
		btnActualizar.setPreferredSize(new Dimension(100, 40));
        btnActualizar.setBackground(new Color(39, 174, 96));
        btnActualizar.setForeground(Color.WHITE);
		//btnActualizar.setBackground(SystemColor.inactiveCaptionBorder);
		//btnActualizar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		panel.add(btnActualizar);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setBorder(null);
		btnRegresar.setFocusPainted(false);
		btnRegresar.setFont(new Font("Calibri", Font.BOLD, 16));
		btnRegresar.setPreferredSize(new Dimension(100, 40));
		btnRegresar.setBackground(new Color(52, 108, 175));
		btnRegresar.setForeground(Color.WHITE);
		//btnRegresar.setBackground(SystemColor.inactiveCaptionBorder);
		//btnRegresar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		panel.add(btnRegresar);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_4.setPreferredSize(new Dimension(10, 65));
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		flowLayout_1.setVgap(20);
		flowLayout_1.setHgap(20);
		panel_3.add(panel_4, BorderLayout.NORTH);

		JLabel lblNombre = new JLabel("Producto");
		panel_4.add(lblNombre);
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxProductos = new JComboBox();
		cbxProductos.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxProductos.setPreferredSize(new Dimension(200, 20));
		panel_4.add(cbxProductos);

		JLabel lblAgregarNuevoEn = new JLabel("Agregar nuevo en la lista");
		lblAgregarNuevoEn.setFont(new Font("Calibri", Font.ITALIC, 16));
		panel_4.add(lblAgregarNuevoEn);

		btnProductos = new JButton("");
		btnProductos.setPreferredSize(new Dimension(35, 23));
		btnProductos.setFont(new Font("Calibri", Font.BOLD, 16));
		btnProductos.setBackground(SystemColor.scrollbar);
		panel_4.add(btnProductos);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_6.setPreferredSize(new Dimension(10, 65));
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		flowLayout_2.setVgap(20);
		flowLayout_2.setHgap(20);
		panel_5.add(panel_6, BorderLayout.NORTH);

		JLabel lblCdigo = new JLabel("Nombre");
		panel_6.add(lblCdigo);
		lblCdigo.setFont(new Font("Calibri", Font.BOLD, 16));

		tNombre = new JTextField();
		tNombre.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_6.add(tNombre);
		tNombre.setColumns(30);

		JLabel lblUnidadDeMedida = new JLabel("Código");
		panel_6.add(lblUnidadDeMedida);
		lblUnidadDeMedida.setFont(new Font("Calibri", Font.BOLD, 16));

		tCodigo = new JTextField();
		tCodigo.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_6.add(tCodigo);
		tCodigo.setColumns(15);

		JLabel lblUnidadDeMedida_1 = new JLabel("Unidad de medida");
		panel_6.add(lblUnidadDeMedida_1);
		lblUnidadDeMedida_1.setFont(new Font("Calibri", Font.BOLD, 16));

		tUnidad = new JTextField();
		tUnidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_6.add(tUnidad);
		tUnidad.setColumns(15);

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_8.setPreferredSize(new Dimension(10, 65));
		FlowLayout flowLayout_3 = (FlowLayout) panel_8.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEADING);
		flowLayout_3.setVgap(20);
		flowLayout_3.setHgap(20);
		panel_7.add(panel_8, BorderLayout.NORTH);

		JLabel lblTipo = new JLabel("Tipo");
		panel_8.add(lblTipo);
		lblTipo.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxTipos = new JComboBox();
		cbxTipos.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxTipos.setPreferredSize(new Dimension(150, 20));
		panel_8.add(cbxTipos);

		JLabel label = new JLabel("Agregar nuevo en la lista");
		label.setFont(new Font("Calibri", Font.ITALIC, 16));
		panel_8.add(label);

		btnTipos = new JButton("");
		btnTipos.setPreferredSize(new Dimension(35, 23));
		btnTipos.setFont(new Font("Calibri", Font.BOLD, 16));
		btnTipos.setBackground(SystemColor.scrollbar);
		panel_8.add(btnTipos);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_10.setPreferredSize(new Dimension(10, 65));
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setVgap(20);
		flowLayout_4.setHgap(20);
		flowLayout_4.setAlignment(FlowLayout.LEADING);
		panel_9.add(panel_10, BorderLayout.NORTH);

		JLabel lblCategora = new JLabel("Categoría");
		panel_10.add(lblCategora);
		lblCategora.setFont(new Font("Calibri", Font.BOLD, 16));

		cbxCategorias = new JComboBox();
		cbxCategorias.setFont(new Font("Calibri", Font.PLAIN, 16));
		cbxCategorias.setPreferredSize(new Dimension(150, 20));
		panel_10.add(cbxCategorias);

		JLabel label_1 = new JLabel("Agregar nuevo en la lista");
		label_1.setFont(new Font("Calibri", Font.ITALIC, 16));
		panel_10.add(label_1);

		btnCategorias = new JButton("");
		btnCategorias.setPreferredSize(new Dimension(35, 23));
		btnCategorias.setFont(new Font("Calibri", Font.BOLD, 16));
		btnCategorias.setBackground(SystemColor.scrollbar);
		panel_10.add(btnCategorias);

		
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
