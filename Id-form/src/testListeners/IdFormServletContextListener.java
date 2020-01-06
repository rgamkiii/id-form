package testListeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
//import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import testDB.DBConnectionManager;

/**
 * Application Lifecycle Listener implementation class IdFormServletContextListener
 *
 */
@WebListener
public class IdFormServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public IdFormServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         ServletContext ctx = sce.getServletContext();
         DBConnectionManager dbManager = 
        		 (DBConnectionManager) ctx.getAttribute("DB_MANAGER");
         try {
        	 dbManager.closeConnection();
             System.out.println("Database connection closed.");
         } catch(SQLException e) {
        	 System.out.println(e);
         }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext ctx = sce.getServletContext();
         String url = ctx.getInitParameter("DB_URL");
         String user = ctx.getInitParameter("DB_USER");
         String password = ctx.getInitParameter("DB_PASSWORD");
         
         try {
        	 DBConnectionManager dbManager = new DBConnectionManager(url, user,
        			 password);
             ctx.setAttribute("DB_MANAGER", dbManager);
             System.out.println("Database connection done.");
         } catch(SQLException e) {
        	 System.out.println(e);
         }
    }
	
}
