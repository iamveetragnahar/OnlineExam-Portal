package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.sql.*;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteNotice
 */
@WebServlet("/DeleteNotice")
public class DeleteNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteNotice() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
//
			int NoticeId = Integer.parseInt(request.getParameter("NoticeId"));
			String FileName = request.getParameter("FileName");
//			out.println(NoticeId);
//			out.println(FileName);

			String filePath= request.getRealPath("/")+"files"+File.separator+FileName;
//			out.println(filePath);
			File f= new File(filePath);
			if(f.delete()){
				ServletContext context= getServletContext();
				Connection conn = (Connection)context.getAttribute("dbcon");
				String sql  ="delete from notices where ID=?";
				PreparedStatement  pstmt  = conn.prepareStatement(sql);
				pstmt.setInt(1, NoticeId);
				pstmt.executeUpdate();
				out.println(1);
			}
			else{
				
				out.println(0);
			}
					
		}catch(Exception e){
				out.println(e);
		}
	}

}
