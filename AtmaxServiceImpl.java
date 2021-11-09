package com.atmax.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atmax.dao.DMLDao;
import com.atmax.model.AtmaxEmployee;
import com.atmax.service.AtmaxService;

@Service
public class AtmaxServiceImpl implements AtmaxService {

	@Autowired
	DMLDao dao;

	@Override
	public int insert(AtmaxEmployee emp) {
		// TODO Auto-generated method stub
		return dao.insert(emp);
	}

	@Override
	public int update(AtmaxEmployee emp) {
		// TODO Auto-generated method stub
		return dao.update(emp);
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		return dao.delete(email);
	}

	@Override
	public List<AtmaxEmployee> select(String email) {
		// TODO Auto-generated method stub
		return dao.select(email);
	}

	@Override
	public List<AtmaxEmployee> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
}
