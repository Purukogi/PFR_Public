<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		<div class="container d-flex align-items-center justify-content-center formulaire_utilisateur">
	        <div class="card p-4 bg-light shadow-lg">
	            <div class="card-body">
	                <h1 class="titreformulaire text-center display-6">Connexion</h1>
	                <form action="connexion" method="POST" >
						<c:if test="${!empty erreur_login }">
							<div class="alert alert-danger">
								${erreur_login }
							</div>
						</c:if>	
						<div>
							<label for="identifiant">Identifiant :</label>
							<input type="text" name="identifiant" id="identifiant" placeholder="Email ou login" class="form-control">
						</div>
						<div>
							<label for="mdp">Mot de passe :</label>
							<input type="password" name="mdp" id="mdp" class="form-control">
						</div>				
						<div class="text-center mt-2">
							<label for="souvenir">Se souvenir de moi ?</label>
							<input type="checkbox" name="souvenir" id="souvenir" class="vert">
						</div>
						<div class="container text-center">					
							<input type="submit" value="Se connecter" class="btn btn-primary mt-2 mb-2">
							<p>Pas encore inscrit ? <a href="inscription" class="vert">Rejoignez-nous !</a></p>
						</div>				
					</form>
	            </div>
	        </div>
	    </div>			
	</main>
	<%@include file="fragments/footer.jspf" %>
</body>
</html>