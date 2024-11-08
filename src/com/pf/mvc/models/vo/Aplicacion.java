package com.pf.mvc.models.vo;

public class Aplicacion {

	private int id;
	private int periodo, semana;
	private String fecha;
	private int idLote;
	private int idVariedad;
	private int idEmpleado;
	private int idLabor;
	private int idProducto;
	private int cantidad;
	private int idSupervisor;

	public Aplicacion(int periodo, int semana, String fecha, int idLote, int idVariedad, int idEmpleado, int idLabor,
			int idProducto, int cantidad, int idSupervisor) {
		this.id = -1;
		this.periodo = periodo;
		this.semana = semana;
		this.fecha = fecha;
		this.idLote = idLote;
		this.idVariedad = idVariedad;
		this.idEmpleado = idEmpleado;
		this.idLabor = idLabor;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	
		this.idSupervisor = idSupervisor;
	}

	public Aplicacion(int id, int periodo, int semana, String fecha, int idLote, int idVariedad,
			int idEmpleado, int idLabor, int idProducto, int cantidad, int idSupervisor) {
		this.id = id;
		this.periodo = periodo;
		this.semana = semana;
		this.fecha = fecha;
		this.idLote = idLote;
		this.idVariedad = idVariedad;
		this.idEmpleado = idEmpleado;
		this.idLabor = idLabor;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		
		this.idSupervisor = idSupervisor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public int getIdVariedad() {
		return idVariedad;
	}

	public void setIdVariedad(int idVariedad) {
		this.idVariedad = idVariedad;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdLabor() {
		return idLabor;
	}

	public void setIdLabor(int idLabor) {
		this.idLabor = idLabor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	@Override
	public String toString() {
		return "Aplicacion [id=" + id + ", periodo=" + periodo + ", semana=" + semana + ", fecha="
				+ fecha + ", idLote=" + idLote + ", idVariedad=" + idVariedad + ", idEmpleado=" + idEmpleado
				+ ", idLabor=" + idLabor + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", unidad="
				+ ", idSupervisor=" + idSupervisor + "]";
	}

}
