<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div>
			<form action="Connexion" method="POST">
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
		</div>
		<div>
			<p>Pas encore inscrit ? <a href="Inscription">Rejoignez-nous !</a></p>
		</div>
	</main>
</body>
</html>