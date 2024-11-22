package com.pf.mvc.controllers;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.pf.mvc.models.dao.DAOEmpleado;
import com.pf.mvc.models.dao.DAOFinca;
import com.pf.mvc.models.vo.Empleado;
import com.pf.mvc.models.vo.Finca;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.empleado.Create;
import com.pf.mvc.views.empleado.Index;
import com.pf.mvc.views.menu.Inicio;
import com.pf.mvc.views.menu.Options;

public class ControllerEmpleados extends Functions implements Controller {

	private DAOEmpleado dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids;
	private int idFinca;

	public ControllerEmpleados(ViewPrincipal vp) {
		this.dao = new DAOEmpleado();
		this.vp = vp;
		this.idFinca = -1;
		this.ids = new ArrayList<>();
	}
	
	public void inicio() {
		Inicio inicio = new Inicio();
		vp.setContenido(inicio, "Bienvenido al Sistema Fino Follaje.");
	}

	@Override
	public void index() {

		Index in = new Index();

		in.modelo.setDataVector(filtrarData(dao.getEmpleados()), getColumns());
		ocultarColumna(in.table);
	
		in.btnNuevo.addActionListener(e -> {

			create();

		});

		in.btnEditar.addActionListener(e -> {

			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un empleado de la tabla para editar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table);
			edit(id);

		});

		in.btnEliminar.addActionListener(e -> {
			
			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un empleado de la tabla para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table);
			System.out.println(id);
			dao.destroy(id);
			index(); 

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
		
		cargarCbxFinca(in);
		
		in.cbxFinca.addActionListener(e->{
			
			cbxDatosFinca(in);
			
		});
		
		vp.setContenido(in, "Gestionar personal");

	}

	@Override
	public void create() {
	    Create c = new Create();

	    ArrayList<Object> fincas = new DAOFinca().getData();
	    for (Object o : fincas) {
	        Finca r = (Finca) o;
	        c.cbxFincas.addItem(r);
	    }

	    c.btnGuardar.addActionListener(e -> {
	        String nombre = c.tNombre.getText();
	        Finca r = (Finca) c.cbxFincas.getSelectedItem();

	        if (nombre.isEmpty() || r == null) {
	            JOptionPane.showMessageDialog(c, "Todos los campos deben estar completos.", "Advertencia",
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        Empleado item = new Empleado(r.getId(), nombre, true);

	        String result = new DAOEmpleado().storeEmpleado(item);

	        JOptionPane.showMessageDialog(c, result);

	        index();
	    });

	    c.btnCancelar.addActionListener(e -> {
	        index();
	    });

	    c.lblTitulo.setText("Registrar nuevo empleado");
	    vp.setContenido(c, "Gestionar personal");
	}


	@Override
	public void edit(int id) {

		Empleado em = (Empleado) dao.getItem(id);

		Create c = new Create();

		c.tNombre.setText(em.getNombre());

		ArrayList<Object> fincas = new DAOFinca().getData();
		c.cbxFincas.removeAllItems();

		
		for (Object o : fincas) {
			Finca r = (Finca) o;

			c.cbxFincas.addItem(r);
			if (r.getId() == em.getIdFinca()) {
				c.cbxFincas.setSelectedItem(r);
			}
		}

		c.btnGuardar.addActionListener(e -> {

			String nombre = c.tNombre.getText();

			Finca r = (Finca) c.cbxFincas.getSelectedItem();
			
			 if (nombre.isEmpty() || r == null) {
		            JOptionPane.showMessageDialog(c, "Todos los campos deben estar completos.", "Advertencia",
		                    JOptionPane.WARNING_MESSAGE);
		            return;
		        }

			Empleado item = new Empleado(r.getId(), nombre, true);
			
			if (em.getId() > 0) {
				update(item, em.getId());
			}
			index();

		});

		c.btnCancelar.addActionListener(e -> {

			index();

		});
		
		c.lblTitulo.setText("Editar empleado");
		vp.setContenido(c, "Gestionar personal");

	}

	@Override
	public Object[][] getData() {

		ArrayList<Object> list = dao.getData();

		ids.clear();

		Object[][] data = new Object[list.size()][getColumns().length];

		int i = 0;

		for (Object o : list) {

			Empleado item = (Empleado) o;
			
			if(idFinca == item.getIdFinca()) {
				ids.add(item.getId());

				data[i][0] = item.getId();
				data[i][1] = item.getNombre();

				Finca finca = (Finca) new DAOFinca().getItem(item.getIdFinca());
				data[i][2] = finca != null ? finca.getNombre() : "Sin Finca";
				i++;
			}
			if(idFinca == -1) {
				ids.add(item.getId());

				data[i][0] = item.getId();
				data[i][1] = item.getNombre();

				Finca finca = (Finca) new DAOFinca().getItem(item.getIdFinca());
				data[i][2] = finca != null ? finca.getNombre() : "Sin Finca";
				i++;
			}

		}

		return data;

	}

	@Override
	public String[] getColumns() {
		return new String[] { "ID", "EMPLEADO", "FINCA" };
	}

	@Override
	public void store(Object o) {
		dao.store(o);

	}

	@Override
	public void update(Object o, int id) {

		dao.update(o, id);
	}

	@Override
	public void destroy(int id) {

		dao.destroy(id);

	}

	
	public void cargarCbxFinca(Index in) {
		
		ArrayList<Object> list = new DAOFinca().getData();
		
		for (Object o : list) {
			Finca f = (Finca) o;
			in.cbxFinca.addItem(f);
		}
	}
	
	public void cbxDatosFinca(Index in) {
		
		int ind = in.cbxFinca.getSelectedIndex();
		
		if(ind > 0) {
			if(ind == 1) {
				idFinca = -1;
			}else {
				Finca f = (Finca) in.cbxFinca.getSelectedItem();
				idFinca = f.getId();
			}
		}
		in.modelo.setDataVector(filtrarData(getData()), getColumns());
		ocultarColumna(in.table);
	}
	
	public Object[][] filtrarData(Object[][] data) {
		ArrayList<Object[]> datosFiltrados = new ArrayList<>();
		
		for (Object[] o : data) {
			for (Object item : o) {
				if(item != null) {
					datosFiltrados.add(o);
					break;
				}
			}
		}
		
		return datosFiltrados.toArray(new Object[0][0]);
	}
	
}
