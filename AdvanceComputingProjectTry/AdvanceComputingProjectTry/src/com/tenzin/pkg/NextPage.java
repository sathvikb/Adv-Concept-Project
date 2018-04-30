package com.tenzin.pkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextPage
 */
public class NextPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		String fileName = "/Users/Ten-Thinlay/Desktop/webpages/About W3C Standards.txt";
//		response.setContentType("APPLICATION/PDF");
//		response.setHeader("Content-Disposition", "inline: fileName = "+fileName);
//		FileInputStream fi = new FileInputStream(fileName);
//		int i;
//		while((i =fi.read()) != -1) {
//			out.write(i);
//			fi.close();
//			out.close();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
	}

}
