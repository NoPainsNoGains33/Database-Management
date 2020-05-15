package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Widget;

public class WidgetDao implements WidgetImpl{
    private static WidgetDao instance = null;
    public static WidgetDao getInstance() {
        if (instance == null) {
            instance = new WidgetDao();
        }
        return instance;
    }
    
    public WidgetDao() {}
    
    java.sql.Connection conn;
    PreparedStatement pStatement;
    Statement statement;
    ResultSet resultsets;

    private static String CREATE_WIDGET_FOR_PAGE = "INSERT INTO widget(id, name, DTYPE, text, `order`, width, height, url, page_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static String FIND_ALL_WIDGETS = "SELECT * FROM widget";
    private static String FIND_WIDGETS_FOR_PAGE = "SELECT * FROM widget WHERE page_id = ?";
    private static String FIND_WIDGET_BY_ID = "SELECT * FROM widget WHERE id = ?";
    private static String UPDATE_WIDGET = "UPDATE widget SET id=?, name=?, DTYPE=?, text=?, `order`=?, width=?, height=?, url=?, page_id=? WHERE id = ?";
    private static String DELETE_WIDGET = "DELETE FROM widget where id=?";


    @Override
    public void createWidgetForPage(int pageId, Widget widget) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(CREATE_WIDGET_FOR_PAGE);
            pStatement.setInt(1, widget.getId());
            pStatement.setString(2, widget.getName());
            pStatement.setString(3, widget.getDtype().toString());
            pStatement.setString(4, widget.getText());
            pStatement.setInt(5, widget.getOrder());
            pStatement.setInt(6, widget.getWidth());
            pStatement.setInt(7, widget.getHeight());
            pStatement.setString(8, widget.getUrl());
            pStatement.setInt(9, pageId);
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
    public Collection<Widget> findAllWidgets() {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_ALL_WIDGETS);
            resultsets = pStatement.executeQuery();
            Collection<Widget> widgets = new ArrayList<Widget>();
            while(resultsets.next()){
                int id = resultsets.getInt("id");
                String name = resultsets.getString("name");
                Widget.type dtype = Widget.type.valueOf(resultsets.getString("dtype"));
                String text = resultsets.getString("text");
                int order = resultsets.getInt("order");
                int width = resultsets.getInt("width");
                int height = resultsets.getInt("height");
                String url = resultsets.getString("url");
                int page_id = resultsets.getInt("page_id");
                Widget widget = new Widget (id, name, width, height, text, order, url, page_id, dtype);
                widgets.add(widget);
            }
            return widgets;
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
    public Collection<Widget> findWidgetsForPage(int pageId) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_WIDGETS_FOR_PAGE);
            pStatement.setInt(1, pageId);
            resultsets = pStatement.executeQuery();
            Collection<Widget> widgets = new ArrayList<Widget>();
            while(resultsets.next()){
                int id = resultsets.getInt("id");
                String name = resultsets.getString("name");
                Widget.type dtype = Widget.type.valueOf(resultsets.getString("dtype"));
                String text = resultsets.getString("text");
                int order = resultsets.getInt("order");
                int width = resultsets.getInt("width");
                int height = resultsets.getInt("height");
                String url = resultsets.getString("url");
                int page_id = resultsets.getInt("page_id");
                Widget widget = new Widget (id, name, width, height, text, order, url, page_id, dtype);
                widgets.add(widget);
            }
            return widgets;
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
    public Widget findWidgetById (int widgetId) {
        try {
            conn = Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_WIDGET_BY_ID);
            pStatement.setInt(1, widgetId);
            resultsets = pStatement.executeQuery();
            if(resultsets.next()){
                int id = resultsets.getInt("id");
                String name = resultsets.getString("name");
                Widget.type dtype = Widget.type.valueOf(resultsets.getString("dtype"));
                String text = resultsets.getString("text");
                int order = resultsets.getInt("order");
                int width = resultsets.getInt("width");
                int height = resultsets.getInt("height");
                String url = resultsets.getString("url");
                int page_id = resultsets.getInt("page_id");
                Widget widget = new Widget (id, name, width, height, text, order, url, page_id, dtype);
                return widget;
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
    public int updateWidget (int widgetId, Widget widget) {
    	try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(UPDATE_WIDGET);
            pStatement.setInt(1, widget.getId());
            pStatement.setString(2, widget.getName());
            pStatement.setString(3, widget.getDtype().toString());
            pStatement.setString(4, widget.getText());
            pStatement.setInt(5, widget.getOrder());
            pStatement.setInt(6, widget.getWidth());
            pStatement.setInt(7, widget.getHeight());
            pStatement.setString(8, widget.getUrl());
            pStatement.setInt(9, widget.getPage_id());
			pStatement.setInt(10, widgetId);
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
    public int deleteWidget(int widgetId) {
		try {
            conn = Connection.getConnection();
			pStatement = conn.prepareStatement(DELETE_WIDGET);
			pStatement.setInt(1, widgetId);
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
