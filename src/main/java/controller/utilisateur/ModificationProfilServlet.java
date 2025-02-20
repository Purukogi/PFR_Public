package controller.utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import bll.UtilisateurBLL;
import bo.Utilisateur;
import exceptions.UtilisateurException;

@WebServlet("/modification")
public class ModificationProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/modification_profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurBLL bll = new UtilisateurBLL();		
		Utilisateur client = (Utilisateur) request.getSession().getAttribute("utilisateur");
		String mdpToCheck = request.getParameter("mdp");
		byte[] hashedMdpToCheck = bll.hashMdp(mdpToCheck, client.getSalt());
		
		if(Arrays.equals(client.getMdp(), hashedMdpToCheck)) {
			client.setPrenom(request.getParameter("prenom"));
			client.setNom(request.getParameter("nom"));
			client.setEmail(request.getParameter("email"));
			client.setTelephone(request.getParameter("telephone"));
			client.setLogin(request.getParameter("identifiant"));
			
			try {
				bll.update(client);
				response.sendRedirect("profil");
			} catch (UtilisateurException e) {
				request.setAttribute("erreurs_modification", e.getMessages());
				request.getRequestDispatcher("/WEB-INF/jsp/modification.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("erreur_mdp", "Mot de passe incorrect !");
			request.getRequestDispatcher("/WEB-INF/jsp/modification.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

}
