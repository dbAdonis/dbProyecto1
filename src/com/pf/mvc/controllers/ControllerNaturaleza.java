package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAONaturaleza;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;

public class ControllerNaturaleza extends Functions implements Controller {

	private DAONaturaleza dao;
	private Index in;
	private ArrayList<Integer> ids;
	private ViewPrincipal vp;

	public ControllerNaturaleza(ViewPrincipal vp) {
		this.dao = new DAONaturaleza();
		this.ids = new ArrayList<>();
		this.vp = vp;
	}

	@Override
	public void index() {

		this.in = new Index();

		in.modelo.setDataVector(getData(), getColumns());
		ocultarColumna(in.table);

		in.btnGuardar.addActionListener(e -> {

			create();

		});

		in.btnEditar.addActionListener(e -> {

			int id = getSelectedId(in.table);
			if (id > -1) {
				edit(id);
				in.btnGuardar.setEnabled(false);
				in.btnGuardar.setVisible(false);
				in.btnActualizar.setEnabled(true);
				in.btnActualizar.setVisible(true);
				in.btnCancelar.setEnabled(true);
				in.btnCancelar.setVisible(true);

				in.lblTitulo.setText("Editar producto");
				in.btnEditar.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		});

		in.btnEliminar.addActionListener(e -> {
			int id = getSelectedId(in.table);
			if (id > -1) {
				destroy(id);
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

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
				buscar(in.tBuscar, in.filtro, 1);
			}
		});

		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);

		in.lblTitulo.setText("Registrar nuevo producto");
		vp.setContenido(in, "Naturalezas");
	}

	@Override
	public void create() {
		String nombre = in.tNombre.getText();

		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(in, "El nombre no puede estar vac�o.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		Naturaleza item = new Naturaleza(nombre, true);

		String result = dao.storeNaturaleza(item);

		JOptionPane.showMessageDialog(in, result);

		in.tNombre.setText("");
		index();
	}

	@Override
	public void edit(int id) {
		Naturaleza n = (Naturaleza) dao.getItem(id);
		if (n == null) {
			JOptionPane.showMessageDialog(in, "El registro no existe.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		in.tNombre.setText(n.getNombre());

		in.btnActualizar.addActionListener(e -> {
			String nombre = in.tNombre.getText();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(in, "Debe completar el campo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Naturaleza item = new Naturaleza(nombre, true);
				boolean actualizado = dao.update(item, id);

				if (actualizado) {
					JOptionPane.showMessageDialog(in, "El registro se actualiz� correctamente.", "�xito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(in, "No se pudo actualizar el registro. Intente nuevamente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				index();
			}
		});

		in.btnCancelar.addActionListener(e -> {

			in.tNombre.setText("");
			in.btnEditar.setEnabled(true);
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
		return new String[] { "ID", "NOMBRE" };
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
