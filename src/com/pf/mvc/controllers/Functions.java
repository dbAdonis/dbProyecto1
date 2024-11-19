package com.pf.mvc.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.pf.mvc.models.vo.Finca;

public class Functions {

	public Functions() {}

	public void buscar(JTextField tBuscar, TableRowSorter<DefaultTableModel> filtro, int columna) {

		
		tBuscar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				String buscar = tBuscar.getText();
					filtro.setRowFilter(RowFilter.regexFilter("(?i)"+buscar, columna));
			}
			@Override
			public void keyPressed(KeyEvent e) {}

		});

	}
	
	public int getSelectedId(JTable table, ArrayList<Integer> ids) {
		
		int row = table.getSelectedRow();
		
		if(row>-1) {
			return ids.get(row);
		}
		return -1;
	}
	
	public void ocultarColumna(JTable tabla) {
		
		TableColumn columna = tabla.getColumnModel().getColumn(0);
		columna.setMinWidth(0);
		columna.setMaxWidth(0);
		columna.setPreferredWidth(0);
		
	}

	
	public int getSelectedId(JTable table) {
		
		int row = table.getSelectedRow();
		
		System.out.println(row);
		
		if(row>-1) {
			return (int) table.getValueAt(row, 0);
		}
		return -1;
	}

}
