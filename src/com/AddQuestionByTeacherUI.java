package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddQuestionByTeacher
 */
@WebServlet("/AddQuestionByTeacherUI")
public class AddQuestionByTeacherUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionByTeacherUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		String testId= request.getParameter("testId");	
		
		out.println("<div style='background-color: rgba(0,0,0,0.5);' class=' border-black w-fullA md:w-1/3 hiddenScrollBar  overflow-y-auto font-Lato h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2'>"
			    +"<h1 class='text-white text-2xl mt-3 text-center'>Add Test Questions</h1>"
			    +"<div id='errorbox' class='hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto'>"
			        +"Username/Password is wrong"
			    +"</div>"
			    +"<div id='successbox' class='hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto'>"
			        +"Details Updated successfully"
			    +"</div>"
			    +"<div class='m-7 sm:mx-12'>"
			        +"<p class='text-white mb-1 text-xl'>Enter Test Question </p>"
			        +"<input type='text' id='testQuestionInp' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'>"
			        +"<input type='hidden' value='"+testId+"' id='testId'>"
			    +"</div>"
			    +"<div class='mx-7 my-2 sm:mx-12 sm:my-2  '>"
			        +"<p class='text-white mb-1 text-xl'>Enter Test Options</p>"
			        +"<input type='text' id='option1' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter option 1'>"
			    +"</div>"
			    +"<div class='m-7 sm:mx-12'>"
			        +"<input type='text' id='option2' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter option 2'>"
			    +"</div>"
			    +"<div class='m-7 sm:mx-12'>"
			        +"<input type='text' id='option3' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter option 3'>"
			    +"</div>"
			    +"<div class='m-7 sm:mx-12'>"
			        +"<input type='text' id='option4' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter option 4'>"
			    +"</div>"
			    +"<div class='m-7 sm:mx-12'>"
			        +"<p class='text-white mb-1 text-xl'>Enter Test Question </p>"
			        +"<!-- <input type='text' id='usernameInp' name='userName' class='p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none' placeholder='Enter Username'> -->"
			        +"<select name='' id='optionSelect' class='bg-white border-b-4 rounded-md border-black  input p-2  text-black/70 text-xl w-full focus:outline-none'>"
			            +"<option value='1'>Option1</option>"
			            +"<option value='2'>Option2</option>"
			            +"<option value='3'>Option3</option>"
			            +"<option value='4'>Option4</option>"
			        +"</select>"
			    +"</div>"
			    +"<div class='m-7 mx-12'>"
			        +"<input type='submit' id='Update' value='Add Question' onclick='addQuestion()' class='bg-blue-600 text-white py-2 text-xl px-4 rounded-md  block w-1/2  m-auto hover:bg-blue-700'>"
			    +"</div>"
			+"</div>");
		
	}

}
