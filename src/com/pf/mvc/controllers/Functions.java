package com.pf.mvc.controllers;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Functions {
	public Functions() {}
	

 public void buscar(JTable tabla, String buscar, int... cols) {
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
		tabla.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)"+buscar, cols));
        //(?i) = case-insensitive

	}
	
	public int getSelectedID(JTable tabla) {

		int row = tabla.getSelectedRow();
		if(row >= 0) {
			return (int) tabla.getValueAt(row, 0);
		}else {
			return -1;
		}

	}
}
