package com.pf.mvc.models.vo;

public class Aplicacion {

	private int periodo, fecha, semana, cantidad;
	private int idProducto;
	private int idSupervisor;
	private int idLabor;
	private int idEmpleado;
	private int idLote;
	private int idVariedades;

	// Lo del periodo en los contructores
	public Aplicacion(int periodo, int fecha, int semana, int cantidad, int idProducto, int idSupervisor, int idLabor,
			int idEmpleado, int idLote, int idVariedades) {
		this.periodo = periodo;
		this.fecha = fecha;
		this.semana = semana;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.idSupervisor = idSupervisor;
		this.idLabor = idLabor;
		this.idEmpleado = idEmpleado;
		this.idLote = idLote;
		this.idVariedades = idVariedades;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public int getIdLabor() {
		return idLabor;
	}

	public void setIdLabor(int idLabor) {
		this.idLabor = idLabor;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public int getIdVariedades() {
		return idVariedades;
	}

	public void setIdVariedades(int idVariedades) {
		this.idVariedades = idVariedades;
	}

	@Override
	public String toString() {
		return "Aplicacion [periodo=" + periodo + ", fecha=" + fecha + ", semana=" + semana + ", cantidad=" + cantidad
				+ ", idProducto=" + idProducto + ", idSupervisor=" + idSupervisor + ", idLabor=" + idLabor
				+ ", idEmpleado=" + idEmpleado + ", idLote=" + idLote + ", idVariedades=" + idVariedades + "]";
	}

}
