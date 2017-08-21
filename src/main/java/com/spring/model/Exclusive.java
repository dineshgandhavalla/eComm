package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Exclusive_Deals")
public class Exclusive {
	@Id
	@GeneratedValue
	private int exid;
	private String epname,epdescription,eprice;
	@Transient
	private MultipartFile eximage;
	public int getExid() {
		return exid;
	}
	public void setExid(int exid) {
		this.exid = exid;
	}
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getEpdescription() {
		return epdescription;
	}
	public void setEpdescription(String epdescription) {
		this.epdescription = epdescription;
	}
	public String getEprice() {
		return eprice;
	}
	public void setEprice(String eprice) {
		this.eprice = eprice;
	}
	public MultipartFile getEximage() {
		return eximage;
	}
	public void setEximage(MultipartFile eximage) {
		this.eximage = eximage;
	}
	

}
