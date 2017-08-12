package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SupplierDAO;
import com.spring.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDAO supplierDAO;
	
	@Transactional
	public void add(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDAO.add(supplier);
		
	}

	@Transactional
	public void edit(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDAO.edit(supplier);
	}

	@Transactional
	public void delete(int Supid) {
		// TODO Auto-generated method stub
		supplierDAO.delete(Supid);
	}
	

	@Transactional
	public Supplier getSupplier(int Supid) {
		// TODO Auto-generated method stub
		return supplierDAO.getSupplier(Supid);
	}

	@Transactional
	public List getAllSupplier() {
		// TODO Auto-generated method stub
		return supplierDAO.getAllSupplier() ;
	}

}
