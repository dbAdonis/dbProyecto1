package com.pf.mvc.controllers;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pf.mvc.models.dao.DAOAplicacion;
import com.pf.mvc.models.dao.DAOEmpleado;
import com.pf.mvc.models.dao.DAOLabor;
import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.dao.DAOProducto;
import com.pf.mvc.models.dao.DAOSupervisor;
import com.pf.mvc.models.dao.DAOVariedad;
import com.pf.mvc.models.vo.Aplicacion;
import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Labor;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.models.vo.Producto;
import com.pf.mvc.models.vo.Supervisor;
import com.pf.mvc.models.vo.Variedad;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.aplicacion.Edit;
import com.pf.mvc.views.aplicacion.Form;
import com.pf.mvc.views.aplicacion.Index;

public class ControllerAplicaciones extends Functions implements Controller {

	private DAOAplicacion dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();

	public ControllerAplicaciones(ViewPrincipal vp) {
		dao = new DAOAplicacion();
		this.vp = vp;
	}

	@Override
	public void index() {

		Index v = new Index();

		v.modelo.setDataVector(getData(), getColumns());

		v.btnAgregarConsumo.addActionListener(e -> {
			create();
		});

		v.btnEditar.addActionListener(e -> {
			int id = getSelectedId(v.tableConsumo, ids);
			edit(id);
		});

		v.btnEliminar.addActionListener(e -> {

			Aplicacion item = (Aplicacion) dao.getItem(getSelectedId(v.tableConsumo, ids));
			dao.destroy(item.getId());

			index();
		});

		vp.setContenido(v, "Lista de Consumo");
	}

	@Override
	public void create() {

		Form f = new Form();
		// falta fecha

		ArrayList<Object> lotes = new DAOLote().getData();

		for (Object o : lotes) {
			Lote l = (Lote) o;
			f.cbxLote.addItem(l);
		}

		ArrayList<Object> variedades = new DAOVariedad().getData();

		for (Object o : variedades) {
			Variedad v = (Variedad) o;
			f.cbxVariedad.addItem(v);
		}

		ArrayList<Object> trabajadores = new DAOEmpleado().getData();

		for (Object o : trabajadores) {
			Empleado e = (Empleado) o;
			f.cbxTrabajador.addItem(e);
		}

		ArrayList<Object> labores = new DAOLabor().getData();

		for (Object o : labores) {
			Labor la = (Labor) o;
			f.cbxLabor.addItem(la);
		}

		ArrayList<Object> productos = new DAOProducto().getData();

		for (Object o : productos) {
			Producto p = (Producto) o;
			f.cbxFitoFerti.addItem(p);
		}

		ArrayList<Object> controles = new DAOSupervisor().getData();

		for (Object o : controles) {
			Supervisor s = (Supervisor) o;
			f.cbxControl.addItem(s);
		}

		f.btnAgregar.addActionListener(e -> {

			int periodo = Integer.parseInt(f.tPeriodoMPS.getText());
			int semana = Integer.parseInt(f.tWK.getText());
			String fecha = f.tFecha.getText();
			int cantidad = Integer.parseInt(f.tCantidad.getText());

			Lote l = (Lote) f.cbxLote.getSelectedItem();
			int idLote = l.getId();

			Variedad v = (Variedad) f.cbxVariedad.getSelectedItem();
			int idVariedad = v.getId();
			//
			Empleado em = (Empleado) f.cbxTrabajador.getSelectedItem();
			int idEmpleado = em.getId();

			Labor la = (Labor) f.cbxLabor.getSelectedItem();
			int idLabor = la.getId();

			Producto p = (Producto) f.cbxFitoFerti.getSelectedItem();
			int idProducto = p.getId();

			Supervisor s = (Supervisor) f.cbxControl.getSelectedItem();
			int idSupervisor = s.getId();

			Aplicacion item = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor,
					idProducto, cantidad, idSupervisor);

			dao.store(item);
			index();
		});

