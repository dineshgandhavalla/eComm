package com.spring.dao;

import java.util.List;

import com.spring.model.Exclusive;


public interface ExclusiveDAO {
	public void add(Exclusive exclusive);
	public void edit(Exclusive exclusive);
	public void delete(int exid);
	public Exclusive getExclusive(int exid);
	public List getAllExclusive();
	

	public List<Exclusive> list();

}
