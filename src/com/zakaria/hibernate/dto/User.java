package com.zakaria.hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id") 
	private int userId;	 
	
	@Column(name="user_name")
	private String userName;
	
//	@ManyToMany(mappedBy = "users")
//	@Cascade(CascadeType.ALL)
//	@JoinTable(name="user_vehicle", joinColumns = @JoinColumn(name="user_id"),
//				inverseJoinColumns = @JoinColumn(name="vehicle_id"))
	//private List<Vehicle> vehicles = new ArrayList<>();

	public int getUserId() { return userId; }
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

//	public List<Vehicle> getVehicles() {
//		return vehicles;
//	}
//
//	public void setVehicles(List<Vehicle> vehicles) {
//		this.vehicles = vehicles;
//	}
}
