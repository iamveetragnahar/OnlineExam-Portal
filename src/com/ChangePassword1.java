package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword1")
public class ChangePassword1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con;
    PreparedStatement ps,ps1;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		HttpSession session = request.getSession();
		String utype = (String)session.getAttribute("uType");
		String enrollmentNumber = (String)session.getAttribute("EnrollmentNumber");
		String email = (String)session.getAttribute("email");
		ServletContext context = getServletContext();
		//out.println(oldPassword+" is old password\n"+newPassword+" is new password\n"+utype+" is u type\n"+enrollmentNumber+" is Enumber\n"+email+" is email");
		if(utype.equalsIgnoreCase("student")){
			try{
				con = (Connection)context.getAttribute("dbcon");
				String sql ="SELECT *FROM student where EnrollmentNumber = ? AND Password = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, enrollmentNumber);
				ps.setString(2, oldPassword);
				ResultSet rs = ps.executeQuery();
				boolean b = rs.next();
				if(b){
					PreparedStatement p = con.prepareStatement("UPDATE student set Password = ? WHERE EnrollmentNumber = ?");
					p.setString(1, newPassword);
					p.setString(2, enrollmentNumber);
					p.executeUpdate();
					out.println(1);
				}else
					out.println(0);
			}catch(Exception e){
				out.println(e);
			}
		}
		else if(utype.equalsIgnoreCase("teacher")){
			try{
				con = (Connection)context.getAttribute("dbcon");
				String sql = "SELECT *FROM teacher WHERE Email = ? AND Password = ?";
				ps1 = con.prepareStatement(sql);
				ps1.setString(1, email);
				ps1.setString(2, oldPassword);
				ResultSet rs = ps1.executeQuery();
				boolean b = rs.next();
				if(b){
					PreparedStatement prs = con.prepareStatement("UPDATE teacher SET Password = ? WHERE Email = ?"); 
					prs.setString(1, newPassword);
					prs.setString(2, email);
					prs.executeUpdate();
					out.println(1);
				}else
					out.println(0);
			}catch(Exception e){
				out.println(e);
			}
		}
	}

}
