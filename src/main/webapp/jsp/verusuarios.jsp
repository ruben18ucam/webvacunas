<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ucam.servlets.Login"%>
    <%@page import="ucam.objetos.Usuarios"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hacer administrador:
<form action = "\rubengomezpratctica1/modificarusuario" method="post">

	
	<select name=<%=Usuarios.PARAM_NOMBREE %>>
    <option>Escoge un usuario</option>
    <% Hashtable<String,Usuarios> contenedorUsuarios = (Hashtable<String,Usuarios>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);

       for(Usuarios c: contenedorUsuarios.values()){
     %>
     <option value="<%=c.getNombreUsuario()%>"><%=c.getNombreUsuario()%></option>
     <%
     } 
     %>   
 <input type="submit">
</select>	
</form> 



<br><br><br>
Eliminar Usuario:
<form action = "\rubengomezpratctica1/eliminarusuario" method="post">
	<select name=<%=Usuarios.PARAM_NOMBREE %>>
    <option>Escoge un usuario</option>
    <% Hashtable<String,Usuarios> contenedorUsuario = (Hashtable<String,Usuarios>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);

       for(Usuarios c: contenedorUsuario.values()){
     %>
     <option value="<%=c.getNombreUsuario()%>"><%=c.getNombreUsuario()%></option>
     <%
     } 
     %>   
 <input type="submit">
</select>	
</form> 


</body>
</html>