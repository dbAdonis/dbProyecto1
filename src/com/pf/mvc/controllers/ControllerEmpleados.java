package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOEmpleado;
import com.pf.mvc.models.dao.DAOFinca;
import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.empleado.Create;
import com.pf.mvc.views.empleado.Index;
import com.pf.mvc.views.menu.Menu;
import com.pf.mvc.views.menu.Options;

public class ControllerEmpleados extends Functions implements Controller {

	private DAOEmpleado dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();

	public ControllerEmpleados(ViewPrincipal vp) {
		this.dao = new DAOEmpleado();
		this.vp = vp;
	}

	@Override
	public void index() {

		Index in = new Index();

		in.modelo.setDataVector(getData(), getColumns());

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
				buscar(in.tBuscar, in.filtro);
			}
		});

		vp.setContenido(in, "Gestionar personal");

	}

	@Override
	public void create() {

		Create c = new Create();

		ArrayList<Object> fincas = new DAOFinca().getData();
		for (Object o : fincas) {
			Finca r = (Finca) o;
			c.cbxFincas.addItem(r);
		}

		c.btnGuardar.addActionListener(e -> {
			String nombre = c.tNombre.getText();

			Finca r = (Finca) c.cbxFincas.getSelectedItem();

			if (nombre.isEmpty() || r == null) {
				JOptionPane.showMessageDialog(c, "Todos los campos deben estar completos.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			Empleado item = new Empleado(r.getId(), nombre);

			store(item);

			index();
		});
		
		c.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			index();

		});


		vp.setContenido(c, "Registrar Empleado");

	}

	@Override
	public void edit(int id) {

		Empleado em = (Empleado) dao.getItem(id);

		Create c = new Create();

		c.tNombre.setText(em.getNombre());

		ArrayList<Object> fincas = new DAOFinca().getData();
		c.cbxFincas.removeAllItems();

		Finca fincaEmpleado = null;
		for (Object o : fincas) {
			Finca r = (Finca) o;

			c.cbxFincas.addItem(r);
			if (r.getId() == em.getIdFinca()) {
				fincaEmpleado = r;
			}
		}

		if (fincaEmpleado != null) {
			c.cbxFincas.setSelectedItem(fincaEmpleado);
		}

		c.btnGuardar.addActionListener(e -> {

			String nombre = c.tNombre.getText();

			em.setNombre(nombre);

			Finca r = (Finca) c.cbxFincas.getSelectedItem();

			Empleado item = new Empleado(r.getId(), nombre);

			if (em.getId() > 0) {
				dao.update(item, em.getId());
				//edit(em.getId());
			}

			index();

		});

		c.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			index();

		});
		
		vp.setContenido(c, "Editar Empleado");

	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();

		ids.clear();

		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {

			Empleado item = (Empleado) o;

			ids.add(item.getId());

			data[i][0] = item.getNombre();

			Finca finca = (Finca) new DAOFinca().getItem(item.getIdFinca());
			data[i][1] = finca != null ? finca.getNombre() : "Sin Finca";
			i++;

		}

		return data;

	}

	@Override
	public String[] getColumns() {
		return new String[] { "Empleado", "Finca" };
	}

	@Override
	public void store(Object o) {
		dao.store(o);

		actualizarTabla();

	}

	@Override
	public void update(Object o, int id) {

		dao.update(o, id);

		actualizarTabla();
	}

	@Override
	public void destroy(int id) {

		dao.destroy(id);

		actualizarTabla();

	}

	public void actualizarTabla() {
		Index in = new Index();
		in.modelo.setDataVector(getData(), getColumns());

	}

}
