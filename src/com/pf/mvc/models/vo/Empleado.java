package com.pf.mvc.models.vo;

public class Empleado {

	private int id;
	private int idFinca;
	private String nombre;

	public Empleado(int idFinca, String nombre) {
		this.id = 0;
		this.idFinca = idFinca;
		this.nombre = nombre;
	}

	public Empleado(int id, int idFinca, String nombre) {
		this.id = id;
		this.idFinca = idFinca;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return nombre;
	}

}
