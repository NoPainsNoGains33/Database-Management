package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Website {
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private int develeloper_id;
	private List<Page> pages = new ArrayList <Page>();
	private Developer developer;
	
	public int getDeveleloper_id() {
		return develeloper_id;
	}
	public void setDeveleloper_id(int develeloper_id) {
		this.develeloper_id = develeloper_id;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public void addPages (Page e) {
		this.pages.add(e);
	}
	public void removePages (Page e) {
		this.pages.remove(e);
	}
	public Website(int id, String name, String description, Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
	
	public Website(int id, String name, String description, Date created, Date updated, int visits,
			int develeloper_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.develeloper_id = develeloper_id;
	}
	public Website () {}
	
	

}
