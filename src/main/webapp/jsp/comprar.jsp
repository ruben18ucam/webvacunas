<%@page import="java.util.Hashtable"%>
<%@page import="ucam.servlets.Login"%>
<%@page import="ucam.objetos.Videojuegos"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprar</title>
</head>
<body>

<%

Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String,Videojuegos>) request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);
int i=0;
if(contenedorVideojuegos.size()>0 && contenedorVideojuegos!=null){
	for(Videojuegos v: contenedorVideojuegos.values() ){
		if(v.isVenta()==true){
			
			out.println(v.getNombre()+" "+v.getCategorias()+"               ");
		}
		%><br><br><%
	}
	
}
System.out.println(request.getSession().getAttribute(Login.ATR_USUARIO)+"              fkjfsljgkfffffffffffff");
//request.getServletContext().setAttribute(Login.PARAM_NOMBRE, request.getSession().getAttribute(Login.PARAM_NOMBRE));
%>

<br><br><br><br>
Valorar:
<form action = "etiqueta.jsp" method="post">
			<input type ="hidden" name="<%=Login.PARAM_NOMBRE%>" value =<%=request.getSession().getAttribute(Login.ATR_USUARIO) %>>
			Nombre Videojuego:<input type="text" name="<%= Login.PARAM_NOMBREVIDEOJUEGO %>" value="fifa">
			Valoracion:<input type="text" name="<%= Login.PARAM_VALORACION %>" value="5">
			<input type="submit">
			<br><br><br>
		</form> 



</body>
</html>