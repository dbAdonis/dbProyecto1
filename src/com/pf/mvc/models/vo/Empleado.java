package com.pf.mvc.models.vo;

public class Empleado {

	private int id;
	private int idFinca;
	private String nombre;
	private boolean activo;

	public Empleado(int idFinca, String nombre, boolean activo) {
		this.id = 0;
		this.idFinca = idFinca;
		this.nombre = nombre;
		this.activo = true;
	}

	public Empleado(int id, int idFinca, String nombre, boolean activo) {
		this.id = id;
		this.idFinca = idFinca;
		this.nombre = nombre;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFinca() {
		return idFinca;
	}

	public void setIdFinca(int idFinca) {
		this.idFinca = idFinca;
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
