package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
//@MultipartConfig
@MultipartConfig 
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			ServletContext context= getServletContext();
			Connection conn = (Connection)context.getAttribute("dbcon");
			
			String StudentName = request.getParameter("StudentName");
			String EnrollmentNumber = request.getParameter("EnrollmentNumber");
			String MobileNumber= request.getParameter("MobileNumber");
			String Email= request.getParameter("Email");
			String DOB= request.getParameter("DOB");
			String Course = request.getParameter("Course");
			String Branch= request.getParameter("Branch");
			String Year= (String)request.getParameter("Year");
			String Gender= request.getParameter("Gender");
			int StudentSemester = Integer.parseInt(request.getParameter("StudentSemester"));
			int StudentYear = Integer.parseInt(request.getParameter("StudentYear"));
			
//			out.println(StudentName);
//			out.println(EnrollmentNumber);
//			out.println(MobileNumber);
//			out.println(Email);
//			out.println(DOB);
//			out.println(Course);
//			out.println(Branch);
			if(StudentName==""||EnrollmentNumber==""||MobileNumber==""||Email==""||DOB==""||Course==""||Branch==""||Year==""||Gender=="")
			{
				out.println("-2");
			}
			Part part= request.getPart("Image");
			String fileName= part.getSubmittedFileName();
			fileName= new Date().getTime()+fileName;
			//out.println(fileName);
			String path = request.getRealPath("/");
//			String path = "C:\\Users\\Lenovo\\workspace\\Exam Portal\\WebContent\\";
			String dbPath= fileName;
			path+="imgs"+File.separator+fileName;
			//out.println(path);
			InputStream in= part.getInputStream();
			boolean b= UploadImage(in,path);	
			if(b){
//				out.println("file uploaded path is "+path);
					
								//							1           2       3    4       5           6    7   8       9      10   11     12			13			14
				String sql  = "insert into student (EnrollmentNumber,Password,Name,Gender,Mobilenumber,Email,DOB,Branch,Course,Year,Status,ImagePath,StudentYear,Semester) "
						+ "                  values(?,                ?, 		?,	?,		?,			?,	   ?,	?,	   ?,   ?,   	?	,	?,?,?)";
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1,EnrollmentNumber );
				ps.setString(2, DOB);
				ps.setString(3,StudentName );
				ps.setString(4, Gender);
				ps.setString(5, MobileNumber);
				ps.setString(6, Email);
				ps.setString(7, DOB);
				ps.setString(8, Branch);
				ps.setString(9, Course);
				ps.setString(10, Year);
				ps.setString(11, "1");
				ps.setString(12,dbPath );
				ps.setInt(13, StudentYear);
				ps.setInt(14,StudentSemester );		
				int i = ps.executeUpdate();
				out.println(i>0?1:0);
			
			}
			else{
				out.println(0);
			}
			
		}
		catch(Exception e){
			out.println(e);
		}
	}
	public boolean UploadImage(InputStream is, String path) throws IOException{
		byte[] data= new byte[is.available()];
		is.read(data);
		FileOutputStream fos= new FileOutputStream(path);
		fos.write(data);
		fos.flush();
		fos.close();
		return true;
	}

	

}
