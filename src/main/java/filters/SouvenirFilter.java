package filters;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import bll.UtilisateurBLL;
import bo.Utilisateur;

@WebFilter(
		dispatcherTypes = DispatcherType.REQUEST,
		urlPatterns = "/*"
)
public class SouvenirFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (Cookie current : cookies) {
				if ("token".equals(current.getName())) {
					UtilisateurBLL bll = new UtilisateurBLL();
					Utilisateur userByToken = bll.selectByToken(current.getValue());
					if (userByToken != null) {
						httpRequest.getSession().setAttribute("utilisateur", userByToken);
						chain.doFilter(httpRequest, httpResponse);
						return;
					}
				}
			}
		}		
		chain.doFilter(httpRequest, httpResponse);
	}

}
