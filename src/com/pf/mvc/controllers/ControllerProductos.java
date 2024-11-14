package com.pf.mvc.controllers;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.pf.mvc.models.dao.DAOCategoria;
import com.pf.mvc.models.dao.DAONaturaleza;
import com.pf.mvc.models.dao.DAOProducto;
import com.pf.mvc.models.dao.DAOTipo;
import com.pf.mvc.models.vo.Categoria;
import com.pf.mvc.models.vo.Naturaleza;
import com.pf.mvc.models.vo.Producto;
import com.pf.mvc.models.vo.Tipo;
import com.pf.mvc.views.ViewPrincipal;
import com.pf.mvc.views.general.FormGeneral;
import com.pf.mvc.views.menu.Menu;
import com.pf.mvc.views.producto.Edit;
import com.pf.mvc.views.producto.Form;
import com.pf.mvc.views.producto.Index;

public class ControllerProductos extends Functions implements Controller{
	
	private DAOProducto dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();
	private Menu menu;
	private boolean btnOn;
	private boolean btnOff;
	private Form f;
	private Edit v;
	private boolean fincaUno;
	private int idApp;

	public ControllerProductos(ViewPrincipal vp, Menu menu) {
		dao = new DAOProducto();
		this.vp = vp;
		this.menu = menu;
		this.btnOn = false;
		this.btnOff = true;
		this.fincaUno = false;
		this.idApp = -1;
	}

	@Override
	public void index() {
		
		idApp = -1;
		
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
		
		v.btnRegresar.addActionListener(e->{
			
			vp.setContenido(menu, "Bienvenido(a) al sistema de Fino Follaje!");
			
		});
		
		vp.setContenido(v, "Lista de productos");
		
	}
	
	public void index(boolean fincaUno, int idApp) {
		
		this.fincaUno = fincaUno;
		this.idApp = idApp;
		
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
			
			if(idApp == -1) {
				index();	
				}
				if(idApp > -1) {
				index(fincaUno, idApp);	
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
		
		vp.setContenido(v, "Lista de productos");
		
	}

	@Override
	public void create() {
		
	    f = new Form();
		
		cargarCbxNaturaleza();
		
		cargarCbxTipo();
		
		cargarCbxCategoria();
		
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
			
			if(idApp == -1) {
				index();	
				}
				if(idApp > -1) {
				index(fincaUno, idApp);	
				}
			
		});
		
		f.btnRegresar.addActionListener(e->{
			
			if(idApp == -1) {
			index();	
			}
			if(idApp > -1) {
			index(fincaUno, idApp);	
			}
			
		});
			
			f.btnProductos.addActionListener(e->{
				
				if(!btnOn && btnOff) {
					setImgBtn(f.btnProductos, "/resources/ButtonOn.png");
					f.btnTipos.setEnabled(false);
					f.btnCategorias.setEnabled(false);
					
					ControllerNaturaleza cn = new ControllerNaturaleza(f, this);
					cn.switchPanel = true;
					cn.index();
					
					btnOn = true;
				}
				
				if(!btnOff && btnOn) {
					setImgBtn(f.btnProductos, "/resources/ButtonOff.png");
					f.btnTipos.setEnabled(true);
					f.btnCategorias.setEnabled(true);
					
					f.setContenido(null);
					btnOn = false;
					btnOff = true;
				}
				
				if(btnOn) {
					btnOff = false;
				}
				
			});
		
		f.btnTipos.addActionListener(e->{
			
			if(!btnOn && btnOff) {
				setImgBtn(f.btnTipos, "/resources/ButtonOn.png");
				f.btnProductos.setEnabled(false);
				f.btnCategorias.setEnabled(false);
				
				ControllerTipo ct = new ControllerTipo(f, this);
				ct.switchPanel = true;
				ct.index();
				
				btnOn = true;
			}
			
			if(!btnOff && btnOn) {
				setImgBtn(f.btnTipos, "/resources/ButtonOff.png");
				f.btnProductos.setEnabled(true);
				f.btnCategorias.setEnabled(true);
				
				f.setContenido(null);
				btnOn = false;
				btnOff = true;
			}
			
			if(btnOn) {
				btnOff = false;
			}
			
			
		});
		
		f.btnCategorias.addActionListener(e->{
			
			if(!btnOn && btnOff) {
				setImgBtn(f.btnCategorias, "/resources/ButtonOn.png");
				f.btnTipos.setEnabled(false);
				f.btnProductos.setEnabled(false);
				
				ControllerCategoria ca = new ControllerCategoria(f, this);
				ca.switchPanel = true;
				ca.index();
				
				btnOn = true;
			}
			
			if(!btnOff && btnOn) {
				setImgBtn(f.btnCategorias, "/resources/ButtonOff.png");
				f.btnTipos.setEnabled(true);
				f.btnProductos.setEnabled(true);
				
				f.setContenido(null);
				btnOn = false;
				btnOff = true;
			}
			
			if(btnOn) {
				btnOff = false;
			}
			
			
		});
		
