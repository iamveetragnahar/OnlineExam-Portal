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
 * Servlet implementation class AnswerSheet
 */
@WebServlet("/AnswerSheet")
public class AnswerSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerSheet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
		 try{
			 String TestId = request.getParameter("TestId");
			 ServletContext context= getServletContext();
			 Connection conn = (Connection)context.getAttribute("dbcon");
			 String sql1 = "Select * from testtitle where ID="+TestId;
			 String sql2 = "select * from testquestions where TestId="+TestId ;
			 Statement stmt1=conn.createStatement();
			 Statement stmt2=conn.createStatement();
			 
			 ResultSet rs1= stmt1.executeQuery(sql1);
			 ResultSet rs2= stmt2.executeQuery(sql2);
			 
			 rs1.next();
			 
			 out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-90 my-3  rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
					 +"    <h1 class='text-white text-2xl text-center m-4'>Answers</h1>"
					 +"    <div class=' w-fullA  m-auto text-black p-3 text-xl bg-white/50 rounded-md '>"
					 +"        <div class='m-2 flex'>"
					 +"            <span class='p-1'>Title:</span>"
					 +"            <span class='p-1'>"+rs1.getString("TestTitle")+"</span>"
					 +"        </div>"
					 +"        <div class='m-2 flex'>"
					 +"            <span class='p-1'>Course:</span>"
					 +"            <span class='p-1'>"+rs1.getString("Course")+"</span>"
					 +"        </div>"
					 +"        <div class='m-2 flex'>"
					 +"            <span class='p-1'>Branch:</span>"
					 +"            <span class='p-1'>"+rs1.getString("Branch")+"</span>"
					 +"        </div>"
					 +"    </div>");
			 
			 while(rs2.next()){
out.println(
 "    <div class=' w-fullA  mx-auto my-3 text-black p-3 text-xl bg-white/50 rounded-md '>"
+"        <div class=' m-2  flex'>"
+"            <span class='p-1'>Q1:</span>"
+"            <span class='p-1'>"+rs2.getString("Question")+"</span>"
+"        </div>"
+"        <div class=' m-2  flex'>");

		if(rs2.getInt("CorrectOption")==1)
			out.println("            <p class='p-1 ml-3 font-semibold  bg-black/50 text-white  rounded-full  px-4 '>"+rs2.getString("Option1")+"</p>");
		else
			out.println("            <p class='p-1 ml-3'>"+rs2.getString("Option1")+"</p>");
out.println("        </div>"
+"        <div class=' m-2  flex'>");

if(rs2.getInt("CorrectOption")==2)
	out.println("            <p class='p-1 ml-3 font-semibold  bg-black/50 text-white  rounded-full  px-4 '>"+rs2.getString("Option2")+"</p>");
else
	out.println("            <p class='p-1 ml-3'>"+rs2.getString("Option2")+"</p>");
out.println("        </div>"
+"        <div class=' m-2  flex'>");

if(rs2.getInt("CorrectOption")==3)
	out.println("            <p class='p-1 ml-3 font-semibold  bg-black/50 text-white  rounded-full  px-4 ' >"+rs2.getString("Option3")+"</p>");
else
	out.println("            <p class='p-1 ml-3'>"+rs2.getString("Option3")+"</p>");
out.println("        </div>"
+"        <div class=' m-2  flex'>");
if(rs2.getInt("CorrectOption")==4)
	out.println("            <p class='p-1 ml-3 font-semibold  bg-black/50 text-white  rounded-full  px-4 ' >"+rs2.getString("Option4")+"</p>");
else
	out.println("            <p class='p-1 ml-3'>"+rs2.getString("Option4")+"</p>");
out.println("        </div>"
+"    </div>");
}
			 
			 
			 out.println("</div>");
			 
			 
			 
		 }
		 catch(Exception e){
			 out.println(e);
		 }
	}

}
