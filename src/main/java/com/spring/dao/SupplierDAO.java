package com.spring.dao;

import java.util.List;

import com.spring.model.Supplier;

public interface SupplierDAO { 

	public boolean saveSupplier(Supplier supplier);

	public void add(Supplier supplier);
	public void edit(Supplier supplier);
	public void delete(int Supid);
	public Supplier getSupplier(int Supid);
	public List getAllSupplier();
	public List<Supplier> list();

}
