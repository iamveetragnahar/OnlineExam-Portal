package com;

import java.io.File;
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
 * Servlet implementation class ShowNotices
 */
@WebServlet("/ShowNotices")
public class ShowNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNotices() {
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
			String type= request.getParameter("userType");
			ServletContext context = getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			String sql = "select * from notices";
			Statement stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(type==null){
		 out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
					+"    <h1 class='text-white text-2xl text-center m-4'>Manage Notices</h1>"
					+"    <div class='flex justify-end w-fullA md:w-4/5 '>"
					+"        <button value='' class='text-white  bg-blue-600 hover:bg-blue-700 px-3 m-2 text-2xl md:translate-x-3/4  rounded' onclick='addNoticeForm()'>Add Notice</button>"
					+"    </div>");}
			else{
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
						+"    <h1 class='text-white text-2xl text-center m-4'>All Notices</h1>");
					//out.println("    <div class='flex justify-end w-fullA md:w-4/5 '>"
					//	+"        <button value='' class='text-white  bg-blue-600 hover:bg-blue-700 px-3 m-2 text-2xl md:translate-x-3/4  rounded' onclick='addNoticeForm()'>Add Notice</button>"
					//	+"    </div>");
			}
			
			if(rs.next()){
			do{
				 out.println("<div class='border-2 p-1 my-3 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 '>"
							+"    <span class='text-black text-xl m-2 '><a href='files"+File.separator+rs.getString("FileName")+"' target='_blank'  class='underline underline-offset-2 hover:no-underline text-blue-900'>"+rs.getString("NoticeTitle")+"</a> </span>");
						if(type==null){
				 out.println("    <div>"
							+"        <button value='"+rs.getString("ID")+"' id='"+rs.getString("FileName")+"' class='text-white  bg-red-600 hover:bg-red-700 px-3 m-2 text-xl   rounded' onclick='deleteNotice(this)'>Delete</button>"
							+"    </div>");}
				 out.println("</div>");
				
			}while(rs.next());
			}else{
				out.println( "<div class='border-2 p-1 my-3 mx-2 md:mx-10    bg-white/50 '>"   
                            +"<h1 class='text-center text-2xl text-white'>No Notice </h1>"
                            +"</div>");
			}
			out.println("</div>");
			
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
