package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.facturacion.mvc.models.vo.Factura;
import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Empleado;

public class DAOEmpleado extends Conexion implements DAO {

	public DAOEmpleado() {}
	
	@Override
	public boolean store(Object o) {
		
		Connection con = conectar();
		String sql = "insert into empleados (id, nombre) values (?, ?)";

		try {
			Empleado e = (Empleado) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, e.getId());
			ps.setString(2, e.getNombre());

			ps.execute();

			// 2.obtenemos el nuevo id
			int id = getLastID();
			e.setId(id);

		

			return true;

		} catch (Exception e) {

			System.err.println("ERROR: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}

	}
	

	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update empleado set id = ?, nombre = ? where id_empleado = ?";

		try {

			// 1. Realizar la actualizacion
			Empleado e = (Empleado) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, e.getId());
			ps.setString(2, e.getNombre());
			ps.setInt(3, id);

			ps.execute();

			return true;

		} catch (Exception e) {

			System.err.println("ERROR: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}

	
	@Override
	public boolean destroy(int id) {
		
		Connection con = conectar();
		String sql = "delete from empleados where id_empleados = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ps.execute();

			return true;

		} catch (Exception e) {

			System.err.println("ERROR: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}

	}

	@Override
	public Object getItem(int id) {
		
		Object item = null;

		Connection con = conectar();
		String sql = "select * from empleados where id_empleado = ?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Empleado e = new Empleado(rs.getInt("id_empleado"), rs.getString("nombre"));

				item = e;
			}

		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());

		} finally {
			desconectar(con);
		}

		return item;

	}


	@Override
	public ArrayList<Object> getData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getLastID() {//obtener el ultimo ID del empleado insertado

		int id = 0;

		Connection con = conectar();
		String sql = "select max(id_empleado) as id from empleados;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.next();

			id = rs.getInt("id");

		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());

		} finally {
			desconectar(con);
		}

		return id;

	}
	

}
