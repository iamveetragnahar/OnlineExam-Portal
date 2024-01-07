package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeteteTest
 */
@WebServlet("/DeteteTest")
public class DeteteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeteteTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		try {
			ServletContext context= getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			
			String testId= (String)request.getParameter("testId");
			String sql = "delete from testtitle where ID =?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, testId);
			int i = ps.executeUpdate();
			if(i==1)
			{
				sql= "delete from testquestions where TestId = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, testId);
				ps.executeUpdate();
				sql= "drop table testid"+testId;
				ps  = conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			out.println(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(-1);
		}
		
		
		
	}

}
