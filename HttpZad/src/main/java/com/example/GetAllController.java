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


public class GetAllController extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
List<StringKlasa> sveReci = Metode.ucitajSveReciZaPoredjenje();
		
		request.setAttribute("sveReci", sveReci);

		
		RequestDispatcher rd = request.getRequestDispatcher("PrikaziSveReci.jsp");
		rd.forward(request, response);
	}


}
