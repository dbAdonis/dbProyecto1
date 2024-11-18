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
import com.pf.mvc.views.general.FormGeneral;
import com.pf.mvc.views.producto.Form;

public class ControllerCategoria extends Functions implements Controller  {
	
	private DAOCategoria dao;
	private FormGeneral fg;
	private JPanel form;
	public boolean switchPanel;
	
	public ControllerCategoria(Form f, ControllerProductos cp) {
		this.dao = new DAOCategoria();
		this.form = f;
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
				
				fg.lblTitulo.setText("Editar categoria");
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			
		});
		
		fg.btnEliminar.addActionListener(e->{
			int row = fg.table.getSelectedRow();
			if(row > -1) {
			int id = (int) fg.table.getValueAt(row, 0);
			destroy(id);
			//cp.cargarCbxCategoria();
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
		
		fg.lblTitulo.setText("Registrar nueva categoria");
		if(switchPanel) {
			((Form) form).setContenido(fg);
		}
	}

	@Override
	public void create() {
		
		String nombre = fg.tNombre.getText();
		
		Categoria item = new Categoria(nombre);
		
		store(item);
		
		fg.tNombre.setText("");
		
		//cp.cargarCbxCategoria();
		
	}

	@Override
	public void edit(int id) {
		Categoria n = (Categoria) dao.getItem(id);
		
		fg.tNombre.setText(n.getNombre());
		
		fg.btnActualizar.addActionListener(e->{
			String nombre = fg.tNombre.getText();
			
			Categoria item = new Categoria(nombre);
			
			update(item, id);
			
			//cp.cargarCbxCategoria();
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
			 
			Categoria item = (Categoria) o;
			
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