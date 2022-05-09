<%@page import="java.util.Hashtable"%>
<%@page import="ucam.servlets.Login"%>
<%@page import="ucam.objetos.Videojuegos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alquilar</title>
</head>
<body>
<%

Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String,Videojuegos>) request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);

if(contenedorVideojuegos.size()>0 && contenedorVideojuegos!=null){
	for(Videojuegos v: contenedorVideojuegos.values() ){
		if(v.isAlquiler()==true){
			
			out.println(v.getNombre()+" "+v.getCategorias()+"<br>");

		}
	}
}



%>
</body>
</html>