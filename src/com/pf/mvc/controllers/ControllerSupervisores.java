package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOSupervisor;
import com.pf.mvc.models.vo.Supervisor;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;

public class ControllerSupervisores extends Functions implements Controller {

	private DAOSupervisor dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids;
	private Index in;

	public ControllerSupervisores(ViewPrincipal vp) {
		this.dao = new DAOSupervisor();
		this.vp = vp;
		this.ids = new ArrayList<>();

	}

	@Override
	public void index() {

		this.in = new Index();

		in.modelo.setDataVector(getData(), getColumns());
		ocultarColumna(in.table);

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

		in.btnGuardar.addActionListener(e -> {

			create();
		});

		in.btnEditar.addActionListener(e -> {

			int id = getSelectedId(in.table);
			if (id == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para editar", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				edit(id);
				in.lblTitulo.setText("Editar supervisor");
				in.btnGuardar.setEnabled(false);
				in.btnGuardar.setVisible(false);
				in.btnActualizar.setEnabled(true);
				in.btnActualizar.setVisible(true);
				in.btnCancelar.setEnabled(true);
				in.btnCancelar.setVisible(true);
			}
		});

		in.btnEliminar.addActionListener(e -> {

			int id = getSelectedId(in.table);
			if (id == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para eliminar", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				dao.destroy(id);
				index();
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

		vp.setContenido(in, "Supervisores");

		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);

		in.lblTitulo.setText("Registrar nuevo Supervisor");
	}

	@Override
	public void create() {
		String nombre = in.tNombre.getText();

		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(in, "El nombre no puede estar vac�o.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		Supervisor item = new Supervisor(nombre, true);

		String result = dao.storeSupervisor(item);

		JOptionPane.showMessageDialog(in, result);

		in.tNombre.setText("");

		index();
	}

	@Override
	public void edit(int id) {

		Supervisor s = (Supervisor) dao.getItem(id);
		if (s == null) {
			JOptionPane.showMessageDialog(in, "El registro no existe.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		in.tNombre.setText(s.getNombre());

		in.btnActualizar.addActionListener(e -> {

			String nombre = in.tNombre.getText();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(in, "Debe completar el campo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Supervisor item = new Supervisor(nombre, true);
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

			Supervisor item = (Supervisor) o;

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
