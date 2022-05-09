<%@page import="ucam.servlets.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta usuario</title>
</head>
<body>

<%
      if(request.getAttribute(Login.MENSAJE)!=null){
    	  out.println(request.getAttribute(Login.MENSAJE));
      }else{
    	  out.println("Pagina de REGISTRO");
      }
       

%>
<br>



<form action = "\rubengomezpratctica1/altausuario" method="post">
         
    Usuario:<input type="text" name="<%= Login.PARAM_NOMBRE%>" value="admin">
	Clave:<input type="text" name="<%= Login.PARAM_CLAVE %>" value="admin"><br>
	<input type="submit">
</form> 

</body>
</html>