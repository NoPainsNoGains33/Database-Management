package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import edu.northeastern.cs5200.Connection;

public class RoleDao implements RoleImpl{
    private static RoleDao instance = null;
    public static RoleDao getInstance() {
        if (instance == null) {
            instance = new RoleDao();
        }
        return instance;
    }
    
    public RoleDao() {}
    
    java.sql.Connection conn;
    PreparedStatement pStatement;
    Statement statement;
    
    private static String ASSIGN_WEBSITE_ROLE = "INSERT INTO website_role(developer_id, website_id, role) VALUES(?, ?, ?)";
    private static String ASSIGN_PAGE_ROLE = "INSERT INTO page_role(developer_id, page_id, role) VALUES(?, ?, ?)";
    private static String DELETE_WEBSITE_ROLE = "DELETE FROM website_role WHERE developer_id=? AND website_id=? AND role=?";
    private static String DELETE_PAGE_ROLE = "DELETE FROM page_role WHERE developer_id=? AND page_id=? AND role=?";

    @Override
    public void assignWebsiteRole (int developerId, int websiteId, int roleId) {
    	String true_role = null;
		switch (roleId) {
        case 1:
            {true_role = "owner";
            break;}
        case 2:
        	{true_role = "admin";
        	break;
        	}
        case 3:{
        	true_role = "writer";
        	break;}
        case 4:{
        	true_role = "editor";
        	break;}
        case 5:{
        	true_role = "reviewer";
        	break;}
    }
         
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(ASSIGN_WEBSITE_ROLE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, websiteId);
             pStatement.setString(3, true_role);
             pStatement.executeUpdate();
         }catch (SQLException | ClassNotFoundException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}finally {
             if(conn!=null){
                 Connection.closeConnection();
             }
 		
     }	
    }
    
    @Override
    public void assignPageRole (int developerId, int pageId, int roleId) {
    	String true_role = null;
		switch (roleId) {
        case 1:
            {true_role = "owner";
            break;}
        case 2:
        	{true_role = "admin";
        	break;
        	}
        case 3:{
        	true_role = "writer";
        	break;}
        case 4:{
        	true_role = "editor";
        	break;}
        case 5:{
        	true_role = "reviewer";
        	break;}
    }
         
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(ASSIGN_PAGE_ROLE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, pageId);
             pStatement.setString(3, true_role);
             pStatement.executeUpdate();
         }catch (SQLException | ClassNotFoundException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}finally {
             if(conn!=null){
                 Connection.closeConnection();
             }
 		
     }	
    }
    
    @Override
    public void deleteWebsiteRole (int developerId, int websiteId, int roleId) {
    	String true_role = null;
		switch (roleId) {
        case 1:
            {true_role = "owner";
            break;}
        case 2:
        	{true_role = "admin";
        	break;
        	}
        case 3:{
        	true_role = "writer";
        	break;}
        case 4:{
        	true_role = "editor";
        	break;}
        case 5:{
        	true_role = "reviewer";
        	break;}
    }
         
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(DELETE_WEBSITE_ROLE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, websiteId);
             pStatement.setString(3, true_role);
             pStatement.executeUpdate();
         }catch (SQLException | ClassNotFoundException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}finally {
             if(conn!=null){
                 Connection.closeConnection();
             }
 		
     }	
    }
    
    @Override
    public void deletePageRole (int developerId, int pageId, int roleId) {
    	String true_role = null;
		switch (roleId) {
        case 1:
            {true_role = "owner";
            break;}
        case 2:
        	{true_role = "admin";
        	break;
        	}
        case 3:{
        	true_role = "writer";
        	break;}
        case 4:{
        	true_role = "editor";
        	break;}
        case 5:{
        	true_role = "reviewer";
        	break;}
    }
         
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(DELETE_PAGE_ROLE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, pageId);
             pStatement.setString(3, true_role);
             pStatement.executeUpdate();
         }catch (SQLException | ClassNotFoundException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}finally {
             if(conn!=null){
                 Connection.closeConnection();
             }
 		
     }	
    }
    
    
}
