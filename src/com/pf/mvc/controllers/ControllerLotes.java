package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;

public class ControllerLotes extends Functions implements Controller {

	private DAOLote dao;
	private int idApp;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids;
	private Index in;

	public ControllerLotes(ViewPrincipal vp) {
		this.dao = new DAOLote();
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
			in.lblTitulo.setText("Editar lote");
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
		
		in.btnRegresar.addActionListener(e->{
			
			new ControllerAplicaciones(vp).create();
			
		});

		vp.setContenido(in, "Lotes");

		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);

		in.lblTitulo.setText("Registrar nuevo lote");
	}

	@Override
	public void create() {
	    String nombre = in.tNombre.getText();

	    if (nombre.equals("")) {
	        JOptionPane.showMessageDialog(in, "Debe completar el campo", 
	            "Advertencia", JOptionPane.WARNING_MESSAGE);
	    } else {
	        Lote item = new Lote(nombre, true);

	        String result = dao.storeLote(item);

	        JOptionPane.showMessageDialog(in, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);

	        in.tNombre.setText("");

	        index();
	    }
	}


	@Override
	public void edit(int id) {
		
		Lote lo = (Lote) dao.getItem(id);
			in.tNombre.setText(lo.getNombre());
		
		in.btnActualizar.addActionListener(e -> {
			
			String nombre = in.tNombre.getText();

			if(nombre.equals("")) {
				JOptionPane.showMessageDialog(in, "Debe completar el campo",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}else {
				Lote item = new Lote(nombre, true);

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

			Lote item = (Lote) o;

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
