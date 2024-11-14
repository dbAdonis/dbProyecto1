package com.pf.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pf.mvc.models.dao.DAOLote;
import com.pf.mvc.models.vo.Lote;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.Index;
import com.pf.mvc.views.menu.Menu;

public class ControllerLotes extends Functions implements Controller  {
	
	private DAOLote dao;
	private Index v;
	private boolean fincaUno;
	private int idApp;
	private ViewPrincipal vp;
	private Menu menu;
	
	public ControllerLotes(boolean fincaUno, ViewPrincipal vp, Menu menu) {
		this.dao = new DAOLote();
		this.fincaUno = fincaUno;
		this.vp = vp;
		this.menu = menu;
		this.idApp = -1;
	}
	
	public int getIdApp() {
		return idApp;
	}

	public void setIdApp(int idApp) {
		this.idApp = idApp;
	}

	@Override
	public void index() {
		
		this.v = new Index();
		
		v.modelo.setDataVector(getData(), getColumns());
		
		v.btnRegistrar.addActionListener(e->{
			
			create();
			
		});
		
		v.btnEditar.addActionListener(e->{
			
			int row = v.table.getSelectedRow();
			if(row > -1) {
				int id = (int) v.table.getValueAt(row, 0);
				edit(id);
				
				v.btnRegistrar.setEnabled(false);
				v.btnRegistrar.setVisible(false);
				v.btnActualizar.setEnabled(true);
				v.btnActualizar.setVisible(true);
				v.btnCancelar.setEnabled(true);
				v.btnCancelar.setVisible(true);
				
				v.lblTitulo.setText("Editar lote");
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			
		});
		
		v.btnEliminar.addActionListener(e->{
			int row = v.table.getSelectedRow();
			if(row > -1) {
			int id = (int) v.table.getValueAt(row, 0);
			destroy(id);
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		});
		
		v.btnRegresar.addActionListener(e->{
			
			ControllerAplicaciones ca = new ControllerAplicaciones(vp, menu);
			
			ca.index(fincaUno);
			
			if(idApp < 1) {
			ca.create();
			}
			
			if(idApp > 0) {
				ca.edit(idApp);	
				}
			
		});
		
		vp.setContenido(v, "Lotes");
		
		v.btnRegistrar.setEnabled(true);
		v.btnRegistrar.setVisible(true);
		v.btnActualizar.setEnabled(false);
		v.btnActualizar.setVisible(false);
		v.btnCancelar.setEnabled(false);
		v.btnCancelar.setVisible(false);
		
		v.lblTitulo.setText("Registrar nuevo lote");
	}

	@Override
	public void create() {
		
		String nombre = v.tNombre.getText();
		
		Lote item = new Lote(nombre);
		
		store(item);
		
		v.tNombre.setText("");
		
	}

	@Override
	public void edit(int id) {
		Lote l = (Lote) dao.getItem(id);
		
		v.tNombre.setText(l.getNombre());
		
		v.btnActualizar.addActionListener(e->{
			String nombre = v.tNombre.getText();
			
			Lote item = new Lote(nombre);
			
			update(item, id);
			
		});
		
		v.btnCancelar.addActionListener(e->{
			
			v.tNombre.setText("");
			
			index();
			
		});
		
		
	}

	@Override
	public Object[][] getData() {
		
		ArrayList<Object> list = dao.getData();
		Object [][] data = new Object [list.size()][getColumns().length];
		
		int i = 0;
		
		for (Object o : list) {
			 
			Lote item = (Lote) o;
			
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
