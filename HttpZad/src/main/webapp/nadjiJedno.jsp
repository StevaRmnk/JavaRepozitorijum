<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nadjeno preko id-a</title>
</head>
<body>

<%
int id = (Integer)request.getAttribute("idy");
List<String> rez = (List<String>)request.getAttribute("rez");

out.println("Za id:" + id +  " nadjene su reci: " + rez.get(0) + " i " + rez.get(1) + " rezultat je: " + rez.get(2));

%>

</body>
</html>