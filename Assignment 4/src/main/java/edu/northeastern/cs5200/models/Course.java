package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "course")
//@Transactional
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String label;
	
	@ManyToOne()
	@JsonIgnore
	private Faculty faculty;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Section> sections;
	
	
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getLabel() {
		return label;
	}




	public void setLabel(String label) {
		this.label = label;
	}




	public Faculty getFaculty() {
		return faculty;
	}




	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}




	public List<Section> getSections() {
		return sections;
	}




	public void setSections(List<Section> sections) {
		this.sections = sections;
	}




	public Course () {}
}
