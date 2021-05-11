<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Strona główna</title>
</head>
<body>
<c:import url="/menu"/>
<div class="row articles" style="margin: 0 auto; margin-top:150px; text-align:center; ">
                <div class="col-sm-6 col-md-4 item"><a href="#"></a><i class="fa fa-book" style="font-size: 70px;margin-bottom: 30px;"></i>
                    <h3 class="name">Wybierz ksiazke</h3>
                </div>
                <div class="col-sm-6 col-md-4 item"><a href="#"></a><i class="fa fa-handshake-o" style="font-size: 70px;margin-bottom: 30px;"></i>
                    <h3 class="name">Zamow</h3>
                </div>
                <div class="col-sm-6 col-md-4 item"><a href="#"></a><i class="fa fa-shopping-basket" style="margin-bottom: 30px;font-size: 70px;"></i>
                    <h3 class="name">Czytaj</h3>
                </div>
            </div>
</body>
</html>