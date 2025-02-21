package filters;

import java.io.IOException;

import bo.Utilisateur;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ConnexionFilter
 */
@WebFilter(
		dispatcherTypes = DispatcherType.REQUEST,
		urlPatterns = {"/contact", "/reservation", "/profil", "/modification-profil"}
)
public class ConnexionFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		Utilisateur utilisateur = (Utilisateur) httpRequest.getSession().getAttribute("utilisateur");
		if (utilisateur != null) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		
        String requestedUrl = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();
        if (queryString != null) {
            requestedUrl += "?" + queryString;
        }
        httpRequest.getSession().setAttribute("redirectAfterLogin", requestedUrl);

		httpResponse.sendRedirect("connexion");
	}
}
