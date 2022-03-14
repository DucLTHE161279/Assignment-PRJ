<%-- 
    Document   : update
    Created on : Mar 10, 2022, 4:52:58 AM
    Author     : Dell
--%>

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
        Product p=(Product)request.getAttribute("product");
        %>
    </head>
    <body>
        <form action="update" method="Post">
            ID:<input type="text" name="id" value="<%=p.getId()%>"/><br/>
            Name: <input type="text" name="name" value="<%=p.getName()%>"><br/>
            Price:<input type="text" name="price" value="<%=p.getPrice()%>"><br/>
            Quantity:<input type="text" name="quantity" value="<%=p.getQuantity()%>"><br/>
            Date: <input type="date" name="date" value="<%=p.getDate()%>"><br/>
            Import:<input type="text" name="import" value="<%=p.getImports()%>"><br/>
            Sold:<input type="text" name="sold" value="<%=p.getSold()%>"><br/>
            <input type="submit" value="Save">
        </form>
  
    </body>
</html>
