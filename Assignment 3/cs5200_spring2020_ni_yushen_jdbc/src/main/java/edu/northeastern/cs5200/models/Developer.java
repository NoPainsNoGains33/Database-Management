package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Developer extends Person{
	private String developerKey;
	private List<Website> websites= new ArrayList<Website>();
	

	public List<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	
	public void addWebsite (Website e) {
		this.websites.add(e);
	}
	public void removeWebsite (Website e) {
		this.websites.remove(e);
	}

	public Developer(int id, String firstName, String lastName, String developerKey) {
		super(id, firstName, lastName);
		this.developerKey = developerKey;
	}

	public Developer(int id, String firstName, String lastName, String username, String password, String email,
			Date dob, String developerKey) {
		super(id, firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
	}

	public Developer(int id, String firstName, String lastName, String username, String password, String email,
			Date dob, List<Phone> phones, List<Address> addresses, String developerKey) {
		super(id, firstName, lastName, username, password, email, dob, phones, addresses);
		this.developerKey = developerKey;
	}
	
	public Developer () {}

}
