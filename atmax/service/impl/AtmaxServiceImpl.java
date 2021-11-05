package com.atmax.service.impl;



import com.atmax.dao.DMLDao;
import com.atmax.dao.impl.DMLDaoImpl;
import com.atmax.service.AtmaxSerivce;

public class AtmaxServiceImpl implements AtmaxSerivce {

	static DMLDao  dao = new DMLDaoImpl();
	
	@Override
	public int insert(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return dao.insert(firstname, lastname);
	}

	@Override
	public int updateFirstName(String oldName, String newName) {
		// TODO Auto-generated method stub
		return dao.updateFN(oldName, newName);
	}


	@Override
	public int delete(String firstname) {
		// TODO Auto-generated method stub
		return dao.delete(firstname);
	}

	@Override
	public void select(String firstname) {
		// TODO Auto-generated method stub
		dao.select(firstname);
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		dao.selectAll();
	}

}
