package edu.northeastern.cs5200;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.UniversityDao;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPart2 {
	@Autowired
	UniversityDao universityDao;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void A_testValidateUsers () {
		System.out.println("The total number of users: " + universityDao.findAllPersons().size());
	}
	
	@Test
	public void B_testValidateFaculty () {
		System.out.println("The total number of faculty: " + universityDao.findAllFaculty().size());
	}
	
	@Test
	public void C_testValidateStudents () {
		System.out.println("The total number of students: " + universityDao.findAllStudents().size());
	}
	
	@Test
	public void D_testValidateCourses () {
		System.out.println("The total number of courses: " + universityDao.findAllCourses().size());
	}
	
	@Test
	public void E_testValidateSections () {
		System.out.println("The total number of sections: " + universityDao.findAllSections().size());
	}
	
    @Test
    public void F_testValidateCourseAuthorship(){
        List<Faculty> faculties = universityDao.findAllFaculty();
        for(Faculty faculty : faculties) {
        	System.out.println("There are " + faculty.getCourses().size() + " courses authorized by " + faculty.getFirstName());
//        	if (faculty.getCourses().isEmpty())
//        		System.out.println("Zero course is authorized by " + faculty.getFirstName());
//        	else 
//        		System.out.println("There are " + faculty.getCourses().size() + " courses authorized by " + faculty.getFirstName());
//        }
    }}
    
    @Test
    public void G_testValidateSectionPerCourse(){
        List<Course> courses = universityDao.findAllCourses();
        for(Course course : courses) {
        	System.out.println("There are " + course.getSections().size() + " sections for " + course.getLabel());
//        	if (course.getSections().isEmpty())
//        		System.out.println("Zero section for " + course.getLabel());
//        	else 
//        		System.out.println("There are " + course.getSections().size() + " sections for " + course.getLabel());
//        }
    }}
    
    @Test
    public void H_testValidateSectionEnrollments(){
        List<Section> sections = universityDao.findAllSections();
        for(Section section : sections) {
        	System.out.println("There are " + section.getEnrollments().size() + " students in " + section.getTitle());
//        	if (section.getEnrollments().isEmpty())
//        		System.out.println("There is no students enrolled in " + section.getTitle());
//        	else 
//        		System.out.println("There are " + section.getEnrollments().size() + " students in " + section.getTitle());
        }
    }
    
    @Test
    public void I_testValidateStudentEnrollments(){
        List<Student> students = universityDao.findAllStudents();
        for(Student student : students) {
        	System.out.println("There are " + student.getEnrollments().size() + " sections enrolled by " + student.getFirstName());
//        	if (student.getEnrollments().isEmpty())
//        		System.out.println(student.getFirstName() + " has not enrolled in any sections.");
//        	else 
//        		System.out.println("There are " + student.getEnrollments().size() + " sections enrolled by " + student.getFirstName());
        }
    }
    
    @Test
    public void J_testValidateSectionSeats(){
        List<Section> sections = universityDao.findAllSections();
        for(Section section : sections) {
           System.out.println(section.getTitle() + " has " + section.getSeats() + " seats left");
        }
    }
}
