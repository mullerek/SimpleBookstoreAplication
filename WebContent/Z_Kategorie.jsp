
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Zarzadzaj Kategorie</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<c:import url="/menu"/>

<br>
<a  href="Kat?action2=newKat" id="new">Dodaj Kategorie</a>
<br>
<br>
<table id="oferta">
<thead>
<tr>
<td>Nazwa</td>
<td colspan=2> Akcja </td>
</tr>
</thead>
<c:forEach var="el" items="${listKategorie}">
<tr>
                <td>${el.nazwa}</td>
                  <td>  <a href="Kat?action2=editKat&id=${el.id_kat}" >Edytuj</a></td>
                  <td>	<a href="Kat?action2=deleteKat&id=${el.id_kat}">Usun</a></td>
                </tr>
            </c:forEach>
</table>
</body>
</html>