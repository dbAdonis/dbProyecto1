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

	public String storeEmpleado(Object o) {
		Connection con = conectar();
		String sql = "select * from empleados where nombre = ? and id_finca = ?;";

		try {
			Empleado e = (Empleado) o;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setInt(2, e.getIdFinca());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getInt("activo") == 0) {
					String updateSql = "update empleados set activo = 1 where id_empleado = ?";
					ps = con.prepareStatement(updateSql);
					ps.setInt(1, rs.getInt("id_empleado"));
					ps.executeUpdate();
					return "Empleado activado correctamente.";
				} else {
					return "El empleado ya existe y está activo.";
				}
			} else {
				sql = "insert into empleados (id_finca, nombre, activo) values (?, ?, ?);";
				ps = con.prepareStatement(sql);
				ps.setInt(1, e.getIdFinca());
				ps.setString(2, e.getNombre());
				ps.setInt(3, e.isActivo() ? 1 : 0);
				ps.execute();
				return "Empleado registrado correctamente.";
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			return "Error al registrar o actualizar el empleado.";
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

			int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0;

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

				item = new Empleado(rs.getInt("id_empleado"), rs.getInt("id_finca"), rs.getString("nombre"),
						rs.getInt("activo") == 1);

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
						rs.getInt("activo") == 1);

				list.add(e);

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return list;
	}
	
	public Object[][] getEmpleados() {
	    Connection con = conectar();
	    String sql = "SELECT e.id_empleado, e.nombre AS empleado, f.nombre AS finca, e.activo " +
	                 "FROM empleados e " +
	                 "INNER JOIN fincas f ON e.id_finca = f.id_finca " +
	                 "WHERE e.activo = 1;";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        ResultSet rs = ps.executeQuery();

	        // Determinar la cantidad de filas en el ResultSet
	        rs.last();
	        int rowCount = rs.getRow();
	        rs.beforeFirst();

	        // Configurar las columnas que necesitamos
	        Object[][] data = new Object[rowCount][4]; // 4 columnas en el SELECT
	        int i = 0;

	        // Rellenar la matriz con los datos de la consulta
	        while (rs.next()) {
	            data[i][0] = rs.getInt("id_empleado");  // ID del empleado
	            data[i][1] = rs.getString("empleado");  // Nombre del empleado
	            data[i][2] = rs.getString("finca");     // Nombre de la finca
	            data[i][3] = rs.getInt("activo") == 1;  // Estado activo (como booleano)
	            i++;
	        }

	        return data;

	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        return new Object[1][1]; // Retornar una matriz vacía si ocurre un error

	    } finally {
	        desconectar(con);
	    }
	}


	

}
