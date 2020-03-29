package com.zakaria.hibernate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zakaria.hibernate.dto.User;

public class HibernateMain {

	public static void main(String[] args) {
		
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("New Vehicle");
//		
//		TwoWheeler bike = new TwoWheeler();
//		bike.setVehicleName("Bike");
//		bike.setSteeringHandle("Bike streering handle");
//		
//		FourWheeler car = new FourWheeler();
//		car.setVehicleName("Car");
//		car.setSteeringWheel("Car steering wheel");
		
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		int id = 4;
		
		Query query = session.createQuery("select userName from User where userId > :userId");
		query.setParameter("userId", id);
		//query.setParameter(0, 1);
//		query.setFirstResult(3);
//		query.setMaxResults(10);
		
		List<String> users = query.getResultList();
		users.forEach(user -> System.out.println(user));
		
//		session.save(vehicle);
//		session.save(bike);
//		session.save(car);

		session.getTransaction().commit();
		session.close();
	}
}
