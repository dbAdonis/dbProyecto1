package com.pf.mvc.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Functions {

	public Functions() {}

	public void buscar(JTextField tBuscar, TableRowSorter<DefaultTableModel> filtro) {

		tBuscar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				String buscar = tBuscar.getText();
				filtro.setRowFilter(RowFilter.regexFilter("(?i)"+buscar));
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

}
