package edu.northeastern.cs5200;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

//@RestController
public class hw_jdbc_ni_yushen {
	public static void main(String[] args) {
		

		// Create 1. 
		// Insert Developer
		DeveloperDao developerdao = DeveloperDao.getInstance();
		Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null, "4321rewq");
        Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com", null, "5432trew");
        Developer charlie = new Developer(34, "Charlie", "Garcia", "charlie", "charlie", "chuch@garcia.com", null, "6543ytre");
        
        developerdao.createDeveloper(alice);
        developerdao.createDeveloper(bob);
        developerdao.createDeveloper(charlie);
        
        // Insert User
        UserDao userdao = UserDao.getInstance();
        User dan = new User(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", null, null);
        User ed = new User(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", null, null);

        userdao.createUser(dan);
        userdao.createUser(ed);
        
        // Create 2.
        Calendar calendar = Calendar.getInstance();
        Date today = new Date(calendar.getTime().getTime());
        WebsiteDao websitedao = WebsiteDao.getInstance();
        
        Website facebook = new Website(123, "Facebook", "an online social media and social networking service", today, today, 1234234);
        Website twitter = new Website(234, "Twitter", "an online news and social networking service", today, today, 4321543);
        Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia", today, today, 3456654);
        Website cnn = new Website(456, "CNN", "an American basic cable and satellite television news channel", today, today, 6543345);
        Website cnet = new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", today, today, 5433455);
        Website gizmodo = new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on polit", today, today, 4322345);
        websitedao.createWebsiteForDeveloper(12, facebook);
        websitedao.createWebsiteForDeveloper(23, twitter);
        websitedao.createWebsiteForDeveloper(34, wikipedia);
        websitedao.createWebsiteForDeveloper(12, cnn);
        websitedao.createWebsiteForDeveloper(23, cnet);
        websitedao.createWebsiteForDeveloper(34, gizmodo);
        
        
        // Insert Website Role
        RoleDao roleDao = RoleDao.getInstance();
        roleDao.assignWebsiteRole(12, 123, 1);
        roleDao.assignWebsiteRole(23, 123, 4);
        roleDao.assignWebsiteRole(34, 123, 2);
        roleDao.assignWebsiteRole(23, 234, 1);
        roleDao.assignWebsiteRole(34, 234, 4);
        roleDao.assignWebsiteRole(12, 234, 2);
        roleDao.assignWebsiteRole(34, 345, 1);
        roleDao.assignWebsiteRole(12, 345, 4);
        roleDao.assignWebsiteRole(23, 345, 2);
        roleDao.assignWebsiteRole(12, 456, 1);
        roleDao.assignWebsiteRole(23, 456, 4);
        roleDao.assignWebsiteRole(34, 456, 2);
        roleDao.assignWebsiteRole(23, 567, 1);
        roleDao.assignWebsiteRole(34, 567, 4);
        roleDao.assignWebsiteRole(12, 567, 2);
        roleDao.assignWebsiteRole(34, 678, 1);
        roleDao.assignWebsiteRole(12, 678, 4);
        roleDao.assignWebsiteRole(23, 678, 2);
        
        
        // Create 3.
        // Insert Page
        PageDao pagedao = PageDao.getInstance();
        Page home = new Page(123, "Home", "Landing page", today, today, 123434);
        Page about = new Page(234, "About", "Website description", today, today, 234545);
        Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", today, today, 345656);
        Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", today, today, 456776);
        Page profile = new Page(567, "Profile", "Users can configure their personal infomation", today, today, 567878);
        pagedao.createPageForWebsite(567, home);
        pagedao.createPageForWebsite(678, about);
        pagedao.createPageForWebsite(345, contact);
        pagedao.createPageForWebsite(456, preferences);
        pagedao.createPageForWebsite(567, profile);
        
        // Insert Page Role
        roleDao.assignPageRole(12, 123, 4);
        roleDao.assignPageRole(23, 123, 5);
        roleDao.assignPageRole(34, 123, 3);
        roleDao.assignPageRole(23, 234, 4);
        roleDao.assignPageRole(34, 234, 5);
        roleDao.assignPageRole(12, 234, 3);
        roleDao.assignPageRole(34, 345, 4);
        roleDao.assignPageRole(12, 345, 5);
        roleDao.assignPageRole(23, 345, 3);  
        roleDao.assignPageRole(12, 456, 4);
        roleDao.assignPageRole(23, 456, 5);
        roleDao.assignPageRole(34, 456, 3);
        roleDao.assignPageRole(23, 567, 4);
        roleDao.assignPageRole(34, 567, 5);
        roleDao.assignPageRole(12, 567, 3);
        
        // Create 4.
        WidgetDao widgetdao = WidgetDao.getInstance();	
        Widget head123 = new Widget(1, "head123", 0, 0, "Welcome", 0, null, 123, Widget.type.HEADING);
        widgetdao.createWidgetForPage(123, head123);
        
        Widget post234 = new Widget(2, "post234", 0, 0, "<p>Lorem</p>", 0, null, 234, Widget.type.HTML);
        widgetdao.createWidgetForPage(234, post234);
        
        Widget head345 = new Widget(3, "head345", 0, 0, "Hi", 1, null, 345, Widget.type.HEADING);
        widgetdao.createWidgetForPage(345, head345);
        
        Widget intro456 = new Widget(4, "intro456", 0, 0, "<h1>Hi</hi>", 2, null, 345, Widget.type.HTML);
        widgetdao.createWidgetForPage(345, intro456);
        
        Widget image345 = new Widget(5, "image345", 50, 100, null, 3, "/img/567.png", 345, Widget.type.IMAGE);
        widgetdao.createWidgetForPage(345, image345);
        
        Widget video456 = new Widget(6, "video456", 400, 300, null, 0, "https://youtu.be/h67VX51QXiQ", 456, Widget.type.YOUTUBE);
        widgetdao.createWidgetForPage(456, video456);
		
		// Create 5. Implement Updates
		// 1.
			developerdao = DeveloperDao.getInstance();	
			developerdao.updatePhone(34, "333-444-5555", true);
		// 2.
			widgetdao = WidgetDao.getInstance();
			Collection <Widget> widgets = new ArrayList<Widget>();
			widgets = widgetdao.findWidgetsForPage(345);
			for (Widget widget: widgets) {
				widget.setOrder(widget.getOrder()+2);
				widgetdao.updateWidget(widget.getId(), widget);
					
			}
		//3.
			pagedao = PageDao.getInstance();
			Collection <Page> pages = pagedao.findPagesForWebsite(567);
			for (Page page : pages) {
				page.setTitle("CNET - " + page.getTitle());
				pagedao.updatePage(page.getId(), page);
			}
		//4. 
			RoleDao roledao = RoleDao.getInstance();
			roledao.deletePageRole(34, 123, 3);
			roledao.deletePageRole(23, 123, 5);
			roledao.assignPageRole(34, 123, 5);
			roledao.assignPageRole(23, 123, 3);
		
		// Create 6. Implement Deletes
		// 1.
		developerdao = DeveloperDao.getInstance();	
		alice = developerdao.findDeveloperByUsername("alice");
		developerdao.deletePrimaryAddress(alice.getId());
		
		// 2.
		widgetdao = WidgetDao.getInstance();
		widgets = new ArrayList<Widget>();
		widgets = widgetdao.findWidgetsForPage(345);
		int max_order = -1;
		int max_id = -1;
		for (Widget widget: widgets) {
			if (widget.getOrder() > max_order) {
				max_order = widget.getOrder();
				max_id = widget.getId();
			}
		}
		widgetdao.deleteWidget(max_id);
		
		// 3.
		pagedao = PageDao.getInstance();
		pages = new ArrayList<Page>();
		pages = pagedao.findPagesForWebsite(345);
        Date last_date = Date.valueOf("1983-08-03");
        max_id = -1;
        for (Page page : pages) {
            int comp = last_date.compareTo(page.getUpdated());
            if(comp < 0){
                last_date = page.getUpdated();
                max_id = page.getId();
            }
        }
        pagedao.deletePage(max_id);
		
		// 4.
        websitedao = WebsiteDao.getInstance();
		websitedao.deleteWebsite(567);
        System.out.println ("done");
	

	}}
