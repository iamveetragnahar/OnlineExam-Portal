package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowNoticeAddForm
 */
@WebServlet("/ShowNoticeAddForm")
public class ShowNoticeAddForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		 out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-2/5  hiddenScrollBar  overflow-y-auto font-Lato h-3/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
					+"    <h1 class='text-white text-2xl text-center m-4'>Manage Notices</h1>"
					+"    <div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
					+"        Username/Password is wrong"
					+"    </div>"
					+"    <div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
					+"        Details Updated successfully"
					+"    </div>"
					+"    <form method='POST' action='#' onsubmit='addNotice(event,this)' enctype='multipart/form-data'>"
					+"        <div class='m-7 sm:mx-12  '>"
					+"            <p class='text-white text-xl p-2'>Notice Title:</p>"
					+"            <input type='text' id='' name='NoticeTitle' class='p-2 input field text-black w-full  rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Name Of Student'>"
					+"        </div>"
					+"        <div class='m-7 sm:mx-12 '>"
					+"            <p class='text-white text-xl p-2 '>Select pdf:</p>"
					+"            <input type='file' id='' name='File' class='p-2 input field text-black w-full bg-blue-50 rounded-md focus:border-none focus:box focus:outline-none'>"
					+"        </div>"
					+"        <div class='m-7 mx-12 '>"
					+"            <input type='submit' id='' value='Add Notice' onclick='' class='bg-blue-600 py-2 text-xl px-4 rounded-md text-white block w-1/2 m-auto hover:bg-blue-700 '>"
					+"        </div>"
					+"    </form>"
					+"</div>");
		
	}

}
