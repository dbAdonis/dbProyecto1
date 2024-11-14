package com.pf.mvc.controllers;

import java.util.ArrayList;

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
import com.pf.mvc.views.menu.Menu;
import com.pf.mvc.views.menu.Options;

public class ControllerAplicaciones extends Functions implements Controller {

	private DAOAplicacion dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();
	private boolean fincaUno;
	private Index v;
	private Options op;
	private Menu menu;

	public ControllerAplicaciones(ViewPrincipal vp, Menu menu) {
		this.dao = new DAOAplicacion();
		this.vp = vp;
		this.menu = menu;
		this.fincaUno = true;
		
	}

	@Override
	public void index() {

		v = new Index();
		
		op = new Options();
		
		buttons();

		//
		
		op.btnMenu.addActionListener(e->{
			
			vp.setContenido(menu, "Bienvenido(a) al sistema de Fino Follaje!");
			
		});
		
		op.btnFincaUno.addActionListener(e->{
			
			fincaUno = true;
			
			v.modelo.setDataVector(getData(), getColumns());
			
			vp.setContenido(v, "Reportes diarios de finca 1");
			
		});

		op.btnFincaDos.addActionListener(e->{
			
			fincaUno = false;
			
			v.modelo.setDataVector(getData(), getColumns());
			
			vp.setContenido(v, "Reportes diarios de finca 2");
		});
		
		
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
			
			v.modelo.setDataVector(getData(), getColumns());

			
		});
		
		v.btnRegresar.addActionListener(e->{
			
			vp.setContenido(op, "Reportes diarios");
			
		});

		vp.setContenido(op, "Reportes diarios");
	}
	
	public void index(boolean switchFinca) {
		
		v = new Index();
		
		op = new Options();
		
		buttons();
		
		fincaUno = switchFinca;
		
		op.btnMenu.addActionListener(e->{
			
			vp.setContenido(menu, "Bienvenido(a) al sistema de Fino Follaje!");
			
		});
		
		op.btnFincaUno.addActionListener(e->{
			
			fincaUno = true;
			
			v.modelo.setDataVector(getData(), getColumns());
			
			vp.setContenido(v, "Reportes diarios de finca 1");
			
		});

		op.btnFincaDos.addActionListener(e->{
			
			fincaUno = false;
			
			v.modelo.setDataVector(getData(), getColumns());
			
			vp.setContenido(v, "Reportes diarios de finca 2");
		});
		
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
			
			v.modelo.setDataVector(getData(), getColumns());

			
		});
		
		v.btnRegresar.addActionListener(e->{
			
			vp.setContenido(op, "Reportes diarios");
			
		});
	
		
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
			
			if(fincaUno) {
				if(e.getIdFinca() == 1) {
					f.cbxTrabajador.addItem(e);
				}
			}else {
				if(e.getIdFinca() == 2) {
					f.cbxTrabajador.addItem(e);
				}
			}
			
			
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
		
		f.cbxFitoFerti.addActionListener(e->{
			
			Producto p = (Producto) f.cbxFitoFerti.getSelectedItem();
			
			f.tUnidades.setText(p.getUnidades());
		});

