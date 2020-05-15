package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;

public class PageDao implements PageImpl{
    private static PageDao instance = null;
    public static PageDao getInstance() {
        if (instance == null) {
            instance = new PageDao();
        }
        return instance;
    }
    
    public PageDao() {}
    
    java.sql.Connection conn;
    PreparedStatement pStatement;
    Statement statement;
    ResultSet resultsets;

    private static String CREATE_PAGE_FOR_WEBSITE = "INSERT INTO page(id, title, description, created, updated, views, website_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static String FIND_ALL_PAGES = "SELECT * FROM page";
    private static String FIND_PAGES_FOR_WEBSITE = "SELECT * FROM page WHERE website_id = ?";
    private static String FIND_PAGE_BY_ID = "SELECT * FROM page WHERE id = ?";
    private static String UPDATE_PAGE = "UPDATE page SET id=?, title=?, description=?, created=?, updated=?, views=?, website_id=? WHERE id = ?";
    private static String DELETE_PAGE = "DELETE FROM page where id=?";


    @Override
    public void createPageForWebsite(int websiteId, Page page) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(CREATE_PAGE_FOR_WEBSITE);
            pStatement.setInt(1, page.getId());
            pStatement.setString(2, page.getTitle());
            pStatement.setString(3, page.getDescription());
            pStatement.setDate(4, page.getCreated());
            pStatement.setDate(5, page.getUpdated());
            pStatement.setInt(6, page.getViews());
            pStatement.setInt(7, websiteId);
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
    public Collection<Page> findAllPages() {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_ALL_PAGES);
            resultsets = pStatement.executeQuery();
            Collection<Page> pages = new ArrayList<Page>();
            while(resultsets.next()){
                int id = resultsets.getInt("id");
                String title = resultsets.getString("title");
                String description = resultsets.getString("description");
                Date created = resultsets.getDate("created");
                Date updated = resultsets.getDate("updated");
                int views = resultsets.getInt("views");
                int website_id = resultsets.getInt("website_id");
                Page page = new Page (id, title, description, created, updated, views, website_id);
                pages.add(page);
            }
            return pages;
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
    public Collection<Page> findPagesForWebsite(int websiteId) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_PAGES_FOR_WEBSITE);
            pStatement.setInt(1, websiteId);
            resultsets = pStatement.executeQuery();
            Collection<Page> pages = new ArrayList<Page>();
            while(resultsets.next()){
                int id = resultsets.getInt("id");
                String title = resultsets.getString("title");
                String description = resultsets.getString("description");
                Date created = resultsets.getDate("created");
                Date updated = resultsets.getDate("updated");
                int views = resultsets.getInt("views");
                int website_id = resultsets.getInt("website_id");
                Page page = new Page (id, title, description, created, updated, views, website_id);
                pages.add(page);
            }
            return pages;
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
    public Page findPageById (int pageId) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_PAGE_BY_ID);
            pStatement.setInt(1, pageId);
            resultsets = pStatement.executeQuery();
            if(resultsets.next()){
                int id = resultsets.getInt("id");
                String title = resultsets.getString("title");
                String description = resultsets.getString("description");
                Date created = resultsets.getDate("created");
                Date updated = resultsets.getDate("updated");
                int views = resultsets.getInt("views");
                int website_id = resultsets.getInt("website_id");
                Page page = new Page (id, title, description, created, updated, views, website_id);
                return page;
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
    public int updatePage (int pageId, Page page) {
    	try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(UPDATE_PAGE);
            pStatement.setInt(1, page.getId());
            pStatement.setString(2, page.getTitle());
            pStatement.setString(3, page.getDescription());
            pStatement.setDate(4, page.getCreated());
            pStatement.setDate(5, page.getUpdated());
            pStatement.setInt(6, page.getViews());
            pStatement.setInt(7, page.getWebsite_id());
			pStatement.setInt(8, pageId);
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
    public int deletePage(int pageId) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(DELETE_PAGE);
			pStatement.setInt(1, pageId);
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
