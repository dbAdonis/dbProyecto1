package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Supervisor;

public class DAOSupervisor extends Conexion implements DAO {

	public DAOSupervisor() {
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "INSERT INTO supervisores (nombre) VALUES (?);";

		try {

			Supervisor item = (Supervisor) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());

			ps.execute();

			return true;

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}
	
	public String storeSupervisor(Object o) {
	    Connection con = conectar();
	    String sql = "select * from supervisores where nombre = ?;";

	    try {
	        Supervisor item = (Supervisor) o;

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, item.getNombre());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            if (rs.getInt("activo") == 0) {
	                String updateSql = "update supervisores set activo = 1 where id_supervisor = ?";
	                ps = con.prepareStatement(updateSql);
	                ps.setInt(1, rs.getInt("id_supervisor"));
	                ps.executeUpdate();
	                return "Supervisor reactivado correctamente.";
	            } else {
	                return "El supervisor ya existe y está activo.";
	            }
	        } else {
	            sql = "insert into supervisores (nombre, activo) values (?, ?);";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, item.getNombre());
	            ps.setInt(2, item.isActivo() ? 1 : 0); 
	            ps.execute();
	            return "Supervisor registrado correctamente.";
	        }
	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        return "Error al registrar o actualizar el supervisor.";
	    } finally {
	        desconectar(con);
	    }
	}


	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update supervisores set nombre = ? where id_supervisor = ?;";

		try {

			Supervisor item = (Supervisor) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			ps.setInt(2, id);

			ps.execute();

			int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0;

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}

	@Override
	public boolean destroy(int id) {
		Connection con = conectar();
		String sql = "update supervisores set activo = 0 where id_supervisor = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ps.execute();

			return true;

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}

	@Override
	public Object getItem(int id) {
		Object item = null;

		Connection con = conectar();
		String sql = "select * from supervisores where id_supervisor = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Supervisor(rs.getInt("id_supervisor"), rs.getString("nombre"),
						rs.getInt("activo")==1);

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return item;
	}

	@Override
	public ArrayList<Object> getData() {

		ArrayList<Object> list = new ArrayList<Object>();

		Connection con = conectar();
		String sql = "select * from supervisores where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Supervisor p = new Supervisor(rs.getInt("id_supervisor"), rs.getString("nombre"),
						rs.getInt("activo")==1);

				list.add(p);

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return list;
	}

}
