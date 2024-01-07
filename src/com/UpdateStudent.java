package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
@MultipartConfig
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String  StudentName = request.getParameter("StudentName"); 
		int id = Integer.parseInt( request.getParameter("ID"));
		String  EnrollmentNumber  = request.getParameter("EnrollmentNumber");
		String  MobileNumber = request.getParameter("MobileNumber");
		String  Email = request.getParameter("Email");
		String  DOB = request.getParameter("DOB");
		String  Course = request.getParameter("Course");
		String  Branch = request.getParameter("Branch");
		int  StartYear = Integer.parseInt(request.getParameter("StartYear"));
		int  StudentYear = Integer.parseInt(request.getParameter("StudentYear"));
		int  StudentSemester = Integer.parseInt(request.getParameter("StudentSemester"));
		
		try{
			ServletContext context = getServletContext();
			Connection con = (Connection)context.getAttribute("dbcon");
			String sql = "update Student SET Name =?, EnrollmentNumber =?, Mobilenumber =?,Email =?, DOB=?, course =?,branch =?, Year =?, Semester=?, StudentYear	=? WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, StudentName);
			ps.setString(2, EnrollmentNumber);
			ps.setString(3, MobileNumber);
			ps.setString(4, Email);
			ps.setString(5, DOB);
			ps.setString(6, Course);
			ps.setString(7, Branch);
			ps.setInt(8, StartYear);
			ps.setInt(9, StudentSemester);
			ps.setInt(10, StudentYear);
			ps.setInt(11, id);
			int x = ps.executeUpdate();
			if(x == 1)
				out.print(1);
			else
				out.print(0);
		}catch(Exception e){
			out.println(e);
		}
		
	}

	
}
