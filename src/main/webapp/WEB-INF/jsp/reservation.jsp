<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://use.typekit.net/nsr7euh.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<main>
	    <div class="container vh-100 d-flex align-items-center justify-content-center">
	        <div class="card p-4 bg-light shadow-lg">
	            <div class="card-body">
	                 <c:if test="${empty reservationSuccess}">
	                <h1 class="titreformulaire text-center display-6">Formulaire de réservation</h1>
	                <h2 class="titrereservation text-center">${restaurant.nom}</h2>
	                <form action="reservation" method="post">
	                    <input type="hidden" name="idRestaurant" id="idRestaurant" value="${restaurant.id}">
	                    <div class="mb-3">
	                        <label for="date" class="form-label">Date :</label>
	                        <input type="date" name="date" id="date" class="form-control" required>
	                    </div>
	
	                    <div class="mb-3">
						    <label for="horaire" class="form-label">Horaire :</label>
						    <select name="horaire" id="horaire" class="form-control" required>
						        <option value="12:00">12:00</option>
						        <option value="12:15">12:15</option>
						        <option value="12:30">12:30</option>
						        <option value="12:45">12:45</option>
						        <option value="13:00">13:00</option>
						        <option value="13:15">13:15</option>
						        <option value="13:30">13:30</option>
						    </select>
						</div>
						<div class="mb-3">
						    <label for="nombre" class="form-label">Nombre de personnes :</label>
						    <select name="nombre" id="nombre" class="form-control" required>
						        <option value="1">1</option>
						        <option value="2">2</option>
						        <option value="3">3</option>
						        <option value="4">4</option>
						        <option value="5">5</option>
						        <option value="6">6</option>
						        <option value="7">7</option>
						        <option value="8">8</option>
						    </select>
						</div>
	                    <div class="text-center">
	                        <input type="submit" value="Réserver" class="btn btn-primary">
	                    </div>
	                </form>
	                </c:if>
	                <c:if test="${not empty reservationSuccess}">
                    <div class="alert alert-success text-center" role="alert">
                        Votre réservation a bien été prise en compte !<br>
                        Vous recevrez une confirmation par mail dans les plus brefs délais.
                    </div>
                    <div class="text-center">
                        <a href="accueil" class="btn btn-secondary">Retour à l'accueil</a>
                    </div>
				</c:if>
	            </div>
	        </div>
	    </div>
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>