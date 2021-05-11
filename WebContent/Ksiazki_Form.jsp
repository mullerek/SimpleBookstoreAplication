<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<c:import url="/menu"/>


<div class="container col-md-5">
<c:forEach var="el" items="${tk}">
<p>${ksiazki}</p>
</c:forEach>
<c:if test="${ksiazki.id_ksiazki > 0}">
<form action="Ksi?action=updateKsi" method="get">
<input type="hidden" name="action" value="updateKsi" />

</c:if>
<c:if test="${(ksiazki.id_ksiazki== null) || (ksiazki.id_ksiazki==0)}">
<form action="Ksi?action=insertKsi" method="get">
<input type="hidden" name="action" value="insertKsi" />
</c:if>
<h3>
<c:if test="${ksiazki.id_ksiazki> 0}">Edytuj Ksiazki</c:if>
<c:if test="${ksiazki.id_ksiazki== null}">Add New User</c:if>
</h3>

<c:if test="${ksiazki.id_ksiazki> 0}">
<input type="hidden" name="id" value="${ksiazki.id_ksiazki}" />
</c:if>
<fieldset>
<input type="hidden" name="id_ksiazki" value="${ksiazki.id_ksiazki}" />
</fieldset>

<fieldset>
<label>Tytul</label>
<input type="text" value="${ksiazki.tytul}" name="tytul" required="required">
</fieldset>

<fieldset>
<label>Autor</label>
<input type="text" value="${ksiazki.autor}" name="autor" required="required">
</fieldset>

<fieldset>
<label>Cena</label>
<input type="text" value="${ksiazki.cena}" name="cena" required="required">
</fieldset>

<fieldset>
<label>Ilosc</label>
<input type="text" value="${ksiazki.ilosc}" name="ilosc" required="required">
</fieldset>

<fieldset>
<label>Id Kategorii</label>
<input type="text" value="${ksiazki.id_kat}" name="id_kat" required="required">
</fieldset>

<fieldset>
<label>Id Wydawnictwa</label>
<input type="text" value="${ksiazki.id_wyd}" name="id_wyd" required="required">
</fieldset>

<button type="submit" class="btn btn-success" style="margin: 0 auto;">Save</button>
</form>



</div>
</div>

</body>
</html>