package com.pf.mvc.controllers;

import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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

public class ControllerProductos extends Functions implements Controller {

	private DAOProducto dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids = new ArrayList<>();
	private boolean btnOn;
	private boolean btnOff;
	private int idApp;

	public ControllerProductos(ViewPrincipal vp) {
		dao = new DAOProducto();
		this.vp = vp;
		this.btnOn = false;
		this.btnOff = true;
		this.idApp = -1;
	}

	@Override
	public void index() {

		idApp = -1;

		Index in = new Index();

		in.modelo.setDataVector(getData(), getColumns());

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

			int id = getSelectedId(in.table, ids);
			edit(id);

		});

		in.btnEliminar.addActionListener(e -> {

			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un empleado de la tabla para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table, ids);
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
				buscar(in.tBuscar, in.filtro);
			}
		});

		vp.setContenido(in, "Lista de productos");

	}

	@Override
	public void create() {

		Form f = new Form();

//		ArrayList<Object> naturalezas = new DAONaturaleza().getData();
//		for (Object o : naturalezas) {
//			Naturaleza n = (Naturaleza) o;
//			f.cbxProductos.addItem(n);
//		}
//
//		ArrayList<Object> tipos = new DAOTipo().getData();
//		for (Object o : tipos) {
//			Tipo t = (Tipo) o;
//
//			f.cbxTipos.addItem(t);
//		}
//
//		ArrayList<Object> categorias = new DAOCategoria().getData();
//		for (Object o : categorias) {
//			Categoria c = (Categoria) o;
//
//			f.cbxCategorias.addItem(c);
//		}

		cargarCbxNaturaleza(f);
		cargarCbxTipo(f);
		cargarCbxCategoria(f);

		f.btnAgregar.addActionListener(e -> {

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

		f.btnCancelar.addActionListener(e -> {

			actualizarTabla();

			index();

		});

		f.btnProductos.addActionListener(e -> {

			if (!btnOn && btnOff) {
				setImgBtn(f.btnProductos, "/resources/ButtonOn.png");
				f.btnTipos.setEnabled(false);
				f.btnCategorias.setEnabled(false);

				ControllerNaturaleza cn = new ControllerNaturaleza(f, this);
				cn.switchPanel = true;
				cn.index();

				btnOn = true;
			}

			if (!btnOff && btnOn) {
				setImgBtn(f.btnProductos, "/resources/ButtonOff.png");
				f.btnTipos.setEnabled(true);
				f.btnCategorias.setEnabled(true);

				f.setContenido(null);
				btnOn = false;
				btnOff = true;
			}

			if (btnOn) {
				btnOff = false;
			}

		});

		f.btnTipos.addActionListener(e -> {

			if (!btnOn && btnOff) {
				setImgBtn(f.btnTipos, "/resources/ButtonOn.png");
				f.btnProductos.setEnabled(false);
				f.btnCategorias.setEnabled(false);

				ControllerTipo ct = new ControllerTipo(f, this);
				ct.switchPanel = true;
				ct.index();

				btnOn = true;
			}

			if (!btnOff && btnOn) {
				setImgBtn(f.btnTipos, "/resources/ButtonOff.png");
				f.btnProductos.setEnabled(true);
				f.btnCategorias.setEnabled(true);

				f.setContenido(null);
				btnOn = false;
				btnOff = true;
			}

			if (btnOn) {
				btnOff = false;
			}

		});

		f.btnCategorias.addActionListener(e -> {

			if (!btnOn && btnOff) {
				setImgBtn(f.btnCategorias, "/resources/ButtonOn.png");
				f.btnTipos.setEnabled(false);
				f.btnProductos.setEnabled(false);

				ControllerCategoria ca = new ControllerCategoria(f, this);
				ca.switchPanel = true;
				ca.index();

				btnOn = true;
			}

			if (!btnOff && btnOn) {
				setImgBtn(f.btnCategorias, "/resources/ButtonOff.png");
				f.btnTipos.setEnabled(true);
				f.btnProductos.setEnabled(true);

				f.setContenido(null);
				btnOn = false;
				btnOff = true;
			}

			if (btnOn) {
				btnOff = false;
			}

		});

		vp.setContenido(f, "Agregar productos");

	}

	@Override
	public void edit(int id) {

		Producto item = (Producto) dao.getItem(id);

		Edit ed = new Edit();

		ArrayList<Object> naturalezas = new DAONaturaleza().getData();
		ed.cbxProductos.removeAllItems();

		for (Object o : naturalezas) {
			Naturaleza n = (Naturaleza) o;
			ed.cbxProductos.addItem(n);

			if (n.getId() == item.getIdNaturaleza()) {
				ed.cbxProductos.setSelectedItem(n);
			}
		}

		ed.tNombre.setText(item.getNombre());
		ed.tCodigo.setText(item.getCodigo());
		ed.tUnidad.setText(item.getUnidades());

		ArrayList<Object> tipos = new DAOTipo().getData();
		ed.cbxTipos.removeAllItems();

		for (Object o : tipos) {
			Tipo t = (Tipo) o;
			ed.cbxTipos.addItem(t);

			if (t.getId() == item.getIdTipo()) {
				ed.cbxTipos.setSelectedItem(t);
			}
		}

		ArrayList<Object> categorias = new DAOCategoria().getData();
		ed.cbxCategorias.removeAllItems();

		for (Object o : categorias) {
			Categoria c = (Categoria) o;
			ed.cbxCategorias.addItem(c);

			if (c.getId() == item.getIdCategoria()) {
				ed.cbxCategorias.setSelectedItem(c);
			}
		}

		ed.btnActualizar.addActionListener(e -> {
			String nombre = ed.tNombre.getText();
			String unidades = ed.tUnidad.getText();
			String codigo = ed.tCodigo.getText();

			Tipo t = (Tipo) ed.cbxTipos.getSelectedItem();
			int idTipo = t.getId();

			Categoria g = (Categoria) ed.cbxCategorias.getSelectedItem();
			int idCategoria = g.getId();

			Naturaleza n = (Naturaleza) ed.cbxProductos.getSelectedItem();
			int idNaturaleza = n.getId();

			Producto nuevoItem = new Producto(nombre, unidades, codigo, idTipo, idCategoria, idNaturaleza);

			if (item.getId() > 0) {
				dao.update(nuevoItem, item.getId());
				edit(item.getId());
			}

			index();
		});

		ed.btnRegresar.addActionListener(e -> {

			actualizarTabla();

			index();

		});

		ed.btnProductos.addActionListener(e -> {

			if (!btnOn && btnOff) {
				setImgBtn(ed.btnProductos, "/resources/ButtonOn.png");
				ed.btnTipos.setEnabled(false);
				ed.btnCategorias.setEnabled(false);

				ControllerNaturaleza cn = new ControllerNaturaleza(ed, this);
				cn.switchPanel = false;
				cn.index();

				btnOn = true;
			}

			if (!btnOff && btnOn) {
				setImgBtn(ed.btnProductos, "/resources/ButtonOff.png");
				ed.btnTipos.setEnabled(true);
				ed.btnCategorias.setEnabled(true);

				ed.setContenido(null);
				btnOn = false;
				btnOff = true;
			}

			if (btnOn) {
				btnOff = false;
			}

		});

		ed.btnTipos.addActionListener(e -> {

			if (!btnOn && btnOff) {
				setImgBtn(ed.btnTipos, "/resources/ButtonOn.png");
				ed.btnProductos.setEnabled(false);
				ed.btnCategorias.setEnabled(false);

				ControllerTipo ct = new ControllerTipo(ed, this);
				ct.switchPanel = false;
				ct.index();

				btnOn = true;
			}

			if (!btnOff && btnOn) {
				setImgBtn(ed.btnTipos, "/resources/ButtonOff.png");
				ed.btnProductos.setEnabled(true);
				ed.btnCategorias.setEnabled(true);

				ed.setContenido(null);
				btnOn = false;
				btnOff = true;
			}

			if (btnOn) {
				btnOff = false;
			}

		});

		ed.btnCategorias.addActionListener(e -> {

			if (!btnOn && btnOff) {
				setImgBtn(ed.btnCategorias, "/resources/ButtonOn.png");
				ed.btnTipos.setEnabled(false);
				ed.btnProductos.setEnabled(false);

				ControllerCategoria ca = new ControllerCategoria(ed, this);
				ca.switchPanel = false;
				ca.index();

				btnOn = true;
			}

			if (!btnOff && btnOn) {
				setImgBtn(ed.btnCategorias, "/resources/ButtonOff.png");
				ed.btnTipos.setEnabled(true);
				ed.btnProductos.setEnabled(true);

				ed.setContenido(null);
				btnOn = false;
				btnOff = true;
			}

			if (btnOn) {
				btnOff = false;
			}

		});

		vp.setContenido(ed, "Editar producto");
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
		return new String[] { "Producto", "Tipo", "Código", "Categoría", "Nombre", "Unidades" };
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

	public void cargarCbxNaturaleza(Form f) {
		//Form f = new Form();
		Edit e = new Edit();
		ArrayList<Object> naturalezas = new DAONaturaleza().getData();

		if (f != null) {
			f.cbxProductos.removeAllItems();
		}
		if (e != null) {
			e.cbxProductos.removeAllItems();
		}

		for (Object o : naturalezas) {
			Naturaleza c = (Naturaleza) o;
			if (f != null) {
				f.cbxProductos.addItem(c);
			}
			if (e != null) {
				e.cbxProductos.addItem(c);
			}

		}
	}

	public void cargarCbxTipo(Form f) {
		Edit e = new Edit();
		ArrayList<Object> tipos = new DAOTipo().getData();

		if (f != null) {
			f.cbxTipos.removeAllItems();
		}
		if (e != null) {
			e.cbxTipos.removeAllItems();
		}

		for (Object o : tipos) {
			Tipo c = (Tipo) o;
			if (f != null) {
				f.cbxTipos.addItem(c);
			}
			if (e != null) {
				e.cbxTipos.addItem(c);
			}

		}
	}

	public void cargarCbxCategoria(Form f) {
		//Form f = new Form();
		Edit e = new Edit();
		ArrayList<Object> categorias = new DAOCategoria().getData();

		if (f != null) {
			f.cbxCategorias.removeAllItems();
		}
		if (e != null) {
			e.cbxCategorias.removeAllItems();
		}

		for (Object o : categorias) {
			Categoria c = (Categoria) o;
			if (f != null) {
				f.cbxCategorias.addItem(c);
			}
			if (e != null) {
				e.cbxCategorias.addItem(c);
			}

		}
	}

	public void actualizarTabla() {
		Index in = new Index();
		in.modelo.setDataVector(getData(), getColumns());

	}

}
