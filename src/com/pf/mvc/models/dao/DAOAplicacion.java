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
        String sql = "INSERT INTO aplicaciones (periodo, semana, fecha, id_lote, id_variedad, id_empleado, id_labor, id_producto, cantidad, id_supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

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
            ps.setInt(10, app.getIdSupervisor());

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
        String sql = "UPDATE aplicaciones SET periodo = ?, semana = ?, fecha = ?, id_lote = ?, id_variedad = ?, id_empleado = ?, id_labor = ?, id_producto = ?, cantidad = ?, id_supervisor = ? WHERE id_aplicacion = ?;";

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
            ps.setInt(10, app.getIdSupervisor());
            ps.setInt(11, id);

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
    
    //Este es el nuevo metodo
    
    public Object[][] getAplicaciones() {
    	
        Connection con = conectar();
        String sql = "select a.id_aplicacion,"
        		+ " a.periodo, a.semana,"
        		+ " a.fecha, l.nombre as lote,"
        		+ " v.nombre as variedad,"
        		+ " e.nombre as empleado,"
        		+ " la.nombre as labor,"
        		+ " p.nombre as producto,"
        		+ " a.cantidad,"
        		+ " p.unidades,"
        		+ " s.nombre as supervisor"
        		+ " from aplicaciones a inner join lotes l on a.id_lote = l.id_lote"
        		+ " inner join variedades v on a.id_variedad = v.id_variedad"
        		+ " inner join empleados e on a.id_empleado = e.id_empleado"
        		+ " inner join labores la on a.id_labor = la.id_labor"
        		+ " inner join productos p on a.id_producto = p.id_producto"
        		+ " inner join supervisores s on a.id_supervisor = s.id_supervisor"
        		+ " order by a.id_aplicacion desc limit 200;";

        try {
            
        	PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //ps.getFetchSize()
            //Error: 0 no retorna la cantidad de filas
            
            rs.last();
            int contadorFilas =rs.getRow();
            rs.beforeFirst();

            Object[][] data = new Object[contadorFilas][12];
            int i = 0;
            
            while (rs.next()) {
            	
            	data[i][0] = rs.getInt("id_aplicacion");
            	data[i][1] = rs.getInt("periodo");
            	data[i][2] = rs.getInt("semana");
            	data[i][3] = rs.getString("fecha");
            	data[i][4] = rs.getString("lote");
            	data[i][5] = rs.getString("variedad");
            	data[i][6] = rs.getString("empleado");
            	data[i][7] = rs.getString("labor");
            	data[i][8] = rs.getString("producto");
            	data[i][9] = rs.getInt("cantidad");
            	data[i][10] = rs.getString("unidades");
            	data[i][11] = rs.getString("supervisor");
                
                i++;
            }
            
           
            
            return data;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return new Object[1][1];

        } finally {
            desconectar(con);
        }

    }
}