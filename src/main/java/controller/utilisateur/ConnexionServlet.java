package controller.utilisateur;

import java.io.IOException;

import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String souvenir = request.getParameter("souvenir");
		String identifiant = request.getParameter("identifiant");
		String mdp = request.getParameter("mdp");
		Utilisateur client = new Utilisateur();
		UtilisateurBLL bll = new UtilisateurBLL();
		
		if (identifiant.contains("@")) {
			client = bll.selectByEmailEtMdp(identifiant, mdp);
		} else {
			client = bll.selectByLoginEtMdp(identifiant, mdp);
		}		
		
		if (client == null) {
			request.setAttribute("erreur_login", "Identifiant ou mot de passe incorrect !");
			request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
		} else {
			if(souvenir != null) {
				String token = bll.generateToken(client);
				Cookie cookie = new Cookie("token", token);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("utilisateur", client);
			response.sendRedirect("accueil");
		}
		
		
	}

}
