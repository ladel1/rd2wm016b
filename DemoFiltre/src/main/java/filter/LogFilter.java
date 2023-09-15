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
import java.io.IOException;

@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST
		},
		urlPatterns = "*"
		)
public class LogFilter extends HttpFilter implements Filter {
       

	public void destroy() {
		System.out.println("Fin filtre");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Je suis dans le filtre");
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Init filtre Log");
	}

}
