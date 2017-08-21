package com.spring.service;

import java.util.List;

import com.spring.model.Exclusive;


public interface ExclusiveService {
	

	public void add(Exclusive exclusive);
	public void edit(Exclusive exclusive);
	public void delete(int exid);
	public Exclusive getExclusive(int exid);
	public List getAllExclusive();

}
