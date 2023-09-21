package filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import fr.eni.gamemanager.bo.Passport;
import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.helper.HttpServer;

@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST
		},
		urlPatterns = {
				"/*"
		}
		)
public class F1RememberMeFilter extends HttpFilter implements Filter {
      

	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;

		HttpSession session = request.getSession();
		
		Cookie cookie = HttpServer.getCookie(request, "rememberMe");
		
		if(session.getAttribute("passport")!=null || cookie==null) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = cookie.getValue();
		Passport passport = HttpServer.getPassport(request, token);
		if(passport==null) {
			chain.doFilter(request, response);
			return;
		}
		
		// si id stocké dans cookie se trouve dans hashtable alors je crée une session
		session.setAttribute("passport", passport);
		chain.doFilter(request, response);
	}

}
