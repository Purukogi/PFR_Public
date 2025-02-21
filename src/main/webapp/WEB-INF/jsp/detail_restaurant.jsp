<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${restaurant.nom}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://use.typekit.net/nsr7euh.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="fragments/header.jspf" %>
<section class="taille-navbar container d-flex flex-column align-items-center justify-content-center">

	<h2 class="mb-3 mt-5">${restaurant.nom}</h2>
	<p>${restaurant.adresse}</p>
	
    <div class="container col-xl-8 col-md-12 d-flex flex-column align-items-center justify-content-center mb-4">
		<div class="row border border-2 rounded align-items-center text-center">
			<div class="col-md-6 m-0 p-0 " >
				<img src="${restaurant.url_image}" alt="Image de ${restaurant.nom}" class="img-fluid restaurant-image" style="max-height: 400px;" >
			</div>
			<div class="col-md-6 pb-3 ">
				<h3 class="mb-3 mt-3">Horaires d'ouverture :</h3>
				<c:if test="${not empty restaurant.horaires}">
					<ul>
					<c:forEach var="horaire" items="${restaurant.horaires}">
						<li>${horaire.jour} : ${horaire.ouverture} - ${horaire.fermeture}</li>
					</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
	</div>
		
	<div class="row justify-content-center">
		<div class="col-xl-8 col-md-12 d-flex justify-content-center align-items-center">
		    <form action="reservation" method="GET" class="mb-3 me-2">
				<input type="hidden" name="id" value="${restaurant.id}">
				<input type="submit" value="Réserver" class="btn btn-primary">
			</form>
			<form action="contact" method="GET" class="mb-3 ms-2">
				<input type="hidden" name="id" value="${restaurant.id}">
				<input type="submit" value="Contactez nous !" class="btn btn-primary">
			</form>
		</div>
	</div>
	
	<div class="row justify-content-center col-xl-8 col-md-12 text-center border border-2 rounded align-items-center pt-4 pb-4">
		<h4>En ce moment : <b>${restaurant.carte.nom}</b></h4>	
		<p>${restaurant.carte.description}</p>
	    	<c:if test="${not empty restaurant.carte.platsGroupedByCategory}">
	    	<c:forEach var="entry" items="${restaurant.carte.platsGroupedByCategory}">
	    		<c:set var="categorie" value="${entry.key}"/>
	    		<c:set var="plats" value="${entry.value}"/>
	            <h3 class="mb-3 mt-4 vert">${categorie.libelle}</h3>

	            <ul>
	            <c:forEach var="plat" items="${plats}">
	            	<li>${plat.nom} : ${plat.description} - ${plat.prix} €</li>
	            </c:forEach>
	            </ul>
	        </c:forEach>
	    	</c:if>

	</div>
</section>

	<%@ include file="fragments/footer.jspf" %>
</body>
</html>