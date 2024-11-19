package com.pf.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pf.mvc.models.dao.DAOCategoria;
import com.pf.mvc.models.dao.DAONaturaleza;
import com.pf.mvc.models.dao.DAOTipo;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Tipo;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.FormGeneral;
import com.pf.mvc.views.producto.Form;

public class ControllerNaturaleza extends Functions implements Controller {

	private DAONaturaleza dao;
	private FormGeneral fg;
	private ArrayList<Integer> ids;
	public boolean switchPanel;
	private ViewPrincipal vp;

	public ControllerNaturaleza(ViewPrincipal vp) {
		this.dao = new DAONaturaleza();
		this.switchPanel = false;
		this.ids = new ArrayList<>();
		this.vp = vp;
	}

	@Override
	public void index() {

		this.fg = new FormGeneral();

		fg.modelo.setDataVector(getData(), getColumns());
		ocultarColumna(fg.table);

		fg.btnRegistrar.addActionListener(e -> {

			create();

		});

		fg.btnEditar.addActionListener(e -> {

			int id = getSelectedId(fg.table);
			if (id > -1) {
				edit(id);
				fg.btnRegistrar.setEnabled(false);
				fg.btnRegistrar.setVisible(false);
				fg.btnActualizar.setEnabled(true);
				fg.btnActualizar.setVisible(true);
				fg.btnCancelar.setEnabled(true);
				fg.btnCancelar.setVisible(true);

				fg.lblTitulo.setText("Editar producto");
				fg.btnEditar.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		});

		fg.btnEliminar.addActionListener(e -> {
			int id = getSelectedId(fg.table);
			if (id > -1) {
				destroy(id);
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		});

		fg.btnRegistrar.setEnabled(true);
		fg.btnRegistrar.setVisible(true);
		fg.btnActualizar.setEnabled(false);
		fg.btnActualizar.setVisible(false);
		fg.btnCancelar.setEnabled(false);
		fg.btnCancelar.setVisible(false);

		fg.lblTitulo.setText("Registrar nuevo producto");
		vp.setContenido(fg, "Naturalezas");
	}

	@Override
	public void create() {
	    String nombre = fg.tNombre.getText();

	    if (nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(fg, "El nombre no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    Naturaleza item = new Naturaleza(nombre, true);

	    String result = dao.storeNaturaleza(item);

	    JOptionPane.showMessageDialog(fg, result);

	    fg.tNombre.setText("");
	}


	@Override
	public void edit(int id) {
		Naturaleza n = (Naturaleza) dao.getItem(id);

		fg.tNombre.setText(n.getNombre());

		fg.btnActualizar.addActionListener(e -> {
			String nombre = fg.tNombre.getText();

			Naturaleza item = new Naturaleza(nombre, true);

			update(item, id);


		});

		fg.btnCancelar.addActionListener(e -> {

			fg.tNombre.setText("");
			fg.btnEditar.setEnabled(true);
			index();

		});

	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();

		ids.clear();

		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {

			Naturaleza item = (Naturaleza) o;

			ids.add(item.getId());

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


}
