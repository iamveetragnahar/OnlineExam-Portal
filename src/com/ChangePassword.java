package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class ChangePasswordOfStudent
 */
@WebServlet("/ChangePasswordOfStudent")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
    Connection con;
    PreparedStatement ps;
    
    public void init(){
    	try{
    		ServletContext context = getServletContext();
    		con = (Connection)context.getAttribute("dbcon");
    		String sql = "SELECT * FROM student WHERE EnrollmentNumber = ? And Password= ?";
    		ps = con.prepareStatement(sql);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htm;charset= UTF-8");
		PrintWriter out = response.getWriter();
		try{
			HttpSession session = request.getSession();
			String EnrollmentNumber = (String) session.getAttribute("EnrollmentNumber");
			String password = request.getParameter("oldPassword");
			String newpassword = request.getParameter("newPassword");
			EnrollmentNumber = EnrollmentNumber.toUpperCase();
			ps.setString(1, EnrollmentNumber);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean b = rs.next();
			if(b){
				String sql1 = "UPDET student set Password = ? Where EnrollmentNumber = ?";
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setString(1, newpassword);
				ps1.setString(2, EnrollmentNumber);
				ps1.executeUpdate();
				out.println(1);
				}
			else{
				out.println(0);
				
			}
		}catch(Exception e){
			out.println(e);
		}
	}

}
