package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Producto;


public class DAOProducto extends Conexion implements DAO {

	public DAOProducto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean store(Object o) {
		Connection con = conectar();
		String sql = "INSERT INTO productos (nombre, unidades, codigo, id_tipo, id_categoria, id_naturaleza) VALUES (?, ?, ?, ?, ?, ?);";

		try {

			Producto item = (Producto) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			ps.setString(2, item.getUnidades());
			ps.setString(3, item.getCodigo());
			ps.setInt(4, item.getIdTipo());
			ps.setInt(5, item.getIdCategoria());
			ps.setInt(6, item.getIdNaturaleza());

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
		String sql = "update productos set nombre = ?, unidades = ?, codigo = ?, id_tipo = ?, id_categoria = ?, id_naturaleza = ?  where id_producto = ?;";

		try {

			Producto item = (Producto) o;

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getNombre());
			ps.setString(2, item.getUnidades());
			ps.setString(3, item.getCodigo());
			ps.setInt(4, item.getIdTipo());
			ps.setInt(5, item.getIdCategoria());
			ps.setInt(6, item.getIdNaturaleza());
			ps.setInt(7, id);

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
		String sql = "delete from productos where id_producto = ?;";

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
		String sql = "select * from productos where id_producto = ?;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				item = new Producto(
						rs.getInt("id_producto"), 
						rs.getString("nombre"), 
						rs.getString("unidades"), 
						rs.getString("codigo"),
						rs.getInt("id_tipo"),
						rs.getInt("id_categoria"),
						rs.getInt("id_naturaleza")
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
		String sql = "select * from productos;";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				Producto p = new Producto(
						rs.getInt("id_producto"), 
						rs.getString("nombre"), 
						rs.getString("unidades"), 
						rs.getString("codigo"),
						rs.getInt("id_tipo"),
						rs.getInt("id_categoria"),
						rs.getInt("id_naturaleza")
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
