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
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bus");
		
		User user = new User();
		user.setUserName("Another");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		

//		Vehicle newVehicle = session.get(Vehicle.class, 2);
//		System.out.println(newVehicle.getVehicleName());
//		System.out.println(newVehicle.getUserDetails().getUserName());
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
