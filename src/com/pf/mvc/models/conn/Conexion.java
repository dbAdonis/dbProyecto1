package com.pf.mvc.models.conn;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conexion {

	private String host, user, pass, db, url;

	public Conexion() {

		host = "localhost";
		user = "root";
		pass = "";
		db = "if4100_pf_g1";
		url = "jdbc:mysql://" + host + "/" + db;

	}
	
	public Connection conectar() {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Connection");
			con = (Connection) DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			System.err.println("Error de conexion");
		}
		
		return con;
		
	}
	
	public void desconectar(Connection con) {
		
		try {
			con.close();
		} catch (Exception e) {}
		
	}
	
}