package com.pf.mvc.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
			}
		});

		vp.btnReportesDiarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(vp.btnReportesDiarios);
				new ControllerAplicaciones(vp).index();
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
				vp.desplegarPanelBtnProductos();
			}
		});
		
		vp.btnLotes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			setSelectedButton(vp.btnLotes);
			new ControllerLotes(vp).index();
			}
		});
		
		vp.btnVariedades.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			setSelectedButton(vp.btnVariedades);
			new ControllerVariedades(vp).index();
			}
		});
		
		vp.btnLabores.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			setSelectedButton(vp.btnLabores);
			new ControllerLabores(vp).index();
			}
		});
		
		vp.btnFincas.addActionListener(e->{
			setSelectedButton(vp.btnFincas);
			new ControllerFincas(vp).index();
			vp.ocultarPanelBtnReportes();
			vp.ocultarPanelBtnProductos();
			
		});
		
		vp.btnGestionarNaturalezas.addActionListener(e->{
			setSelectedButton(vp.btnGestionarNaturalezas);
			new ControllerNaturaleza(vp).index();
			
		});
		
		vp.btnGestionarTipos.addActionListener(e->{
			setSelectedButton(vp.btnGestionarTipos);
			new ControllerTipo(vp).index();
			
		});
		
		vp.btnGestionarCategorias.addActionListener(e->{
			setSelectedButton(vp.btnGestionarCategorias);
			new ControllerCategoria(vp).index();
			
		});
		
		vp.btnSupervisor.addActionListener(e->{
			setSelectedButton(vp.btnSupervisor);
			new ControllerSupervisores(vp).index();
			vp.ocultarPanelBtnReportes();
			vp.ocultarPanelBtnProductos();
			
		});

		setSelectedButton(vp.btnGestionarPersonal);
		new ControllerEmpleados(vp).index();
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
