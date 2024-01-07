package com;
import java.io.IOException;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowProfile")
public class ShowProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName= (String)request.getParameter("username");
		String uType= (String) request.getParameter("uType");
		
		//out.println(userNa me);
		if(uType.equalsIgnoreCase("student")){
			
			try{
				ServletContext context = getServletContext();
			      Connection con = (Connection)context.getAttribute("dbcon");
			      String sql = "select * from student where EnrollmentNumber=?";
			      PreparedStatement pstmt = con.prepareStatement(sql);
			      pstmt.setString(1, userName);
			      
			      ResultSet rs = pstmt.executeQuery();
			      if(rs.next()){
			    	  
			    	  
			    	  out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-4/5  h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
			    	  +"<div id='profileImg' class='font-Courgette absolute hidden md:block  md:w-1/4 left-0 top-1/2 -translate-y-full'>"
			    	  +"<div id='img' class='  m-1'>"
			    	  +"<img src='imgs/"+rs.getString("ImagePath")+"' alt='' class='aspect-square rounded-full w-3/4  p-1  m-auto'>"
			    	  +"</div>"
			    	  +"<div class=' m-0'>"
			    	  +"<p class='text-center text-xl m-0 p-0 leading-none'>"+rs.getString("Name")+"</p>"
			    	  +"<p class='text-center text-md m-1 p-0 leading-none'>Student</p>"
			    	  +"</div>"
			    	  +"</div>"
			    	  +"<div class=' w-3/4 px-12 h-full absolute right-1/2 translate-x-1/2 md:-translate-x-0 md:right-4'>"
			    	  +"<div class=' p-4 rounded-md font-Lato absolute w-full left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2   bg-white/60 '>"
			    	  +"<div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Name:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("Name")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Enrollment No:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("EnrollmentNumber")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>D.O.B:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("DOB")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Gender:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("Gender")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Course:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("Course")+" "+rs.getString("Branch")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Batch:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("Year")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Email:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("Email")+"</span>"
			    	  +"</div>"
			    	  +"<div class='text-white text-2xl m-3'>"
			    	  +"<span class='pl-2'>Mobile:</span>"
			    	  +"<span class='pl-2'>"+rs.getString("Mobilenumber")+"</span>"
			    	  +"</div>"
			    	  +"</div>"
			    	  +"<div>"
			    	 // +"<input type='button' value='Edit Profile' class='bg-blue-600 hover:bg-blue-700 py-2 px-4 rounded-md text-white m-3'>"
			    	  +"</div>"
			    	  +"</div>"
			    	  +"</div>"
			    	  +"</div>");
			      }
			      //getServletContext().getRealPath("/")+
			}
			catch(Exception e){
				out.println(e);
			}
		}else{
			try {
				ServletContext context = getServletContext();
			      Connection con = (Connection)context.getAttribute("dbcon");
			      String sql = "select * from teacher where Email=?";
			      PreparedStatement pstmt = con.prepareStatement(sql);
			      pstmt.setString(1, userName);
			      ResultSet rs = pstmt.executeQuery();
			      boolean  b = rs.next();
			    //   out.println(b+" "+userName+" is the email");
				  if (b) {
					  
					out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-4/5  h-2/3 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
					+"<div id='profileImg' class='font-Courgette absolute hidden md:block  md:w-1/4 left-0 top-1/2 -translate-y-2/3'>"
							+"<div id='img' class='  m-1'>"
								+"<img src='imgs/"+rs.getString("ImagePath")+"' alt='' class=' rounded-full w-3/4  p-1  m-auto'>"
							+"</div>"
							+"<div class=' m-0'>"
								+"<p class='text-center text-xl m-0 p-0 leading-none'>"
								+rs.getString("Name")
								+"</p>"
								+"<p class='text-center text-md m-1 p-0 leading-none'>Examiner</p>"
							+"</div>"
						+"</div>"
						+"<div class=' w-3/4 px-12 h-full absolute right-1/2 translate-x-1/2 md:-translate-x-0 md:right-4'>"
							+"<div class=' p-4 rounded-md font-Lato absolute w-full left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2   bg-white/60 '>"
								+"<div>"
									+"<div class='text-white text-xl md:text-3xl m-3'>"
										+"<span class='pl-2'>Name:</span>"
										+"<span class='pl-2'>"+rs.getString("Name")+"</span>"
									+"</div>"
									+"<div class='text-white text-xl md:text-3xl m-3'>"
										+"<span class='pl-2'>D.O.B:</span>"
										+"<span class='pl-2'>"+rs.getString("DOB")+"</span>"
									+"</div>"
									+"<div class='text-white text-xl md:text-3xl m-3'>"
										+"<span class='pl-2'>Gender:</span>"
										+"<span class='pl-2'>"+rs.getString("Gender")+"</span>"
									+"</div>"
									+"<div class='text-white text-xl md:text-3xl m-3'>"
										+"<span class='pl-2'>Qualification:</span>"
										+"<span class='pl-2'>"+rs.getString("Qualification")+"</span>"
									+"</div>"
									+"<div class='text-white text-xl md:text-3xl m-3'>"
										+"<span class='pl-2'>Email:</span>"
										+"<span class='pl-2'>"+rs.getString("Email")+"</span>"
									+"</div>"
									+"<div class='text-white text-xl md:text-3xl m-3'>"
										+"<span class='pl-2'>Mobile:</span>"
										+"<span class='pl-2'>"+rs.getString("MobileNumber")+"</span>"
									+"</div>"
								+"</div>"
							+"</div>"
						+"</div>"
					+"</div>");


				  }
			} catch (Exception e) {
				//TODO: handle exception
				out.println(e);
			}}
		}
	}


