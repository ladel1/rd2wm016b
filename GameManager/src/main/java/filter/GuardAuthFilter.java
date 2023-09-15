package filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST
		},
		urlPatterns = {
				"/jeux/ajouter",
				"/jeux/modifier/*",
				"/jeux/supprimer/*",
				"/deconnexion"
		}
		)
public class GuardAuthFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession session = rq.getSession();
		if(session.getAttribute("user")==null) {
			HttpServletResponse rs = (HttpServletResponse) response;
			rs.sendRedirect(rq.getContextPath()+"/connexion");
			return;
		}
		chain.doFilter(request, response);
	}
}
