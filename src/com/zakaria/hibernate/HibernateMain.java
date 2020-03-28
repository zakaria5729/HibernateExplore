package com.zakaria.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.zakaria.hibernate.dto.User;
import com.zakaria.hibernate.dto.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		User user = new User();
		user.setUserName("New User");
		user.setVehicle(vehicle);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
}
