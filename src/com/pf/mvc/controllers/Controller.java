package com.pf.mvc.controllers;

public interface Controller {
	
	// VIEWS
	
	public void index();
	public void create();
	public void edit(int id);
	
	public Object[][] getData();
	public String[] getColumns();
	
	// MODELS
	
	public void store(Object o);
	public void update(Object o, int id);
	public void destroy(int id);
	
	// DAO -> DATA ACCESS OBJECT
	// VO -> VALUE OBJECT 
	

}
