package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Website;

public class WebsiteDao implements WebsiteImpl{
    private static WebsiteDao instance = null;
    public static WebsiteDao getInstance() {
        if (instance == null) {
            instance = new WebsiteDao();
        }
        return instance;
    }
    
    public WebsiteDao() {}
    
    java.sql.Connection conn;
    PreparedStatement pStatement;
    Statement statement;
    ResultSet resultsets;
    Collection<Website> websites = new ArrayList<Website>();

    private static String CREATE_WEBSITE_FOR_DEVELOPER = "INSERT INTO website(id, name, description, created, updated, visits, developer_id) VALUE(?, ?, ?, ?, ?, ?, ?)";
    private static String FIND_ALL_WEBSITE = "SELECT * FROM website";
    private static String FIND_WEBSITES_FOR_DEVELOPER = "SELECT * FROM website WHERE developer_id = ?";
    private static String FIND_WEBSITES_BY_ID = "SELECT * FROM website WHERE id = ?";
    private static String UPDATE_WEBSITE = "UPDATE website SET id=?, name=?, description=?, created=?, updated=?, visits=?, developer_id=? WHERE id = ?";
    private static String DELETE_WEBSITE = "DELETE FROM website where id=?";


    @Override
    public void createWebsiteForDeveloper(int developerId, Website website) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(CREATE_WEBSITE_FOR_DEVELOPER);
            pStatement.setInt(1, website.getId());
            pStatement.setString(2, website.getName());
            pStatement.setString(3, website.getDescription());
            pStatement.setDate(4, website.getCreated());
            pStatement.setDate(5, website.getUpdated());
            pStatement.setInt(6, website.getVisits());
            pStatement.setInt(7, developerId);
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
    public Collection<Website> findAllWebsite() {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_ALL_WEBSITE);
            resultsets = pStatement.executeQuery();
            Collection<Website> websites = new ArrayList<Website>();
            while(resultsets.next()){
                int id = resultsets.getInt("id");
                String name = resultsets.getString("name");
                String description = resultsets.getString("description");
                Date created = resultsets.getDate("created");
                Date updated = resultsets.getDate("updated");
                int visits = resultsets.getInt("visits");
                int developer_id = resultsets.getInt("developer_id");
                Website website = new Website (id, name, description, created, updated, visits, developer_id);
                websites.add(website);
            }
            return websites;
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
    public Collection<Website> findWebsitesForDeveloper(int developerId) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_WEBSITES_FOR_DEVELOPER);
            pStatement.setInt(1, developerId);
            resultsets = pStatement.executeQuery();
            Collection<Website> websites = new ArrayList<Website>();
            while(resultsets.next()){
                int id = resultsets.getInt("id");
                String name = resultsets.getString("name");
                String description = resultsets.getString("description");
                Date created = resultsets.getDate("created");
                Date updated = resultsets.getDate("updated");
                int visits = resultsets.getInt("visits");
                int developer_id = resultsets.getInt("developer_id");
                Website website = new Website (id, name, description, created, updated, visits, developer_id);
                websites.add(website);
            }
            return websites;
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
    public Website findWebsiteById (int websiteId) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_WEBSITES_BY_ID);
            pStatement.setInt(1, websiteId);
            resultsets = pStatement.executeQuery();
            if(resultsets.next()){
                int id = resultsets.getInt("id");
                String name = resultsets.getString("name");
                String description = resultsets.getString("description");
                Date created = resultsets.getDate("created");
                Date updated = resultsets.getDate("updated");
                int visits = resultsets.getInt("visits");
                int developer_id = resultsets.getInt("developer_id");
                Website website = new Website (id, name, description, created, updated, visits, developer_id);
                return website;
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
    public int updateWebsite (int websiteId, Website website) {
    	try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(UPDATE_WEBSITE);
			pStatement.setInt(1, website.getId());
			pStatement.setString(2, website.getName());
			pStatement.setString(3, website.getDescription());
			pStatement.setDate(4, website.getCreated());
			pStatement.setDate(5, website.getUpdated());
			pStatement.setInt(6, website.getVisits());
			pStatement.setInt(7, website.getDeveleloper_id());
			pStatement.setInt(8, websiteId);
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
    public int deleteWebsite(int websiteId) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(DELETE_WEBSITE);
			pStatement.setInt(1, websiteId);
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
	

	}

    
    
