package com.pf.mvc.models.vo;

public class Producto {

	private int id;
	private int idTipo;
	private int idNaturaleza;
	private int idCategoria;
	private String nombre, unidades, codigo;

	public Producto(int idTipo, int idNaturaleza, int idCategoria, String nombre, String unidades, String codigo) {
		this.id = 0;
		this.idTipo = idTipo;
		this.idNaturaleza = idNaturaleza;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.unidades = unidades;
		this.codigo = codigo;
	}

	public Producto(int id, int idTipo, int idNaturaleza, int idCategoria, String nombre, String unidades,
			String codigo) {
		this.id = id;
		this.idTipo = idTipo;
		this.idNaturaleza = idNaturaleza;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.unidades = unidades;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdNaturaleza() {
		return idNaturaleza;
	}

	public void setIdNaturaleza(int idNaturaleza) {
		this.idNaturaleza = idNaturaleza;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", idTipo=" + idTipo + ", idNaturaleza=" + idNaturaleza + ", idCategoria="
				+ idCategoria + ", nombre=" + nombre + ", unidades=" + unidades + ", codigo=" + codigo + "]";
	}

}
