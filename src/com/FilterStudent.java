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
 * Servlet implementation class FilterStudent
 */
@WebServlet("/FilterStudent")
public class FilterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out= response.getWriter();
			response.setContentType("text/html");
			String Course=request.getParameter("Course");
			String Branch=request.getParameter("Branch");
			String Semester=request.getParameter("Semester");
			String Year=request.getParameter("Year");
			String SearchValue  = request.getParameter("SearchValue");
			try
			{
				ServletContext context= getServletContext();
				Connection conn =(Connection)context.getAttribute("dbcon");
				String sql=null;
				if(SearchValue==null)
			 sql= "select * from student where course=? and branch=? and Semester=? and StudentYear=?";
				else{
					sql="select * from student where Name=? OR EnrollmentNumber=?";
				}
				PreparedStatement ps= conn.prepareStatement(sql);
				if(SearchValue==null){
					ps.setString(1, Course );
					ps.setString(2, Branch );
					ps.setString(3, Semester );
					ps.setString(4, Year );
				}	
				else{
					ps.setString(1, SearchValue);
					ps.setString(2, SearchValue);
				}
					
				
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()){
					do{
						out.println("<div class='border-2 p-1 my-2 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 rounded-xl'>"
    +"<span class='text-black text-xl m-1 '>"+rs.getString("Name")+" "+rs.getString("EnrollmentNumber")+"</span>"
    +"<div>"
        +"<button value='"+rs.getString("ID")+"' class='text-white    bg-blue-600 hover:bg-blue-700 px-3 m-1 text-xl rounded' onclick='addUpdateFormUI(this)' >Edit</button>"
        +"<button value='"+rs.getString("ID")+"' class='text-white bg-blue-600 hover:bg-blue-700 px-3 m-1 text-xl rounded' onclick='deleteStudent(this)'>Delete</button>"
    +"</div>"
+"</div>");
					}while(rs.next());
				}else{
					out.println("<p class='text-white text-2xl text-center'>No Student Found</p>");
				}
			}catch(Exception e){
				out.println(e);
			}
	}

}
