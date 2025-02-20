package controller.utilisateur;

import java.io.IOException;

import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/suppression")
public class SuppressionProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurBLL bll = new UtilisateurBLL();
		Utilisateur client = (Utilisateur) request.getSession().getAttribute("utilisateur");
		bll.delete(client);
		response.sendRedirect("deconnexion");
	}


}
