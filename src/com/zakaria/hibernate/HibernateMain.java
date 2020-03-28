package com.zakaria.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zakaria.hibernate.dto.FourWheeler;
import com.zakaria.hibernate.dto.TwoWheeler;
import com.zakaria.hibernate.dto.User;
import com.zakaria.hibernate.dto.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("New Vehicle");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike streering handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Car");
		car.setSteeringWheel("Car steering wheel");
		
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		session.close();
	}
}