//		ArrayList<Object> controles = new DAOSupervisor().getData();
//
//		for (Object o : controles) {
//			Supervisor s = (Supervisor) o;
//			f.cbxControl.addItem(s);
//		}

		f.btnAgregar.addActionListener(e -> {

			int periodo = (int) f.tPeriodoMPS.getValue();
			int semana = (int) f.tWK.getValue();
			String fecha = f.tFecha.getText();
			int cantidad = (int) f.tCantidad.getValue();

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

//			Supervisor s = (Supervisor) f.cbxControl.getSelectedItem();
//			int idSupervisor = s.getId();

			Aplicacion item = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor,
					idProducto, cantidad, 1);

			dao.store(item);
		});
		
		f.btnRegresar.addActionListener(e->{
			
			if(fincaUno) {
				v.modelo.setDataVector(getData(), getColumns());
				vp.setContenido(v, "Reportes diarios de finca 1");
			}else {
				v.modelo.setDataVector(getData(), getColumns());
				vp.setContenido(v, "Reportes diarios de finca 2");
			}
			
		});
		
		f.btnLotes.addActionListener(e->{
			
			ControllerLotes cl = new ControllerLotes(fincaUno, vp, menu);
			cl.index();
			
		});
		
		f.btnVariedades.addActionListener(e->{
			
			ControllerVariedades cv = new ControllerVariedades(fincaUno, vp, menu);
			cv.index();
			
		});
		
		f.btnEmpleados.addActionListener(e->{
			
			new ControllerEmpleados(vp, menu).index(fincaUno);
			
		});
		
		f.btnLabores.addActionListener(e->{
			
			ControllerLabores cl = new ControllerLabores(fincaUno, vp, menu);
			cl.index();
			
		});
		
		f.btnProductos.addActionListener(e->{
			
			new ControllerProductos(vp, menu).index(fincaUno, 0);
			
		});
		
		if(fincaUno) {
			vp.setContenido(f, "Reportes diarios de finca 1");
		}else {
			vp.setContenido(f, "Reportes diarios de finca 2");
		}

		
	}

	@Override
	public void edit(int id) {

		Aplicacion item = (Aplicacion) dao.getItem(id);

		Edit ed = new Edit();

		ArrayList<Object> lotes = new DAOLote().getData();
		ed.cbxLote.removeAllItems();

		for (Object o : lotes) {
			Lote l = (Lote) o;
			ed.cbxLote.addItem(l);

			if (l.getId() == item.getIdLote()) {
				ed.cbxLote.setSelectedItem(l);
			}
		}

		ed.tPeriodoMPS.setValue(item.getPeriodo());
		ed.tWK.setValue(item.getSemana());
		ed.tFecha.setText(item.getFecha());
		ed.tCantidad.setValue(item.getCantidad());
	

		ArrayList<Object> variedades = new DAOVariedad().getData();
		ed.cbxVariedad.removeAllItems();

		for (Object o : variedades) {
			Variedad va = (Variedad) o;
			ed.cbxVariedad.addItem(va);

			if (va.getId() == item.getIdVariedad()) {
				ed.cbxVariedad.setSelectedItem(va);
			}
		}

		ArrayList<Object> trabajadores = new DAOEmpleado().getData();
		ed.cbxTrabajador.removeAllItems();

		for (Object o : trabajadores) {
			Empleado e = (Empleado) o;
			
			if(fincaUno) {
				if(e.getIdFinca() == 1) {
					ed.cbxTrabajador.addItem(e);
				}
			}else {
				if(e.getIdFinca() == 2) {
					ed.cbxTrabajador.addItem(e);
				}
			}
			

			if (e.getId() == item.getIdEmpleado()) {
				ed.cbxTrabajador.setSelectedItem(e);
			}
		}
		
		ArrayList<Object> labores = new DAOLabor().getData();
		ed.cbxLabor.removeAllItems();

		
		for (Object o : labores) {
			Labor l = (Labor) o;
			ed.cbxLabor.addItem(l);

			if (l.getId() == item.getIdLabor()) {
				ed.cbxLabor.setSelectedItem(l);
			}
		}
		
		ArrayList<Object> productos = new DAOProducto().getData();
		ed.cbxFitoFerti.removeAllItems();

		
		for (Object o : productos) {
			Producto p = (Producto) o;
			ed.cbxFitoFerti.addItem(p);

			if (p.getId() == item.getIdProducto()) {
				ed.cbxFitoFerti.setSelectedItem(p);
			}
		}
		
		ed.cbxFitoFerti.addActionListener(e->{
			
			Producto p = (Producto) ed.cbxFitoFerti.getSelectedItem();
			
			ed.tUnidades.setText(p.getUnidades());
		});
		
		
		ed.btnActualizar.addActionListener(e->{
			
			int periodo = (int) ed.tPeriodoMPS.getValue();
			int semana = (int) ed.tWK.getValue();
			String fecha = ed.tFecha.getText();
			int cantidad = (int) ed.tCantidad.getValue();
			
			
			Lote l = (Lote) ed.cbxLote.getSelectedItem();
			int idLote = l.getId();
			
			Variedad va = (Variedad) ed.cbxVariedad.getSelectedItem();
			int idVariedad = va.getId();
			
			Empleado en = (Empleado) ed.cbxTrabajador.getSelectedItem();
			int idEmpleado = en.getId();
			
			Labor la = (Labor) ed.cbxLabor.getSelectedItem();
			int idLabor = la.getId();
			
			Producto p = (Producto) ed.cbxFitoFerti.getSelectedItem();
			int idProducto = p.getId();
			
			Aplicacion nuevoItem;
			
			if(fincaUno) {
				nuevoItem = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor, idProducto, cantidad, 1);
			}else {
				nuevoItem = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor, idProducto, cantidad, 2);
			}
			
			
		
		if (item.getId() > 0) {
			dao.update(nuevoItem, item.getId());
			edit(item.getId());
			if(fincaUno) {
				v.modelo.setDataVector(getData(), getColumns());
				vp.setContenido(v, "Editar reporte diario de finca 1");
			}else {
				v.modelo.setDataVector(getData(), getColumns());
				vp.setContenido(v, "Editar reporte diario de finca 2");
			}
		}
		
		
		
		});
		
		if(fincaUno) {
			vp.setContenido(ed, "Editar reporte diario de finca 1");
		}else {
			vp.setContenido(ed, "Editar reporte diario de finca 2");
		}
		
		ed.btnRegresar.addActionListener(e->{
			
			if(fincaUno) {
				v.modelo.setDataVector(getData(), getColumns());
				vp.setContenido(v, "Reportes diarios de finca 1");
			}else {
				v.modelo.setDataVector(getData(), getColumns());
				vp.setContenido(v, "Reportes diarios de finca 2");
			}
			
		});
		
		ed.btnLotes.addActionListener(e->{
			
			ControllerLotes cl = new ControllerLotes(fincaUno, vp, menu);
			cl.setIdApp(id);
			cl.index();
			
		});
		
		ed.btnVariedades.addActionListener(e->{
			
			ControllerVariedades cv = new ControllerVariedades(fincaUno, vp, menu);
			cv.setIdApp(id);
			cv.index();
			
		});
		
		ed.btnEmpleados.addActionListener(e->{
			
			new ControllerEmpleados(vp, menu).index(fincaUno);
			
		});
		
		ed.btnLabores.addActionListener(e->{
			
			ControllerLabores cl = new ControllerLabores(fincaUno, vp, menu);
			cl.setIdApp(id);
			cl.index();
			
		});
		
		ed.btnProductos.addActionListener(e->{
			
			new ControllerProductos(vp, menu).index(fincaUno, id);
			
		});
		
		
	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();
		ArrayList<Aplicacion> reportesFincaUno = new ArrayList<>();
		ArrayList<Aplicacion> reportesFincaDos = new ArrayList<>();
		Object[][] data;

		ids.clear();

		int i = 0;

		for (Object o : list) {
			Aplicacion a = (Aplicacion) o;
			
			Empleado em = (Empleado) new DAOEmpleado().getItem(a.getIdEmpleado());
			
			if(em.getIdFinca() == 1) {
				
				reportesFincaUno.add(a);
				
			}
			
			if(em.getIdFinca() == 2) {
				
				reportesFincaDos.add(a);
				
			}
			
		}
		
		if(fincaUno){
			data = new Object[reportesFincaUno.size()][getColumns().length];
			for (Aplicacion a : reportesFincaUno) {
				
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
				
				data[i][8] = a.getCantidad();
				
				data[i][9] = producto.getUnidades();
				
				Supervisor supervisor = (Supervisor) new DAOSupervisor().getItem(a.getIdSupervisor());
				data[i][10] = supervisor.getNombre();
				
				i++;
			}
		}else {
			data = new Object[reportesFincaDos.size()][getColumns().length];
			for (Aplicacion a : reportesFincaDos) {
				
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
				
				data[i][8] = a.getCantidad();
				
				data[i][9] = producto.getUnidades();

				Supervisor supervisor = (Supervisor) new DAOSupervisor().getItem(a.getIdSupervisor());
				data[i][10] = supervisor.getNombre();
				
				i++;
			
		}
			
	}
		
		return data;
	}
	
	@Override
	public String[] getColumns() {
		return new String[] { "PERIODO MPS", "WK", "FECHA", "LOTE", "VARIEDAD", "TRABAJADOR", "LABOR",
				"FITOSANITARIO - FERTILIZANTE", "CANTIDAD", "UNIDADES", "CONTROL" };
	}
	
	public void buttons() {
		op.setImagesButtons("/resources/Plantas.png", "/resources/Form.png", "/resources/Form.png");
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
