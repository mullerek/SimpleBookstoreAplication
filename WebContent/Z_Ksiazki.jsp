
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Zarzadzaj ksiazkami</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<body>
<c:import url="/menu"/>

<br>
<a  href="Ksi?action=newKsi" id="new" style="margin-left:5%;">Dodaj Ksiazke </a>
<br>
<br>
<table id="oferta">
<thead>
<tr >
<td>Tytul</td>
<td>Autor</td>
<td>Cena</td>
<td>Ilosc</td>
<td>Id_kat</td>
<td>Id_wyd</td>

<td colspan=2>Akcja</td>
</tr>
</thead>
<c:forEach var="el" items="${listKsiazki}">
<tr>
               <td> ${el.tytul}  </td>
                <td> ${el.autor} </td>
                <td>  ${el.cena}  </td>
                <td>  ${el.ilosc}  </td>
                <td>  ${el.id_kat}  </td>
                <td>  ${el.id_wyd}  </td>
                 <td> <a href="Ksi?action=editKsi&id=${el.id_ksiazki}" >Edytuj</a></td>
                    
                        
                  	<td><a href="Ksi?action=deleteKsi&id=${el.id_ksiazki}">Usun</a></td>
                
              </tr>
            </c:forEach>
</table>
</body>
</html>