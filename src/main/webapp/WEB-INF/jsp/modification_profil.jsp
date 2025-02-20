<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifiez votre profil</title>
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
		<div id="formulaire_modif_profil">
			<form action="modification" method="POST">
			
			<div >
			<c:if test="${!empty erreur_mdp}">
				<div id="erreur_mdp" class="alert alert-danger">
					${erreur_mdp }
				</div>
			</c:if>
			<c:if test="${!empty erreurs_modification }">
				<div id="erreurs_modification" class="alert alert-danger">
				<ul>
					<c:forEach var="message" items="${erreurs_modification }">
						<li>${message }</li>
					</c:forEach>
				</ul>
				</div>
			</c:if>			
			</div>
			
			<div id="formulaire_modification_contenu">			
				<div id="profil_col1">
					<div>
						<label for="prenom">Prénom :</label>
						<input type="text" name="prenom" id="prenom" placeholder="Votre prénom" value="${sessionScope.utilisateur.prenom }" class="form-control">
					</div>
					<div>
						<label for="email">Email :</label>
						<input type="text" name="email" id="email" placeholder="Adresse E-Mail" value="${sessionScope.utilisateur.email }" class="form-control"> 
					</div>
					<div>
						<label for="telephone">Numéro de téléphone :</label>
						<input type="text" name="telephone" id="telephone" placeholder="Numéro de téléphone" value="${sessionScope.utilisateur.telephone }" class="form-control">
					</div>					
				</div>
				<div id="profil_col2">
					<div>
						<label for="nom">Nom :</label>
						<input type="text" name="nom" id="nom" placeholder="Votre nom" value="${sessionScope.utilisateur.nom }" class="form-control">
					</div>
					<div>
						<label for="identifiant">Identifiant :</label>
						<input type="text" name="identifiant" id="identifiant" placeholder="Identifiant" value="${sessionScope.utilisateur.login }" class="form-control">
					</div>			
				</div>							
			</div>
			<div>
				<label for="mdp">Entrez votre mot de passe pour confirmer :</label>
				<input type="password" name="mdp" id="mdp" class="form-control">
			</div>
			<div id="inscription_bouton">				
				<input type="submit" value="Modifier" class="btn btn-primary">
			</div>
			</form>
		</div>
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>