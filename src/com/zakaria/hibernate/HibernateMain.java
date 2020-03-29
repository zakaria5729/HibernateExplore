package com.zakaria.hibernate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		
//		int id = 4;
//		Query query = session.getNamedQuery("User.byId");
//		query.setParameter("id", id);
//		query.setParameter(0, 1);
//		query.setFirstResult(3);
//		query.setMaxResults(10);
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.where(
			criteriaBuilder.like(root.get("userName"), "user1%"),
			criteriaBuilder.between(root.get("userId"), 1, 50)
		);
		
		List<User> users = session.createQuery(criteriaQuery).getResultList();
		users.forEach(user -> System.out.println(user.getUserName()));
		
//		session.save(vehicle);
//		session.save(bike);
//		session.save(car);

		session.getTransaction().commit();
		session.close();
	}
}
