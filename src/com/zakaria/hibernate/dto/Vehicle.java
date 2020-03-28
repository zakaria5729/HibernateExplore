package com.zakaria.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("new_vehicle")
@DiscriminatorColumn(
		name="vehicle_type",
		discriminatorType = DiscriminatorType.STRING
	)
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
