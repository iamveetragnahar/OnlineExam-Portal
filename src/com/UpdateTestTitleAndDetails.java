package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class UpdateTestTitleAndDetails
 */
@WebServlet("/UpdateTestTitleAndDetails")
public class UpdateTestTitleAndDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTestTitleAndDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con ;
    PreparedStatement ps;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String testid = request.getParameter("testId");
		String title = request.getParameter("testTitle");
		String branch = request.getParameter("testBranch");
		String course = request.getParameter("testCourse");
		
		try{
			ServletContext context = getServletContext();
			con = (Connection)context.getAttribute("dbcon");
			String sql = "UPDATE testtitle set TestTitle = ?, Course = ?, Branch = ? where ID=?";
			ps = con.prepareStatement(sql);
			ps.setString(4, testid);
			ps.setString(1, title);
			ps.setString(2, course);
			ps.setString(3, branch);
			int i=ps.executeUpdate();
			out.println(i>0?1:0);
		}catch(Exception e){
			out.println(e);
		}
	}

}
