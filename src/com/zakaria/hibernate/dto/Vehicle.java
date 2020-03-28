package com.zakaria.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="vehicle_name")
	private String vehicleName;
	
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
