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
    </head>
    <body>
      <form action="login" method="POST">
            Username: <input type="text" name="username" /> <br/>
            Password: <input type="password" name="password"/> <br/>
         
            <input type="submit" value="Login" />
           
        </form>
    </body>
</html>
