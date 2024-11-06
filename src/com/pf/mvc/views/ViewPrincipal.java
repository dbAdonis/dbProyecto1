package com.pf.mvc.views;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;

public class ViewPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contenido;
	public JLabel lEstado;
	public JLabel lTitulo;

	public JButton btnLabor;
	public JButton btnSupervisor;
	public JButton btnEmpleados;
	private JPanel panel_4;
	public JButton btnLote;
	public JButton btnVariedad;
	public JButton btnProducto;
	public JButton btnNaturaleza;
	public JButton btnCategoria;
	public JButton btnTipo;
	public JButton btnAplicacion;
	public JButton btnReporte;

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 736);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setPreferredSize(new Dimension(150, 10));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		panel_4 = new JPanel();
		panel_4.setBackground(null);
		panel_4.setPreferredSize(new Dimension(130, 500));
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 5));

		btnEmpleados = new JButton("Empleado");
		panel_4.add(btnEmpleados);

		btnSupervisor = new JButton("Supervisor");
		panel_4.add(btnSupervisor);

		btnLabor = new JButton("Labor");
		panel_4.add(btnLabor);
		
		btnLote = new JButton("Lote");
		panel_4.add(btnLote);
		
		btnVariedad = new JButton("Variedad");
		panel_4.add(btnVariedad);
		
		btnProducto = new JButton("Producto");
		panel_4.add(btnProducto);
		
		btnNaturaleza = new JButton("Naturaleza");
		panel_4.add(btnNaturaleza);
		
		btnCategoria = new JButton("Categor\u00EDa");
		panel_4.add(btnCategoria);
		
		btnTipo = new JButton("Tipo");
		panel_4.add(btnTipo);
		
		btnAplicacion = new JButton("Aplicaci\u00F3n");
		panel_4.add(btnAplicacion);
		
		btnReporte = new JButton("Reporte");
		panel_4.add(btnReporte);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.setPreferredSize(new Dimension(10, 50));
		panel_1.add(panel_2, BorderLayout.NORTH);

		lTitulo = new JLabel("Titulo");
		lTitulo.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		panel_2.add(lTitulo);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 10, 0, 10));
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(10, 30));
		panel_1.add(panel_3, BorderLayout.SOUTH);

		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblEstado);

		lEstado = new JLabel("...");
		lEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_3.add(lEstado);

		contenido = new JPanel();
		contenido.setPreferredSize(new Dimension(900, 600));
		contenido.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new BorderLayout(20, 20));
	}

	
	public void init() {
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public void setContenido(JComponent c, String titulo) {

		lTitulo.setText(titulo);

		contenido.removeAll();

		if(c != null) {
			contenido.add(c, BorderLayout.CENTER);
		}

		contenido.repaint();
		contenido.revalidate();

	}


















}
