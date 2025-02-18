<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Nos restaurants</h1>
	
	<div>
	<c:forEach items="${listeRestaurants}" var="r" varStatus="bStatus">
		<fieldset>
			<p>${r.url_image}</p>
			<p>${r.nom}</p>
			<p>${r.adresse}</p>
			<p>${r.carte.nom}</p>
		</fieldset>
	</c:forEach>
	</div>
</body>
</html>