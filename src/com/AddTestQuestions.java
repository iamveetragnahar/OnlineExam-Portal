package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class AddTestQuestions
 */
@WebServlet("/AddTestQuestions")
public class AddTestQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTestQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con;
    PreparedStatement ps;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String testid = request.getParameter("testId");
		String que = request.getParameter("question");
		String opt1 = request.getParameter("option1");
		String opt2 = request.getParameter("option2");
		String opt3 = request.getParameter("option3");
		String opt4 = request.getParameter("option4");
		int correctOption = Integer.parseInt((String)request.getParameter("correctSelect"));
//		String correctOption = (String)request.getParameter("correctSelect");
//		out.println(testid);
//		out.println(que);
//		out.println(opt1);
//		out.println(opt2);
//		out.println(opt3);
//		out.println(opt4);
//		out.println(correctOption);
//		
		
		try{
			ServletContext context = getServletContext();
			con = (Connection)context.getAttribute("dbcon");
			String sql = "INSERT INTO testquestions (TestId,Question,Option1,Option2,Option3,Option4,CorrectOption) values (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, testid);
			ps.setString(2, que);
			ps.setString(3, opt1);
			ps.setString(4, opt2);
			ps.setString(5, opt3);
			ps.setString(6, opt4);
			ps.setInt(7, correctOption);
			int i =ps.executeUpdate();
			
			out.println(i>0?1:-1);
		}catch(Exception e){
			out.println(-1);
		}
		
	}

}
