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
 * Servlet implementation class ShowAvailableAnsSheet
 */
@WebServlet("/ShowAvailableAnsSheet")
public class ShowAvailableAnsSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAvailableAnsSheet() {
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
			ServletContext context= getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			
			String StudentId=request.getParameter("StudentId");
//			out.println(StudentId);
			String sql1 = "SELECT * From student WHERE EnrollmentNumber = ?";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, StudentId);
			ResultSet res = ps.executeQuery();
			String year = "";
			String course = "";
			String sem = "" ;
			String Branch ="" ;
			boolean b = res.next();
			if(b){
				year = res.getString("StudentYear");
				course = res.getString("course");
				sem = res.getString("Semester");
				Branch = res.getString("branch");
			}else{
				out.println("Data would'nt fetched from student table");
			}
			String sql = "select * from testtitle where AnsSheetStatus=1 AND Branch='"+Branch+"' AND Year='"+year+"' AND Course='"+course+"' AND Semester='"+sem+"';";
			
			
		// sql = "select * from testtitle where AnsSheetStatus=1";
			Statement stmt= conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
					+"<h1 class='text-white text-2xl text-center m-4'>Tests Answers</h1>");
			
			if(rs.next())
			{int i =1;
				do{
					out.println("<div class='border-2 p-3 my-3 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 rounded-xl'>"
								+"<span class='text-black text-xl m-2 '>"+(i++)+"."+rs.getString("TestTitle")+"</span>"
								+"<div>"
								+" <button class='text-white bg-blue-600 hover:bg-blue-700 px-3 m-2 text-xl rounded' value='"+rs.getString("ID")+"' onclick='generateAnsSheet(this)' >Check here</button>"
								+"</div>"
								+"</div>");
				}while(rs.next());
			}
			else{
				out.println("<div class='border-2 p-3 my-3 mx-2 md:mx-10 bg-white/50 rounded-xl'>");
				out.println("<h1 class='text-center text-white text-2xl m-1'>No AnswerSheet available</h1>");
				out.println("</div>");
			}
			out.println("</div>");
			
		}catch(Exception e){
		out.println(e);}
	}

}
