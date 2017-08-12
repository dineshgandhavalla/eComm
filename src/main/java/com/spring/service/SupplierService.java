package com.spring.service;

import java.util.List;

import com.spring.model.Supplier;

public interface SupplierService {


	public void add(Supplier supplier);
	public void edit(Supplier supplier);
	public void delete(int Supid);
	public Supplier getSupplier(int Supid);
	public List getAllSupplier();
}
