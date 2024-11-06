package com.pf.mvc.controllers;

import com.pf.mvc.views.ViewPrincipal;

public class ControllerPrincipal {

	private ViewPrincipal vp;
	
	public ControllerPrincipal() {
		vp = new ViewPrincipal();
	}
	
	public void init() {
		
		vp.setVisible(true);
		
		vp.btnProducto.addActionListener(e->{
			
			new ControllerProductos(vp).index();
			
		});
		
		
		
		new ControllerProductos(vp).index();
		vp.init();
		
	}
}
