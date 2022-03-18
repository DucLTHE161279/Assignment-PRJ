<%-- 
    Document   : insertimport
    Created on : Mar 16, 2022, 3:17:28 PM
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
        ArrayList<ImportManage> importmanage =(ArrayList<ImportManage>)request.getAttribute("importmanage");
        %>
        <link href="css/background.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="insertimport" method="Post">
         
            Mã số nhập: <input type="text" name="importid"><br/>
            Ngày nhập:<input type="date" name="importdate"><br/>
            Ghi chú:<input type="text" name="importnote"><br/>
            <input type="submit" value="Save">
        </form>
  
    </body>
</html>
