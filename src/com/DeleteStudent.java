package com;

import java.io.IOException;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
		try{
				ServletContext context= getServletContext();
				Connection conn = (Connection)context.getAttribute("dbcon");
				String ID = request.getParameter("ID");
				String sql = "Delete from student where ID=?";
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1, ID);
				int i  = ps.executeUpdate();
				if(i!=0){
					out.println(1);
				}
				else {
					out.println(0);
				}
		}
		catch(Exception e){
			out.println(e);
		}
	}

}
