package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Tipo;

public class DAOTipo extends Conexion implements DAO {

	public DAOTipo() {
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "insert into tipos (nombre) values (?);";

		try {

			Tipo item = (Tipo) o;

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
	
	public String storeTipo(Object o) {
	    Connection con = conectar();
	    String sql = "select * from tipos where nombre = ?;";

	    try {
	        Tipo item = (Tipo) o;

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, item.getNombre());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            if (rs.getInt("activo") == 0) {
	                String updateSql = "update tipos set activo = 1 where id_tipo = ?";
	                ps = con.prepareStatement(updateSql);
	                ps.setInt(1, rs.getInt("id_tipo"));
	                ps.executeUpdate();
	                return "Tipo reactivado correctamente.";
	            } else {
	                return "El tipo ya existe y está activo.";
	            }
	        } else {
	            sql = "insert into tipos (nombre, activo) values (?, ?);";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, item.getNombre());
	            ps.setInt(2, item.isActivo() ? 1 : 0); 
	            ps.execute();
	            return "Tipo registrado correctamente.";
	        }
	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        return "Error al registrar o actualizar el tipo.";
	    } finally {
	        desconectar(con);
	    }
	}


	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update tipos set nombre = ? where id_tipo = ?;";

		try {

			Tipo item = (Tipo) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			ps.setInt(2, id);

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
	public boolean destroy(int id) {
		Connection con = conectar();
		String sql = "update tipos set activo = 0 where id_tipo = ?;";

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
		String sql = "select * from tipos where id_tipo = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Tipo(rs.getInt("id_tipo"), rs.getString("nombre"),
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
		String sql = "select * from tipos where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Tipo p = new Tipo(rs.getInt("id_tipo"), rs.getString("nombre"),
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
