package revisions;

import java.util.ArrayList;
import java.util.List;

import revisions.bll.ArticleManager;
import revisions.bll.ClientManager;

public class Main {
	

	public static void main(String[] args) {
		

		ArticleManager artcileManager = ArticleManager.getInstance();
		ClientManager clientManager = ClientManager.getInstance();

		System.out.println(artcileManager.getArticles());
		System.err.println(clientManager.getClients());

		
		
	}

}
