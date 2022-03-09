<%-- 
    Document   : insert
    Created on : Mar 9, 2022, 9:41:07 PM
    Author     : Dell
--%>

<%@page import="java.sql.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        ArrayList<Product> products =(ArrayList<Product>)request.getAttribute("products");
        %>
    </head>
    <body>
        <form action="insert" method="Post">
            ID:<input type="text" name="id"/><br/>
            Name: <input type="text" name="name"><br/>
            Price:<input type="text" name="price"><br/>
            Quantity:<input type="text" name="quantity"><br/>
            <input type="submit" value="Save">
        </form>
  
    </body>
</html>
