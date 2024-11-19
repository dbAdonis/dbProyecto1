package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Labor;

public class DAOLabor extends Conexion implements DAO {

	public DAOLabor() {
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "insert into labores (nombre, activo) VALUES (?, ?);";

		try {

			Labor item = (Labor) o;

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

	public String storeLabor(Object o) {
		Connection con = conectar();
		String sql = "select * from labores where nombre = ?;";

		try {
			Labor item = (Labor) o;

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getNombre());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getInt("activo") == 0) {
					String updateSql = "update labores set activo = 1 where id_labor = ?";
					ps = con.prepareStatement(updateSql);
					ps.setInt(1, rs.getInt("id_labor"));
					ps.executeUpdate();
					return "Labor activada correctamente.";
				} else {
					return "La labor ya existe y está activa.";
				}
			} else {
				sql = "insert into labores (nombre, activo) VALUES (?, ?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, item.getNombre());
				ps.setInt(2, item.isActivo() ? 1 : 0);
				ps.execute();
				return "Labor registrada correctamente.";
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return "Error al registrar o actualizar la labor.";
		} finally {
			desconectar(con);
		}
	}

	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update labores set nombre = ? where id_labor = ?;";

		try {

			Labor item = (Labor) o;

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
		String sql = "update labores set activo = 0 where id_labor = ?;";

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
		String sql = "select * from labores where id_labor = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Labor(rs.getInt("id_labor"), rs.getString("nombre"), rs.getInt("activo") == 1);
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
		String sql = "select * from labores where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Labor p = new Labor(rs.getInt("id_labor"), rs.getString("nombre"), rs.getInt("activo") == 1);

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
