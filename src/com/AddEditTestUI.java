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
 * Servlet implementation class AddEditTestUI
 */
@WebServlet("/AddEditTestUI")
public class AddEditTestUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEditTestUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int index=0;
		//out.println("this is addedit test ui  page from servlet ");
		ServletContext context= getServletContext();
		try{
			Connection conn = (Connection)context.getAttribute("dbcon");
			String testId= request.getParameter("testId");
			
			String sql = "Select * from testtitle where ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, testId);
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			
			
			
			out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-5/6  rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
				    +"<h1 class='text-white text-2xl text-center m-4'>Edit Test</h1>"
				    +"<div class='flex justify-end p-2 m-2'>"
				        +"<button class=' bg-blue-600 py-2 text-xl px-6 rounded-md block text-white  hover:bg-blue-700 md:mx-5 ' value='"+testId+"' onclick='addQuestionsByButton(this)'>Add Questions</button>"
				    +"</div>"
				    +"<!-- title and branch and course edit box -->"
				    +"<div class=' w-fullA  m-auto text-black p-3 text-xl bg-white/50 rounded-md '>"
				        +"<div class='m-2 flex'>"
				            +"<span class='p-1'>Title:</span>"
				            +"<span class='p-1'>"+rs.getString("TestTitle")+"</span>"
				            +"<input type='text' class='hidden  p-1 input field text-black  w-full rounded-md focus:border-none focus:box focus:outline-none' value='"+rs.getString("TestTitle")+"'>"
				        +"</div>"
				        +"<div class='m-2 flex'>"
				            +"<span class='p-1'>Course:</span>"
				            +"<span class='p-1'>"+rs.getString("Course")+"</span>"
				            +"<select name='' id='' class='hidden p-1 bg-white border-b-4 rounded-md border-black  input   text-black/70 text-xl w-full focus:outline-none'>");
				
			String sql1  ="Select * from course";
			PreparedStatement ps1= conn.prepareStatement(sql1);
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next())
			{out.println("<option value='"+rs1.getString("CourseName")+"'>"+rs1.getString("CourseName")+"</option>");}
				                
				                
				      out.println("</select>"
				        +"</div>"
				        +"<div class='m-2 flex'>"
				            +"<span class='p-1'>Branch:</span>"
				            +"<span class='p-1'>"+rs.getString("Branch")+"</span>"
				            +"<select name='' id='' class='hidden bg-white border-b-4 rounded-md border-black  input p-1  text-black/70 text-xl w-full focus:outline-none'>");
				      String sql2  ="Select * from branch";
						PreparedStatement ps2= conn.prepareStatement(sql2);
						ResultSet rs2= ps2.executeQuery();
						
						while(rs2.next())
				      {out.println( "<option value='"+rs2.getString("BranchName")+"'>"+rs2.getString("BranchName")+"</option>");}
				        
						String sql3= "select * from testquestions where TestId=?";
						
						PreparedStatement ps3 = conn.prepareStatement(sql3);
						ps3.setString(1,testId);
						ResultSet rs3= ps3.executeQuery();
						
						out.println("</select>"
				        +"</div>"
				        +"<div class='flex justify-end'>"
				            +"<button class=' bg-blue-600 py-2 text-xl px-6 rounded-md block text-white  hover:bg-blue-700 md:mx-5 ' value='"+rs.getString("ID")+"' onclick='editHead(this)'>Edit</button>"
				            +"<button class='hidden bg-blue-600 py-2 text-xl px-6 rounded-md  text-white  hover:bg-blue-700 md:mx-5 ' value='"+rs.getString("ID")+"' onclick='submitHead(this)'>Submit</button>"
				        +"</div>"
				    +"</div>"
				    +"<!-- question and optons and and edit box -->");
				    
						while(rs3.next()){
out.println("<div class=' w-fullA  mx-auto my-3 text-black p-3 text-xl bg-white/50 rounded-md '>"
				        +"<div class=' m-2  flex'>"
				            +"<span class='p-1'>Q"+(++index)+":</span>"
				            +"<span class='p-1'>"+rs3.getString("Question")+"</span>"
				            +"<input type='text ' class='hidden p-1 input field text-black  w-full rounded-md focus:border-none focus:box focus:outline-none ' value='"+rs3.getString("Question")+"'>"
				        +"</div>"
				        +"<div class=' m-2  flex'>"
				            +"<span class='p-1'>1:</span>"
				            +"<span class='p-1'>"+rs3.getString("Option1")+"</span>"
				            +"<input type='text ' class=' hidden p-1 input field text-black  w-full rounded-md focus:border-none focus:box focus:outline-none ' value='"+rs3.getString("Option1")+"'>"
				        +"</div>"
				        +"<div class=' m-2  flex'>"
				            +"<span class='p-1'>2:</span>"
				            +"<span class='p-1'>"+rs3.getString("Option2")+"</span>"
				            +"<input type='text ' class='hidden  p-1 input field text-black  w-full rounded-md focus:border-none focus:box focus:outline-none ' value='"+rs3.getString("Option2")+"'>"
				        +"</div>"
				        +"<div class=' m-2  flex'>"
				            +"<span class='p-1'>3:</span>"
				            +"<span class='p-1'>"+rs3.getString("Option3")+"</span>"
				            +"<input type='text ' class='hidden  p-1 input field text-black  w-full rounded-md focus:border-none focus:box focus:outline-none ' value='"+rs3.getString("Option3")+"'>"
				        +"</div>"
				        +"<div class=' m-2  flex'>"
				            +"<span class='p-1'>4:</span>"
				            +"<span class='p-1'>"+rs3.getString("Option4")+"</span>"
				            +"<input type='text ' class='hidden  p-1 input field text-black  w-full rounded-md focus:border-none focus:box focus:outline-none ' value='"+rs3.getString("Option4")+"'>"
				        +"</div>"
				        +"<div class='m-2 flex'>"
				            +"<span class='p-1'>Correct Option:</span>"
				            +"<span class='p-1'>1</span>"
				            +"<select name='' id='' class='hidden p-1 bg-white border-b-4 rounded-md border-black  input   text-black/70 text-xl  w-full md:w-3/5 focus:outline-none'>"
				                +"<option value='1'>1</opt>"
				                +"<option value='2'>2</option>"
				                +"<option value='3'>3</option>"
				                +"<option value='4'>4</option>"
				            +"</select>"
				        +"</div>"
				        +"<div class='flex justify-end'>"
				            +"<button class=' bg-blue-600 py-2 text-xl px-6 rounded-md block text-white  hover:bg-blue-700 md:mx-5 ' value='"+rs3.getString("QuestionId")+"' onclick='editTestQuestionsBox(this)'>Edit</button>"
				            +"<button class='hidden bg-blue-600 py-2 text-xl px-6 rounded-md  text-white  hover:bg-blue-700 md:mx-5 ' value='"+rs3.getString("QuestionId")+"' onclick='submitTestQuestionsBox(this)'>Submit</button>"
				        +"</div>"
+"</div>");
}
				  
				  
				out.println( "</div>");
			
			
		}
		catch(Exception e){
			out.println(e);
		}
		
		
		
	}

}
