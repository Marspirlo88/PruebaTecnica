
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="api.Constructor"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="index.jsp">Regresar al Menu</a>


        <c:forEach  items="${lista}" var="lista">

            <div >
                <c:out value="${lista.id}"></c:out>
                    <br/>
                <c:out value="${lista.nombre}"></c:out>
                    <br/>
                <c:out value="${lista.status}"></c:out>    
                    <br/>
                <c:out value="${lista.specie}"></c:out>
                    <br/>
                <c:out value="${lista.gender}"></c:out>
                    <br/>
                    <img  src="<c:url value="${lista.imagen}"></c:url>"> </img>
                </div>
                <br/>



        </c:forEach>
        <nav>
            <c:forEach  items="${lista}" var="lista">
                <span>
                    <form action="/ApiPayana/Servlet" method="post">
                        <input type="hidden" name="nombre" value="${lista.nombre}"/>
                        <input type="submit" value="<c:out value="${lista.nombre}"></c:out>"/>
                        </form>
                    </span>
            </c:forEach>       
        </nav>

        <c:forEach  items="${lista2}" var="lista2">
            <div>
                <c:out value="Pruebaquesierve"></c:out>
                <c:out value="${lista2.id}"></c:out>
                    <br/>
                <c:out value="${lista2.nombre}"></c:out>
                    <br/>
                <c:out value="${lista2.status}"></c:out>    
                    <br/>
                <c:out value="${lista2.specie}"></c:out>
                    <br/>
                <c:out value="${lista2.gender}"></c:out>
                    <br/>
                    <img  src="<c:url value="${lista2.imagen}"></c:url>"> </img>


            </c:forEach>
            <form action="/ApiPayana/Servlet" method="get">      
                <input type="submit" value="Regresar"/>
            </form>

            <a href="index.jsp">Menu</a>
        </div>



    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
