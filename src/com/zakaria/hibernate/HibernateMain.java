package com.zakaria.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zakaria.hibernate.dto.Address;
import com.zakaria.hibernate.dto.Person;
import com.zakaria.hibernate.dto.User;

public class HibernateMain {

	public static void main(String[] args) {
		Person person = new Person();
		person.setFirstName("new first name");
		person.setLastName("new last name");
		
		Address homeAddress = new Address();
		homeAddress.setCity("Dhaka");
		homeAddress.setStreet("Shekertek");
		homeAddress.setState("Mohammadpur");
		homeAddress.setPincode(123);
		
		Address officeAddress = new Address();
		officeAddress.setCity("Dhaka1");
		officeAddress.setStreet("Shekertek1");
		officeAddress.setState("Mohammadpur1");
		officeAddress.setPincode(1231);
		
		User user = new User();
		user.setUserName("New User");
		user.setPerson(person);
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		user.setDescription("It is a long established fact that a reader");
		user.setJoinedData(new Date());
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.getTransaction().commit();
		
		user = null;
		
		/*
		 * user = session.get(UserDetails.class, 3);
		 * System.out.println(user.getDescription());
		 */
		
		session.close();
	}

}
