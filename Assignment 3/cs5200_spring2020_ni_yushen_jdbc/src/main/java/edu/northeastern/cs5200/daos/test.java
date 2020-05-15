package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Person;


@RestController
public class test {
	java.sql.Connection conn;
	Statement statement;
	PreparedStatement pStatement;
	private static String FIND_ALL_COURSES = "SELECT * FROM courses";
	private static String FIND_COURSE_BY_ID = "SELECT * FROM test WHERE id=?";
	
	@GetMapping ("findperson_id_1")
	public Person test123() { 
		try {
			conn = Connection.getConnection();
			pStatement = conn.prepareStatement(FIND_COURSE_BY_ID);
			pStatement.setInt(1, 1);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				Person person = new Person(
						resultSet.getInt("id"),
						resultSet.getString("fistname"),
						resultSet.getString("lastname"));
				return person; 
			} 
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
