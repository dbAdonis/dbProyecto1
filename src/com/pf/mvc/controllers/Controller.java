package com.pf.mvc.controllers;

public interface Controller {
	
	public void index();
	public void create();
	public void edit(int id);
	
	public Object[][] getData();
	public String[] getColumns();
	
	public void store(Object o);
	public void update(Object o, int id);
	public void destroy(int id);
}
