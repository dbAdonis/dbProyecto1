package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Finca;

public class DAOFinca extends Conexion implements DAO{

	public DAOFinca() {
		
	}

	@Override
	public boolean store(Object o) {

		Connection con = conectar();
		String sql = "insert into fincas (nombre) values (?);";

		try {
			
			Finca f = (Finca) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, f.getNombre());

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
		String sql = "update fincas set nombre = ? where id_finca = ?;";

		try {

			Finca f = (Finca) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, f.getNombre());
			ps.setInt(2, id);

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
		String sql = "delete from fincas where id_finca = ?;";

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
		String sql = "select * from fincas where id_finca = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Finca(rs.getInt("id_finca"), rs.getString("nombre"));

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
		String sql = "select * from fincas;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Finca item = new Finca(rs.getInt("id_finca"), rs.getString("nombre"));

				list.add(item);

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			desconectar(con);
		}

		return list;
	}
	
	

}
