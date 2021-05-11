<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Rejestracja</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
</head>
<body>
<c:import url="/menu"/>

	
	
	
	
	<div class="login-clean">
        <form method="post" action="User?action=insertUser" style="width:300px;margin:0 auto; margin-top:50px;">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><i class="icon ion-person-add" style="color: blue; font-size:25px;"></i></div>
            <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Login" required/></div>
            <div class="form-group"><input class="form-control" type="password" name="haslo" placeholder="Hasło" required/></div>
      
            <div class="form-group"><input class="form-control" type="text" name="imie" placeholder="Imie"  pattern="[A-Za-z]{1,32}" required/></div>
            <div class="form-group"><input class="form-control" type="text" name="nazwisko" placeholder="Nazwisko" pattern="[A-Za-z]{1,32}" required/></div>
            <div class="form-group"><input class="form-control" type="text" name="miejscowosc" placeholder="Miejscowość" required/></div>
            <div class="form-group"><input class="form-control" type="text" name="ulica" placeholder="Ulica" required/></div>
            <div class="form-group"><input class="form-control" type="text" name="kod_pocztowy" maxlength="6" placeholder="Kod pocztowy" required/></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="E-mail" required/></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background: var(--blue);">Zarejestruj</button></div>
        </form>
    </div>
<
</body>
</html>


