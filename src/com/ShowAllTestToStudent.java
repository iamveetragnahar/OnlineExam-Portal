package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  * Servlet implementation class ShowAllTestToStudent
*/
@WebServlet("/ShowAllTestToStudent")
public class ShowAllTestToStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String StudentId= request.getParameter("StudentId");
		try{
			ServletContext context= getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			String sq1= "select * from student where EnrollmentNumber ='"+StudentId+"';";
			Statement st= conn.createStatement();
			ResultSet rset = st.executeQuery(sq1);
			rset.next();
//			out.println(rset.getString("course")+" "+rset.getString("branch")+" "+rset.getInt("StudentYear")+" "+rset.getInt("Semester"));
			String sql= "Select * from testtitle where Status=1 AND Course=? AND Branch=? AND Year=? AND Semester=?";
			PreparedStatement stmt  = conn.prepareStatement(sql);
			stmt.setString(1, rset.getString("course"));
			stmt.setString(2, rset.getString("branch"));
			stmt.setInt(3, rset.getInt("StudentYear"));
			stmt.setInt(4, rset.getInt("Semester"));
			
			ResultSet rs= stmt.executeQuery();
			int i =1;
			if(rs.next()){
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
+"    <h1 class='text-white text-2xl text-center m-4'>All Tests</h1>");
				
				do{
						
					out.println("    <div class='border-2 p-3 my-3 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 rounded-xl'>"
							+"        <span class='text-black text-xl m-2 '>"+(i++)+"."+ rs.getString("TestTitle")+"</span>"
							+"        <div>");	
				                     String sql1= "select * from testid"+rs.getString("ID")+" where StudentId='"+StudentId+"'";				    
				                     PreparedStatement stmt1= conn.prepareStatement(sql1);				                     
//				                     stmt1.setString(1, StudentId);				                    
				                     ResultSet rs1= stmt1.executeQuery(sql1);				                    
				                     if(rs1.next()){				                    
				                    	 out.println("            <button value='' class='text-white    bg-blue-600/50  px-3 m-2 text-xl rounded'>Submitted</button>");				                    	 				                     
				                     }
				                     else
				                     {				                    	 
				                    	 out.println("            <button id='"+rs.getString("ID")+"' value='"+StudentId+"' onclick='GenerateTestPapar(this)' class='text-white    bg-blue-600 hover:bg-blue-700 px-3 m-2 text-xl rounded'>Give Test</button>");				                   
				                     }
				                     out.println("        </div>");				                     
				                    	 
				                     out.println("    </div>");
				}while(rs.next());
					out.println("</div>");
			}
			else{
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
						+"    <h1 class='text-white text-2xl text-center m-4'>All Tests</h1>"
						+"   <h1 class='text-white text-3xl text-center mx-3 my-5'>No Test Available</h1>"
						+"</div>");
			}
			
		}catch(Exception e){
			out.println(e);
		}
		
		
		
	}

}
