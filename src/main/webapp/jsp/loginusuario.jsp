<%@page import="ucam.servlets.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login usuario</title>
</head>
<body>

<%
      if(request.getAttribute(Login.MENSAJE)!=null){
    	  out.println(request.getAttribute(Login.MENSAJE));
      }else{
    	  out.println("Pagina de LOGIN");
      }
       

%>
<br>



<form action = "\rubengomezpratctica1/login" method="post">
         
    User:<input type="text" name="<%= Login.PARAM_NOMBRE%>" value="admin">
	Pass:<input type="text" name="<%= Login.PARAM_CLAVE %>" value="admin"><br>
	<input type="submit">
</form> 
</body>
</html>