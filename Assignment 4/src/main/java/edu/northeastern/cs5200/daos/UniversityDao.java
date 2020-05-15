package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

//@RestController
@Repository
public class UniversityDao {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public void truncateDatabase () {
		enrollmentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		personRepository.deleteAll();
	}
	
	public Faculty createFaculty (Faculty faculty) {
		personRepository.save(faculty);
		return faculty;
	}
	
	public Student createStudent(Student student) {
		personRepository.save(student);
		return student;
	}
	
	public Course createCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
	
	public Section createSection(Section section) {
		sectionRepository.save(section);
		return section;
	}
	
	public Course addSectionToCourse(Section section, Course course) {
		course.getSections().add(section);
		courseRepository.save(course);
		return course;
	}
	
	public Course setAuthorForCourse(Faculty faculty, Course course) {
		course.setFaculty(faculty);
		courseRepository.save(course);
		return course;
	}
	
	public Boolean enrollStudentInSection(Student student, Section section) {
		if(section.getSeats() == 0)
			return false;
		else {
			Enrollment enrollment = new Enrollment();
			enrollment.setStudent(student);
			enrollment.setSection(section);
			enrollmentRepository.save(enrollment);
			
			section.setSeats(section.getSeats()-1);
			sectionRepository.save(section);
			return true;
		}
	}
	
	public List<Person> findAllPersons(){
		return (List<Person>)personRepository.findAll();
	}
	
//	@GetMapping("/addFaculty & Find")
//	public List<Person> addFaculty () {
//		Faculty faculty = new Faculty ();
//		faculty.setOffice("Dana");
//		personRepository.save(faculty);
//		
//		return (List<Person>)personRepository.findAll();
//	}
	
	public List<Faculty> findAllFaculty(){
		return (List<Faculty>) facultyRepository.findAll();
	}
	
	public List<Student> findAllStudents(){
		return (List<Student>)studentRepository.findAll();
	}
	
	public List<Course> findAllCourses(){
		return (List<Course>)courseRepository.findAll();
	}
	
	public List<Section> findAllSections(){
		return (List<Section>)sectionRepository.findAll();
	}
	
	
	public List<Course> findCoursesForAuthor(Faculty faculty){
		return faculty.getCourses();
	}
	
	public List<Section> findSectionForCourse(Course course){
		return course.getSections();
	}
	
	public List<Student> findStudentsInSection(Section section){	
		List<Student> students = new ArrayList<Student>();
		for(Enrollment e: section.getEnrollments()) {
			students.add(e.getStudent());
		}
		return students;
	}
	
	public List<Section> findSectionsForStudent(Student student){
		List <Section> sections = new ArrayList<Section>();
		for(Enrollment e: student.getEnrollments()) {
			sections.add(e.getSection());
		}
		return sections;	
	}
}
