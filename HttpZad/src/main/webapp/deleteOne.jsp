<%@page import="paket.Metode"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brisanje</title>
</head>
<body>
<%
int id = (Integer)request.getAttribute("idy");
List<String> rez = (List<String>)request.getAttribute("rez");

out.println("Obrisane reci i rezultat sa id-om: " + id);

%>
</body>
</html>