<%@page import="paket.StringKlasa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sve reci za poredjenje</title>
</head>
<body>

<%
List<StringKlasa> sveReci = (List<StringKlasa>)request.getAttribute("sveReci");
for(StringKlasa k : sveReci){
	out.println("ID: "+k.getIdStringa() +" Pocetna rec je: " + k.getPocetnaRec() + " Trazena rec je: "+ 
			 k.getTrazenaRec() + "|");
}

%>

</body>
</html>