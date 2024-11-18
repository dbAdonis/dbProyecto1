package com.pf.mvc.models.vo;

public class Lote {

	private int id;
	private String nombre;
	private boolean activo;

	public Lote(String nombre, boolean activo) {
		this.id = 0;
		this.nombre = nombre;
		this.activo = true;
	}

	public Lote(int id, String nombre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
