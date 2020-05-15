package edu.northeastern.cs5200.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

@Entity
//@Transactional
public class Student extends Person{
	private Integer gradYear;
	private Long scholarship;
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "student")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Enrollment> enrollments;
	

	public Integer getGradYear() {
		return gradYear;
	}
	public void setGradYear(Integer gradYear) {
		this.gradYear = gradYear;
	}
	public Long getScholarship() {
		return scholarship;
	}
	public void setScholarship(Long scholarship) {
		this.scholarship = scholarship;
	}
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	

	
}
