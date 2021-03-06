package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
@Entity 
@Table(name="User_details")
public class Users {
	
	@Id 
	@GeneratedValue
	private int id;
	@Size(min=3, message="name should not be less than {min} characters")
	private String name;
	@NotNull@Email(message="please enter a valid email")
	private String email;
	@NotNull(message="please provide address")
	private String address;
	private String role;
	@NotNull@Pattern(regexp="(^$|[0-9]{10})" , message="invalid number")
	private String contact_number;
	@Size(min=4,max=8, message="password must be between {min} and {max} characters ")
	private String repeat_password;
	@Size(min=4,max=8, message="password must be between {min} and {max} characters ")
	private String password;
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getRepeat_password() {
		return repeat_password;
	}
	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
	}
	
	

}
