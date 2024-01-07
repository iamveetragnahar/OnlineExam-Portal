package com;

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
 * Servlet implementation class GenerateTestPapar
 */
@WebServlet("/GenerateTestPapar")
public class GenerateTestPapar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateTestPapar() {
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
			 ServletContext  context = getServletContext();
			 Connection conn = (Connection)context.getAttribute("dbcon");
			 
			 String TestId= request.getParameter("TestId");
			 String StudentId= request.getParameter("StudentId");
			 
			 String sql1 = 	"Select * from testtitle where ID=?";
			 String sql2 = 	"Select * from testquestions where TestId=? ";
			 String sql3= 	"Insert into testid"+TestId+" Values('"+StudentId+"')";
			 
			 
			 PreparedStatement pstmt1= conn.prepareStatement(sql1);
//			 out.println("49");
			 PreparedStatement pstmt2= conn.prepareStatement(sql2);
//			 out.println("51");
			 Statement stmt  = conn.createStatement();
//			 out.println("53");
			 pstmt1.setString(1, TestId);
			 pstmt2.setString(1, TestId);
			 ResultSet rs1= pstmt1.executeQuery();
//			 out.println("58");
			 ResultSet rs2= pstmt2.executeQuery();
//			 out.println("59");
			 stmt.executeUpdate(sql3);
			 
			 if(rs1.next()){
				 out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-90 my-3  rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>)"
						 +"<h1 class='text-white text-2xl text-center m-4'>Give Test</h1>");
				 out.println("<form  onsubmit='SubmitTest(event,this)'>"
				 		+ "<input type='hidden' value='"+TestId+"' name='TestId'/>"
				 				+ "<input type='hidden' value='"+StudentId+"' name='StudentId'/>");
				 // this is title box of text
				 out.println("    <div class=' w-fullA  m-auto text-black p-3 text-xl bg-white/50 rounded-md '>"
				 			+"        <div class='m-2 flex'>"
				 			+"            <span class='p-1'>Title:</span>"
				 			+"            <span class='p-1'>"+rs1.getString("TestTitle")+"</span>"
				 			+"        </div>"
				 			+"        <div class='m-2 flex'>"
				 			+"            <span class='p-1'>Course:</span>"
				 			+"            <span class='p-1'>"+rs1.getString("Course")+"</span>"
				 			+"        </div>"
				 			+"        <div class='m-2 flex'>"
				 			+"            <span class='p-1'>Branch:</span>"
				 			+"            <span class='p-1'>"+rs1.getString("Branch")+"</span>"
				 			+"        </div>"
				 			+"    </div>");
				 //this is questions boxes
				 int i=0;
				 if(rs2.next()){
					 do{
					 out.println("    <div class=' w-fullA  mx-auto my-3 text-black p-3 text-xl bg-white/50 rounded-md '>"
					 			+"        <div class=' m-2  flex'>"
					 			+"            <span class='p-1'>Q"+(++i)+":</span>"
					 			+"            <span class='p-1'>"+rs2.getString("Question")+"</span>"
					 			+"        </div>"
					 			+"        <div class=' m-2  flex'>"
					 			+"            <input type='radio' name='ans"+i+"' class='my-3 mx-1 radio-size' value='1' id='"+i+"op1'>"
					 			+"            <label for='"+i+"op1' class='p-1'>"+rs2.getString("Option1")+"</label>"
					 			+"        </div>"
					 			+"        <div class=' m-2  flex'>"
					 			+"            <input type='radio' name='ans"+i+"' class='my-3 mx-1 radio-size' value='2' id='"+i+"op2'>"
					 			+"            <label for='"+i+"op2' class='p-1'>"+rs2.getString("Option2")+"</label>"
					 			+"        </div>"
					 			+"        <div class=' m-2  flex'>"
					 			+"            <input type='radio' name='ans"+i+"' class='my-3 mx-1 radio-size' value='3' id='"+i+"op3'>"
					 			+"            <label for='"+i+"op3' class='p-1'>"+rs2.getString("Option3")+"</label>"
					 			+"        </div>"
					 			+"        <div class=' m-2  flex'>"
					 			+"            <input type='radio' name='ans"+i+"' class='my-3 mx-1 radio-size' value='4' id='"+i+"op4'>"
					 			+"            <label for='"+i+"op4' class='p-1'>"+rs2.getString("Option4")+"</label>"
					 					+ "<input type='radio' checked name='ans"+i+"' class='my-3 hidden mx-1 radio-size' value='0' id='"+i+"op5'>"
					 			+"        </div>"
					 		
					 			+"    </div>");
					 }while(rs2.next());
					 out.println("<div class='flex justify-center'>"
                +"<button class='text-white py-1 px-5 rounded text-2xl m-5  bg-blue-600 hover:bg-blue-700' >Submit</button>"
            +"</div>");
					 out.println("</form>");
				 }else{
					 out.println(" <div class='w-fullA  mx-auto my-3 text-black p-3 text-xl bg-white/50 rounded-md '>");
					 out.println("<h1 class='text-center'>No Questions Available In This Test</h1>");
					 out.println("</div>");
				 }
				 
				 
				 	
				 out.println("</div>");
			 }else{
				 
			 }
			 
			 
			 
			 
			 
			 
		}catch(Exception e){
			out.println(e);
		}
		
	}

}
