package edu.northeastern.cs5200.models;

import java.sql.Date;

public class User extends Person{
	private Boolean userAgreement;

	public Boolean getUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(Boolean userAgreement) {
		this.userAgreement = userAgreement;
	}

	public User(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
	
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			Boolean userAgreement) {
		super(id, firstName, lastName, username, password, email, dob);
		this.userAgreement = userAgreement;
	}

	public User () {}
	
	
}
