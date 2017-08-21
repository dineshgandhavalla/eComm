package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ExclusiveDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Exclusive;

@Service
public class ExclusiveServiceImpl implements ExclusiveService {


	@Autowired
	private  ExclusiveDAO  exclusiveDAO;
	
@Transactional
	public void add(Exclusive exclusive) {
		// TODO Auto-generated method stub
		exclusiveDAO.add(exclusive);
	}

@Transactional
public void edit(Exclusive exclusive) {
		// TODO Auto-generated method stub
	exclusiveDAO.edit(exclusive);
	}

@Transactional
	public void delete(int exid) {
		// TODO Auto-generated method stub
	exclusiveDAO.delete(exid);
	}

@Transactional
	public Exclusive getExclusive(int exid) {
		// TODO Auto-generated method stub
		return exclusiveDAO.getExclusive(exid);
	}

@Transactional
	public List getAllExclusive() {
		// TODO Auto-generated method stub
		return exclusiveDAO.getAllExclusive();
	}
	

}
