package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class UpdateTestQuestionsAndAnswers
 */
@WebServlet("/UpdateTestQuestionsAndAnswers")
public class UpdateTestQuestionsAndAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTestQuestionsAndAnswers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con;
    PreparedStatement ps;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		  question id  as ‘queId’;
		 question as ‘question’;
		 option 1 as ‘opt1’;
		 option 2 as ‘opt2’
		 option 3 as ‘opt3’
		 option 4 as ‘opt4
		 correctOption is ‘correctOption’;
*
		 */
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("queId"));
		String que = request.getParameter("question");
		String opt1 = request.getParameter("opt1");
		String opt2 = request.getParameter("opt2");
		String opt3 = request.getParameter("opt3");
		String opt4 = request.getParameter("opt4");
		int correct  = Integer.parseInt(request.getParameter("correctOption"));
		try{
			ServletContext context = getServletContext();
			con = (Connection)context.getAttribute("dbcon");
			String sql = "UPDATE testquestions set Question = ?, Option1 = ?, Option2=?, Option3=?,Option4=?, CorrectOption = ? where QuestionId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(7, id);
			ps.setString(1, que);
			ps.setString(2, opt1);
			ps.setString(3, opt2);
			ps.setString(4, opt3);
			ps.setString(5, opt4);
			ps.setInt(6, correct);
			int i=ps.executeUpdate();
			out.println(i>0?1:0);
		}catch(Exception e){
			out.println(e);
		}
	}

}
