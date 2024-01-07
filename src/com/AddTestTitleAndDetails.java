package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTestTitleAndDetails
 */
@WebServlet("/AddTestTitleAndDetails")
public class AddTestTitleAndDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		PrintWriter out =response.getWriter();
   		response.setContentType("text/html");
   		try{
   			ServletContext context = getServletContext();
   			Connection con = (Connection)context.getAttribute("dbcon");
   			
   			String testTitle = (String)request.getParameter("testTitle");
   			String testId = (String)request.getParameter("testId");
   			String branch = (String)request.getParameter("branch");
   			String course = (String)request.getParameter("course");
   			int year =  Integer.parseInt((String )request.getParameter("year"));
   			int semester= Integer.parseInt((String )request.getParameter("semester"));
//   			out.println(testId+"is testid");
   			String sql = "insert into testtitle  values(?,?,?,?,?,?,?,?)";
   			String tableName = "testid"+testId;
   			String sql1 = "CREATE table "+tableName+" (StudentId varchar(30) primary key)";
   			PreparedStatement ps= con.prepareStatement(sql);
   			PreparedStatement pse= con.prepareStatement(sql1);
//   			pse.setString(1, tableName);
   			ps.setString(1,testId );
   			ps.setString(2,testTitle );
   			ps.setString(3, course);
   			ps.setString(4,branch);
   			ps.setInt(5, 1);
   			ps.setInt(6, year);
   			ps.setInt(7,semester);
   			ps.setInt(8,0);
   			
   			int c = pse.executeUpdate();	
   			
   			
   			int b= ps.executeUpdate();
   			
   			if(b>0)
   				out.println(1);
   			else{
   				String sa= "drop table ?";
   				PreparedStatement pstmt= con.prepareStatement(sa);
   				pstmt.setString(1, tableName);
   				pstmt.executeUpdate();
   				out.println(0);		
   			}
   		
   		}catch(Exception e){
   			out.println(e);
   		}
        
        
        
        
   		
	}

}
