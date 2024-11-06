package com.pf.mvc.controllers;

import java.util.ArrayList;

import com.pf.mvc.models.dao.DAOCategoria;
import com.pf.mvc.models.dao.DAONaturaleza;
import com.pf.mvc.models.dao.DAOProducto;
import com.pf.mvc.models.dao.DAOTipo;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Producto;
import com.pf.mvc.models.vo.Tipo;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.producto.Edit;
import com.pf.mvc.views.producto.Form;
import com.pf.mvc.views.producto.Index;

public class ControllerProductos extends Functions implements Controller{
	
	private DAOProducto dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();

	public ControllerProductos(ViewPrincipal vp) {
		dao = new DAOProducto();
		this.vp = vp;
	}

	@Override
	public void index() {
		Index v = new Index();
		
		v.modelo.setDataVector(getData(), getColumns());
		
		v.btnAgregarProducto.addActionListener(e->{
			
			create();
			
		});
		
		v.btnEditar.addActionListener(e->{
			
			int id = getSelectedId(v.tableProductos, ids);
			edit(id);
			
		});
		
		v.btnEliminar.addActionListener(e->{
			
			Producto item = (Producto) dao.getItem(getSelectedId(v.tableProductos, ids));
			
			dao.destroy(item.getId());
			
			index();
			
		});
		
		vp.setContenido(v, "Lista de productos");
		
	}

	@Override
	public void create() {
		
		Form f = new Form();
		
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
		
		f.btnAgregar.addActionListener(e->{
			
			String nombre = f.tNombre.getText();
			String unidades = f.tUnidad.getText();
			String codigo = f.tCodigo.getText();
			
			Tipo t = (Tipo) f.cbxTipos.getSelectedItem();
			int idTipo = t.getId();
			
			Categoria g = (Categoria) f.cbxCategorias.getSelectedItem();
			int idCategoria = g.getId();
			
			Naturaleza n = (Naturaleza) f.cbxProductos.getSelectedItem();
			int idNaturaleza = n.getId();
			
			Producto item = new Producto(nombre, unidades, codigo, idTipo, idCategoria, idNaturaleza);
			
			dao.store(item);
			
			index();
			
			
		});
		
		vp.setContenido(f, "Agregar productos");
		
	}

	@Override
	public void edit(int id) {
		Producto item = (Producto) dao.getItem(id);
		
		Edit v = new Edit();
		
		ArrayList<Object> naturalezas = new DAONaturaleza().getData();
		v.cbxProductos.removeAllItems();
		
		for (Object o : naturalezas) {
			Naturaleza n = (Naturaleza) o;
			v.cbxProductos.addItem(n);
			
			if(n.getId() == item.getIdNaturaleza()) {
				v.cbxProductos.setSelectedItem(n);
			}
		}
		
		v.tNombre.setText(item.getNombre());
		v.tCodigo.setText(item.getCodigo());
		v.tUnidad.setText(item.getUnidades());
		
		ArrayList<Object> tipos = new DAOTipo().getData();
		v.cbxTipos.removeAllItems();
		
		for (Object o : tipos) {
			Tipo t = (Tipo) o;
			v.cbxTipos.addItem(t);
			
			if(t.getId() == item.getIdTipo()) {
				v.cbxTipos.setSelectedItem(t);
			}
		}
		
		ArrayList<Object> categorias = new DAOCategoria().getData();
		v.cbxCategorias.removeAllItems();
		
		for (Object o : categorias) {
			Categoria c = (Categoria) o;
			v.cbxCategorias.addItem(c);
			
			if(c.getId() == item.getIdCategoria()) {
				v.cbxCategorias.setSelectedItem(c);
			}
		}
		
		v.btnActualizar.addActionListener(e->{
			String nombre = v.tNombre.getText();
			String unidades = v.tUnidad.getText();
			String codigo = v.tCodigo.getText();
			
			Tipo t = (Tipo) v.cbxTipos.getSelectedItem();
			int idTipo = t.getId();
			
			Categoria g = (Categoria) v.cbxCategorias.getSelectedItem();
			int idCategoria = g.getId();
			
			Naturaleza n = (Naturaleza) v.cbxProductos.getSelectedItem();
			int idNaturaleza = n.getId();
			
			Producto nuevoItem = new Producto(nombre, unidades, codigo, idTipo, idCategoria, idNaturaleza);
			
			if (item.getId() > 0) {
				dao.update(nuevoItem, item.getId());
				edit(item.getId());
			}
			
			index();
		});
		
		vp.setContenido(v, "Editar producto");
	}
	
	

	@Override
	public Object[][] getData() {
		ArrayList<Object> list = dao.getData();
		
		ids.clear();
		
		Object[][] data = new Object[list.size()][getColumns().length];
		
		int i = 0;
		
		for (Object o : list) {
			
			Producto p = (Producto) o;
			
			ids.add(p.getId());
			
			Naturaleza naturaleza = (Naturaleza) new DAONaturaleza().getItem(p.getIdNaturaleza());
			data[i][0] = naturaleza.getNombre();
			
			Tipo tipo = (Tipo) new DAOTipo().getItem(p.getIdTipo());
			data[i][1] = tipo.getNombre();
			
			data[i][2] = p.getCodigo();
			
			Categoria categoria = (Categoria) new DAOCategoria().getItem(p.getIdCategoria());
			data[i][3] = categoria.getNombre();
			
			data[i][4] = p.getNombre();
		    data[i][5] = p.getUnidades();
		    
		    
		    
		    i++;
		}
		
		return data;
	}

	@Override
	public String[] getColumns() {
		return new String [] {"Producto", "Tipo", "Código", "Categoría", "Nombre", "Unidades"};
	}

	@Override
	public void store(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object o, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
