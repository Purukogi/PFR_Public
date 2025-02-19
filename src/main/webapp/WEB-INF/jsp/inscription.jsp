<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<main>
		<div>
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
			<form action="Inscription" method="POST">
				<div>
					<label for="identifiant">Identifiant :</label>
					<input type="text" name="identifiant" id="identifiant" placeholder="Email ou login" value="${identifiant }">
				</div>
				<div>
					<label for="mdp">Mot de passe :</label>
					<input type="password" name="mdp" id="mdp">
				</div>
				<div>
					<label for="mdp_confirmation">Confirmez le mot de passe :</label>
					<input type="password" name="mdp_confirmation" id="mdp_confirmation">
				</div>
				<div>
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" id="prenom" placeholder="Votre prénom" value="${prenom }">
				</div>
				<div>
					<label for="nom">Nom :</label>
					<input type="text" name="nom" id="nom" placeholder="Votre nom" value="${nom }">
				</div>
				<div>
					<label for="telephone">Numéro de téléphone :</label>
					<input type="text" name="telephone" id="telephone" placeholder="Numéro de téléphone" value="${telephone }">
				</div>
				<div>
					<label for="email">Email :</label>
					<input type="text" name="email" id="email" placeholder="Adresse E-Mail" value="${email }">
				</div>
				<input type="submit" value="Envoyer">
			</form>
		</div>
	</main>
</body>
</html>