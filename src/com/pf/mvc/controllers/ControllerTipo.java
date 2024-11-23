package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pf.mvc.models.dao.DAOCategoria;
import com.pf.mvc.models.dao.DAONaturaleza;
import com.pf.mvc.models.dao.DAOTipo;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Tipo;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.FormGeneral;
import com.pf.mvc.views.general.Index;
import com.pf.mvc.views.producto.Form;

public class ControllerTipo extends Functions implements Controller  {
	
	private DAOTipo dao;
	private Index in;
	private ViewPrincipal vp;
	
	public ControllerTipo(ViewPrincipal vp) {
		this.dao = new DAOTipo();
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
			
			int id = getSelectedId(in.table);
			if(id > -1) {
				edit(id);
				in.btnGuardar.setEnabled(false);
				in.btnGuardar.setVisible(false);
				in.btnActualizar.setEnabled(true);
				in.btnActualizar.setVisible(true);
				in.btnCancelar.setEnabled(true);
				in.btnCancelar.setVisible(true);
				
				in.lblTitulo.setText("Editar tipo");
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			
		});
		
		in.btnEliminar.addActionListener(e->{
			int id = getSelectedId(in.table);
			if(id > -1) {
			destroy(id);
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
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
		
		in.btnGuardar.setEnabled(true);
		in.btnGuardar.setVisible(true);
		in.btnActualizar.setEnabled(false);
		in.btnActualizar.setVisible(false);
		in.btnCancelar.setEnabled(false);
		in.btnCancelar.setVisible(false);
		
		in.lblTitulo.setText("Registrar nuevo tipo");
			vp.setContenido(in, "Tipos");
		
	}

	@Override
	public void create() {
		
		String nombre = in.tNombre.getText();

		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(in, "El nombre no puede estar vacío.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		Tipo item = new Tipo(nombre, true);

		String result = dao.storeTipo(item);

		JOptionPane.showMessageDialog(in, result);

		in.tNombre.setText("");

		index();
	}

	@Override
	public void edit(int id) {
		Tipo n = (Tipo) dao.getItem(id);
		if (n == null) {
			JOptionPane.showMessageDialog(in, "El registro no existe.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		in.tNombre.setText(n.getNombre());
		
		in.btnActualizar.addActionListener(e->{
			String nombre = in.tNombre.getText();
			
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(in, "Debe completar el campo", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Tipo item = new Tipo(nombre, true);
				boolean actualizado = dao.update(item, id);

				if (actualizado) {
					JOptionPane.showMessageDialog(in, "El registro se actualizó correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(in, "No se pudo actualizar el registro. Intente nuevamente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				index();
			}
			
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
			 
			Tipo item = (Tipo) o;
			
			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			
			i++;
		}
		
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String [] {"ID", "NOMBRE"};
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
