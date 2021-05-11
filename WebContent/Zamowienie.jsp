<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Koszyk</title>
<link rel="stylesheet" href="styles.css" type="text/css" >
</head>
<body>
<c:import url="/menu"/>
<h3 style="display:${zakryj};">Zaloguj się aby zrealizować zamówienie..
<a href="zaloguj.jsp">zaloguj</a></h3>
<div style="display:none; display:${zakryj3};">
<h3>Dane zamawiającego:</h3>
<p>Imię i nazwisko: <b>${user.imie} ${user.nazwisko}</b></p>
<p>Ulica: <b>${user.ulica}</b></p>
<p>Kod pocztowy, miejscowość <b>${user.kod_pocztowy} ${user.miejscowosc}</b></p>
<p>Adres mailowy: <b>${user.email}</b></p>

<h3>Twój koszyk:</h3>
<table cellpadding="2"  border="1"id="oferta">
<thead>
		<tr>
			<th>Pozycja</th>
			<th>Tytuł</th>
			<th>Autor</th>
			<th>Cena</th>
			<th>Ilość</th>
			
		</tr>
</thead>
		<c:forEach var="item" items="${sessionScope.cart }">
			
			<tr>
				<td align="center">
					<a href="cart?action=remove&id=${item.id_ksiazki}"
					onclick="return confirm('Czy na pewno chcesz usunąć wybraną pozycję?')">Usuń</a>
				</td>
				<td>${item.tytul}</td>
				<td>${item.autor }</td>
				<td>${item.cena}</td>
				<td>${item.ilosc_w_koszyku}</td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Łącznie: ${total} zł</td>
		</tr>
	</table>
<p></p>
<p></p>
	<br>
  
    <form action="zamowienie" id="formularz">
  	
  	<h3>Forma dostawy:</h3><br>
  	<input type="radio" id="scales" name="scales" value="Kurier (+15zł)" checked>
 	 <label for="scales">Kurier (+15zl)</label>
  
  <input type="radio" id="scales" name="scales" value="Poczta (+10zł)">
  <label for="scales">Poczta (+10zl)</label>
  
   <input type="radio" id="scales" name="scales"value="Odbiór osobisty (0zł)">
  <label for="scales">Odbior osobisty (0zl)</label>
	
	
	<h3>Forma platnosci:</h3><br>
  	<input type="radio" id="platnosc" name="platnosc" value="Blik" checked>
 	 <label for="platnosc">Blik</label>
  
  <input type="radio" id="platnosc" name="platnosc"value = "Przelew">
  <label for="platnosc">Przelew</label>
  

	<button type=submit>Zamów </a></button><h6>(może to potrwać kilka sekund)</h6>
	</form>

	</div>
</body>
</html>