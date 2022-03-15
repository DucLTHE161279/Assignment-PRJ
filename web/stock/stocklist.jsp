<%-- 
    Document   : stocklist
    Created on : Mar 9, 2022, 10:21:28 PM
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
  Integer pageindex =(Integer)request.getAttribute("pageindex");
  Integer totalpage=(Integer)request.getAttribute("totalpage");
    
    
    %>
    <script src="js/pagger.js" type="text/javascript"></script>
    <link href="css/pagger.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     
        <table border ="1px">
            
            <tr>
               <td>ID</td>
                <td>Product</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Date</td>
                    <td> Import Quantity</td>
                    <td> Sold</td>
                    <td> </td>
                      
            </tr>
            <%
            for(Product p: products){
              %>
                 <tr>
                     <td><%=p.getId()%></td>
                <td><%=p.getName()%></td>
              <td><%=p.getPrice()%></td>
              <td><%=p.getQuantity()%></td>
              
              <td><%=p.getDate()%></td>
              <td><%=p.getImports()%></td>
               <td><%=p.getSold()%></td>
              
              <td> </td>
           
              <td><a href="update?id=<%=p.getId()%>">Update</a></td>
       
                  </tr>
              <%}%>
        </table>
      
        
        
        <a href="insert"><button> Insert the new one</button></a>
        
        
        <a href="importlist"><button>Quản Lý Hàng Nhập Kho</button></a>
        
        
        <div id="container" class="pagger" > </div>
        <script> 
      pagger("container",<%=pageindex%>,<%=totalpage%>,3);
        </script>
      
    </body>
</html>
