<%-- 
    Document   : importlist
    Created on : Mar 15, 2022, 11:07:50 PM
    Author     : Dell
--%>

<%@page import="model.ImportManage"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>JSP Page</title>
   
    <%
    ArrayList<ImportManage> importmanage= (ArrayList<ImportManage>)request.getAttribute("importmanage");

    
    
    %>
 
    </head>
    <body>
     
        <table border ="1px">
            
            <tr>
                <td>Mã số nhập</td>
                <td>Ngày nhập</td>
                    <td>Ghi chú</td>
                    <td> </td>
                      
            </tr>
            <%
            for(ImportManage im: importmanage){
              %>
                 <tr>
                     <td><%=im.getImportid()%></td>
                <td><%=im.getImportdate()%></td>
              <td><%=im.getImportnote()%></td>
            
              
        
           
              <td><a href="update?id=<%=im.getImportid()%>">Update</a></td>
       
                  </tr>
              <%}%>
        </table>
      
        
        
        <a href="insert"><button> Insert the new one</button></a>
        
     
      
    </body>
</html>