		vp.setContenido(f, "Agregar productos");
		
	}

	@Override
	public void edit(int id) {
		
		Producto item = (Producto) dao.getItem(id);
		
		v = new Edit();
		
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
			
			if(idApp == -1) {
				index();	
				}
				if(idApp > -1) {
				index(fincaUno, idApp);	
				}
		});
		
		v.btnRegresar.addActionListener(e->{
			
			if(idApp == -1) {
				index();	
				}
				if(idApp > -1) {
				index(fincaUno, idApp);	
				}
			
		});
		
		v.btnProductos.addActionListener(e->{
			
			if(!btnOn && btnOff) {
				setImgBtn(v.btnProductos, "/resources/ButtonOn.png");
				v.btnTipos.setEnabled(false);
				v.btnCategorias.setEnabled(false);
				
				ControllerNaturaleza cn = new ControllerNaturaleza(v, this);
				cn.switchPanel = false;
				cn.index();
				
				btnOn = true;
			}
			
			if(!btnOff && btnOn) {
				setImgBtn(v.btnProductos, "/resources/ButtonOff.png");
				v.btnTipos.setEnabled(true);
				v.btnCategorias.setEnabled(true);
				
				v.setContenido(null);
				btnOn = false;
				btnOff = true;
			}
			
			if(btnOn) {
				btnOff = false;
			}
			
		});
	
	v.btnTipos.addActionListener(e->{
		
		if(!btnOn && btnOff) {
			setImgBtn(v.btnTipos, "/resources/ButtonOn.png");
			v.btnProductos.setEnabled(false);
			v.btnCategorias.setEnabled(false);
			
			ControllerTipo ct = new ControllerTipo(v, this);
			ct.switchPanel = false;
			ct.index();
			
			btnOn = true;
		}
		
		if(!btnOff && btnOn) {
			setImgBtn(v.btnTipos, "/resources/ButtonOff.png");
			v.btnProductos.setEnabled(true);
			v.btnCategorias.setEnabled(true);
			
			v.setContenido(null);
			btnOn = false;
			btnOff = true;
		}
		
		if(btnOn) {
			btnOff = false;
		}
		
		
	});
	
	v.btnCategorias.addActionListener(e->{
		
		if(!btnOn && btnOff) {
			setImgBtn(v.btnCategorias, "/resources/ButtonOn.png");
			v.btnTipos.setEnabled(false);
			v.btnProductos.setEnabled(false);
			
			ControllerCategoria ca = new ControllerCategoria(v, this);
			ca.switchPanel = false;
			ca.index();
			
			btnOn = true;
		}
		
		if(!btnOff && btnOn) {
			setImgBtn(v.btnCategorias, "/resources/ButtonOff.png");
			v.btnTipos.setEnabled(true);
			v.btnProductos.setEnabled(true);
			
			v.setContenido(null);
			btnOn = false;
			btnOff = true;
		}
		
		if(btnOn) {
			btnOff = false;
		}
		
		
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
	
	public void setImgBtn(JButton btn, String ruta) {
		
		ImageIcon imgBtn = new ImageIcon(getClass().getResource(ruta));
		
		ImageIcon iconImgBtn = new ImageIcon(imgBtn.getImage().getScaledInstance(30, 27, Image.SCALE_DEFAULT));
		
		btn.setIcon(iconImgBtn);
		
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
	
	public void cargarCbxNaturaleza() {
		
		ArrayList<Object> naturalezas = new DAONaturaleza().getData();
		if(f != null) {
			f.cbxProductos.removeAllItems();
		}
		if(v != null) {
		v.cbxProductos.removeAllItems();	
		}
		
		for (Object o : naturalezas) {
			Naturaleza n = (Naturaleza) o;
			if(f != null) {
				f.cbxProductos.addItem(n);
			}
			if(v != null) {
				v.cbxProductos.addItem(n);
			}
		}
		
	}
	
	public void cargarCbxTipo() {
		ArrayList<Object> tipos = new DAOTipo().getData();
		
		if(f != null) {
			f.cbxTipos.removeAllItems();
		}
		if(v != null) {
			v.cbxTipos.removeAllItems();	
		}
		
		
		for (Object o : tipos) {
			Tipo t = (Tipo) o;
			if(f != null) {
				f.cbxTipos.addItem(t);
			}
			if(v != null) {
				v.cbxTipos.addItem(t);	
			}
		}
	}
	
	public void cargarCbxCategoria() {
		ArrayList<Object> categorias = new DAOCategoria().getData();
		
		if(f != null) {
			f.cbxCategorias.removeAllItems();
		}
		if(v != null) {
			v.cbxCategorias.removeAllItems();	
		}
		
		for (Object o : categorias) {
			Categoria c = (Categoria) o;
			if(f != null) {
				f.cbxCategorias.addItem(c);
			}
			if(v != null) {
				v.cbxCategorias.addItem(c);
			}
			
		}
	}

}
