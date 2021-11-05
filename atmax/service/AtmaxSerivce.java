package com.atmax.service;

public interface AtmaxSerivce {
	int insert(String firstname,String lastname);
	int updateFirstName(String oldName, String newName);
	int delete(String firstname);
	void select(String firstname);
	void selectAll();
	
}
