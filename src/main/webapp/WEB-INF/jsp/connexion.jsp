<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connectez-vous</title>
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
		<div id="formulaire_connexion">
			<form action="connexion" method="POST">
				<div>
					<label for="identifiant">Identifiant :</label>
					<input type="text" name="identifiant" id="identifiant" placeholder="Email ou login">
				</div>
				<div>
					<label for="mdp">Mot de passe :</label>
					<input type="password" name="mdp" id="mdp">
				</div>
				<div>
					<label for="souvenir">Se souvenir de moi ?</label>
					<input type="checkbox" name="souvenir" id="souvenir">
				</div>
				<input type="submit" value="Connexion">
			</form>
			<div>
				<p>Pas encore inscrit ? <a href="inscription">Rejoignez-nous !</a></p>
			</div>
		</div>		
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>