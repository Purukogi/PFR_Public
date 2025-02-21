<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nos restaurants</title>
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
	<h2 class="mb-5 mt-5">Nos restaurants</h2>
	
	<div class="row justify-content-center" >
	<c:forEach items="${listeRestaurants}" var="r" varStatus="bStatus">
		<fieldset class="mb-4 col-lg-8 col-md-12 text-center">
			<div class="row border border-2 rounded align-items-center" >
				<div class="col-md-6 m-0 p-0 " style="max-height: 250px; overflow: hidden;">
					<img src="${r.url_image}" alt="Image de ${r.nom}" class="img-fluid restaurant-image" style="max-height: 250px;">
				</div>
				<div class="col-md-6 pt-2 pb-2 d-flex flex-column justify-content-between">
					<h4 >${r.nom}</h4>
					<p>${r.adresse}</p>
					<form action="detail-restaurant" method="GET">
						<input type="hidden" name="id" value="${r.id}">
						<input type="submit" value="Plus d'informations" class="btn btn-primary">
					</form>
				</div>
			</div>
		</fieldset>
	</c:forEach>
	</div>
	
	</section>
	<%@ include file="fragments/footer.jspf" %>
</body>
</html>