package com.pf.mvc.controllers;

import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.GenericArrayType;
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
import com.pf.mvc.views.producto.Form;
import com.pf.mvc.views.producto.Index;

public class ControllerProductos extends Functions implements Controller {

	private DAOProducto dao;
	private ViewPrincipal vp;
	private ArrayList<Integer> ids;
	private boolean btnOn;
	private boolean btnOff;

	public ControllerProductos(ViewPrincipal vp) {
		dao = new DAOProducto();
		this.vp = vp;
		this.btnOn = false;
		this.btnOff = true;
		this.ids = new ArrayList<>();
	}

	@Override
	public void index() {

		Index in = new Index();

		in.modelo.setDataVector(dao.getProductos(), getColumns());
		ocultarColumna(in.table);

		in.btnNuevo.addActionListener(e -> {

			create();

		});

		in.btnEditar.addActionListener(e -> {

			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un producto de la tabla para editar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table);
			edit(id);

		});

		in.btnEliminar.addActionListener(e -> {

			int selectedRow = in.table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(in, "Debe seleccionar un producto de la tabla para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int id = getSelectedId(in.table);
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

		vp.setContenido(in, "Lista de productos");

	}

	@Override
	public void create() {

		Form f = new Form();

		cargarCbxNaturaleza(f);
		cargarCbxTipo(f);
		cargarCbxCategoria(f);

		f.btnAgregar.addActionListener(e -> {

			String nombre = f.tNombre.getText().trim();
			String unidades = f.tUnidad.getText().trim();
			String codigo = f.tCodigo.getText().trim();

			Tipo t = (Tipo) f.cbxTipos.getSelectedItem();
			Categoria g = (Categoria) f.cbxCategorias.getSelectedItem();
			Naturaleza n = (Naturaleza) f.cbxProductos.getSelectedItem();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(f, "El campo 'Nombre' es obligatorio.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (codigo.isEmpty()) {
				JOptionPane.showMessageDialog(f, "El campo 'Código' es obligatorio.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (unidades.isEmpty()) {
				JOptionPane.showMessageDialog(f, "El campo 'Unidad de medida' es obligatorio.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (t == null) {
				JOptionPane.showMessageDialog(f, "Debe seleccionar un Tipo.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (g == null) {
				JOptionPane.showMessageDialog(f, "Debe seleccionar una Categoría.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (n == null) {
				JOptionPane.showMessageDialog(f, "Debe seleccionar una Naturaleza.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			try {
				int idTipo = t.getId();
				int idCategoria = g.getId();
				int idNaturaleza = n.getId();

				Producto item = new Producto(nombre, unidades, codigo, idTipo, idCategoria, idNaturaleza);

				dao.store(item);

				JOptionPane.showMessageDialog(f, "Producto registrado correctamente.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				index();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(f, "Ocurrió un error al guardar el producto: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		f.btnCancelar.addActionListener(e -> {
			actualizarTabla();
			index();
		});

		vp.setContenido(f, "Agregar productos");
	}

	@Override
	public void edit(int id) {

		Producto item = (Producto) dao.getItem(id);

		Form f = new Form();
		f.btnAgregar.setText("Actualizar");

		ArrayList<Object> naturalezas = new DAONaturaleza().getData();
		f.cbxProductos.removeAllItems();
		for (Object o : naturalezas) {
			Naturaleza n = (Naturaleza) o;
			f.cbxProductos.addItem(n);
			if (n.getId() == item.getIdNaturaleza()) {
				f.cbxProductos.setSelectedItem(n);
			}
		}

		f.tNombre.setText(item.getNombre());
		f.tCodigo.setText(item.getCodigo());
		f.tUnidad.setText(item.getUnidades());

		ArrayList<Object> tipos = new DAOTipo().getData();
		f.cbxTipos.removeAllItems();
		for (Object o : tipos) {
			Tipo t = (Tipo) o;
			f.cbxTipos.addItem(t);
			if (t.getId() == item.getIdTipo()) {
				f.cbxTipos.setSelectedItem(t);
			}
		}

		ArrayList<Object> categorias = new DAOCategoria().getData();
		f.cbxCategorias.removeAllItems();
		for (Object o : categorias) {
			Categoria c = (Categoria) o;
			f.cbxCategorias.addItem(c);
			if (c.getId() == item.getIdCategoria()) {
				f.cbxCategorias.setSelectedItem(c);
			}
		}

		f.btnAgregar.addActionListener(e -> {
			String nombre = f.tNombre.getText().trim();
			String unidades = f.tUnidad.getText().trim();
			String codigo = f.tCodigo.getText().trim();

			Tipo t = (Tipo) f.cbxTipos.getSelectedItem();
			Categoria g = (Categoria) f.cbxCategorias.getSelectedItem();
			Naturaleza n = (Naturaleza) f.cbxProductos.getSelectedItem();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(f, "El campo 'Nombre' es obligatorio.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (codigo.isEmpty()) {
				JOptionPane.showMessageDialog(f, "El campo 'Código' es obligatorio.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (unidades.isEmpty()) {
				JOptionPane.showMessageDialog(f, "El campo 'Unidad de medida' es obligatorio.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (t == null) {
				JOptionPane.showMessageDialog(f, "Debe seleccionar un Tipo.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (g == null) {
				JOptionPane.showMessageDialog(f, "Debe seleccionar una Categoría.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (n == null) {
				JOptionPane.showMessageDialog(f, "Debe seleccionar una Naturaleza.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			try {
				int idTipo = t.getId();
				int idCategoria = g.getId();
				int idNaturaleza = n.getId();

				Producto nuevoItem = new Producto(nombre, unidades, codigo, idTipo, idCategoria, idNaturaleza);

				if (item.getId() > 0) {
					dao.update(nuevoItem, item.getId());
					JOptionPane.showMessageDialog(f, "Producto actualizado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}

				index();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(f, "Ocurrió un error al actualizar el producto: " + ex.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		f.btnCancelar.addActionListener(e -> {
			actualizarTabla();
			index();
		});

		vp.setContenido(f, "Editar producto");
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

			data[i][0] = p.getId();

			Naturaleza naturaleza = (Naturaleza) new DAONaturaleza().getItem(p.getIdNaturaleza());
			data[i][1] = naturaleza.getNombre();

			Tipo tipo = (Tipo) new DAOTipo().getItem(p.getIdTipo());
			data[i][2] = tipo.getNombre();

			data[i][3] = p.getCodigo();

			Categoria categoria = (Categoria) new DAOCategoria().getItem(p.getIdCategoria());
			data[i][4] = categoria.getNombre();

			data[i][5] = p.getNombre();
			data[i][6] = p.getUnidades();

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
		return new String[] { "ID", "PRODUCTO", "TIPO", "CÓDIGO", "CATEGORÍA", "NOMBRE", "UNIDADES" };
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
		ArrayList<Object> naturalezas = new DAONaturaleza().getData();

		if (f != null) {
			f.cbxProductos.removeAllItems();
		}

		for (Object o : naturalezas) {
			Naturaleza c = (Naturaleza) o;
			if (f != null) {
				f.cbxProductos.addItem(c);
			}

		}
	}

	public void cargarCbxTipo(Form f) {
		ArrayList<Object> tipos = new DAOTipo().getData();

		if (f != null) {
			f.cbxTipos.removeAllItems();
		}

		for (Object o : tipos) {
			Tipo c = (Tipo) o;
			if (f != null) {
				f.cbxTipos.addItem(c);
			}

		}
	}

	public void cargarCbxCategoria(Form f) {
		ArrayList<Object> categorias = new DAOCategoria().getData();

		if (f != null) {
			f.cbxCategorias.removeAllItems();
		}

		for (Object o : categorias) {
			Categoria c = (Categoria) o;
			if (f != null) {
				f.cbxCategorias.addItem(c);
			}

		}
	}

	public void actualizarTabla() {
		Index in = new Index();
		in.modelo.setDataVector(getData(), getColumns());

	}

}
