package com.pf.mvc.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import com.pf.mvc.views.ViewPrincipal;

public class ControllerPrincipal {

	private ViewPrincipal vp;
	private JButton botonSeleccionado;

	public ControllerPrincipal() {
		vp = new ViewPrincipal();
	}

	public void init() {
		vp.setVisible(true);
		
		vp.btnGestionarPersonal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(vp.btnGestionarPersonal);
				vp.ocultarPanelBtnReportes();
				vp.ocultarPanelBtnProductos();
				new ControllerEmpleados(vp).index();
				vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal2.png");
				vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
				vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
				vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
				vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
				vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
				vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
				vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
				vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
				vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
				vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
				
			}
		});

		vp.btnReportesDiarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(vp.btnReportesDiarios);
				new ControllerAplicaciones(vp).index();
				vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
				vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte2.png");
				vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
				vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
				vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
				vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
				vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
				vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
				vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
				vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
				vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
				vp.desplegarPanelBtnReportes();
				vp.ocultarPanelBtnProductos();
			}
		});

		vp.btnProductos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(vp.btnProductos);
				vp.ocultarPanelBtnReportes();
				new ControllerProductos(vp).index();
				vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
				vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
				vp.setIconBtn(vp.btnProductos, "/resources/Productos2.png");
				vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
				vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
				vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
				vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
				vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
				vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
				vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
				vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
				vp.desplegarPanelBtnProductos();
			}
		});
		
		vp.btnLotes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			setSelectedButton(vp.btnLotes);
			new ControllerLotes(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote2.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			}
		});
		
		vp.btnVariedades.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			setSelectedButton(vp.btnVariedades);
			new ControllerVariedades(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas2.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			}
		});
		
		vp.btnLabores.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			setSelectedButton(vp.btnLabores);
			new ControllerLabores(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores2.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			}
		});
		
		vp.btnFincas.addActionListener(e->{
			setSelectedButton(vp.btnFincas);
			new ControllerFincas(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca2.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			vp.ocultarPanelBtnReportes();
			vp.ocultarPanelBtnProductos();
			
		});
		
		vp.btnGestionarNaturalezas.addActionListener(e->{
			setSelectedButton(vp.btnGestionarNaturalezas);
			new ControllerNaturaleza(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar2.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			
		});
		
		vp.btnGestionarTipos.addActionListener(e->{
			setSelectedButton(vp.btnGestionarTipos);
			new ControllerTipo(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar2.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			
		});
		
		vp.btnGestionarCategorias.addActionListener(e->{
			setSelectedButton(vp.btnGestionarCategorias);
			new ControllerCategoria(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar2.png");
			
		});
		
		vp.btnSupervisor.addActionListener(e->{
			setSelectedButton(vp.btnSupervisor);
			new ControllerSupervisores(vp).index();
			vp.setIconBtn(vp.btnGestionarPersonal, "/resources/Personal.png");
			vp.setIconBtn(vp.btnReportesDiarios, "/resources/Reporte.png");
			vp.setIconBtn(vp.btnProductos, "/resources/Productos.png");
			vp.setIconBtn(vp.btnFincas, "/resources/Finca.png");
			vp.setIconBtn(vp.btnSupervisor, "/resources/Supervisor2.png");
			vp.setIconBtn(vp.btnLotes, "/resources/Lote.png");
			vp.setIconBtn(vp.btnVariedades, "/resources/Plantas.png");
			vp.setIconBtn(vp.btnLabores, "/resources/Labores.png");
			vp.setIconBtn(vp.btnGestionarNaturalezas, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarTipos, "/resources/Gestionar.png");
			vp.setIconBtn(vp.btnGestionarCategorias, "/resources/Gestionar.png");
			vp.ocultarPanelBtnReportes();
			vp.ocultarPanelBtnProductos();
			
		});

		setSelectedButton(vp.btnReportesDiarios);
		new ControllerAplicaciones(vp).index();
		vp.init();
	}

	private void setSelectedButton(JButton button) {
		if (botonSeleccionado != null) {
			botonSeleccionado.setBackground(new Color(62, 85, 40));
			botonSeleccionado.setForeground(Color.white);
		}

		botonSeleccionado = button;
		botonSeleccionado.setBackground(Color.WHITE);
		botonSeleccionado.setForeground(Color.BLACK);
	}
	
}
