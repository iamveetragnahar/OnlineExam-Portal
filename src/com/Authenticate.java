package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    PreparedStatement ps, ps1;
    Connection con;
    public void init(){
    	
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");	
       PrintWriter out = response.getWriter();
       
       String EnrollmentNumber = request.getParameter("userName");
       String password = request.getParameter("password");
       String userType = request.getParameter("utype");
       //out.println(name+" "+password+" "+userType);
       ServletContext context = getServletContext();
       con = (Connection)context.getAttribute("dbcon");
       
       if(userType.equalsIgnoreCase("student")){
    	   try{
       			String sql = "SELECT * FROM student Where EnrollmentNumber =? And Password = ?";
       			ps = con.prepareStatement(sql);
       			ps.setString(1, EnrollmentNumber);
       			ps.setString(2, password);
       			ResultSet rs = ps.executeQuery();
       			boolean b = rs.next();
       			if(b){
       				HttpSession session =request.getSession();
       				session.setAttribute("EnrollmentNumber", EnrollmentNumber);
       				session.setAttribute("uType",userType);
       				session.setAttribute("imgPath",rs.getString("ImagePath"));
       				session.setAttribute("name", rs.getString("Name"));
       				out.println("1");
       			}else{
       				out.println("0");
       			}
    	   }catch(Exception e){
    		   out.println(e);
    	   }
       }else if(userType.equalsIgnoreCase("teacher")){
    	   try{
//    		   out.println("inside teacehr if block");
    		   
    		   String email  =EnrollmentNumber;
    		   
//    		   out.println(email);
//    		   out.println(password);
      			String sql = "SELECT * FROM teacher Where Email =? And Password = ?";	
      			ps = con.prepareStatement(sql);
      			ps.setString(1, email);
      			ps.setString(2, password);
      			ResultSet rs = ps.executeQuery();
      			boolean b = rs.next();
//      			out.println("the result of result set is "+b);
      			if(b){
      				HttpSession session =request.getSession();
      				session.setAttribute("email", email);
      				session.setAttribute("uType",userType);
      				session.setAttribute("imgPath",rs.getString("ImagePath"));
      				session.setAttribute("name", rs.getString("Name"));
      				out.println("1");
      			}else{
      				out.println("0");
      			}
   	   }catch(Exception e){
   		   out.println(e);
   	   }
       }
	}

}
