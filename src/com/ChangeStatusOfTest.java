package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class ChangeStatusOfTest
 */
@WebServlet("/ChangeStatusOfTest")
public class ChangeStatusOfTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusOfTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String testid = request.getParameter("testId");
		int status = Integer.parseInt(request.getParameter("status"));
		
		try{
			ServletContext context = getServletContext();
			Connection con = (Connection)context.getAttribute("dbcon");
			PreparedStatement ps=null;
			if(status == 1){
				String sql = "UPDATE testtitle set Status = 0  where ID = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, testid);
				int i=	ps.executeUpdate();
				out.println(i>0?1:0);
			}
			else if(status == 0){
				String sql = "UPDATE testtitle set Status = 1  where ID = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, testid);
				int i=	ps.executeUpdate();
				out.println(i>0?1:0);			}
			
		}catch(Exception e){
			out.println("0");
		}
	}

}
