<%@page import="paket.RezultatKlasa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>svi rezultati</title>
</head>
<body>
<%

List<RezultatKlasa> sviRezultati =(List<RezultatKlasa>) request.getAttribute("sviRezultati");
for(RezultatKlasa rez : sviRezultati){
	out.println("ID: " + rez.getIdRezultata() + " vrednost: " + rez.getRezultat() + "|");
}

%>

</body>
</html>