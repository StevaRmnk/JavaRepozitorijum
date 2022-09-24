package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormPairsController extends HttpServlet {
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prvaRec = (String) request.getParameter("prvaRec");
		String drugaRec = (String) request.getParameter("drugaRec");
		
		request.setAttribute("prvaRec1", prvaRec);
		request.setAttribute("drugaRec1", drugaRec);
		
		RequestDispatcher rd = request.getRequestDispatcher("ispisiRezultat.jsp");
		rd.forward(request, response);
		
	}

}
