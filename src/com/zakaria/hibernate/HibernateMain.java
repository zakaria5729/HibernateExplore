package com.zakaria.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.zakaria.hibernate.dto.User;
import com.zakaria.hibernate.dto.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Auto");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bi-cycle");
		
		User user = new User();
		user.setUserName("Fourth User");
		
//		User user2 = new User();
//		user2.setUserName("Second User");
		
//		user.getVehicles().add(vehicle);
//		user.getVehicles().add(vehicle2);
//		vehicle.getUsers().add(user);
//		vehicle2.getUsers().add(user);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		user = null;
		user = session.get(User.class, 7);
		
		session.delete(user);
//		session.save(user);
//		session.save(user2);
//		session.save(vehicle);
		

//		Vehicle newVehicle = session.get(Vehicle.class, 2);
//		System.out.println(newVehicle.getVehicleName());
//		System.out.println(newVehicle.getUserDetails().getUserName());
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
