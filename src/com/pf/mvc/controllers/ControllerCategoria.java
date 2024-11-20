package com.pf.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOCategoria;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;

public class ControllerCategoria extends Functions implements Controller  {
	
	private DAOCategoria dao;
	private Index in;
	public boolean switchPanel;
	private ViewPrincipal vp;
	
	public ControllerCategoria(ViewPrincipal vp) {
		this.dao = new DAOCategoria();
		this.switchPanel = false;
		this.vp = vp;
	}

	
	@Override
	public void index() {
		this.in = new Index();
		in.modelo.setDataVector(getData(), getColumns());
		ocultarColumna(in.table);
		
		in.btnGuardar.addActionListener(e->{
			
			create();
			
		});
		
		in.btnEditar.addActionListener(e->{
			
			int row = in.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para editar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int id = getSelectedId(in.table);
				edit(id);
				in.btnGuardar.setEnabled(false);
				in.btnGuardar.setVisible(false);
				in.btnActualizar.setEnabled(true);
				in.btnActualizar.setVisible(true);
				in.btnCancelar.setEnabled(true);
				in.btnCancelar.setVisible(true);
				
				in.lblTitulo.setText("Editar categoria");
			
		});
		
		in.btnEliminar.addActionListener(e->{
			int row = in.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un registro para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;

			}
			int id = getSelectedId(in.table);
			destroy(id);
			index();
			
		});
		
		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);
		
		in.lblTitulo.setText("Registrar nueva categoria");
		vp.setContenido(in, "Categor�as");
	}

	@Override
	public void create() {
		
		String nombre = in.tNombre.getText();

	    if (nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(in, "El nombre no puede estar vac�o.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    Categoria item = new Categoria(nombre, true);

	    String result = dao.storeCategoria(item);

	    JOptionPane.showMessageDialog(in, result);

	    in.tNombre.setText("");
	}

	@Override
	public void edit(int id) {
		Categoria n = (Categoria) dao.getItem(id);
		
		in.tNombre.setText(n.getNombre());
		
		in.btnActualizar.addActionListener(e->{
			String nombre = in.tNombre.getText();
			
			Categoria item = new Categoria(nombre, true);
			
			update(item, id);
			
		});
		
		in.btnCancelar.addActionListener(e->{
			
			in.tNombre.setText("");
			
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

}
