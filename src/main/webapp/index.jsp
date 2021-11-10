

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="api.Api"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumo de Api desde payana</title>
    </head>
    <body>
        
        <a href="Prueba.jsp">Regresar al Menu</a>
        <h1>Consumir ver desde payana 1</h1>
     
        <form action="/ApiPayana/Servlet" method="post">
            <br>
            <input type="text" name="nombre" value="Buscar Personaje"/>
            
            <input type="submit" value="Buscar"/>

        </form>
        
        <br/>
        <form action="/ApiPayana/Servlet" method="get">      
  <input type="submit" value="Mostrar Todos"/>
        </form>
        
    </body>
</html>
