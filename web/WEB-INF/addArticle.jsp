<%-- 
    Document   : addArticle
    Created on : Jan 25, 2018, 2:34:19 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Новая статья</h1>
        <form action="controller?command=newArticle" method="POST">
            Заголовок: <input type="text" name="title"/><br>
            Текст: <textarea name="text"></textarea><br>
            <input type="submit" value="Добавить статью"/>
        </form>
    </body>
</html>
