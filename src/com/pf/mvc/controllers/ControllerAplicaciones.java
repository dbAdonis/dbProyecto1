package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOAplicacion;
import com.pf.mvc.models.dao.DAOEmpleado;
import com.pf.mvc.models.dao.DAOFinca;
import com.pf.mvc.models.dao.DAOLabor;
import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.dao.DAOProducto;
import com.pf.mvc.models.dao.DAOSupervisor;
import com.pf.mvc.models.dao.DAOVariedad;
import com.pf.mvc.models.vo.Aplicacion;
import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Finca;
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
	private ArrayList<Integer> ids;
	private int idFinca;

	public ControllerAplicaciones(ViewPrincipal vp) {
		this.dao = new DAOAplicacion();
		this.vp = vp;
		this.ids = new ArrayList<>();
		this.idFinca = -1;
	}

	@Override
	public void index() {

		Index in = new Index();
		
		in.modelo.setDataVector(filtrarData(getData()), getColumns());
		in.ajustarColumnasYExpandirTabla(in.table);


		in.btnNuevo.addActionListener(e -> {

			create();

		});

		in.btnEditar.addActionListener(e -> {
			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un empleado de la tabla para editar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table, ids);
			edit(id);
		});

		in.btnEliminar.addActionListener(e -> {

			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un empleado de la tabla para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table, ids);
			dao.destroy(id);
			index();

		});

		in.tBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				in.tBuscar.setText("");
			}
		});

		in.tBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buscar(in.tBuscar, in.filtro, 0);
			}
		});
		
		cargarCbxFinca(in);
		
		in.cbxFinca.addActionListener(e->{
			
			cbxDatosFinca(in);
			
		});

		vp.setContenido(in, "Reportes diarios");
	}

	@Override
	public void create() {

		Form f = new Form();

		ArrayList<Object> lotes = new DAOLote().getData();

		for (Object o : lotes) {
			Lote l = (Lote) o;
			f.cbxLotes.addItem(l);
		}

		ArrayList<Object> variedades = new DAOVariedad().getData();

		for (Object o : variedades) {
			Variedad v = (Variedad) o;
			f.cbxVariedades.addItem(v);
		}

		ArrayList<Object> trabajadores = new DAOEmpleado().getData();

		for (Object o : trabajadores) {
			Empleado e = (Empleado) o;

			f.cbxTrabajadores.addItem(e);

		}

		ArrayList<Object> labores = new DAOLabor().getData();

		for (Object o : labores) {
			Labor la = (Labor) o;
			f.cbxLabores.addItem(la);
		}

		ArrayList<Object> productos = new DAOProducto().getData();

		for (Object o : productos) {
			Producto p = (Producto) o;
			f.cbxFitoFerti.addItem(p);
		}

		f.cbxFitoFerti.addActionListener(e -> {

			Producto p = (Producto) f.cbxFitoFerti.getSelectedItem();

			f.tUnidades.setText(p.getUnidades());
		});

		f.btnGuardar.addActionListener(e -> {

			int periodo = (int) f.tPeriodoMPS.getValue();
			int semana = (int) f.tWK.getValue();

			java.util.Date fechaSeleccionada = f.tFecha.getDate();
			DateFormat dateFormat = new SimpleDateFormat("Y-MM-dd");
			String fecha = dateFormat.format(fechaSeleccionada);

			int cantidad = (int) f.tCantidad.getValue();

			Lote l = (Lote) f.cbxLotes.getSelectedItem();
			int idLote = l.getId();

			Variedad va = (Variedad) f.cbxVariedades.getSelectedItem();
			int idVariedad = va.getId();
			//
			Empleado em = (Empleado) f.cbxTrabajadores.getSelectedItem();
			int idEmpleado = em.getId();

			Labor la = (Labor) f.cbxLabores.getSelectedItem();
			int idLabor = la.getId();

			Producto p = (Producto) f.cbxFitoFerti.getSelectedItem();
			int idProducto = p.getId();

			Aplicacion item = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor,
					idProducto, cantidad, 1);

			dao.store(item);

			index();

		});

		f.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			index();

		});

		f.btnLotes.addActionListener(e -> {

			new ControllerLotes(vp).index();;

		});

		f.btnVariedades.addActionListener(e -> {

			new ControllerVariedades(vp).index();

		});

		f.btnTrabajadores.addActionListener(e -> {

			new ControllerEmpleados(vp).index();

		});

		f.btnLabores.addActionListener(e -> {

			new ControllerLabores(vp).index();

		});

		f.btnProductos.addActionListener(e -> {

			new ControllerProductos(vp);

		});

		vp.setContenido(f, "Reportes diarios");

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
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(item.getFecha());
			ed.tFecha.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

			ed.cbxTrabajador.addItem(e);

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

		ed.cbxFitoFerti.addActionListener(e -> {

			Producto p = (Producto) ed.cbxFitoFerti.getSelectedItem();

			ed.tUnidades.setText(p.getUnidades());
		});

		ed.btnActualizar.addActionListener(e -> {

			int periodo = (int) ed.tPeriodoMPS.getValue();
			int semana = (int) ed.tWK.getValue();
			java.util.Date fechaSeleccionada = ed.tFecha.getDate();

			DateFormat dateFormat = new SimpleDateFormat("Y-MM-dd");

			String fecha = dateFormat.format(fechaSeleccionada);
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

			Aplicacion nuevoItem = new Aplicacion(periodo, semana, fecha, idLote, idVariedad, idEmpleado, idLabor,
					idProducto, cantidad, 1);

			if (item.getId() > 0) {
				dao.update(nuevoItem, item.getId());
				edit(item.getId());
			}

			index();

		});

		ed.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			index();

		});

		ed.btnLotes.addActionListener(e -> {

			new ControllerLotes(vp).index();;

		});

		ed.btnVariedades.addActionListener(e -> {

			new ControllerVariedades(vp).index();

		});

		ed.btnTrabajadores.addActionListener(e -> {

			new ControllerEmpleados(vp).index();

		});

		ed.btnLabores.addActionListener(e -> {

			new ControllerLabores(vp).index();

		});

		ed.btnProductos.addActionListener(e -> {

			new ControllerProductos(vp);

		});

		
		vp.setContenido(ed, "Editar Reporte");

	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();

		ids.clear();

		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {
			
			Aplicacion a = (Aplicacion) o;

			Empleado em = (Empleado) new DAOEmpleado().getItem(a.getIdEmpleado());
			
			if(idFinca == em.getIdFinca()) {
				ids.add(a.getId());
				data[i][0] = a.getPeriodo();
				data[i][1] = a.getSemana();
				data[i][2] = a.getFecha();

				Lote lote = (Lote) new DAOLote().getItem(a.getIdLote());
				data[i][3] = lote.getNombre();

				Variedad variedad = (Variedad) new DAOVariedad().getItem(a.getIdVariedad());
				data[i][4] = variedad.getNombre();

				data[i][5] = em.getNombre();

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
			if(idFinca == -1) {
				ids.add(a.getId());
				data[i][0] = a.getPeriodo();
				data[i][1] = a.getSemana();
				data[i][2] = a.getFecha();

				Lote lote = (Lote) new DAOLote().getItem(a.getIdLote());
				data[i][3] = lote.getNombre();

				Variedad variedad = (Variedad) new DAOVariedad().getItem(a.getIdVariedad());
				data[i][4] = variedad.getNombre();

				data[i][5] = em.getNombre();

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
	
	public void cargarCbxFinca(Index in) {
		
		ArrayList<Object> list = new DAOFinca().getData();
		
		for (Object o : list) {
			Finca f = (Finca) o;
			in.cbxFinca.addItem(f);
		}
	}
	
	public void cbxDatosFinca(Index in) {
		
		int ind = in.cbxFinca.getSelectedIndex();
		
		if(ind > 0) {
			if(ind == 1) {
				idFinca = -1;
			}else {
				Finca f = (Finca) in.cbxFinca.getSelectedItem();
				idFinca = f.getId();
			}
		}
		in.modelo.setDataVector(filtrarData(getData()), getColumns());
		in.ajustarColumnasYExpandirTabla(in.table);
	}
	
	public Object[][] filtrarData(Object[][] data) {
		ArrayList<Object[]> datosFiltrados = new ArrayList<>();
		
		for (Object[] o : data) {
			for (Object item : o) {
				if(item != null) {
					datosFiltrados.add(o);
					break;
				}
			}
		}
		
		return datosFiltrados.toArray(new Object[0][0]);
	}

	public void actualizarTabla() {
		Index in = new Index();
		in.modelo.setDataVector(getData(), getColumns());

	}

}
