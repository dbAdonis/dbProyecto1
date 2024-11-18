package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Empleado;

public class DAOEmpleado extends Conexion implements DAO {

	public DAOEmpleado() {
	}

	@Override
	public boolean store(Object o) {

		Connection con = conectar();
		String sql = "insert into empleados (id_finca, nombre, activo) values (?, ?, ?);";

		try {

			Empleado e = (Empleado) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, e.getIdFinca());
			ps.setString(2, e.getNombre());
			ps.setInt(3, e.isActivo() ? 1 : 0);

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
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update empleados set id_finca = ?, nombre = ? where id_empleado = ?;";

		try {

			Empleado e = (Empleado) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, e.getIdFinca());
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
		String sql = "update empleados set activo = 0 where id_empleado = ?;";

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
		String sql = "select * from empleados where id_empleado = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Empleado(
						rs.getInt("id_empleado"), 
						rs.getInt("id_finca"), 
						rs.getString("nombre"),
						rs.getInt("activo")==1);

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
		ArrayList<Object> list = new ArrayList<Object>();

		Connection con = conectar();
		String sql = "select * from empleados where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Empleado e = new Empleado(
						rs.getInt("id_empleado"), 
						rs.getInt("id_finca"), 
						rs.getString("nombre"), 
						rs.getInt("activo")==1);

				list.add(e);

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return list;
	}

}
