<%@page import="ucam.servlets.AltaVideojuegos"%>
<%@page import="java.util.Hashtable"%>
<%@page import="ucam.objetos.Categoria"%>
<%@page import="ucam.objetos.Videojuegos"%>
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
Crear Videojuego:
<form action = "\rubengomezpratctica1/altavideojuegos" method="post">

	Nombre del videojuegos:<input type="text" name="<%= AltaVideojuegos.VARIABLE_VIDEOJUEGO%>"><br>
	
	
	<select name=<%=Categoria.PARAM_CATEGORIA %>>
    <option>Escoge una categoria</option>
    <% Hashtable<String,Categoria> contenedorCategorias= (Hashtable<String,Categoria>)request.getServletContext().getAttribute(Login.ATR_CATEGORIAS);
       for(Categoria c: contenedorCategorias.values()){
     %>
     <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
     <%
     } 
     %>
     
         <input type="checkbox" name="<%=AltaVideojuegos.VARIABLE_VENTA %>" value= "true"> Venta
         <input type="checkbox" name="<%=AltaVideojuegos.VARIABLE_ALQUILER %>" value ="true"> Alquiler<br>
     
 <input type="submit">
</select>

</form> 
<br><br><br><br>


Eliminar Videojuego:
</form> 
<form action = "\rubengomezpratctica1/borrarvideojuego" method="post">
               
	
	<select name=<%=AltaVideojuegos.VARIABLE_VIDEOJUEGO %>>
    <option>Escoge un videojuego</option>
    <% Hashtable<String,Videojuegos> contenedorVideojuegos= (Hashtable<String,Videojuegos>)request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);
       for(Videojuegos c: contenedorVideojuegos.values()){
     %>
     <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
     <%
     } 
     %>   
 <input type="submit">
</select>	
</form> 
<br><br><br><br>


Modificar Videojuego:
<form action = "\rubengomezpratctica1/modificarvideojuego" method="post">
               
	
	<select name=<%=AltaVideojuegos.VARIABLE_VIDEOJUEGO %>>
    <option>Escoge un videojuego</option>
    <% Hashtable<String,Videojuegos> contenedorVideojuego= (Hashtable<String,Videojuegos>)request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);
       for(Videojuegos c: contenedorVideojuego.values()){
     %>
     <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
     <%
     } 
     %> 
     <input type="checkbox" name="<%=AltaVideojuegos.VARIABLE_VENTA %>" value= "true"> Venta
     <input type="checkbox" name="<%=AltaVideojuegos.VARIABLE_ALQUILER %>" value ="true"> Alquiler<br>  
 <input type="submit">
</select>	
</form> 








</body>
</html>