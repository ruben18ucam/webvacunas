<%@page import="java.util.Hashtable"%>
<%@page import="ucam.objetos.Categoria"%>
<%@page import="ucam.servlets.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Anadir/Eliminar categoria</title>
</head>
<body>

Anadir categoria:
<form action = "\rubengomezpratctica1/altacategoria" method="post">

	Nombre de la categoria:<input type="text" name="<%= Categoria.PARAM_CATEGORIA %>"><br>
	<input type="submit">
	
</form> 
<br><br><br>
Eliminar categoria:
<form action = "\rubengomezpratctica1/borrarcategoria" method="post">

	
	<select name=<%=Categoria.PARAM_CATEGORIA %>>
    <option>Escoge una categoria</option>
    <% Hashtable<String,Categoria> contenedorCategorias= (Hashtable<String,Categoria>)request.getServletContext().getAttribute(Login.ATR_CATEGORIAS);
       for(Categoria c: contenedorCategorias.values()){
     %>
     <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
     <%
     } 
     %>   
 <input type="submit">
</select>	
</form> 

</body>
</html>