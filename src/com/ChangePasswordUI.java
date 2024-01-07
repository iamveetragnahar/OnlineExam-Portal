package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePasswordUI
 */
@WebServlet("/ChangePasswordUI")
public class ChangePasswordUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String username= (String)request.getParameter("username");
		String uType= (String)request.getParameter("uType");
		ServletContext context = getServletContext();
	    Connection  con = (Connection)context.getAttribute("dbcon");
		if(uType.equalsIgnoreCase("student")||uType.equalsIgnoreCase("teacher")){
				
			out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-1/3  h-auto py-8 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
		    +"<div class='font-Lato'>"
		        +"<!-- <form method='POST' action='' id='form'> -->"
		        +"<h1 class='text-white text-center text-3xl font-bold'>Change Password</h1>"
		        +"<!-- error box  -->"
		        +"<div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
		            +"Username/Password is wrong"
		        +"</div>"
		        +"<div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
		          +"Password changed successfully"
		        +"</div>"
		        +"<div class='m-7 sm:mx-12 relative'>"
		            +"<input type='password' id='oldPassword' name='password' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Old Password'>"
		            +"<i id='eye' onclick='Eye(this)' class='fas fa-eye text-black absolute right-3 top-1/2  -translate-y-1/2 '></i>"
		            +"<i id='eye_slash' onclick='EyeSlash(this)' class='fas fa-eye-slash text-black absolute right-3 top-1/2 -translate-y-1/2  hidden  '></i>"
		        +"</div>"
		        +"<div class='m-7 sm:mx-12 relative'>"
		            +"<input type='password' id='newPassword' oninput='passwordConfirmByNewPassword(this)' name='password' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter New Password'>"
		            +"<i id='eye' onclick='Eye(this)' class='fas fa-eye text-black absolute right-3 top-1/2 -translate-y-1/2 '></i>"
		            +"<i id='eye_slash' onclick='EyeSlash(this)' class='fas fa-eye-slash text-black absolute right-3 top-1/2 -translate-y-1/2 hidden '></i>"
		        +"</div>"
		        +"<div class='m-7 sm:mx-12 relative '>"
		            +"<input type='password' id='confirmPassword' name='password' oninput='passwordConfirmByConfirmPassword(this)' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none ' placeholder='Confirm Password '>"
		            +"<i id='eye ' onclick='Eye(this) ' class='fas fa-eye text-black absolute right-3 top-1/2 -translate-y-1/2 '></i>"
		            +"<i id='eye_slash ' onclick='EyeSlash(this)' class='fas fa-eye-slash text-black absolute right-3 top-1/2 -translate-y-1/2 hidden '></i>"
		        +"</div>"
		        +"<div>"
		            +"<input type='submit' id='passwordChangeSubmit' onclick='changePasswordButton(this)' value='Submit ' class=' bg-blue-500 hover:bg-blue-600 text-center text-white px-7   py-2 text-2xl rounded block m-auto '>"
		        +"</div>"
		    +"</div>"
		    +"</div>"
			+"<script  src='./passwordreset.js'></script>");
			
			
		}
		
		
		
	}

}
