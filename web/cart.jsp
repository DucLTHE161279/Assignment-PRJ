<%-- 
    Document   : cart
    Created on : Feb 27, 2022, 11:27:16 PM
    Author     : Dell
--%>

<%@page import="model.OrderDetail"%>
<%@page import="model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        Order order= (Order)session.getAttribute("shoppingcart");
        float totaldiscounted= order.getTotal()-order.getTotal()/4;
        %>
    </head>
    <body>
      
   
        <%if(order!=null){%>
          <table border ="1px">
            
            <tr>
                <td>Mặt hàng</td>
                    <td>Số lượng</td>
                        <td> Giá mỗi mặt hàng</td>
                        <td> Tổng tiền</td>
            </tr>
            <%
            for(OrderDetail od: order.getDetails()){
              %>
                 <tr>
                <td><%=od.getProduct().getName()%></td>
              <td><%=od.getQuantity()%></td>
              <td>
                   <%=od.getUnitPrice()%>
              </td>
                <td>
                   <%=od.getTotal()%>
              </td>
     
                  </tr>
              <%}%>
              <tr>
                  <td colspan="3">Giá cho khách bán lẻ </td>
                  <td ><%=order.getTotal()%></td>                  
              </tr>
              <tr>
                  <td>  Giá sau khi chiết khấu cho đại lý  là   </td>
                  <td><%=totaldiscounted%></td>   
              </tr>
        </table>
              
            
              <a href="resetorder">Tính đơn hàng mới </a>
            
              
           
              <%}else{%>
              you did not buy anything .
              <%}%>
            
              
    </body>
</html>
