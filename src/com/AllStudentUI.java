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
 * Servlet implementation class AllStudentUI
 */
@WebServlet("/AllStudentUI")
public class AllStudentUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllStudentUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try{
			ServletContext context = getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			String sql = "select * from course ";
			Statement stmt= conn.createStatement();
			Statement stmt1= conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			ResultSet rs1= stmt1.executeQuery("select * from branch ");
			
			
			out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-4/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
    +"<h1 class='text-white text-2xl text-center m-4'>All Student</h1>"
    +"<div id='filterbox' class='h-10  md:h-10  overflow-hidden  transition-all duration-300'>"
        +"<h1 class='text-2xl text-white mx-5'>Filter <a href='#' onclick='showHideFilterBox(this)' class='text-white hover:text-white underline'>here</a> </h1>"
        +"<div class='flex justify-between md:flex-row flex-col'>"
            +"<div>"
                +"<form action='#' onsubmit='filterForm1(event,this)'>"
                    +"<div class='flex  m-2  w-Afull justify-between'>"
                        +"<p class='text-white text-xl mx-3'>Course</p>"
                        +"<select name='Course' id='' value='' class='text-xl rounded-md w-48 border-b-2 input border-black focus:outline-none px-2 py-1'>");
                while(rs.next()){
                	out.println("<option value='"+rs.getString("CourseName")+"'>"+rs.getString("CourseName")+"</option>");
                }
                    out.println("</select>"
                    +"</div>"
                    +"<div class='flex m-2  w-Afull justify-between'>"
                        +"<p class='text-white text-xl mx-3'>Branch</p>"
                        +"<select name='Branch' id='' class='text-xl rounded-md w-48 border-b-2 input border-black focus:outline-none px-2 py-1'>");
               while(rs1.next()){
            	   out.println("<option value='"+rs1.getString("BranchName")+"'>"+rs1.getString("BranchName")+"</option>");
               }
                out.println("</select>"
                    +"</div>"
                    +"<div class='flex m-2  w-Afull justify-between'>"
                        +"<p class='text-white text-xl mx-3'>Year</p>"
                        +"<select name='Year' id='' class='text-xl rounded-md w-48 border-b-2 input border-black focus:outline-none px-2 py-1'>"
                +"<option value='1'>1</option>"
                +"<option value='2'>2</option>"
                +"<option value='3'>3</option>"
                +"<option value='4'>4</option>"
                +"<option value='5'>5</option>"
            +"</select>"
                    +"</div>"
                    +"<div class='flex m-2  w-Afull justify-between'>"
                        +"<p class='text-white text-xl mx-3'>Semester</p>"
                        +"<select name='Semester' id='' class='text-xl rounded-md w-48 border-b-2 input border-black focus:outline-none px-2 py-1'>"
                +"<option value='1'>1</option>"
                +"<option value='2'>2</option>       "
            +"</select>"
                    +"</div>"
                    +"<div>"
                        +"<button type='submit' class='text-white bg-blue-700 px-4 py-2 text-xl md:ml-52 ml-32 hover:bg-blue-600 rounded-md'>Search</button>"
                    +"</div>"
                +"</form>"
            +"</div>"
            +"<form action='#' onsubmit='filterForm1(event,this)' class='flex flex-col justify-end border-black md:w-1/2 w-full '>"
                +"<p class='text-xl text-white m-2'>Enter Enrollment/Name</p>"
                +"<input type='text' id='usernameInp ' name='SearchValue' class='p-3 m-2 input field text-black md:w-1/2 rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Enrollment/Name '>"
                +"<button type='submit ' class='text-white bg-blue-700 px-4 py-2 text-xl mx-2 w-36 hover:bg-blue-600 rounded-md '>Search</button>"
            +"</form>"
        +"</div>"
    +"</div>"
    +"<div id='studentList'>"
        +"<p class='text-white text-2xl my-8 text-center'>Use Filter Box to See Students or Search Specific student by Name or Enrollment</p>"
    +"</div>"
+"</div>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
		
	}

}
