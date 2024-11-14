package com.pf.mvc.controllers;

import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.menu.Menu;

public class ControllerPrincipal {

	private ViewPrincipal vp;
	
	public ControllerPrincipal() {
		vp = new ViewPrincipal();
	}
	
	public void init() {
		
		Menu menu = new Menu();
		
		//vp.setVisible(true);
		
		menu.btnProductos.addActionListener(e->{
			
			new ControllerProductos(vp, menu).index();
			
		});
		
		
		menu.btnReportesDiarios.addActionListener(e->{
			
			new ControllerAplicaciones(vp, menu).index();
			
		});
		
		menu.btnGestionarPersonal.addActionListener(e->{
			
			new ControllerEmpleados(vp, menu).index();
			
		});
		
		vp.setContenido(menu, "Bienvenido(a) al sistema de Fino Follaje!");
		vp.init();
		
	}
}
