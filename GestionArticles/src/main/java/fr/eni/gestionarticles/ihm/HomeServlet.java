package fr.eni.gestionarticles.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String op1 = request.getParameter("op1");
		String op = request.getParameter("op");
		String op2 = request.getParameter("op2");
		
		
		response.getWriter()
			    .append("Resultat: "+calculer(
				    		Float.parseFloat(op1), 
							Float.parseFloat(op2) ,
							op.charAt(0) 
						)
			    );
		
	}
	
	private float calculer(float op1,float op2, char op) {
		
		if(op=='+') return op1+op2;
		if(op=='-') return op1-op2;
		if(op=='*') return op1*op2;
		if(op=='/') return op1/op2;// div par zéro
		if(op=='%') return op1%op2;
		
		return 0;
	}
	

}
