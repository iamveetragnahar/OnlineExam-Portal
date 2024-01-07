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

/**
 * Servlet implementation class UpdateStudentFormUI
 */
@WebServlet("/UpdateStudentFormUI")
public class UpdateStudentFormUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentFormUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  out = response.getWriter();
		response.setContentType("text/html");
		try{
			ServletContext context= getServletContext();
			Connection conn  = (Connection)context.getAttribute("dbcon");
				
			String ID = (String)request.getParameter("ID");
			String sql ="select * from student where ID=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs= ps.executeQuery();
			Statement stmt1= conn.createStatement();
			Statement stmt2= conn.createStatement();
			ResultSet branchset = stmt1.executeQuery("select * from branch");
			ResultSet courseset= stmt2.executeQuery("select * from course");
			if(rs.next()){
			out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-2/5 hiddenScrollBar  overflow-y-auto font-Lato h-5/6  rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
				    +"<div id='div'>"
			        +"<h1 class='text-white text-2xl text-center m-4'>Update Student</h1>"
			        +"<div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
			            +"Username/Password is wrong"
			        +"</div>"
			        +"<div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
			            +"Details Updated successfully"
			        +"</div>"
			        +"<form action='#' id='UpdateStudentForm' onsubmit='updateStudentDetails(event,this)'>"
			         +"<input type='hidden' value='"+ID+"' name='ID'/>"   
			        +"<div class='m-7 sm:mx-12  '>"
			                +"<p class='text-white text-xl p-2'>Name:</p>"
			                +"<input type='text' id='usernameInp'  name='StudentName' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' value='"+rs.getString("Name")+"' placeholder='Enter Name Of Student'>"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12  '>"
			                +"<p class='text-white text-xl p-2'>Enrollment No.:</p>"
			                +"<input type='text' id='usernameInp' readonly name='EnrollmentNumber' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Enrollment Number' value='"+rs.getString("EnrollmentNumber")+"'>"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12  '>"
			                +"<p class='text-white text-xl p-2'>Mobile No.:</p>"
			                +"<input type='number' id='usernameInp' name='MobileNumber' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Mobile Number' value='"+rs.getString("Mobilenumber")+"'>"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12  '>"
			                +"<p class='text-white text-xl p-2'>Email:</p>"
			                +"<input type='text' id='usernameInp' name='Email' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Email' value='"+rs.getString("Email")+"'>"
			            +"</div>"
			            +"<div class=' m-7 sm:mx-12 '>"
			                +"<p class='text-white text-xl p-2 '>DOB:</p>"
			                +"<input type='date' id='usernameInp' name='DOB' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter DOB Of Student ' value='"+rs.getString("DOB")+"'>"
			            +"</div>"
			          
			            +"<div class='m-7 sm:mx-12 '>"
			                +"<p class='text-white text-xl p-2 '>Course</p>"
			                +"<select class=' bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none' name='Course'>"
			                +"<option value='"+rs.getString("course")+"'>"+rs.getString("course")+"</option>");
			                while(courseset.next()){
			                	out.println("<option value='"+courseset.getString("CourseName")+"'>"+courseset.getString("CourseName")+"</option>");
			                }
			                out.println("</select>"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12 '>"
			                +"<p class='text-white text-xl p-2 '>Branch</p>"
			                +"<select class=' bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none' name='Branch'>"
			                +"<option value='"+rs.getString("branch")+"'>"+rs.getString("branch")+"</option>");
			               while(branchset.next()){
			            	   out.println("<option value='"+branchset.getString("BranchName")+"'>"+branchset.getString("BranchName")+"</option>");
			               }
			                
			               
			                out.println("</select>"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12 '>"
			                +"<p class='text-white text-xl p-2 '>Select start Year</p>"
			                +"<input type='number' step='1'  name='StartYear' id='startInputYear' value='"+rs.getString("Year")+"' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter Start Year' />"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12 '>"
			                +"<p class='text-white text-xl p-2 '>Enter Student Year</p>"
			                +"<input type='number' step='1' name='StudentYear' id='startInputYear' value='"+rs.getString("StudentYear")+"'  class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter student year' />"
			            +"</div>"
			            +"<div class='m-7 sm:mx-12 '>"
			                +"<p class='text-white text-xl p-2 '>Enter Student Semester</p>"
			                +"<input type='number' step='1' name='StudentSemester' value='"+rs.getString("Semester")+"' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter student semester' />"
			            +"</div>"
			                
			            
//			            +"<div class='m-7 sm:mx-12 '>"
//			                +"<p class='text-white text-xl p-2 '>Image:</p>"
//			                +"<input type='file' id='usernameInp' name='Image' class='p-2 input field text-black w-full bg-blue-50 rounded-md focus:border-none focus:box focus:outline-none'>"
//			            +"</div>"
			            
			            
			            +"<div class='m-7 mx-12 '>"
			                +"<input type='submit' id='AddStudent' value='Add Student'  class='bg-blue-600 py-2 text-xl px-4 rounded-md text-white block w-1/2 m-auto hover:bg-blue-700 '>"
			            +"</div>"
			        +"</form>"
			    +"</div>"
			+"</div>");
			
		}
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
