<%@page import="java.util.List"%>
<%@page import="paket.Metode"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rezultat za reci</title>
</head>
<body>

<%

String prvaRec = (String)request.getAttribute("prvaRec1");
String drugaRec = (String)request.getAttribute("drugaRec1");
List<String>konacno = Metode.sacuvajReciIDajRezultat(prvaRec, drugaRec);
out.println("Za reci: " + konacno.get(0) + " i " + konacno.get(1) + " rezultat je: " + konacno.get(2));

%>

</body>
</html>