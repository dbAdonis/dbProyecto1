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
import com.pf.mvc.views.producto.Edit;
import com.pf.mvc.views.general.FormGeneral;
import com.pf.mvc.views.producto.Form;

public class ControllerTipo extends Functions implements Controller  {
	
	private DAOTipo dao;
	private FormGeneral fg;
	private JPanel form;
	private ControllerProductos cp;
	public boolean switchPanel;
	
	public ControllerTipo(Form f, ControllerProductos cp) {
		this.dao = new DAOTipo();
		this.form = f;
		this.cp = cp;
		this.switchPanel = false;
	}
	
	public ControllerTipo(Edit ed, ControllerProductos cp) {
		this.dao = new DAOTipo();
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
			cargarCbx();

			
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
				
				fg.lblTitulo.setText("Editar tipo");
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			
		});
		
		fg.btnEliminar.addActionListener(e->{
			int row = fg.table.getSelectedRow();
			if(row > -1) {
			int id = (int) fg.table.getValueAt(row, 0);
			destroy(id);
			//cp.cargarCbxTipo();
			cargarCbx();
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
		
		fg.lblTitulo.setText("Registrar nuevo tipo");
		if(switchPanel) {
			((Form) form).setContenido(fg);
		}else {
			((Edit) form).setContenido(fg);
		}
	}

	@Override
	public void create() {
		
		String nombre = fg.tNombre.getText();
		
		Tipo item = new Tipo(nombre);
		
		store(item);
		
		fg.tNombre.setText("");
		
		//cp.cargarCbxTipo();
		cargarCbx();

		
	}

	@Override
	public void edit(int id) {
		Tipo n = (Tipo) dao.getItem(id);
		
		fg.tNombre.setText(n.getNombre());
		
		fg.btnActualizar.addActionListener(e->{
			String nombre = fg.tNombre.getText();
			
			Tipo item = new Tipo(nombre);
			
			update(item, id);
			
			//cp.cargarCbxTipo();
			cargarCbx();

			
			
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
			 
			Tipo item = (Tipo) o;
			
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
	
	public void cargarCbx() {
		Form f = (Form) this.form; 

	    f.cbxProductos.removeAllItems();
	    f.cbxTipos.removeAllItems();
	    f.cbxCategorias.removeAllItems();

		ArrayList<Object> naturalezas = new DAONaturaleza().getData();
		for (Object o : naturalezas) {
			Naturaleza n = (Naturaleza) o;
			f.cbxProductos.addItem(n);
		}

		ArrayList<Object> tipos = new DAOTipo().getData();
		for (Object o : tipos) {
			Tipo t = (Tipo) o;

			f.cbxTipos.addItem(t);
		}

		ArrayList<Object> categorias = new DAOCategoria().getData();
		for (Object o : categorias) {
			Categoria c = (Categoria) o;

			f.cbxCategorias.addItem(c);
		}
	}

}
