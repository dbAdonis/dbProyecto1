package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Variedad;

public class DAOVariedad extends Conexion implements DAO {

	public DAOVariedad() {
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "insert into variedades (nombre, activo) VALUES (?, ?);";

		try {

			Variedad item = (Variedad) o;

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
	
	public String storeVariedad(Object o) {
	    Connection con = conectar();
	    String sql = "select * from variedades where nombre = ?;";

	    try {
	        Variedad item = (Variedad) o;
	        
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, item.getNombre());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            if (rs.getInt("activo") == 0) {
	                String updateSql = "update variedades set activo = 1 where id_variedad = ?";
	                ps = con.prepareStatement(updateSql);
	                ps.setInt(1, rs.getInt("id_variedad"));
	                ps.executeUpdate();
	                return "Variedad activada correctamente.";
	            } else {
	                return "La variedad ya existe y está activa.";
	            }
	        } else {
	            sql = "insert into variedades (nombre, activo) VALUES (?, ?);";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, item.getNombre());
	            ps.setInt(2, item.isActivo() ? 1 : 0);
	            ps.execute();
	            return "Variedad registrada correctamente.";
	        }

	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        return "Error al registrar o actualizar la variedad.";
	    } finally {
	        desconectar(con);
	    }
	}



	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update variedades set nombre = ? where id_variedad = ?;";

		try {

			Variedad item = (Variedad) o;

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
		String sql = "update variedades set activo = 0 where id_variedad = ?;";

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
		String sql = "select * from variedades where id_variedad = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Variedad(rs.getInt("id_variedad"), rs.getString("nombre"),
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
		String sql = "select * from variedades where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Variedad p = new Variedad(rs.getInt("id_variedad"), rs.getString("nombre"),
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
