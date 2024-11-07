package com.pf.mvc.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.pf.mvc.models.conn.Conexion;
import com.pf.mvc.models.vo.Aplicacion;

public class DAOAplicacion extends Conexion implements DAO {

    public DAOAplicacion() {
    }

    @Override
    public boolean store(Object o) {
        Connection con = conectar();
        String sql = "INSERT INTO aplicaciones (periodo, semana, fecha, id_lote, id_variedad, id_empleado, id_labor, id_producto, cantidad, unidad, id_supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Aplicacion app = (Aplicacion) o;
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, app.getPeriodo());
            ps.setInt(2, app.getSemana());
            ps.setString(3, app.getFecha());
            ps.setInt(4, app.getIdLote());
            ps.setInt(5, app.getIdVariedad());
            ps.setInt(6, app.getIdEmpleado());
            ps.setInt(7, app.getIdLabor());
            ps.setInt(8, app.getIdProducto());
            ps.setInt(9, app.getCantidad());
            ps.setString(10, app.getUnidad());
            ps.setInt(11, app.getIdSupervisor());

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
    public boolean update(Object o, int id) {
        Connection con = conectar();
        String sql = "UPDATE aplicaciones SET periodo = ?, semana = ?, fecha = ?, id_lote = ?, id_variedad = ?, id_empleado = ?, id_labor = ?, id_producto = ?, cantidad = ?, unidad = ?, id_supervisor = ? WHERE id_aplicacion = ?;";

        try {
            Aplicacion app = (Aplicacion) o;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, app.getPeriodo());
            ps.setInt(2, app.getSemana());
            ps.setString(3, app.getFecha());
            ps.setInt(4, app.getIdLote());
            ps.setInt(5, app.getIdVariedad());
            ps.setInt(6, app.getIdEmpleado());
            ps.setInt(7, app.getIdLabor());
            ps.setInt(8, app.getIdProducto());
            ps.setInt(9, app.getCantidad());
            ps.setString(10, app.getUnidad());
            ps.setInt(11, app.getIdSupervisor());
            ps.setInt(12, id);

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
        String sql = "DELETE FROM aplicaciones WHERE id_aplicacion = ?;";

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
        Aplicacion app = null;
        Connection con = conectar();
        String sql = "SELECT * FROM aplicaciones WHERE id_aplicacion = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                app = new Aplicacion(
                    rs.getInt("id_aplicacion"),
                    rs.getInt("periodo"),
                    rs.getInt("semana"),
                    rs.getString("fecha"),
                    rs.getInt("id_lote"),
                    rs.getInt("id_variedad"),
                    rs.getInt("id_empleado"),
                    rs.getInt("id_labor"),
                    rs.getInt("id_producto"),
                    rs.getInt("cantidad"),
                    rs.getString("unidad"),
                    rs.getInt("id_supervisor")
                );
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        } finally {
            desconectar(con);
        }

        return app;
    }

    @Override
    public ArrayList<Object> getData() {
        ArrayList<Object> list = new ArrayList<>();
        Connection con = conectar();
        String sql = "SELECT * FROM aplicaciones;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aplicacion app = new Aplicacion(
                    rs.getInt("id_aplicacion"),
                    rs.getInt("periodo"),
                    rs.getInt("semana"),
                    rs.getString("fecha"),
                    rs.getInt("id_lote"),
                    rs.getInt("id_variedad"),
                    rs.getInt("id_empleado"),
                    rs.getInt("id_labor"),
                    rs.getInt("id_producto"),
                    rs.getInt("cantidad"),
                    rs.getString("unidad"),
                    rs.getInt("id_supervisor")
                );

                list.add(app);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        } finally {
            desconectar(con);
        }

        return list;
    }
}