		vp.setContenido(f, "Agregar Consumo");
	}

	@Override
	public void edit(int id) {

		Aplicacion item = (Aplicacion) dao.getItem(id);

		Edit v = new Edit();

		ArrayList<Object> lotes = new DAOLote().getData();
		v.cbxLote.removeAllItems();

		for (Object o : lotes) {
			Lote l = (Lote) o;
			v.cbxLote.addItem(l);

			if (l.getId() == item.getIdLote()) {
				v.cbxLote.setSelectedItem(l);
			}
		}

		v.tPeriodoWPS.setText(item.getPeriodo() + " ");
		v.tWK.setText(item.getSemana() + " ");
		v.tCantidad.setText(item.getCantidad() + " ");
	

		ArrayList<Object> variedades = new DAOVariedad().getData();
		v.cbxVariedad.removeAllItems();

		for (Object o : variedades) {
			Variedad va = (Variedad) o;
			v.cbxVariedad.addItem(va);

			if (va.getId() == item.getIdVariedad()) {
				v.cbxVariedad.setSelectedItem(va);
			}
		}

		ArrayList<Object> trabajadores = new DAOEmpleado().getData();
		v.cbxTrabajador.removeAllItems();

		for (Object o : trabajadores) {
			Empleado e = (Empleado) o;
			v.cbxTrabajador.addItem(e);

			if (e.getId() == item.getIdEmpleado()) {
				v.cbxTrabajador.setSelectedItem(e);
			}
		}
		
		ArrayList<Object> labores = new DAOLabor().getData();
		v.cbxLabor.removeAllItems();

		
		for (Object o : labores) {
			Labor l = (Labor) o;
			v.cbxLabor.addItem(l);

			if (l.getId() == item.getIdLabor()) {
				v.cbxLabor.setSelectedItem(l);
			}
		}
		
		ArrayList<Object> productos = new DAOProducto().getData();
		v.cbxFitoFerti.removeAllItems();

		
		for (Object o : productos) {
			Producto p = (Producto) o;
			v.cbxFitoFerti.addItem(p);

			if (p.getId() == item.getIdProducto()) {
				v.cbxFitoFerti.setSelectedItem(p);
			}
		}
		
		ArrayList<Object> controles = new DAOSupervisor().getData();
		v.cbxControl.removeAllItems();

		
		for (Object o : controles) {
			Supervisor s = (Supervisor) o;
			v.cbxControl.addItem(s);

			if (s.getId() == item.getIdSupervisor()) {
				v.cbxControl.setSelectedItem(s);
			}
		}
		
		v.btnActualizar.addActionListener(e->{
			
			int periodo = Integer.parseInt(v.tPeriodoWPS.getText());
			int semana = Integer.parseInt(v.tWK.getText());
			String fecha = v.tFecha.getText();
			int cantidad = Integer.parseInt(v.tCantidad.getText());
			
			
			Lote l = (Lote) v.cbxLote.getSelectedItem();
			int idLote = l.getId();
			
			Variedad va = (Variedad) v.cbxVariedad.getSelectedItem();
			int idVariedad = va.getId();
			
			Empleado en = (Empleado) v.cbxTrabajador.getSelectedItem();
			int idEmpleado = en.getId();
			
			Labor la = (Labor) v.cbxLabor.getSelectedItem();
			int idLabor = la.getId();
			
			Producto p =(Producto) v.cbxFitoFerti.getSelectedItem();
			int idProducto = p.getId();
			
			Supervisor s = (Supervisor) v.cbxControl.getSelectedItem();
			int idSupervisor = s.getId();
			
			Aplicacion nuevoItem = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor, idProducto, cantidad, idSupervisor);
		
		if (item.getId() > 0) {
			dao.update(nuevoItem, item.getId());
			edit(item.getId());
		}
		
		index();
		});
		
		vp.setContenido(v, "Editar Consumo");
	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();

		ids.clear();

		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {
			Aplicacion a = (Aplicacion) o;

			ids.add(a.getId());

			data[i][0] = a.getPeriodo();
			data[i][1] = a.getSemana();
			data[i][2] = a.getFecha();

			Lote lote = (Lote) new DAOLote().getItem(a.getIdLote());
			data[i][3] = lote.getNombre();

			Variedad variedad = (Variedad) new DAOVariedad().getItem(a.getIdVariedad());
			data[i][4] = variedad.getNombre();

			Empleado empleado = (Empleado) new DAOEmpleado().getItem(a.getIdEmpleado());
			data[i][5] = empleado.getNombre();

			Labor labor = (Labor) new DAOLabor().getItem(a.getIdLabor());
			data[i][6] = labor.getNombre();

			Producto producto = (Producto) new DAOProducto().getItem(a.getIdProducto());
			data[i][7] = producto.getNombre();
			data[i][8] = producto.getUnidades();

			data[i][9] = a.getCantidad();

			Supervisor supervisor = (Supervisor) new DAOSupervisor().getItem(a.getIdSupervisor());
			data[i][10] = supervisor.getNombre();

			i++;
		}
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String[] { "PERIODO MPS", "WK", "FECHA", "LOTE", "VARIEDAD", "TRABAJADOR", "LABOR",
				"FITOSANITARIO - FERTILIZANTE", "CANTIDAD", "UNIDADES", "CONTROL" };
	}

	@Override
	public void store(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub

	}

}
