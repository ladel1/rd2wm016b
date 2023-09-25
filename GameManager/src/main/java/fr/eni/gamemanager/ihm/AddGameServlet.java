package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import fr.eni.gamemanager.bll.GameManager;
import fr.eni.gamemanager.bo.Game;

@WebServlet("/jeux/ajouter")
@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
					maxFileSize = 1024 * 1024 * 5,
					maxRequestSize = 1024 * 1024 * 5 * 5 )
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*
     * Chemin dans lequel les images seront sauvegardées.
     */
    public static final String IMAGES_FOLDER = "/Images";
        
    public String uploadPath;
    
    /*
     * Si le dossier de sauvegarde de l'image n'existe pas, on demande sa création.
     */ 
    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
        File uploadDir = new File( uploadPath );
        if ( ! uploadDir.exists() ) uploadDir.mkdir();
    }    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// afficher la page d'ajout
		request.getRequestDispatcher("/WEB-INF/pages/game-add.jsp")
			   .forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// get data from param
			String name =   request.getParameter("name");
			String company =   request.getParameter("company");
			String cat =   request.getParameter("cat");
			float price =  Float.parseFloat(request.getParameter("price")) ;
			LocalDate releaseDate =  LocalDate.parse(request.getParameter("releaseDate")) ;
			int pegi =  Integer.parseInt(request.getParameter("pegi")) ;
			String format =   request.getParameter("format");
			String version =   request.getParameter("version");	
			
			// récupération et sauvegarde de l'image
			String fileName=null;
	       for ( Part part : request.getParts() ) {
	            fileName = getFileName( part );
	            String fullPath = uploadPath + File.separator + fileName;
	            part.write( fullPath );
	        }
			
			// create Game instance
			Game game = new Game(0, name, company, cat, price, releaseDate, pegi, format, version,fileName);
			
			// Add
			GameManager.getInstance().ajouterUnJeu(game);
			// redirect
			response.sendRedirect( request.getContextPath() +"/jeux");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    /*
     * Récupération du nom du fichier dans la requête.
     */
    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            
        	if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.jpg";
    }

}
