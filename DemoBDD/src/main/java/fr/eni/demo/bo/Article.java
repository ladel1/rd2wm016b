package fr.eni.demo.bo;

import java.time.LocalDate;

public class Article {
	private int id; 
	private String titre;
	private String contenu;
	private String auteur;
	private String categorie;
	private LocalDate dateCreation;
	
	
	public Article(int id, String titre, String contenu, String auteur, String categorie, LocalDate dateCreation) {
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.auteur = auteur;
		this.categorie = categorie;
		this.dateCreation = dateCreation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public LocalDate getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", auteur=" + auteur + ", categorie="
				+ categorie + ", dateCreation=" + dateCreation + "]";
	}
	
	
	
}
