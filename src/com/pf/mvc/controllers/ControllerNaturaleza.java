package com.pf.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pf.mvc.models.dao.DAONaturaleza;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.views.producto.Edit;
import com.pf.mvc.views.general.FormGeneral;
import com.pf.mvc.views.producto.Form;

public class ControllerNaturaleza extends Functions implements Controller  {
	
	private DAONaturaleza dao;
	private FormGeneral fg;
	private JPanel form;
	private ControllerProductos cp;
	public boolean switchPanel;
	
	public ControllerNaturaleza(Form f, ControllerProductos cp) {
		this.dao = new DAONaturaleza();
		this.form = f;
		this.cp = cp;
		this.switchPanel = false;
	}
	
	public ControllerNaturaleza(Edit ed, ControllerProductos cp) {
		this.dao = new DAONaturaleza();
		this.form = ed;
		this.cp = cp;
		this.switchPanel = false;
	}

	
	@Override
	public void index() {
		
		this.fg = new FormGeneral();
		
		fg.modelo.setDataVector(getData(), getColumns());
		
		fg.btnRegistrar.addActionListener(e->{
			
			create();
			
		});
		
		fg.btnEditar.addActionListener(e->{
			
			int row = fg.table.getSelectedRow();
			if(row > -1) {
				int id = (int) fg.table.getValueAt(row, 0);
				edit(id);
				
				fg.btnRegistrar.setEnabled(false);
				fg.btnRegistrar.setVisible(false);
				fg.btnActualizar.setEnabled(true);
				fg.btnActualizar.setVisible(true);
				fg.btnCancelar.setEnabled(true);
				fg.btnCancelar.setVisible(true);
				
				fg.lblTitulo.setText("Editar producto");
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			
		});
		
		fg.btnEliminar.addActionListener(e->{
			int row = fg.table.getSelectedRow();
			if(row > -1) {
			int id = (int) fg.table.getValueAt(row, 0);
			destroy(id);
			cp.cargarCbxNaturaleza();
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		});
		
		fg.btnRegistrar.setEnabled(true);
		fg.btnRegistrar.setVisible(true);
		fg.btnActualizar.setEnabled(false);
		fg.btnActualizar.setVisible(false);
		fg.btnCancelar.setEnabled(false);
		fg.btnCancelar.setVisible(false);
		
		fg.lblTitulo.setText("Registrar nuevo producto");
		if(switchPanel) {
			((Form) form).setContenido(fg);
		}else {
			((Edit) form).setContenido(fg);
		}
	}

	@Override
	public void create() {
		
		String nombre = fg.tNombre.getText();
		
		Naturaleza item = new Naturaleza(nombre);
		
		store(item);
		
		fg.tNombre.setText("");
		
		cp.cargarCbxNaturaleza();
		
	}

	@Override
	public void edit(int id) {
		Naturaleza n = (Naturaleza) dao.getItem(id);
		
		fg.tNombre.setText(n.getNombre());
		
		fg.btnActualizar.addActionListener(e->{
			String nombre = fg.tNombre.getText();
			
			Naturaleza item = new Naturaleza(nombre);
			
			update(item, id);
			
			cp.cargarCbxNaturaleza();
			
			
		});
		
		fg.btnCancelar.addActionListener(e->{
			
			fg.tNombre.setText("");
			
			index();
			
		});
		
		
	}

	@Override
	public Object[][] getData() {
		
		ArrayList<Object> list = dao.getData();
		Object [][] data = new Object [list.size()][getColumns().length];
		
		int i = 0;
		
		for (Object o : list) {
			 
			Naturaleza item = (Naturaleza) o;
			
			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			
			i++;
		}
		
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String [] {"ID", "Nombre"};
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
