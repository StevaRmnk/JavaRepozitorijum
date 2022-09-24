package com.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paket.Metode;


public class GetOneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id =Integer.parseInt(request.getParameter("idb")) ;
		
		List<String> rez =  Metode.ucitajReciZaPoredjenjeIRezultatPrekoIda(id);
		
		request.setAttribute("idy", id);
		request.setAttribute("rez", rez);
		
		RequestDispatcher rd = request.getRequestDispatcher("nadjiJedno.jsp");
		rd.forward(request, response);
		
		
		
	}


}
