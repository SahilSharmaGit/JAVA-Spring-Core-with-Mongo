package com.atmax.dao;

public interface DMLDao {

	int insert(String firstname,String lastname);
	int updateFN(String oldName, String newName);
	int delete(String firstname);
	void select(String firstname);
	void selectAll();
}
