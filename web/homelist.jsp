<%-- 
    Document   : homelist
    Created on : Mar 8, 2022, 8:10:13 AM
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
    ArrayList<Product> products= (ArrayList<Product>)request.getAttribute("products");
 
    %>
    </head>
    <body>
      
        <table border ="1px">
            
            <tr>
                <td>Product</td>
                    <td>Price</td>
                        <td></td>
            </tr>
            <%
            for(Product p: products){
              %>
                 <tr>
                <td><%=p.getName()%></td>
              <td><%=p.getPrice()%></td>
              <td>
                  <form action="addcart" method="POST">
                      <input type="hidden" value="<%=p.getId()%>" name="id"/>
                  <input type="submit" value="Buy">
                    </form>
              </td>
       
                  </tr>
              <%}%>
        </table>
    </body>
</html>
