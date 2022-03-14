<%-- 
    Document   : homelist
    Created on : Feb 27, 2022, 10:45:30 PM
    Author     : Dell
--%>

<%@page import="model.Order"%>
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
   Order order=(Order) session.getAttribute("shoppingcart");
     Integer pageindex =(Integer)request.getAttribute("pageindex");
  Integer totalpage=(Integer)request.getAttribute("totalpage");
    
    if(order==null){
        order =new Order();
    }
    %>
 <script src="js/paggerforshopping.js" type="text/javascript"></script>
 
    
    
    </head>
    <body>
        <%= order.getSize() +" "%> item in the shopping cart.
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
        
           <div id="container" class="pagger" > </div>
        <script> 
      pagger("container",<%=pageindex%>,<%=totalpage%>,3);
        </script>
        
        <a href="cart"><button>Check Out</button></a>
        
        
    </body>
</html>
