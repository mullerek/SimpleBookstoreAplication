<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Add ksiazke</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
</head>
<body>
<div class="rejestracja">
	
	
	<table>
	<tr>
	<td colspan="2"><h2>Dodawanie ksiazki do bazy danych</h2></td>
	</tr>
	
	<tr>
	<td><label>Tytul</label></td>
	<td><input type="text" id="tytul"></td>
	</tr>
	
	<tr>
	<td><label>Autor</label></td>
	<td><input type="text" id="autor"></td>
	</tr>
	
	<tr>
	<td><label>Cena</label></td>
	<td><input type="text" id="cena"></td>
	</tr>
	
	<tr>
	<td><label>Ilosc</label></td>
	<td><input type="text" id="ilosc"></td>
	</tr>
	
	<tr>
	<td><label>Id kategorii</label></td>
	<td><input type="text" id="id_kat"></td>
	</tr>
	
	<tr>
	<td><label>Id wydawnictwa</label></td>
	<td><input type="text" id="id_wyd"></td>
	</tr>
	
	<tr>
	<td colspan="2"><p><button type="submit">Dodaj</button><p></td>
	</tr>
	
	
	</table>
	
</div>
</body>
</html>