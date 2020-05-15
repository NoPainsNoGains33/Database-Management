package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "section")
//@Transactional
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer seats;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "section")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Enrollment> enrollments;
	
	@ManyToOne (cascade = CascadeType.MERGE)
	@JsonIgnore
	private Course course;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
}
