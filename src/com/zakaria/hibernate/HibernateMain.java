package com.zakaria.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zakaria.hibernate.dto.Address;
import com.zakaria.hibernate.dto.User;

public class HibernateMain {

	public static void main(String[] args) {
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
		user.getListOfAddresses().add(homeAddress);
		user.getListOfAddresses().add(officeAddress); 
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = factory.openSession();
		user = session.get(User.class, 1);
		//session.close();
		user.getListOfAddresses(); //lazy initialization (fetch)
		
		System.out.println(user.getListOfAddresses().size()+"");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
