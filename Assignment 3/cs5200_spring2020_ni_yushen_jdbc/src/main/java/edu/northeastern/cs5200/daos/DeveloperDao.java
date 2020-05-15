package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;

public class DeveloperDao implements DeveloperImpl{
    private static DeveloperDao instance = null;
    public static DeveloperDao getInstance() {
        if (instance == null) {
            instance = new DeveloperDao();
        }
        return instance;
    }
    
    public DeveloperDao () {}
    
	java.sql.Connection conn;
	Statement statement;
	PreparedStatement pStatement;
	ResultSet results;
	Collection<Developer> developers = new ArrayList<Developer>();
	private static String CREATE_PERSON = "INSERT INTO person (id, first_name, last_name, username, password, email, dob) VALUES (?,?, ?, ?, ?, ?, ?)";
	private static String CREATE_DEVELOPER = "INSERT INTO developer (id, developer_key) VALUES (?, ?)";
	private static String FIND_ALL_DEVELOPERS = "SELECT * FROM developer, person WHERE developer.id = person.id";
	private static String FIND_DEVELOPER_BY_ID = "SELECT * FROM developer, person WHERE developer.id = person.id AND developer.id = ?";
	private static String FIND_DEVELOPER_BY_USERNAME = "SELECT * FROM developer, person WHERE developer.id = person.id AND person.username = ?";
	private static String FIND_DEVELOPER_BY_CREDENTIALS = "SELECT * FROM developer, person WHERE developer.id = person.id AND person.username = ? AND person.password = ?";
    private static String UPDATE_PERSON = "UPDATE person SET id=?, first_name=?, last_name=?, username=?, password=?, email=?, dob=? WHERE id=?";
    private static String UPDATE_DEVELOPER = "UPDATE developer SET id=?, developer_key=? WHERE id=?";
    private static String DELETE_DEVELOPER = "DELETE FROM person WHERE id=?";
    private static String UPDATE_PHONE = "INSERT INTO phone(phone, `primary`, person_id) VALUES (?,?,?)";
    private static String DELETE_PRIMARY_ADDRESS = "DELETE FROM address WHERE person_id = ? AND `primary` = TRUE";



	@Override
    public void createDeveloper (Developer developer) {
		try {
            conn = Connection.getConnection();
			// Insert into person
			pStatement = conn.prepareStatement(CREATE_PERSON);
			pStatement.setInt(1, developer.getId());
			pStatement.setString(2, developer.getFirstName());
			pStatement.setString(3, developer.getLastName());
			pStatement.setString(4, developer.getUsername());
			pStatement.setString(5, developer.getPassword());
			pStatement.setString(6, developer.getEmail());
			pStatement.setDate(7, developer.getDob());
            pStatement.executeUpdate();
			// Insert into developer
			pStatement = conn.prepareStatement(CREATE_DEVELOPER);
			pStatement.setInt(1, developer.getId());
			pStatement.setString(2, developer.getDeveloperKey());
            pStatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
}
	@Override
    public Collection<Developer> findAllDevelopers(){
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(FIND_ALL_DEVELOPERS);
            results = pStatement.executeQuery();
            while (results.next()) {
				int id = results.getInt("id");
				String first_name = results.getString("first_name");
				String last_name = results.getString("last_name");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developer_key = results.getString("developer_key");
				Developer developer = new Developer (
						id, first_name, last_name, username, password, email, dob, developer_key
						);
				developers.add(developer);
            }
            return developers;

		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return null;
    }
	
	@Override
    public Developer findDeveloperById(int developerId) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_ID);
			pStatement.setInt(1, developerId);
            results = pStatement.executeQuery();
            if (results.next()) {
				int id = results.getInt("id");
				String first_name = results.getString("first_name");
				String last_name = results.getString("last_name");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developer_key = results.getString("developer_key");
				Developer developer = new Developer (
						id, first_name, last_name, username, password, email, dob, developer_key
						);
	            return developer;
            }
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return null;
	}
	
	@Override
    public Developer findDeveloperByUsername(String username) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
			pStatement.setString(1, username);
            results = pStatement.executeQuery();
            if (results.next()) {
				int id = results.getInt("id");
				String first_name = results.getString("first_name");
				String last_name = results.getString("last_name");
				String Username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developer_key = results.getString("developer_key");
				Developer developer = new Developer (
						id, first_name, last_name, Username, password, email, dob, developer_key
						);
	            return developer;
            }
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return null;
	}
	
	@Override
    public Developer findDeveloperByCredentials(String username, String password) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_CREDENTIALS);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
            results = pStatement.executeQuery();
            if (results.next()) {
				int id = results.getInt("id");
				String first_name = results.getString("first_name");
				String last_name = results.getString("last_name");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developer_key = results.getString("developer_key");
				Developer developer = new Developer (
						id, first_name, last_name, Username, Password, email, dob, developer_key
						);
	            return developer;
            }
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return null;
	}
	
	@Override
    public int updateDeveloper(int developerId, Developer developer) {
		try {
            conn = Connection.getConnection();
			// Insert into person
			pStatement = conn.prepareStatement(UPDATE_PERSON);
			pStatement.setInt(1, developer.getId());
			pStatement.setString(2, developer.getFirstName());
			pStatement.setString(3, developer.getLastName());
			pStatement.setString(4, developer.getUsername());
			pStatement.setString(5, developer.getPassword());
			pStatement.setString(6, developer.getEmail());
			pStatement.setDate(7, developer.getDob());
			pStatement.setInt(8, developerId);
            pStatement.executeUpdate();
			// Insert into developer
			pStatement = conn.prepareStatement(UPDATE_DEVELOPER);
			pStatement.setInt(1, developer.getId());
			pStatement.setString(2, developer.getDeveloperKey());
			pStatement.setInt(3, developerId);
            return pStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return -1;
	}
	
	@Override
    public int updatePhone(int developerId, String phone, Boolean primary) {
		try {
            conn = Connection.getConnection();
			// Insert into person
			pStatement = conn.prepareStatement(UPDATE_PHONE);
			pStatement.setInt(3, developerId);
			pStatement.setBoolean(2, primary);
			pStatement.setString(1, phone);
            pStatement.executeUpdate();
            return pStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return -1;
	}
	
	@Override
    public int deleteDeveloper(int developerId) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(DELETE_DEVELOPER);
			pStatement.setInt(1, developerId);
            return pStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
    	return -1;
	}
	
	@Override
	public void deletePrimaryAddress (int developerId) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(DELETE_PRIMARY_ADDRESS);
			pStatement.setInt(1, developerId);
			pStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
            if(conn!=null){
                Connection.closeConnection();
            }
		
    }
	}
	

    
}
