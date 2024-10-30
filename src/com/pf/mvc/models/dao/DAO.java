package com.pf.mvc.models.dao;

import java.util.ArrayList;

public interface DAO {

	// ACCIONES
	public boolean store(Object o);
	public boolean update(Object o, int id);
	public boolean destroy(int id);
	
	// OBTENER INFO
	public Object getItem(int id);
	public ArrayList<Object> getData();

}
