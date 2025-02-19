<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
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
		<div >
			<div id="erreur_mdp">
				${erreur_msp }
			</div>
			<div id="erreur_inscription">
				<ul>
					<c:forEach var="message" items="${erreurs_inscription }">
						<li>${message }</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="formulaire_inscription">
			<form action="inscription" method="POST" id="formulaire_inscription_contenu">
				<div id="inscription_col1">
					<div>
						<label for="identifiant">Identifiant :</label>
						<input type="text" name="identifiant" id="identifiant" placeholder="Identifiant" value="${identifiant }" class="form-control">
					</div>
					<div>
						<label for="email">Email :</label>
						<input type="text" name="email" id="email" placeholder="Adresse E-Mail" value="${email }" class="form-control"> 
					</div>
					<div>
						<label for="mdp">Mot de passe :</label>
						<input type="password" name="mdp" id="mdp" class="form-control">
					</div>
					<div>
						<label for="mdp_confirmation">Confirmez le mot de passe :</label>
						<input type="password" name="mdp_confirmation" id="mdp_confirmation" class="form-control">
					</div>			
				</div>
				<div id="inscription_col2">
					<div>
						<label for="prenom">Prénom :</label>
						<input type="text" name="prenom" id="prenom" placeholder="Votre prénom" value="${prenom }" class="form-control">
					</div>
					<div>
						<label for="nom">Nom :</label>
						<input type="text" name="nom" id="nom" placeholder="Votre nom" value="${nom }" class="form-control">
					</div>
					<div>
						<label for="telephone">Numéro de téléphone :</label>
						<input type="text" name="telephone" id="telephone" placeholder="Numéro de téléphone" value="${telephone }" class="form-control">
					</div>
					<div id="inscription_boutton">				
						<input type="submit" value="Envoyer" class="btn btn-primary d-none d-lg-block">
					</div>
				</div>
			</form>
		</div>
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>