<%-- 
    Document   : updateimport
    Created on : Mar 16, 2022, 4:02:21 PM
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
        ImportManage im =(ImportManage)request.getAttribute("oneimportmanage");
        %>
    </head>
    <body>
        <form action="updateimport" method="Post">
         
            Mã số nhập: <input type="text" name="importid"  value="<%=im.getImportid()%>"><br/>
            Ngày nhập:<input type="date" name="importdate" value="<%=im.getImportdate()%>"><br/>
            Ghi chú:<input type="text" name="importnote" value="<%=im.getImportnote()%>"><br/>
            <input type="submit" value="Save">
        </form>
  
    </body>
</html>

