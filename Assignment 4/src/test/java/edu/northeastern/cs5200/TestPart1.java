package edu.northeastern.cs5200;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.UniversityDao;
//import edu.northeastern.cs5200.daos.UniversityImpl;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPart1 {	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UniversityDao universityDao;
	
	@Test
	public void A_testEmpty () {
		universityDao.truncateDatabase();
	}
	
//	private static boolean initialized = false;
	
//	@Before
//	public void A_testDelete() {
//		if (!initialized) {
//			universityDao.truncateDatabase();
//			initialized = true;
//		}
//	}
	
	@Test
	public void B_testCreateFaculties () {
		Faculty alan = new Faculty();
		alan.setFirstName("Alan");
		alan.setLastName("Turin");
		alan.setOffice("123A");
		alan.setTenured(true);
		alan.setUsername("alan");
		alan.setPassword("password");
		
		Faculty ada = new Faculty();
		ada.setFirstName("Ada");
		ada.setLastName("Lovelace");
		ada.setOffice("123B");
		ada.setTenured(true);
		ada.setUsername("ada");
		ada.setPassword("password");
		
		universityDao.createFaculty(alan);
		universityDao.createFaculty(ada);
	}
	
	@Test
	public void C_testCreateStudents () {
		Student alice = new Student();
		alice.setFirstName("Alice");
		alice.setLastName("Wonderland");
		alice.setGradYear(2020);
		alice.setScholarship((long) 12000);
		alice.setUsername("alice");
		alice.setPassword("password");
		universityDao.createStudent(alice);
		
		Student bob = new Student();
		bob.setFirstName("Bob");
		bob.setLastName("Hope");
		bob.setGradYear(2021);
		bob.setScholarship((long) 23000);
		bob.setUsername("bob");
		bob.setPassword("password");
		universityDao.createStudent(bob);
		
		Student charlie = new Student();
		charlie.setFirstName("Charlie");
		charlie.setLastName("Brown");
		charlie.setGradYear(2019);
		charlie.setScholarship((long) 21000);
		charlie.setUsername("charlie");
		charlie.setPassword("password");
		universityDao.createStudent(charlie);
		
		Student dan = new Student();
		dan.setFirstName("Dan");
		dan.setLastName("Craig");
		dan.setGradYear(2019);
		dan.setScholarship((long) 0);
		dan.setUsername("dan");
		dan.setPassword("password");
		universityDao.createStudent(dan);
		
		Student edward = new Student();
		edward.setFirstName("Edward");
		edward.setLastName("Scissorhands");
		edward.setGradYear(2022);
		edward.setScholarship((long) 11000);
		edward.setUsername("edward");
		edward.setPassword("password");
		universityDao.createStudent(edward);
		
		Student frank = new Student();
		frank.setFirstName("Frank");
		frank.setLastName("Herbert");
		frank.setGradYear(2018);
		frank.setScholarship((long) 0);
		frank.setUsername("frank");
		frank.setPassword("password");
		universityDao.createStudent(frank);
		
		Student gregory = new Student();
		gregory.setFirstName("Gregory");
		gregory.setLastName("Peck");
		gregory.setGradYear(2023);
		gregory.setScholarship((long) 10000);
		gregory.setUsername("gregory");
		gregory.setPassword("password");
		universityDao.createStudent(gregory);
	}
	
	@Test
	public void D_testCreateCourses() {
		Faculty alan = facultyRepository.findFacultyByFirstName("Alan");
		
		Course cs1234 = new Course();
		cs1234.setLabel("CS1234");
		cs1234.setFaculty(alan);
		universityDao.createCourse(cs1234);
		
		Course cs2345 = new Course();
		cs2345.setLabel("CS2345");
		cs2345.setFaculty(alan);
		universityDao.createCourse(cs2345);
		
		Faculty ada = facultyRepository.findFacultyByFirstName("Ada");
		
		Course cs3456 = new Course();
		cs3456.setLabel("CS3456");
		cs3456.setFaculty(ada);
		universityDao.createCourse(cs3456);
		
		Course cs4567 = new Course();
		cs4567.setLabel("CS4567");
		cs4567.setFaculty(ada);
		universityDao.createCourse(cs4567);
	}
	
	@Test
	public void E_testCreateSection() {
		Course cs1234 = courseRepository.findCourseByLabel("CS1234");
		
		Section sec4321 = new Section();
		sec4321.setTitle("SEC4321");
		sec4321.setSeats(50);
		sec4321.setCourse(cs1234);
		universityDao.createSection(sec4321);
		
		
		Section sec5432 = new Section();
		sec5432.setTitle("SEC5432");
		sec5432.setSeats(50);
		sec5432.setCourse(cs1234);
		universityDao.createSection(sec5432);
		
		Course cs2345 = courseRepository.findCourseByLabel("CS2345");
		
		Section sec6543 = new Section();
		sec6543.setTitle("SEC6543");
		sec6543.setSeats(50);
		sec6543.setCourse(cs2345);
		universityDao.createSection(sec6543);
		
		Course cs3456 = courseRepository.findCourseByLabel("CS3456");
		
		Section sec7654 = new Section();
		sec7654.setTitle("SEC7654");
		sec7654.setSeats(50);
		sec7654.setCourse(cs3456);
		universityDao.createSection(sec7654);
	}
	
	@Test
	public void F_testEnrollStudentToSection() {
		Section sec4321 = sectionRepository.findSectionByTitle("SEC4321");
		Section sec5432 = sectionRepository.findSectionByTitle("SEC5432");
		Section sec6543 = sectionRepository.findSectionByTitle("SEC6543");

		
		Student alice = studentRepository.findStudentByFirstName("alice");
		Student bob = studentRepository.findStudentByFirstName("bob");
		Student charlie = studentRepository.findStudentByFirstName("charlie");
		
		universityDao.enrollStudentInSection(alice, sec4321);
		universityDao.enrollStudentInSection(alice, sec5432);
		universityDao.enrollStudentInSection(bob, sec5432);
		universityDao.enrollStudentInSection(charlie, sec6543);
		
	}

}
