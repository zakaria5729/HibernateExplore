package com.zakaria.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.zakaria.hibernate.dto.User;
import com.zakaria.hibernate.dto.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Truck");
		
//		Vehicle vehicle2 = new Vehicle();
//		vehicle2.setVehicleName("Bus");
		
		User user = new User();
		user.setUserName("First User");
		
		User user2 = new User();
		user2.setUserName("Second User");
		
		user.getVehicles().add(vehicle);
		user2.getVehicles().add(vehicle);
		vehicle.getUsers().add(user);
		vehicle.getUsers().add(user2);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		

//		Vehicle newVehicle = session.get(Vehicle.class, 2);
//		System.out.println(newVehicle.getVehicleName());
//		System.out.println(newVehicle.getUserDetails().getUserName());
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
