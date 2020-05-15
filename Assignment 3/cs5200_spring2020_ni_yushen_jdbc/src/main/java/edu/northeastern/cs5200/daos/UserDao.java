package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.User;

public class UserDao implements UserImpl {
    private static UserDao instance = null;
    public static UserDao getInstance() {
        if(instance == null) {
            instance = new UserDao();
        }
        return instance;
    }
    
    public UserDao() {}
    
	java.sql.Connection conn;
	Statement statement;
	PreparedStatement pStatement;
	private static String CREATE_PERSON = "INSERT INTO person (id, first_name, last_name, username, password, email, dob) VALUES (?,?, ?, ?, ?, ?, ?)";
	private static String CREATE_USER = "INSERT INTO user (id, user_agreement) VALUES (?, NULL)";
	
	@Override
    public void createUser(User user) {
    	try {
        conn = Connection.getConnection();
		// Insert into person
		pStatement = conn.prepareStatement(CREATE_PERSON);
		pStatement.setInt(1, user.getId());
		pStatement.setString(2, user.getFirstName());
		pStatement.setString(3, user.getLastName());
		pStatement.setString(4, user.getUsername());
		pStatement.setString(5, user.getPassword());
		pStatement.setString(6, user.getEmail());
		pStatement.setDate(7, user.getDob());
        pStatement.executeUpdate();
		// Insert into user
		pStatement = conn.prepareStatement(CREATE_USER);
		pStatement.setInt(1, user.getId());
//		pStatement.setBoolean(2, user.getUserAgreement());
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
    
