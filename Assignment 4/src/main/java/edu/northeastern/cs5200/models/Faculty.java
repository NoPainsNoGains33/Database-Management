package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

@Entity
//@Transactional
public class Faculty extends Person{
	private String office;
	private Boolean tenured;
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "faculty")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Course> courses;
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenured() {
		return tenured;
	}
	public void setTenured(Boolean tenured) {
		this.tenured = tenured;
	}
	
}
