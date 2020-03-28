package com.zakaria.hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	@Id @GeneratedValue
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="vehicle_name")
	private String vehicleName;
	
	@ManyToMany
	private List<User> users = new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
