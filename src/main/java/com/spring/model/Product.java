package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product_details")
public class Product implements Serializable{
	@Id
	@Column(name="pid") 
	@GeneratedValue 
	private int id;
	private String product_name,description;
	private int price,stock;
	private int Catid;
	private int Supid;
	@Transient
	private MultipartFile image;
	
	
	
	@ManyToOne
	@JoinColumn(name="Catid" , updatable = false, insertable = false, nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="Supid", updatable = false, insertable = false, nullable = false)
	private Supplier supplier;
	
	
	
	
	

	public int getCatid() {
		return Catid;
	}
	public void setCatid(int catid) {
		Catid = catid;
	}
	public int getSupid() {
		return Supid;
	}
	public void setSupid(int supid) {
		Supid = supid;
	}
	public int getId() {
		return id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}


	
}
