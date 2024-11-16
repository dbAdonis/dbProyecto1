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
				new ControllerEmpleados(vp).index();
			}
		});

		vp.btnReportesDiarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(vp.btnReportesDiarios);
				new ControllerAplicaciones(vp).index();
			}
		});

		vp.btnProductos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(vp.btnProductos);
				new ControllerProductos(vp).index();
			}
		});

		setSelectedButton(vp.btnGestionarPersonal);
		new ControllerEmpleados(vp).index();
		vp.init();
	}

	private void setSelectedButton(JButton button) {
		if (botonSeleccionado != null) {
			botonSeleccionado.setBackground(null);
			botonSeleccionado.setForeground(Color.white);
		}

		botonSeleccionado = button;
		botonSeleccionado.setBackground(Color.WHITE);
		botonSeleccionado.setForeground(Color.BLACK);
	}
}
