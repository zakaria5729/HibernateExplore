package com.zakaria.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id") private int userId;	 
	
	@Column(name="user_name")
	private String userName;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
