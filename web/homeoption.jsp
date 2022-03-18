<%-- 
    Document   : homeoption
    Created on : Mar 9, 2022, 8:49:21 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/HomeOption.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Hãy chọn tính năng </h1>
        <div class="imgmanage">
            <img src="img/stockmanage.png" alt="loi anh kho"/>
        <form action="stocklist" method="GET"> <input type="submit" value="Quản Lý Kho"/> </form>
</div>    
        <div class="imgcaculator">
            <img src="img/caculator.png" alt="loi anh may"/>
        <form action="home" method="GET"> <input type="submit" value="Tính Hóa Đơn"/> </form>
        </div>
    </body>
</html>
