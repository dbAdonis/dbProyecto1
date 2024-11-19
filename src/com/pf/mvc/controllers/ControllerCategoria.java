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

public class ControllerCategoria extends Functions implements Controller  {
	
	private DAOCategoria dao;
	private FormGeneral fg;
	public boolean switchPanel;
	private ViewPrincipal vp;
	
	public ControllerCategoria(ViewPrincipal vp) {
		this.dao = new DAOCategoria();
		this.switchPanel = false;
		this.vp = vp;
	}

	
	@Override
	public void index() {
		
		this.fg = new FormGeneral();
		
		fg.modelo.setDataVector(getData(), getColumns());
		ocultarColumna(fg.table);
		
		fg.btnRegistrar.addActionListener(e->{
			
			create();
			
		});
		
		fg.btnEditar.addActionListener(e->{
			
			int row = fg.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(fg, "Debe seleccionar un registro para editar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int id = getSelectedId(fg.table);
				edit(id);
				fg.btnRegistrar.setEnabled(false);
				fg.btnRegistrar.setVisible(false);
				fg.btnActualizar.setEnabled(true);
				fg.btnActualizar.setVisible(true);
				fg.btnCancelar.setEnabled(true);
				fg.btnCancelar.setVisible(true);
				
				fg.lblTitulo.setText("Editar categoria");
			
		});
		
		fg.btnEliminar.addActionListener(e->{
			int row = fg.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(fg, "Debe seleccionar un registro para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;

			}
			int id = getSelectedId(fg.table);
			destroy(id);
			index();
			
		});
		
		fg.btnRegistrar.setEnabled(true);
		fg.btnRegistrar.setVisible(true);
		fg.btnActualizar.setEnabled(false);
		fg.btnActualizar.setVisible(false);
		fg.btnCancelar.setEnabled(false);
		fg.btnCancelar.setVisible(false);
		
		fg.lblTitulo.setText("Registrar nueva categoria");
		vp.setContenido(fg, "Categorías");
	}

	@Override
	public void create() {
		
		String nombre = fg.tNombre.getText();

	    if (nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(fg, "El nombre no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    Categoria item = new Categoria(nombre, true);

	    String result = dao.storeCategoria(item);

	    JOptionPane.showMessageDialog(fg, result);

	    fg.tNombre.setText("");
	}

	@Override
	public void edit(int id) {
		Categoria n = (Categoria) dao.getItem(id);
		
		fg.tNombre.setText(n.getNombre());
		
		fg.btnActualizar.addActionListener(e->{
			String nombre = fg.tNombre.getText();
			
			Categoria item = new Categoria(nombre, true);
			
			update(item, id);
			
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

}
