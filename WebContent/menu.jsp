<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-search" style="background-color:orange;">
        <div class="container"><a class="navbar-brand" href="index.jsp"><i class="fas fa-feather-alt"></i></a><a class="navbar-brand" href="index.jsp">Kruczek</a>
            <div class="dropdown show"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#" style="color: var(--dark);height: 40px;width: 90px;">Kategorie</a>
                <div class="dropdown-menu " style="width: auto;">
                
                <c:forEach var="el" items="${tkat}">
		<a class="dropdown-item" href="ListaKsiazekServlet?idkat=${el.id_kat}">${el.nazwa}</a>
		</c:forEach>
                
                
                </div>
            </div><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="kontakt.jsp" style="color: var(--dark);">Kontakt</a></li>
                </ul>
                <form class="form-inline mr-auto" target="_self" action="SzukajKsiazkiServlet" method="get">
                    <div class="form-group">
                    <label for="search-field">
                   <button class="btn btn-primary" type="submit" id="button_szukaj" style="background-color:orange;border-width:0px;"><i class="fa fa-search lupa" style="color: var(--light);"></i></button>
                    </label>
                    <input class="form-control search-field" type="search" id="search-field" name="nazwa" style="background-color: white;width: 300px;text-align: center;" value="Szukaj "></div>
                </form>
                
                <a href="koszyk.jsp"><i class="fa fa-shopping-cart" style="font-size:30px;margin-right:30px;"></i></a>
                <a class="btn btn-light action-button" role="button" href="rejestracja.jsp" style="margin-right: 5px; display:${zakryj};">Rejestracja</a>
                <a class="btn btn-light action-button" role="button"  href="zaloguj.jsp" style="margin-left: 0px; display:${zakryj};">Zaloguj</a>
            </div>
            <div class="dropdown show">
            <a class="dropdown" data-toggle="dropdown" aria-expanded="false" href="#" style="color:white; font-size: 20px;height: 20px;width: 90px; margin-left:10px;">${username}</a>
                <div class="dropdown-menu " style="width: auto;">
                
                
				<a class="dropdown-item" href="wyloguj" style="background-color:#00bfff;'">Wyloguj</a>
				<a class="dropdown-item" href="Ksi?action=listKsi" style="display:${zakryj2};">Ksiazki</a>
				<a class="dropdown-item" href="Wyd?action=listWyd" style="display:${zakryj2};">Wydawnictwa</a>
				<a class="dropdown-item" href="Kat?action2=listKat"style="display:${zakryj2};">Kategorie</a>
		

                </div>
            
        </div>
    </nav>
    
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
