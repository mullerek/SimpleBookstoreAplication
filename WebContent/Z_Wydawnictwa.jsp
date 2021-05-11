
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Zarzadzaj Wydawnictwa</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<c:import url="/menu"/>

<br>
<a  href="Wyd?action=newWyd" id="new">Dodaj Wydawnictwo</a>
<br>
<br>
<table id="oferta">
<thead>
	<tr>
	<td>Nazwa</td>
	<td colspan=3>Akcja</td>
	</tr>
	</thead>
<c:forEach var="el" items="${listWydawnictwa}">
<tr>
                <td>${el.nazwa}</td>
                    
                  <td>  <a href="Wyd?action=editWyd&id=${el.id_wyd}" >Edytuj</a></td>
                  <td>	<a href="Wyd?action=deleteWyd&id=${el.id_wyd}">Usun</a></td>
  </tr>             
            </c:forEach>
</table>
</body>
</html>