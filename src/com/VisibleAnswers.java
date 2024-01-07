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
 * Servlet implementation class VisibleAnswers
 */
@WebServlet("/VisibleAnswers")
public class VisibleAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		try{
			ServletContext context= getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			String sql = "select * from testtitle";
			Statement stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			
			if(rs.next()){
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
						+"    <h1 class='text-white text-2xl text-center m-4'>All Tests</h1>"
						+"    <div class='border-2 p-1 my-3 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 '>"
						+"        <span class='text-black text-xl my-1 mx-2 md:mx-12 '>Test</span>"
						+"        <span class='text-white text-xl m-1 bg-green-600 p-1  rounded '>Answers Sheet Status</span>"
						+"    </div>");
					
				int i =1;
				do{
					out.println("<div class='border-2 p-3 my-3 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 rounded-xl'>"
					+"    <span class='text-black text-xl m-2 '>"+(i++)+"."+rs.getString("TestTitle") +"</span>"
							+"    <div>");
								if(rs.getInt("AnsSheetStatus")==1){
									out.println("        <button value='"+rs.getString("ID")+"' onclick='changeVisibilityto0(this)' class='text-white bg-green-600 hover:bg-green-700 px-3 m-2 text-xl rounded'> Visible</button>");
									out.println("        <button value='"+rs.getString("ID")+"' onclick='changeVisibilityto1(this)' class='hidden text-white bg-red-600 hover:bg-red-700 px-3 m-2 text-xl rounded'>Not Visible</button>");
									
								}
								else{
									out.println("        <button value='"+rs.getString("ID")+"' onclick='changeVisibilityto0(this)' class='hidden text-white bg-green-600 hover:bg-green-700 px-3 m-2 text-xl rounded'> Visible</button>");
									out.println("        <button value='"+rs.getString("ID")+"' onclick='changeVisibilityto1(this)' class='text-white bg-red-600 hover:bg-red-700 px-3 m-2 text-xl rounded'>Not Visible</button>"	);								
								}
						out.println(	"    </div>"
							+"</div>");
					
						
						
				}while(rs.next());
				
				
				out.println("</div>");
				
			}else{
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
							+"<h1 class='text-white text-2xl text-center m-4'>All Tests</h1>"
							+"<h1 class='text-3xl text-white  text-center my-20'>No Tests Available</h1>"
							+"</div>");
			}
			
			
			
		}catch(Exception e){
			out.println(e);
		}
		
	}

	

}
