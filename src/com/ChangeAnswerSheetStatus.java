package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeAnswerSheetStatus
 */
@WebServlet("/ChangeAnswerSheetStatus")
public class ChangeAnswerSheetStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAnswerSheetStatus() {
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
		String testId= request.getParameter("testId");
		int status= Integer.parseInt((String)request.getParameter("status"));
		
		
		try{
			ServletContext context= getServletContext();
			Connection conn = (Connection) context.getAttribute("dbcon");
			String sql = "Update testtitle set AnsSheetStatus=? where ID=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setString(2,testId);
			int  i = ps.executeUpdate();
			out.println(i>0?1:0);
		}catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}
