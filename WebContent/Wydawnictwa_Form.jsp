<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
</head>
<body>
<c:import url="/menu"/>


<div class="container col-md-5">
<c:forEach var="el" items="${tk}">
<p>${wydanictwa}</p>
</c:forEach>
<c:if test="${wydawnictwa.id_wyd > 0}">
<form action="Wyd?action=updateWyd" method="get">
<input type="hidden" name="action" value="updateWyd" />
</c:if>
<c:if test="${(wydawnictwa.id_wyd == null) || (wydawnictwo.id_wyd==0)}">
<form action="Wyd?action=insertWyd" method="get">
<input type="hidden" name="action" value="insertWyd" />
</c:if>
<h3>
<c:if test="${wydawnictwa.id_wyd> 0}">Edytuj Wydawnictwa</c:if>
<c:if test="${wydawnictwa.id_wyd== null}">Add New User</c:if>
</h3>

<c:if test="${wydawnictwa.id_wyd> 0}">
<input type="hidden" name="id" value="${wydawnictwa.id_wyd}" />
</c:if>
<fieldset>
<label>Nazwa</label>
<input type="text" value="${wydawnictwa.nazwa}" name="nazwa" required="required">
</fieldset>

<button type="submit" class="btn btn-success" style="margin: 0 auto;">Save</button>
</form>



</div>
</div>

</body>
</html>