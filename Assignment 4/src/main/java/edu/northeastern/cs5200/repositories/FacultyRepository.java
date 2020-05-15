package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.*;

public interface FacultyRepository extends CrudRepository  <Faculty, Integer>{
	
	@Query ("SELECT person FROM Person person WHERE person.firstName = :firstName")
	public Faculty findFacultyByFirstName (@Param ("firstName") String firstName);
}
