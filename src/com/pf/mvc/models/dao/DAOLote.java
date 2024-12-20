package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Lote;

public class DAOLote extends Conexion implements DAO {

	public DAOLote() {
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "insert into lotes (nombre, activo) VALUES (?, ?);";

		try {

			Lote item = (Lote) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			ps.setInt(2, item.isActivo() ? 1 : 0);

			ps.execute();

			return true;

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}
	
	public String storeLote(Object o) {
	    Connection con = conectar();
	    String sql = "select * from lotes where nombre = ?;";  

	    try {
	        Lote item = (Lote) o;

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, item.getNombre());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            if (rs.getInt("activo") == 0) {
	                String updateSql = "update lotes set activo = 1 where id_lote = ?";
	                ps = con.prepareStatement(updateSql);
	                ps.setInt(1, rs.getInt("id_lote"));
	                ps.executeUpdate();
	                return "Lote activado correctamente.";
	            } else {
	                return "El lote ya existe y est� activo.";
	            }
	        } else {
	            sql = "insert into lotes (nombre, activo) VALUES (?, ?);";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, item.getNombre());
	            ps.setInt(2, item.isActivo() ? 1 : 0);
	            ps.execute();
	            return "Lote registrado correctamente.";
	        }

	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        return "Error al registrar o activar el lote.";
	    } finally {
	        desconectar(con);
	    }
	}


	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update lotes set nombre = ? where id_lote = ?;";

		try {

			Lote item = (Lote) o;

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
		String sql = "update lotes set activo = 0 where id_lote = ?;";

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
		String sql = "select * from lotes where id_lote = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Lote(rs.getInt("id_lote"), rs.getString("nombre"),
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
		String sql = "select * from lotes where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Lote p = new Lote(rs.getInt("id_lote"), rs.getString("nombre"),
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
