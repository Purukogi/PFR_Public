<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact</title>
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
	            <c:if test="${empty messageSent}">
	            	<h1 class="titreformulaire text-center display-6">Contactez notre restaurant</h1>
	            	<h2 class="titrereservation text-center">${restaurant.nom}</h2>

					<form action="contact" method="post">
	                    <input type="hidden" name="idRestaurant" id="idRestaurant" value="${restaurant.id}">
	                    <div class="mb-3">
	                        <label for="utilisateur" class="form-label">Message de :</label>
	                        <input type="text" name="utilisateur" id="utilisateur" class="form-control" value= "${utilisateur.prenom} ${utilisateur.nom}"required>
	                    </div> 
	                     <div class="mb-3">
	                        <textarea name="message" id="message" class="form-control" rows="6" placeholder="Entrez votre message ici" required></textarea>
	                    </div> 
	                    <div class="text-center mb-3">
	                        <input type="submit" value="Envoyer" class="btn btn-primary">
	                    </div>  
	                </form>
	             </c:if>
	             
	             <c:if test="${not empty messageSent}">
                    <div class="alert alert-success text-center" role="alert">
                        Votre message a bien été pris en compte !<br>
                        Nous vous répondrons dans les plus brefs délais.
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