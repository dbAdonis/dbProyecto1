package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.pf.mvc.models.dao.DAOEmpleado;
import com.pf.mvc.models.dao.DAOFinca;
import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.empleado.Index;
import com.pf.mvc.views.menu.Menu;
import com.pf.mvc.views.menu.Options;

public class ControllerEmpleados extends Functions implements Controller {

	private DAOEmpleado dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();
	private Menu menu;
	private boolean fincaUno;
	private Index v;
	private Options op;

	public ControllerEmpleados(ViewPrincipal vp, Menu menu) {
		dao = new DAOEmpleado();
		this.vp = vp;
		this.menu = menu;
		fincaUno = true;
	}

	@Override
	public void index() {

		op = new Options();

		v = new Index();

		buttons();

		op.btnMenu.addActionListener(e -> {

			vp.setContenido(menu, "Bienvenido(a) al sistema de Fino Follaje!");

		});

		op.btnFincaUno.addActionListener(e -> {

			fincaUno = true;

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 1");

		});

		op.btnFincaDos.addActionListener(e -> {

			fincaUno = false;

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 2");

		});

		v.btnRegresar.addActionListener(e -> {

			vp.setContenido(op, "Gestionar empleados");

		});

		v.btnAgregar.addActionListener(e -> {

			v.lblTitulo.setText("Registar nuevo empleado");

			create();

			v.tNombre.setText("");

		});

		v.btnEditar.addActionListener(e -> {

			int row = v.tableEmpleados.getSelectedRow();
			if (row > -1) {
				v.lblTitulo.setText("Editar empleado");
				v.btnActualizar.setVisible(true);
				v.btnActualizar.setEnabled(true);
				v.btnCancelar.setVisible(true);
				v.btnCancelar.setEnabled(true);
				v.btnAgregar.setVisible(false);
				v.btnAgregar.setEnabled(false);

				int id = (int) v.tableEmpleados.getValueAt(row, 0);
				edit(id);
			}

		});

		v.btnEliminar.addActionListener(e -> {

			int row = v.tableEmpleados.getSelectedRow();
			int id = (int) v.tableEmpleados.getValueAt(row, 0);

			destroy(id);

		});

		v.tBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				v.tBuscar.setText("");
			}
		});

		v.tBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buscar(v.tBuscar, v.filtro);
			}
		});

		vp.setContenido(op, "Gestionar personal");

	}

	public void index(boolean switchFinca) {

		op = new Options();

		v = new Index();

		buttons();

		fincaUno = switchFinca;

		op.btnMenu.addActionListener(e -> {

			vp.setContenido(menu, "Bienvenido(a) al sistema de Fino Follaje!");

		});

		op.btnFincaUno.addActionListener(e -> {

			fincaUno = true;

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 1");

		});

		op.btnFincaDos.addActionListener(e -> {

			fincaUno = false;

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 2");

		});

		v.btnRegresar.addActionListener(e -> {
			ControllerAplicaciones ca = new ControllerAplicaciones(vp, menu);
			ca.index(fincaUno);
			ca.create();

		});

		v.btnAgregar.addActionListener(e -> {

			v.lblTitulo.setText("Registar nuevo empleado");

			create();

			v.tNombre.setText("");

		});

		v.btnEditar.addActionListener(e -> {

			int row = v.tableEmpleados.getSelectedRow();
			if (row > -1) {
				v.lblTitulo.setText("Editar empleado");
				v.btnActualizar.setVisible(true);
				v.btnActualizar.setEnabled(true);
				v.btnCancelar.setVisible(true);
				v.btnCancelar.setEnabled(true);
				v.btnAgregar.setVisible(false);
				v.btnAgregar.setEnabled(false);

				int id = (int) v.tableEmpleados.getValueAt(row, 0);
				edit(id);
			}

		});

		v.btnEliminar.addActionListener(e -> {

			int row = v.tableEmpleados.getSelectedRow();
			int id = (int) v.tableEmpleados.getValueAt(row, 0);

			destroy(id);

		});

		if (switchFinca) {

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 1");
		} else {

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 2");
		}

	}

	@Override
	public void create() {

		if (fincaUno) {

			int idFinca = 1;
			String nombre = v.tNombre.getText();

			Empleado item = new Empleado(idFinca, nombre);

			store(item);

		} else {

			int idFinca = 2;
			String nombre = v.tNombre.getText();

			Empleado item = new Empleado(idFinca, nombre);

			store(item);
		}

	}

	@Override
	public void edit(int id) {

		Empleado em = (Empleado) dao.getItem(id);

		v.tNombre.setText(em.getNombre());

		v.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			v.lblTitulo.setText("Registrar nuevo empleado");
			v.btnActualizar.setVisible(false);
			v.btnActualizar.setEnabled(false);
			v.btnCancelar.setVisible(false);
			v.btnCancelar.setEnabled(false);
			v.btnAgregar.setVisible(true);
			v.btnAgregar.setEnabled(true);

			v.tNombre.setText("");

		});

		v.btnActualizar.addActionListener(e -> {

			String nombre = v.tNombre.getText();

			Empleado item = new Empleado(em.getIdFinca(), nombre);

			update(item, id);

			v.lblTitulo.setText("Registrar nuevo empleado");
			v.btnActualizar.setVisible(false);
			v.btnActualizar.setEnabled(false);
			v.btnCancelar.setVisible(false);
			v.btnCancelar.setEnabled(false);
			v.btnAgregar.setVisible(true);
			v.btnAgregar.setEnabled(true);

			v.tNombre.setText("");

		});

	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();
		ArrayList<Empleado> empleadosF1 = new ArrayList<>();
		ArrayList<Empleado> empleadosF2 = new ArrayList<>();
		Object[][] data;

		ids.clear();

		int i = 0;

		for (Object o : list) {

			Empleado item = (Empleado) o;
			if (item.getIdFinca() == 1) {

				empleadosF1.add(item);

			}

			if (item.getIdFinca() == 2) {

				empleadosF2.add(item);

			}

		}

		if (fincaUno) {
			data = new Object[empleadosF1.size()][getColumns().length];
			for (Empleado item : empleadosF1) {
				data[i][0] = item.getId();

				Finca finca = (Finca) new DAOFinca().getItem(item.getIdFinca());

				data[i][1] = finca.getNombre();

				data[i][2] = item.getNombre();
				i++;
			}
		} else {
			data = new Object[empleadosF2.size()][getColumns().length];
			for (Empleado item : empleadosF2) {
				data[i][0] = item.getId();

				Finca finca = (Finca) new DAOFinca().getItem(item.getIdFinca());

				data[i][1] = finca.getNombre();

				data[i][2] = item.getNombre();
				i++;
			}
		}

		return data;

	}

	@Override
	public String[] getColumns() {
		return new String[] { "ID", "Finca", "Empleado" };
	}

	public void buttons() {
		op.setImagesButtons("/resources/Plantas.png", "/resources/Personal.png", "/resources/Personal.png");
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

		if (fincaUno) {

			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 1");
		} else {
			v.modelo.setDataVector(getData(), getColumns());

			vp.setContenido(v, "Empleados de finca 2");
		}

	}

}
