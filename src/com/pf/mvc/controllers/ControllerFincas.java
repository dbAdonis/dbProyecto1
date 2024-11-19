package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOFinca;
import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;

public class ControllerFincas extends Functions implements Controller {

	private DAOFinca dao;
	private int idApp;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids;
	private Index in;

	public ControllerFincas(ViewPrincipal vp) {
		this.dao = new DAOFinca();
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
			if(id == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para editar",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
			edit(id);
			in.lblTitulo.setText("Editar finca");
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
			if(id == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para eliminar",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
			dao.destroy(id);
			index();
			}
			
		});

		vp.setContenido(in, "Fincas");

		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);

		in.lblTitulo.setText("Registrar nueva finca");
	}

	@Override
	public void create() {
	    String nombre = in.tNombre.getText();

	    if (nombre.equals("")) {
	        JOptionPane.showMessageDialog(in, "Debe completar el campo", 
	            "Advertencia", JOptionPane.WARNING_MESSAGE);
	    } else {
	        Finca item = new Finca(nombre);

	        dao.store(item);

	        in.tNombre.setText("");

	        index();
	    }
	}


	@Override
	public void edit(int id) {
		
		Finca f = (Finca) dao.getItem(id);
			in.tNombre.setText(f.getNombre());
		
		in.btnActualizar.addActionListener(e -> {
			
			String nombre = in.tNombre.getText();

			if(nombre.equals("")) {
				JOptionPane.showMessageDialog(in, "Debe completar el campo",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				Finca item = new Finca(nombre);

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

			Finca item = (Finca) o;

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
	
	public void actualizarTabla() {
		Index in = new Index();
		in.modelo.setDataVector(getData(), getColumns());

	}

}
