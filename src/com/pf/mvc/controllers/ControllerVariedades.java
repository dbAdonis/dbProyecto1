package com.pf.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.dao.DAOVariedad;
import com.pf.mvc.models.vo.Labor;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.models.vo.Variedad;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;
import com.pf.mvc.views.menu.Menu;

public class ControllerVariedades extends Functions implements Controller {

	private DAOVariedad dao;
	private int idApp;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();

	public ControllerVariedades(ViewPrincipal vp) {
		this.dao = new DAOVariedad();
		this.vp = vp;
		this.idApp = -1;
	}

	public int getIdApp() {
		return idApp;
	}

	public void setIdApp(int idApp) {
		this.idApp = idApp;
	}

	@Override
	public void index() {

		Index in = new Index();

		in.modelo.setDataVector(getData(), getColumns());

		in.btnGuardar.addActionListener(e -> {

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

		vp.setContenido(in, "Variedades");

		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);

		in.lblTitulo.setText("Registrar nueva variedad");
	}

	@Override
	public void create() {

		Index in = new Index();

		in.btnGuardar.addActionListener(e -> {
			String nombre = in.tNombre.getText();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(in, "El campo debe estar completo.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			Variedad item = new Variedad(nombre);

			store(item);

			in.tNombre.setText("");

			index();
		});

		in.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			index();

		});

		in.tNombre.setText("");
	}

	@Override
	public void edit(int id) {
		Index in = new Index();

		Labor la = (Labor) dao.getItem(id);

		in.tNombre.setText(la.getNombre());

		in.btnActualizar.addActionListener(e -> {
			String nombre = in.tNombre.getText();

			Variedad item = new Variedad(nombre);

			update(item, id);

		});

		in.btnCancelar.addActionListener(e -> {

			in.tNombre.setText("");

			index();

		});

	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();
		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {

			Variedad item = (Variedad) o;

			data[i][0] = item.getId();
			data[i][1] = item.getNombre();

			i++;
		}

		return data;
	}

	@Override
	public String[] getColumns() {
		return new String[] { "ID", "Nombre" };
	}

	@Override
	public void store(Object o) {
		dao.store(o);
		index();
	}

	@Override
	public void update(Object o, int id) {
		dao.update(o, id);
		index();

	}

	@Override
	public void destroy(int id) {
		dao.destroy(id);
		index();

	}

	public void actualizarTabla() {
		Index in = new Index();
		in.modelo.setDataVector(getData(), getColumns());

	}

}
