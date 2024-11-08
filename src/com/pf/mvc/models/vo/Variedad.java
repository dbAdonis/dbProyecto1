package com.pf.mvc.models.vo;

public class Variedad {

	private int id;
	private String nombre;

	public Variedad(String nombre) {
		this.id = 0;
		this.nombre = nombre;
	}

	public Variedad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
