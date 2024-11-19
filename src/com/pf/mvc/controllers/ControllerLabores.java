package com.pf.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOLabor;
import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.dao.DAOVariedad;
import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.models.vo.Labor;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.models.vo.Variedad;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;
import com.pf.mvc.views.menu.Menu;

public class ControllerLabores extends Functions implements Controller {

	private DAOLabor dao;
	private int idApp;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids;
	private Index in;

	public ControllerLabores(ViewPrincipal vp) {
		this.dao = new DAOLabor();
		this.vp = vp;
		this.idApp = -1;
		this.ids = new ArrayList<>();
	}

	public int getIdApp() {
		return idApp;
	}

	public void setIdApp(int idApp) {
		this.idApp = idApp;
	}

	@Override
	public void index() {

		in = new Index();

		in.modelo.setDataVector(getData(), getColumns());

		in.btnGuardar.addActionListener(e -> {

			create();

		});

		in.btnEditar.addActionListener(e -> {

			int id = getSelectedId(in.table, ids);
			if(id == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para editar",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
			edit(id);
			in.lblTitulo.setText("Editar labor");
			in.btnGuardar.setEnabled(false);
			in.btnGuardar.setVisible(false);
			in.btnActualizar.setEnabled(true);
			in.btnActualizar.setVisible(true);
			in.btnCancelar.setEnabled(true);
			in.btnCancelar.setVisible(true);
			}

		});

		in.btnEliminar.addActionListener(e -> {

			int id = getSelectedId(in.table, ids);
			if(id == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para eliminar",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
			dao.destroy(id);
			index();
			}

		});
		
//		in.btnRegresar.addActionListener(e->{
//			
//			new ControllerAplicaciones(vp).create();
//			
//		});

		vp.setContenido(in, "Labores");

		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);

		in.lblTitulo.setText("Registrar nueva labor");
	}

	@Override
	public void create() {
	    String nombre = in.tNombre.getText();

	    if (nombre.equals("")) {
	        JOptionPane.showMessageDialog(in, "Debe completar el campo", 
	                "Advertencia", JOptionPane.WARNING_MESSAGE);
	    } else {
	        Labor item = new Labor(nombre, true);

	        String result = dao.storeLabor(item);

	        JOptionPane.showMessageDialog(in, result, 
	                "Resultado de la operación", JOptionPane.INFORMATION_MESSAGE);

	        in.tNombre.setText("");
	        index();
	    }
	}


	@Override
	public void edit(int id) {
		
		Labor la = (Labor) dao.getItem(id);

		in.tNombre.setText(la.getNombre());

		in.btnActualizar.addActionListener(e -> {
			String nombre = in.tNombre.getText();

			if(nombre.equals("")) {
				JOptionPane.showMessageDialog(in, "Debe completar el campo",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				Labor item = new Labor(nombre, true);

			update(item, id);
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

			Labor item = (Labor) o;

			ids.add(item.getId());

			data[i][0] = item.getNombre();

			i++;
		}

		return data;
	}

	@Override
	public String[] getColumns() {
		return new String[] { "Nombre" };
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
