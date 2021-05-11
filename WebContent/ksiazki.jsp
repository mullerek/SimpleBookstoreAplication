<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Oferty</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<c:import url="/menu"/>
<h3>Oferty:</h3>
<table id="oferta" style="display:${display};">
<thead>
        <tr>
			<td >Tytul</td>
			<td>Autor</td>
			<td>Cena</td>
			<td>Ilość</td>
			<td></td>
		</tr>
    </thead>
		
		<c:forEach var="el" items="${tk}">
		<tr>
		<td >${el.tytul}</td>
		<td>${el.autor}</td>
		<td>${el.cena}</td>
		<form action="cart" method ="get">
		<input type='hidden' name='action' value='buy'>
		<input type='hidden' name='id' value='${el.id_ksiazki }'>		
		<td><input class="form-control search-field" type="text" id="search-field" name="ilosc" style="background-color: white;text-align: center;" value="1"></td>
		<td><input type="submit" class="btn btn-primary btn-block" value="Dodaj do koszyka"></td></form>
		</c:forEach>
	
</table>

<h3 style="color:red; ">${error}</h3>
		
</body>
</html>