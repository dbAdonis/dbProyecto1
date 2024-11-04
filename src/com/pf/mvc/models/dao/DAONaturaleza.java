package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Naturaleza;


public class DAONaturaleza extends Conexion implements DAO {

	public DAONaturaleza() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "INSERT INTO naturalezas (nombre) VALUES (?);";

		try {

			Naturaleza item = (Naturaleza) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			
			ps.execute();

			return true;

		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}

	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update naturalezas set nombre = ? where id_naturaleza = ?;";

		try {

			Naturaleza item = (Naturaleza) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			ps.setInt(2, id);

			ps.execute();

			return true;

		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}

	@Override
	public boolean destroy(int id) {
		Connection con = conectar();
		String sql = "delete from naturalezas where id_naturaleza = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ps.execute();

			return true;

		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
			return false;

		} finally {
			desconectar(con);
		}
	}

	@Override
	public Object getItem(int id) {

		Object item = null;

		Connection con = conectar();
		String sql = "select * from naturalezas where id_naturaleza = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				item = new Naturaleza(
						rs.getInt("id_naturaleza"), 
						rs.getString("nombre")
						);

			}



		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
		} finally {
			desconectar(con);
		}

		return item;
	}

	@Override
	public ArrayList<Object> getData() {
		ArrayList<Object> list = new ArrayList<Object>();

		Connection con = conectar();
		String sql = "select * from naturalezas;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				Naturaleza p = new Naturaleza(
						rs.getInt("id_naturaleza"), 
						rs.getString("nombre")
						);
				
				list.add(p);

			}



		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
		} finally {
			desconectar(con);
		}

		return list;
	}

}
