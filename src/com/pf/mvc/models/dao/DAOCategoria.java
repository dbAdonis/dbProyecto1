package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Categoria;

public class DAOCategoria extends Conexion implements DAO {

	public DAOCategoria() {
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "insert into categorias (nombre, activo) VALUES (?, ?);";

		try {

			Categoria item = (Categoria) o;

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

	public String storeCategoria(Object o) {
		Connection con = conectar();
		String sql = "select * from categorias where nombre = ?;";

		try {
			Categoria item = (Categoria) o;

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getNombre());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getInt("activo") == 0) {
					String updateSql = "update categorias set activo = 1 where id_categoria = ?";
					ps = con.prepareStatement(updateSql);
					ps.setInt(1, rs.getInt("id_categoria"));
					ps.executeUpdate();
					return "Categoría reactivada correctamente.";
				} else {
					return "La categoría ya existe y está activa.";
				}
			} else {
				sql = "insert into categorias (nombre, activo) values (?, ?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, item.getNombre());
				ps.setInt(2, item.isActivo() ? 1 : 0);
				ps.execute();
				return "Categoría registrada correctamente.";
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return "Error al registrar o actualizar la categoría.";
		} finally {
			desconectar(con);
		}
	}

	@Override
	public boolean update(Object o, int id) {
		Connection con = conectar();
		String sql = "update categorias set nombre = ? where id_categoria = ?;";

		try {

			Categoria item = (Categoria) o;

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
		String sql = "update categorias set activo = 0 where id_categoria = ?;";

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
		String sql = "select * from categorias where id_categoria = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item = new Categoria(rs.getInt("id_categoria"), rs.getString("nombre"), rs.getInt("activo") == 1);
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
		String sql = "select * from categorias where activo = 1;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria p = new Categoria(rs.getInt("id_categoria"), rs.getString("nombre"),
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
