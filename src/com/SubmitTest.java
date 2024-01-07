package com;

import java.io.IOException;
import java.util.*;
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
 * Servlet implementation class SubmitTest
 */
@WebServlet("/SubmitTest")
public class SubmitTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
			String TestId= (String)request.getParameter("TestId");
			String StudentId = (String)request.getParameter("StudentId");
		//	out.println("this is servlet page submit test");
//			***********************************
			
			ArrayList<Integer> list = new ArrayList<>();
			Enumeration en = request.getParameterNames();
			int t= 0;
			
			while(en.hasMoreElements()){
				String name = (String)en.nextElement();
                if(t >1){
                	int val = Integer.parseInt(request.getParameter(name));
                	list.add(val);
                }
                t++;
			}
                	
			
//			out.println(list);
			
			int total = 0, scored = 0, i= 0;
			
				ServletContext context = getServletContext();
				
				Connection con = (Connection)context.getAttribute("dbcon");
				String sql = "SELECT *FROM testquestions WHERE TestId = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, TestId);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int correct = rs.getInt("CorrectOption");
					if(correct == list.get(i++))
						scored++;
					total++;
				}
				
			//start insertion of result details from here	
			
			
//			out.println("test id is ="+TestId);
//			out.println("student id is ="+StudentId);
//			out.println("Total marks = "+total+"<br>");
//			out.print("Scored marks = "+scored+"<br>");
			
//			***********************************
			
			
			String sql1 = "SELECT * FROM testtitle WHERE ID = ?";
			 
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, TestId);
			ResultSet rse = ps1.executeQuery();
			int year = 0, sem = 0; String testName = "";
			boolean b = rse.next();
			if(b){
				year = rse.getInt("Year");
				sem = rse.getInt("Semester");
				testName = rse.getString("TestTitle");
			}else{
//				out.println("Row doest not fetched <br>");
			}
			String sql2 = "INSERT INTO result (StudentId, TestName, TotalMarks, ScoredMarks, Semester, Year) Values (?,?,?,?,?,?)";
			PreparedStatement p =  con.prepareStatement(sql2);
			p.setString(1, StudentId);
			p.setString(2, testName);
			p.setInt(3, total);
			p.setInt(4, scored);
			p.setInt(5, sem);
			p.setInt(6, year);
			int n = p.executeUpdate();
			if (n ==1)
				out.print("<div id='rightBox' class='w-full  md:w-4/5 h-full  fixed top-0 right-0'>"
+"    <div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
+"        <h1 class='text-white text-2xl text-center m-4'>Result</h1>"
+"        <h1 class='text-white text-2xl text-center mt-28'>Your Test has been submiited succefully you can check your result.</h1>"
+"        <h1 class='text-white text-2xl text-center mt-2 underline underline-offset-1 hover:no-underline hover:cursor-pointer ' onclick='showAllTest()'> click here to give more test</h1>"
+"    </div>"
+"</div>");
			else
				out.print("<div id='rightBox' class='w-full  md:w-4/5 h-full  fixed top-0 right-0'>"
+"    <div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
+"        <h1 class='text-white text-2xl text-center m-4'>Result</h1>"
+"        <h1 class='text-white text-2xl text-center mt-28'>Your Test has not been submiited</h1>"

+"    </div>"
+"</div>");
		}
		catch(Exception e){
			out.println(e);
		}
		
		
	}

}
