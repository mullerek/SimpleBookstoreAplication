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
<p>${kategorie}</p>
</c:forEach>
<c:if test="${kategorie.id_kat > 0}">
<form action="Kat?action2=updateKat" method="get">
<input type="hidden" name="action2" value="updateKat" />
</c:if>
<c:if test="${(kategorie.id_kat == null) || (kategorie.id_kat==0)}">
<form action="Kat?action2=insertKat" method="get">
<input type="hidden" name="action2" value="insertKat" />
</c:if>
<h3>
<c:if test="${kategorie.id_kat> 0}">Edytuj Kategorie</c:if>
<c:if test="${kategorie.id_kat == null}">Add New User</c:if>
</h3>

<c:if test="${kategorie.id_kat> 0}">
<input type="hidden" name="id" value="${kategorie.id_kat}" />
</c:if>
<fieldset>
<label>Id_kat</label>
<input type="text" value="${kategorie.id_kat}" name="id_kat" required="required">
</fieldset>
<label>Nazwa</label>
<input type="text" value="${kategorie.nazwa}" name="nazwa" required="required">
</fieldset>

<button type="submit" class="btn btn-success" style="margin: 0 auto;">Save</button>
</form>



</div>
</div>

</body>
</html>