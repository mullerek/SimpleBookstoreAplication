<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Zaloguj</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
</head>
<body>
<c:import url="/menu"/>
<div class="login-clean">
        <form method="post" action="login" style="width:300px;margin:0 auto; margin-top:50px;">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><i class="icon ion-ios-book-outline" style="border-style: none;border-color: var(--blue);background: white;color: var(--blue);"></i></div>
            <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Login"  required></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Hasło"  required ></div>
            <div class="form-group"><p style="color:red;">${error}</p></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background: var(--blue);">Zaloguj</button></div>
        </form>
    </div>
</body>
</html>