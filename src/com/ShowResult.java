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
 * Servlet implementation class ShowResult
 */
@WebServlet("/ShowResult")
public class ShowResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResult() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	try{
    		String ResultId= request.getParameter("ResultId");
    		ServletContext context= getServletContext();
    		Connection conn = (Connection) context.getAttribute("dbcon");
    		String sql ="select * from result where ResultId=?";
    		PreparedStatement ps  = conn.prepareStatement(sql);
    		ps.setString(1, ResultId);
    		ResultSet rs= ps.executeQuery();
    		String sql1 = "select * from student where EnrollmentNumber =?";
    		PreparedStatement ps1= conn.prepareStatement(sql1);
    		if(rs.next()){
    			ps1.setString(1, rs.getString("StudentId"));
    			ResultSet rs1 = ps1.executeQuery();
    			rs1.next();
    			out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
+"    <h1 class='text-white text-2xl text-center m-4'>Result</h1>"
+"    <div class='bg-white/60 p-2 mx-5 rounded'>"
+"        <p class='text-black text-2xl mx-7 my-3'><span class='underline-offset-2 underline'>Student Name</span>: <span class='mx-3'>"+rs1.getString("Name")+"</span></p>"
+"        <p class='text-black text-2xl mx-7 my-3'><span class='underline-offset-2 underline'>Enrollment Number</span>:<span class='mx-3'>"+rs1.getString("EnrollmentNumber")+"</span></p>"
+"    </div>"
+"    <div class='my-5 bg-white/60 p-2 mx-5 rounded'>"
+"        <div class='text-black text-2xl mx-7 my-3 '>"
+"            <p> <span class='underline-offset-2 underline'>Exam Name</span> : <span class='mx-3'>"+rs.getString("TestName")+"</span></p>"
+"        </div>"
+"        <div class='text-black text-2xl mx-7  my-3'>"
+"            <p><span class='underline-offset-2 underline'>Semester</span>:<span class='mx-3'>"+rs.getInt("Semester")+"</span></p>"
+"        </div>"
+"        <div class='text-black text-2xl mx-7 my-3 '>"
+"            <p><span class='underline-offset-2 underline'>Year</span>: <span class='mx-3'>"+rs.getInt("Year")+"</span></p>"
+"        </div>"
+"    </div>"
+"    <div class='my-5 bg-white/60 p-2 mx-5 rounded'>"
+"        <div class='text-black text-2xl mx-7 my-3 '>"
+"            <p><span class='underline-offset-2 underline'>Total Questions</span>:<span class='mx-3'>"+rs.getInt("TotalMarks")+"</span></p>"
+"        </div>"
+"        <div class='text-black text-2xl mx-7 my-3 '>"
+"            <p><span class='underline-offset-2 underline'>Toatal marks</span>:<span class='mx-3'>"+rs.getInt("TotalMarks")+"</span></p>"
+"        </div>"
+"        <div class='text-black text-2xl mx-7 my-3 '>"
+"            <p class='font-bold'><span class='underline-offset-2 underline'>Scored</span>:<span class='mx-3'>"+rs.getInt("ScoredMarks")+"</span></p>"
+"        </div>"
+"    </div>"
+"</div>");
    		}else{
    			out.println("<h1 class='text-2xl text-white border-b-2 m-6 pb-3 text-center '>Some issue occured sorry for Inconvenience!</h1>");
    		}
    		
    		
    	}catch(Exception e){
    		out.println(e);
    	}
    	
    	
    }

}
