package com.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paket.Metode;
import paket.StringKlasa;


public class DeleteOneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("id")) ;
		
		List<String> rez =  Metode.ucitajReciZaPoredjenjeIRezultatPrekoIda(id);
		
		request.setAttribute("idy", id);
		request.setAttribute("rez", rez);
		
		Metode.obrisiReciZaPoredjenjeIRezultatPrekoIda(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("deleteOne.jsp");
		rd.forward(request, response);
	}


}
