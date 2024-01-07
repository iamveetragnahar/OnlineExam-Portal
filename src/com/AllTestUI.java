package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AllTestUI
 */
@WebServlet("/AllTestUI")
public class AllTestUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllTestUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int index=1;
		try{
			ServletContext context = getServletContext();
			Connection con = (Connection)context.getAttribute("dbcon");
			String sql = "select * from testtitle";
			Statement stmt= con.createStatement();
			ResultSet rs  =stmt.executeQuery(sql);
			
			if(rs.next()){
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
						+"<h1 class='text-white text-2xl text-center m-4'>All Tests</h1>");
					do{
		out.println("<div class='border-2 p-3 my-3 mx-2 md:mx-10   flex flex-col sm:flex-row  sm:justify-between bg-white/50 rounded-xl'>"
					+"<span class='text-black text-xl m-2 '>"+(index++)+". "+rs.getString("TestTitle")+"</span>"
					+"<div>"
					+"<button value='"+rs.getString("ID")+"' class='text-white    bg-blue-600 hover:bg-blue-700 px-3 m-2 text-xl rounded' onclick='addEditTestUI(this)' >Edit</button>"
					+"<button value='"+rs.getString("ID")+"' class='text-white bg-blue-600 hover:bg-blue-700 px-3 m-2 text-xl rounded' onclick='deleteTest(this)' >Delete</button>");
					if(rs.getInt("Status")==1){
						out.println("<button value='"+rs.getString("ID")+"' class='text-white bg-green-600 hover:bg-green-700 px-3 m-2 text-xl rounded' onclick='activeButton(this)' > Active</button>");						
						out.println("<button value='"+rs.getString("ID")+"' class='hidden text-white bg-red-600 hover:bg-red-700 px-3 m-2 text-xl rounded' onclick='notActiveButton(this)' >Not Active</button> ");
					}
					else{						
						out.println("<button value='"+rs.getString("ID")+"' class='hidden text-white bg-green-600 hover:bg-green-700 px-3 m-2 text-xl rounded' onclick='activeButton(this)' > Active</button>");						
						out.println("<button value='"+rs.getString("ID")+"' class='	text-white bg-red-600 hover:bg-red-700 px-3 m-2 text-xl rounded' onclick='notActiveButton(this)'>Not Active</button> ");
					}
					out.println("</div>"
					+"</div>");
						
					}while(rs.next());
					out.print("</div>");
			}
			else{
				out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-3/5 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
						+"<h1 class='text-white text-2xl text-center m-4'>All Tests</h1>");
				out.println("<div class='border-2 p-3 my-3 mx-2 md:mx-10    bg-white/50 rounded-xl'>"
							+"<h1 class='text-black text-2xl text-center'>Currently No test available</h1>"
							+"</div>");
				out.print("</div>");
			}
		}
		catch(Exception e){
			
		}
		
		
		
		
		
	}

}
