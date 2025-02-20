package controller.utilisateur;

import java.io.IOException;

import bll.UtilisateurBLL;
import exceptions.UtilisateurException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String identifiant = request.getParameter("identifiant");
		String mdp = request.getParameter("mdp");
		String mdpConfirm = request.getParameter("mdp_confirmation");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		//on ajoute les infos à la requête pour préremplir le formulaire en cas d'erreur
		request.setAttribute("identifiant", identifiant);
		request.setAttribute("prenom", prenom);
		request.setAttribute("nom", nom);
		request.setAttribute("telephone", telephone);
		request.setAttribute("email", email);
		
		if(!mdp.equals(mdpConfirm)) {
			
			request.setAttribute("erreur_mdp", "Les champs de mot de passe ne correspondent pas !");
			request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
			
		}else {			
			
			UtilisateurBLL bll = new UtilisateurBLL();
			
			try {
				bll.insert(nom, prenom, identifiant, mdp, telephone, email);
				response.sendRedirect("connexion");
				
			} catch (UtilisateurException e) {
				request.setAttribute("erreurs_inscription", e.getMessages());
				request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
			}
			
						
		}
		
		
	}

}
