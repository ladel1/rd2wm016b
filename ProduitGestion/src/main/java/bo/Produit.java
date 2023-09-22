package bo;

public class Produit {
	
	/**
	 * SELECT * FROM users u inner join produits
	 * User user = new User( rs.getInt("id"),rs.getString() )
	 * Produit p = new Produit(... ,user)
	 */
	private int id;
	private String nom;
	private String description;
	private float prix;
	private User vendeur;
}
