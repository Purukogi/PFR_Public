let bouton_suppression_elem = document.getElementById("bouton_suppression");

bouton_suppression_elem.addEventListener("click", () => {
	if (window.confirm("Etes-vous sûr de vouloir supprimer votre compte ?")){
		document.location.href="suppression";       
	}
});