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
		
		Utilisateur clientSession = (Utilisateur) request.getSession().getAttribute("utilisateur");
		String mdpToCheck = request.getParameter("mdp");
		byte[] hashedMdpToCheck = bll.hashMdp(mdpToCheck, clientSession.getSalt());
		
		if(Arrays.equals(clientSession.getMdp(), hashedMdpToCheck)) {			
			try {
				Utilisateur clientToCheck = new Utilisateur();
				clientToCheck.setPrenom(request.getParameter("prenom"));
				clientToCheck.setNom(request.getParameter("nom"));
				clientToCheck.setEmail(request.getParameter("email"));
				clientToCheck.setTelephone(request.getParameter("telephone"));
				clientToCheck.setLogin(request.getParameter("identifiant"));
				bll.checkUtilisateur(clientToCheck);
				
				clientSession.setNom(clientToCheck.getNom());
				clientSession.setPrenom(clientToCheck.getPrenom());
				clientSession.setEmail(clientToCheck.getEmail());
				clientSession.setTelephone(clientToCheck.getTelephone());
				clientSession.setLogin(clientToCheck.getLogin());
				bll.update(clientSession);
				
				response.sendRedirect("profil");
			} catch (UtilisateurException e) {
				request.setAttribute("erreurs_modification", e.getMessages());
				request.getRequestDispatcher("/WEB-INF/jsp/modification_profil.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("erreur_mdp", "Mot de passe incorrect !");
			request.getRequestDispatcher("/WEB-INF/jsp/modification_profil.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

}
