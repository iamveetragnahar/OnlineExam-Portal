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
 * Servlet implementation class ShowTeacherUpdateForm
 */
@WebServlet("/ShowTeacherUpdateForm")
public class ShowTeacherUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTeacherUpdateForm() {
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
		
		String uType= (String)request.getParameter("uType");
		if(uType.equalsIgnoreCase("teacher")){
			try{
				ServletContext context = getServletContext();
				Connection con = (Connection)context.getAttribute("dbcon");
				String username= (String)request.getParameter("username");
				String sql= "Select * from teacher where Email =?";
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1, username);
				
				ResultSet rs= ps.executeQuery();
				if(rs.next()){
					out.println("<div style='background-color: rgba(0,0,0,0.5);' class='font-Lato border-black w-fullA md:w-2/5 hiddenScrollBar  overflow-y-auto h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
							+"    <h1 class='text-white text-2xl mt-3 text-center'>Update Form</h1>"
							+"    <div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
							+"        Username/Password is wrong"
							+"    </div>"
							+"    <div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
							+"        Details Updated successfully"
							+"    </div>"
							+"    <div class='m-7 sm:mx-12'>"
							+"        <p class='text-white mb-1 text-xl'>Update Name</p>"
							+"        <input type='text' id='UpdateNameInp' name='userName' value='"+rs.getString("Name")+"' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'>"
							+"    </div>"
							+"    <div class='m-7 sm:mx-12'>"
							+"        <p class='text-white mb-1 text-xl'>Update Qualification</p>"
							+"        <input type='text' id='UpdateQualificationInp' name='userName' value='"+rs.getString("Qualification")+"' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'>"
							+"    </div>"
							+"    <div class='m-7 sm:mx-12'>"
							+"        <p class='text-white mb-1 text-xl'>Update Mobile Number</p>"
							+"        <input type='text' id='UpdateMobileInp' name='userName' value='"+rs.getString("MobileNumber")+"' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'>"
							+"    </div>"
							+"    <div class='m-7 sm:mx-12'>"
							+"        <p class='text-white mb-1 text-xl'>Update Email</p>"
							+"        <input type='text' id='UpdateEmailInp' name='userName' value='"+rs.getString("Email")+"' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'>"
							+"    </div>"
							+"    <div class='m-7 mx-12'>"
							+"        <input type='submit' id='UpdateButton' onclick='updateTeacherDetails()' value='Update' class='bg-blue-600 text-white py-2 text-xl px-4 rounded-md  block w-1/2  m-auto hover:bg-blue-700'>"
							+"    </div>"
							+"</div>");
				}
				
			}catch(Exception e)
			{
				out.println(e);
			}
				
		     
		    		 
		      
		}
		
	}

}
