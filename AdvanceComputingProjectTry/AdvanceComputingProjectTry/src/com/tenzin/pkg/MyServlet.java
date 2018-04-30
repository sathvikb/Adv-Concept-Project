package com.tenzin.pkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("welcome chodus");
		String username = request.getParameter("uname");
		String password = request.getParameter("passw");
		if(username.equals("tenzin") && password.equals("tenzin")) {
			response.sendRedirect("Search.jsp");
			
			
//			response.setContentType("text/html");
//			//PrintWriter out = response.getWriter();
//			String fileName = "/Users/Ten-Thinlay/Desktop/assignment4.pdf";
//			String mainFile = "assignment4.pdf";
//			response.setContentType("APPLICATION/PDF");
//			response.setHeader("Content-Disposition", "inline; fileName = /"+mainFile+"/");
//			FileInputStream fi = new FileInputStream(fileName);
//			int i;
//			while((i =fi.read()) != -1) {
//				out.write(i);
//				fi.close();
//				out.close();
//			}
//			
			
			
		}
		else {
			response.sendRedirect("index.jsp");
		}
//		out.println("<h1> how you doing</h1>");
//		out.write("<h1> how you doing</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
