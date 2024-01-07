package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




@WebServlet("/AddNotice")
@MultipartConfig
public class AddNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotice() {
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
				String NoticeTitle = request.getParameter("NoticeTitle");
				Part p = request.getPart("File");
				String name = p.getSubmittedFileName();
//				out.println(NoticeTitle);
//				out.println(name);
				String filename= new Date().getTime()+name;
				String path = request.getRealPath("/");
				path += "files"+File.separator+filename;  
				InputStream in = p.getInputStream();
				boolean b= UploadFile(in,path);
				if(b)
				{		
				
				ServletContext context= getServletContext();
				Connection conn  = (Connection)context.getAttribute("dbcon");
				
				String sql = "insert into notices (NoticeTitle,FileName) values(?,?)";
				
				PreparedStatement pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, NoticeTitle);
				pstmt.setString(2, filename);
				
				int i = pstmt.executeUpdate();
				out.println(i>0?1:0);
				
				}
				else{
					out.print(0);
				}
								
		}
		catch(Exception e){
			out.println(e);
		}
	}

	public static boolean UploadFile(InputStream in , String path) throws Exception{
		byte[] b= new byte[in.available()];
		in.read(b);
		FileOutputStream o= new FileOutputStream(path);
		o.write(b);
		o.flush();
		o.close();
		return true;
	}
}
