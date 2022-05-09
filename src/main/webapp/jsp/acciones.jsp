<%@page import="ucam.servlets.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
if(request.getAttribute(Login.MENSAJE_ACCIONES)==null){
	out.println("Bienvenido  "+request.getSession().getAttribute(Login.ATR_USUARIO)); 
}else{
	out.println(request.getAttribute(Login.MENSAJE_ACCIONES)); 
}




%>



<br>
<a href="jsp/comprar.jsp">Comprar</a><br>
<a href="jsp/alquilar.jsp">Alquilar</a><br>
<a href="jsp/anadirvideojuego.jsp">CRUD videojuego</a><br>
<a href="jsp/anadircategoria.jsp">CRUD categoria</a><br>
<a href="jsp/verusuarios.jsp">CRUD usuarios</a><br>





</body>
</html>