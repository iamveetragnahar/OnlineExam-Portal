package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class UpdateTeacherDetails
 */
@WebServlet("/UpdateTeacherDetails")
public class UpdateTeacherDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*		“username” for getting the oldemail of teacher;
		“newname” for getting new name of the teacher;
		“newqualification” for getting new qualification of the teacher;
		“newmobilenumber” for getting new mobile number of the teacher;
		“newemail” for getting the newemail*/

PrintWriter out = response.getWriter();
String oldemail = request.getParameter("username");
String name = request.getParameter("newname");
String mobile = request.getParameter("newmobilenumber");
String newemail = request.getParameter("newemail");
String quali = request.getParameter("newqualification");
//out.println(newemail);
//out.println(oldemail);
try{
	ServletContext context = getServletContext();
Connection	con = (Connection)context.getAttribute("dbcon");
	String sql = "UPDATE teacher set Email = ?, Name = ?, MobileNumber = ?, Qualification = ? where Email = ?";
PreparedStatement	ps = con.prepareStatement(sql);
	ps.setString(1, newemail);
	ps.setString(2, name);
	ps.setString(3, mobile);
	ps.setString(4, quali);
	ps.setString(5, oldemail);
int i=	ps.executeUpdate();
	
out.println(i>0?i:0);
}catch(Exception e){
	out.println(0); 
}
	}

}
