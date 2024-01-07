package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentFormUI
 */
@WebServlet("/AddStudentFormUI")
public class AddStudentFormUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentFormUI() {
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
		try{
				ServletContext context= getServletContext();
				Connection conn = (Connection)context.getAttribute("dbcon");
				

				Statement stmt= conn.createStatement();
				Statement stmt1= conn.createStatement();
				ResultSet rs= stmt.executeQuery("select * from course");
				ResultSet rs1= stmt1	.executeQuery("select * from branch");
		out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-2/5 hiddenScrollBar  overflow-y-auto font-Lato h-5/6  rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
    +"<div id='div'>"
        +"<h1 class='text-white text-2xl text-center m-4'>Add Student</h1>"
        +"<div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
            +"Username/Password is wrong"
        +"</div>"
        +"<div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
            +"Details Updated successfully"
        +"</div>"
        +"<form action='#' id='AddStudentForm' onsubmit='preventDefaultNature(event)'>"
            +"<div class='m-7 sm:mx-12  '>"
                +"<p class='text-white text-xl p-2'>Name:</p>"
                +"<input type='text' id='usernameInp' name='StudentName' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Name Of Student'>"
            +"</div>"
            +"<div class='m-7 sm:mx-12  '>"
                +"<p class='text-white text-xl p-2'>Enrollment No.:</p>"
                +"<input type='text' id='usernameInp' name='EnrollmentNumber' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Enrollment Number'>"
            +"</div>"
            +"<div class='m-7 sm:mx-12  '>"
                +"<p class='text-white text-xl p-2'>Mobile No.:</p>"
                +"<input type='number' id='usernameInp' name='MobileNumber' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Mobile Number'>"
            +"</div>"
            +"<div class='m-7 sm:mx-12  '>"
                +"<p class='text-white text-xl p-2'>Email:</p>"
                +"<input type='text' id='usernameInp' name='Email' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Email'>"
            +"</div>"
            +"<div class=' m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>DOB:</p>"
                +"<input type='date' id='usernameInp' name='DOB' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter DOB Of Student '>"
            +"</div>"
            +"<div class=' m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Gender:</p>"
                +"<div class='flex justify-between  '>"
                    +"<div class='flex flex-row'>"
                        +"<label for='MaleInp' class='text-white text-xl p-2 inline border-black' for='MaleInp'>Male</label>"
                        +"<input type='radio' id='MaleInp' checked name='Gender' value='Male' class='my-4 inline  field text-black rounded-md focus:border-none focus:box focus:outline-none' value='Male'>"
                    +"</div>"
                    +"<div class='flex flex-row'>"
                        +"<label for='FemaleInp' class='text-white text-xl p-2 inline border-black' for='MaleInp'>Female</label>"
                        +"<input type='radio' id='FemaleInp' name='Gender' value='Memale' class='my-4 inline  field text-black rounded-md focus:border-none focus:box focus:outline-none' value='Male'>"
                    +"</div>"
                    +"<div class='flex flex-row'>"
                        +"<label for='OtherInp' class='text-white text-xl p-2 inline border-black' for='MaleInp'>Other</label>"
                        +"<input type='radio' id='OtherInp' name='Gender' value='Other' class='my-4 inline  field text-black rounded-md focus:border-none focus:box focus:outline-none' value='Male'>"
                    +"</div>"
                +"</div>"
            +"</div>"
            +"<div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Course</p>"
                +"<select class=' bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none' name='Course'>"
                +"<option value=''>Select</option>");
		while(rs.next()){
			out.println("<option value='"+rs.getString("CourseName")+"'>"+rs.getString("CourseName")+"</option>");	
		}
            out.println("</select>"
            +"</div>"
            +"<div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Branch</p>"
                +"<select class=' bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none' name='Branch'>"
                +"<option value=''>Select</option>");
            while(rs1.next()){
            	out.println("<option value='"+rs1.getString("BranchName")+"'>"+rs1.getString("BranchName")+"</option>");
            }    
            	
                out.println("</select>"
            +"</div>"
            +"<div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Select start Year</p>"
                +"<input type='number' step='1' value='2022' name='Year' id='startInputYear' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter Start Year' />"
            +"</div>"
            + "<div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Enter Student Year</p>"
                +"<input type='number' step='1'  name='StudentYear' id='startInputYear' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter student year' />"
            +"</div><div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Enter Student Semester</p>"
                +"<input type='number' step='1'  name='StudentSemester' class='p-2 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enter student semester' />"
            +"</div>"
            +"<div class='m-7 sm:mx-12 '>"
                +"<p class='text-white text-xl p-2 '>Image:</p>"
                +"<input type='file' id='usernameInp' name='Image' class='p-2 input field text-black w-full bg-blue-50 rounded-md focus:border-none focus:box focus:outline-none'>"
            +"</div>"
            +"<div class='m-7 mx-12 '>"
                +"<input type='submit' id='AddStudent' value='Add Student' onclick='addStudent(this)' class='bg-blue-600 py-2 text-xl px-4 rounded-md text-white block w-1/2 m-auto hover:bg-blue-700 '>"
            +"</div>"
        +"</form>"
    +"</div>"
    + "<script>"
    + " document.getElementById('AddStudentForm').addEventListener('submit', (e) => {"
                +"e.preventDefault();"
                +"console.log('default prevented');"
            +"})"
    + "</script>"
    +"<script src='https://code.jquery.com/jquery-3.6.0.min.js' integrity='sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=' crossorigin='anonymous'></script>"
+"</div>");
		}catch(Exception e){
			out.println(e);
		}
		
	}

}
