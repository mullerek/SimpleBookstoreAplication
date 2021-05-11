<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Koszyk</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<c:import url="/menu"/>
<h2 style="text-align:center;">Zawartość koszyka:</h2>
<table cellpadding="2"  border="1" id="oferta">
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
					onclick="return confirm('Czy na pewno chcesz usunąć wybraną pozycję?')" class="btn btn-primary btn-block" style="background-color:red">Usuń</a>
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
	<br>
	<a href="ksiazki.jsp" class="btn btn-primary btn-block" style="width:100px; margin:0 auto; margin-bottom:5px;">Kontynuuj zakupy</a>
	<c:if test="${total > 0}">
<a href="Zamowienie.jsp" class="btn btn-primary btn-block" style="width:100px; margin:0 auto;">Zrealizuj zamówienie</a>
</c:if>
	
</body>
</html>