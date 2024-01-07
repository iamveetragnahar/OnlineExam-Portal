package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTestFormUI
 */
@WebServlet("/AddTestFormUI")
public class AddTestFormUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try{
			ServletContext context = getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			String sql1 ="Select * from branch";
			String sql2= "Select * from course";
			
			PreparedStatement pstmt1= conn.prepareStatement(sql1);
			PreparedStatement pstmt2= conn.prepareStatement(sql2);
			ResultSet rs1= pstmt1.executeQuery();
			ResultSet rs2= pstmt2.executeQuery();
			
			
			out.println("<div style='background-color: rgba(0,0,0,0.5);' class='overflow-scroll hiddenScrollBar border-black w-fullA md:w-1/3  font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
				    +"<h1 class='text-white text-2xl mt-3 text-center'>Add Test</h1>"
				    +"<div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
				        +"Username/Password is wrong"
				    +"</div>"
				    +"<div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
				        +"Details Updated successfully"
				    +"</div>"
				    +"<div class='m-7 sm:mx-12'>"
				        +"<p class='text-white mb-1 text-xl'>Enter Test Title </p>"
				        +"<input type='text' id='testTitleInp' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Test Title'>"
				    +"</div>"
				    +"<div class='m-7 sm:mx-12'>"
				        +"<p class='text-white mb-1 text-xl'>Select Branch</p>"
				        +"<!-- <input type='text' id='usernameInp' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'> -->"
				        +"<select  id='branchSelect' class='bg-white border-b-4 rounded-md border-black  input p-2  text-black/70 text-xl w-full focus:outline-none'>"
				        +"<option value=''>Select</option>");
					while(rs1.next()){
						
							out.println("<option value='"+rs1.getString("BranchName")+"'>"+rs1.getString("BranchName")+"</option>");
					}
				            
				            
				       out.println( "</select>"
				    		   		+"</div>"
				    		   		+"<div class='m-7 sm:mx-12'>"
				    		   		+"<p class='text-white mb-1 text-xl'>Select Course</p>"
				    		   		+"<!-- <input type='text' id='usernameInp' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'> -->"
				    		   		+"<select  id='courseselect' class='bg-white border-b-4 rounded-md border-black  p-2 input text-black/70 text-xl w-full focus:outline-none'>"
				    		   		+"<option value=''>Select</option>");
				       while(rs2.next()){
							
							out.println("<option value='"+rs2.getString("CourseName")+"'>"+rs2.getString("CourseName")+"</option>");
					}
				            out.println("</select>"
				    +"</div>"
				    +"<div class='m-7 sm:mx-12 '>"
	                +"<p class='text-white text-xl p-2 '>Year</p>"
	                +"<select class=' bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none' id='Year'>"
	                +"<option value='1'>1</option>"
	                +"<option value='2'>2</option>"
	                +"<option value='3'>3</option>"
	                +"<option value='4'>4</option>"
	                +"<option value='5'>5</option>"
	              +"</select>"
	            +"</div>"
	            +"<div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Semester</p>"
                +"<select class=' bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none' id='Semester'>"
                +"<option value='1'>1</option>"
                +"<option value='2'>2</option>"
              +"</select>"
            +"</div>"
	            
				    
				    +"<div class='m-7 mx-12'>"
				        +"<input type='submit' id='Update' value='Add Test' onclick='addTestTitleAndDetails()'  class='bg-blue-600 text-white py-2 text-xl px-4 rounded-md  block w-1/2  m-auto hover:bg-blue-700'>"
				    +"</div>"
				+"</div>");
			
		}catch(Exception e){
			out.println(e);
		}
		
	}

}
