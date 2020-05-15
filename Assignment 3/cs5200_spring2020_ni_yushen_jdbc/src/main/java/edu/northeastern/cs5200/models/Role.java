package edu.northeastern.cs5200.models;

public class Role {
	public enum type{
		owner, admin, writer, editor, reviewer;
	}
	private type dtype;
	private Developer developer;
	private Website website;
	private Page page;
	private int id;
	private int developer_id;
	private int page_id;
	private int website_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeveloper_id() {
		return developer_id;
	}
	public void setDeveloper_id(int developer_id) {
		this.developer_id = developer_id;
	}
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public int getWebsite_id() {
		return website_id;
	}
	public void setWebsite_id(int website_id) {
		this.website_id = website_id;
	}
	public type getDtype() {
		return dtype;
	}
	public void setDtype(type dtype) {
		this.dtype = dtype;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public Website getWebsite() {
		return website;
	}
	public void setWebsite(Website website) {
		this.website = website;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public Role(type dtype, Developer developer, Website website) {
		super();
		this.dtype = dtype;
		this.developer = developer;
		this.website = website;
	}
	public Role(type dtype, Developer developer, Page page) {
		super();
		this.dtype = dtype;
		this.developer = developer;
		this.page = page;
	}
	
	public Role(type dtype, int developer_id, int website_id) {
		super();
		this.dtype = dtype;
		this.developer_id = developer_id;
		this.website_id = website_id;
	}
	public Role(int developer_id, int page_id, type dtype) {
		super();
		this.dtype = dtype;
		this.developer_id = developer_id;
		this.page_id = page_id;
	}
	public Role () {}
	
}
