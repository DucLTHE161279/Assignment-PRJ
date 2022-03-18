<%-- 
    Document   : login
    Created on : Mar 1, 2022, 11:11:56 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>



    </head>
    <body>
<div class="bg-img">
        <form action="login" method="POST">


            <div class="imgholder1">
                <img class="logo"src="img/103461467_102690458160720_1596495925575421295_n.png" alt="loi anh" class="logo"/>
            </div>
            <input type="text" placeholder="Điền tên tài khoản" name="username" /> <br/>
            <input type="password" placeholder="Điền mật khẩu" name="password"/> <br/>

            <input type="submit" value="Đăng Nhập" />
            <p class="loginfailed">${loginfailed}</p>
        </form>
</div>

    </body>
</html>
