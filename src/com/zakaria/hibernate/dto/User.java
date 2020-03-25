package com.zakaria.hibernate.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="user_details")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id") private int userId;	 
	
	@Column(name="user_name")
	private String userName;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@OrderColumn(name="address_id")
	@JoinTable(name="user_addresses", joinColumns=@JoinColumn(name="user_id"))
	private List<Address> listOfAddresses = new ArrayList<>();	
	
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public int getUserId() { return userId; }
	 
	public void setUserId(int userId) { this.userId = userId; }
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
