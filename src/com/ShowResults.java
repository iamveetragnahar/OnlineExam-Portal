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
 * Servlet implementation class ShowResults
 */
@WebServlet("/ShowResults")
public class ShowResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResults() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	try{
    		String StudentId= request.getParameter("StudentId");
    		ServletContext context = getServletContext();
    		Connection conn = (Connection ) context.getAttribute("dbcon");
    		String sql= "select * from result where StudentId = ?";
    		PreparedStatement pstmt= conn.prepareStatement(sql);
    		pstmt.setString(1, StudentId);
    		ResultSet rs = pstmt.executeQuery();
    		
    		out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
    					+"    <h1 class='text-white text-2xl text-center m-4'>Results</h1>"
    					+"    <div class=' p-1 my-3  mx-2 md:mx-10 '>");
    		if(rs.next()){
    			do{
    				out.println("        <h1 class='text-2xl text-white border-b-2 m-6 pb-3 hover:underline underline-offset-1' onclick='showResult(this)' id='"+rs.getString("ResultId")+"'> <a> "+rs.getString("TestName")+"</a> </h1>");
    			}while(rs.next());
    		}
    		else{
    			out.println("<h1 class='text-2xl text-white border-b-2 m-6 pb-3 text-center '>Currenltly No Result available</h1>");
    		}
    		out.println("</div>"
    					+"</div>");
    		
    		
    	}
    	catch(Exception e)
    	{
    		out.println(e);
    	}
	}

}
