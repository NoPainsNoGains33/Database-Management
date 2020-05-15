package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import edu.northeastern.cs5200.Connection;

public class PriviledgeDao implements PriviledgeImpl{
    private static PriviledgeDao instance = null;
    public static PriviledgeDao getInstance() {
        if (instance == null) {
            instance = new PriviledgeDao();
        }
        return instance;
    }
    
    public PriviledgeDao() {}
    
    java.sql.Connection conn;
    PreparedStatement pStatement;
    Statement statement;
    
    private static String ASSIGN_WEBSITE_PRIVILEDGE = "INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES(?, ?, ?)";
    private static String ASSIGN_PAGE_PRIVILEDGE = "INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES(?, ?, ?)";
    private static String DELETE_WEBSITE_PRIVILEDGE = "DELETE FROM website_priviledge WHERE developer_id=? AND website_id=? AND priviledge=?";
    private static String DELETE_PAGE_PRIVILEDGE = "DELETE FROM page_priviledge WHERE developer_id=? AND website_id=? AND priviledge=?";

    @Override
    public void assignWebsitePriviledge (int developerId, int websiteId, String priviledge) {        
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(ASSIGN_WEBSITE_PRIVILEDGE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, websiteId);
             pStatement.setString(3, priviledge);
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
    public void assignPagePriviledge (int developerId, int pageId, String priviledge) {
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(ASSIGN_PAGE_PRIVILEDGE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, pageId);
             pStatement.setString(3, priviledge);
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
    public void deleteWebsitePriviledge (int developerId, int websiteId, String priviledge) {
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(DELETE_WEBSITE_PRIVILEDGE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, websiteId);
             pStatement.setString(3, priviledge);
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
    public void deletePagePriviledge (int developerId, int pageId, String priviledge) {
         try {
    		 conn = Connection.getConnection();
             pStatement = conn.prepareStatement(DELETE_PAGE_PRIVILEDGE);
             pStatement.setInt(1, developerId);
             pStatement.setInt(2, pageId);
             pStatement.setString(3, priviledge);
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
