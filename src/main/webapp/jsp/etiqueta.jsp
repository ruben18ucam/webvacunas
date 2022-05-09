<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ucam.servlets.Login"%>
<%@page import="ucam.objetos.Videojuegos"%>
<%@page import ="java.util.*, java.sql.*" %>
<%@ taglib uri="mistags" prefix="dad2" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%System.out.println((String) pageContext.getRequest().getParameter(Login.PARAM_VALORACION)); %>
<%System.out.println((String) pageContext.getRequest().getParameter(Login.PARAM_NOMBREVIDEOJUEGO)); %>

<dad2:hacervaloracion nombreVideojuego="admin" nombreCliente="admin"  valoracion="5" />

<a href="\rubengomezpratctica1/loggin">Volver</a><br>
</body>
</html>