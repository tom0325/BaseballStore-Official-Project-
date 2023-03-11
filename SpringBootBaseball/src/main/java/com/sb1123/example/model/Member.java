package com.sb1123.example.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@Table(name="member")
//@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	private String  phone;
	private String address;

	private String email;

	private String password;
    private String name;
    private String enabled;
	

	public Member() 
	{
	}
	

	public Member(String phone, String address, String email, String password, String name, String enabled) {
		super();
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.password = password;
		this.name = name;
		this.enabled = enabled;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}