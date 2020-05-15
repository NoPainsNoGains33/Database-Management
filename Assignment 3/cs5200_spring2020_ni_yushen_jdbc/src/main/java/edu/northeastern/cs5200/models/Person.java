package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private Date dob;
	private List<Phone> phones = new ArrayList <Phone>();
	private List<Address> addresses = new ArrayList <Address>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public void addPhone (Phone e) {
		this.phones.add(e);
	}
	public void removePhone (Phone e) {
		this.phones.remove(e);
	}
	public void addAddress (Address e) {
		this.addresses.add(e);
	}
	public void removeAddress (Address e) {
		this.addresses.remove(e);
	}
	
	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			List<Phone> phones, List<Address> addresses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phones = phones;
		this.addresses = addresses;
	}
	public Person(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	public Person () {}

}
