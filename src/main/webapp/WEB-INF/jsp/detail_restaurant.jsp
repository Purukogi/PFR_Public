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
	<h3>${restaurant.nom}</h3>
	<p>${restaurant.url_image}IMAGE</p>
	<p>${restaurant.adresse}</p>
	<h4>Horaires d'ouverture :</h4>
    <c:if test="${not empty restaurant.horaires}">
    	<ul>
    	<c:forEach var="horaire" items="${restaurant.horaires}">
    		<li>${horaire.jour} : ${horaire.ouverture} - ${horaire.fermeture}</li>
    	</c:forEach>
    	</ul>
    </c:if>
	<fieldset>
		<p>Carte du moment : <b>${restaurant.carte.nom}</b></p>	
		<p>${restaurant.carte.description}</p>
	    	<c:if test="${not empty restaurant.carte.platsGroupedByCategory}">
	    	<c:forEach var="entry" items="${restaurant.carte.platsGroupedByCategory}">
	    		<c:set var="categorie" value="${entry.key}"/>
	    		<c:set var="plats" value="${entry.value}"/>
	            
	            <h3>${categorie.libelle}</h3>
	            <ul>
	            <c:forEach var="plat" items="${plats}">
	            	<li>${plat.nom} : ${plat.description} - ${plat.prix} €</li>
	            </c:forEach>
	            </ul>
	        </c:forEach>
	    	</c:if>
	</fieldset>
</body>
</html>