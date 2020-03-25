package com.zakaria.hibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_details")
public class User implements Serializable {

	/*
	 * @Id @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name="user_id") private int userId;
	 */
	
	@EmbeddedId
	private Person person;
	
	@Column(name="user_name")
	private String userName;
		
	@Lob
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date joinedData;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="home_street")),
		@AttributeOverride(name="city", column=@Column(name="home_cityt")),
		@AttributeOverride(name="state", column=@Column(name="home_state")),
		@AttributeOverride(name="pincode", column=@Column(name="home_pincode")),
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public Address getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getJoinedData() {
		return joinedData;
	}
	
	public void setJoinedData(Date joinedData) {
		this.joinedData = joinedData;
	}
	
	/*
	 * public int getUserId() { return userId; }
	 * 
	 * public void setUserId(int userId) { this.userId = userId; }
	 */
	
	
	
	public String getUserName() {
		return userName;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person id) {
		this.person = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
