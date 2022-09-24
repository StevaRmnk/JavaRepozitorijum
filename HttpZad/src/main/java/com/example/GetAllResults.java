package com.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paket.Metode;
import paket.RezultatKlasa;


public class GetAllResults extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<RezultatKlasa> sviRezultati = Metode.ucitajSveRezultate();
		
		request.setAttribute("sviRezultati", sviRezultati);
		
		RequestDispatcher rd = request.getRequestDispatcher("allResults.jsp");
		rd.forward(request, response);
	}


}
