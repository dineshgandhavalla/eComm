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
	private int id;
	
	private int userid;
	private String productname;
	private double productprice;
	private int quantity;
	private String status;
	private double subTotal;
	private int productid;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}

	
	
	
	
	/*@Id
	@Column(name="Cartid")
	@GeneratedValue
	private int cartId;
	private int quantity;
	private float sumtotal;
	private int pid;
	private int prodprice;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="pid", updatable = false, insertable = false, nullable = false)
	private Product product;
	private Set<Product> products = new HashSet<Product>(0);
	
	
	
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
	public Product getProduct() {
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
	public int getCartId() {
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
	
		this.sumtotal = sumtotal;
	}

	
	
*/
