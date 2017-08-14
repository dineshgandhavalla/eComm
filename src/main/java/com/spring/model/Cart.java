package com.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART_DETAILS")
public class Cart {
	@Id
	@Column(name="Cartid")
	@GeneratedValue
	private int cartId;
	int q=1;
	private int quantity;
	private float sumtotal;
	private int pid;
	private int prodprice;
	/*
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="pid", updatable = false, insertable = false, nullable = false)
	private Product product;
	private Set<Product> products = new HashSet<Product>(0);
	*/
	
	
	public int getPid() {
		return pid;
	}
	public int getProdprice() {
		return prodprice;
	}
	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	/*public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
*/	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSumtotal() {
		return sumtotal;
	}
	public void setSumtotal(float sumtotal) {
		sumtotal= (q*(prodprice));
		this.sumtotal = sumtotal;
	}

	
	
}

