package com;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.*;

/**
 * Application Lifecycle Listener implementation class MyListner
 *
 */
@WebListener
public class MyListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
     Connection con;
     PreparedStatement ps;
    public void contextDestroyed(ServletContextEvent sce)  { 
         try{
        	 con.close();
         }catch(Exception e){
        	 e.printStackTrace();
         }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         try{
        	 Class.forName("com.mysql.jdbc.Driver");
      		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","1234");
      		ServletContext context =  sce.getServletContext();
      		context.setAttribute("dbcon", con);
      		 System.out.println("Connected");
         }catch(Exception e){
        	 System.out.println("In LISyner");
        	 e.printStackTrace();
         }
    }
	
}
