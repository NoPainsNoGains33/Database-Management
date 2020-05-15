//package edu.northeastern.cs5200.daos;
//
//import java.util.List;
//
//import edu.northeastern.cs5200.models.Course;
//import edu.northeastern.cs5200.models.Faculty;
//import edu.northeastern.cs5200.models.Person;
//import edu.northeastern.cs5200.models.Section;
//import edu.northeastern.cs5200.models.Student;
//
//public interface UniversityImpl {
//	void truncateDatabase ();
//	Faculty createFaculty (Faculty faculty);
//	Student createStudent(Student student);
//	Course createCourse(Course course);
//	Section createSection(Section section);
//	Course addSectionToCourse(Section section, Course course);
//	Course setAuthorForCourse(Faculty faculty, Course course);
//	Boolean enrollStudentInSection(Student student, Section section);
//	List<Person> findAllPersons();
//	List<Faculty> findAllFaculty();
//	List<Student> findAllStudents();
//	List<Course> findAllCourses();
//	List<Section> findAllSections();
//	List<Course> findCoursesForAuthor(Faculty faculty);
//	List<Section> findSectionForCourse(Course course);
//	List<Student> findStudentsInSection(Section section);
//	List<Section> findSectionsForStudent(Student student);
//}
