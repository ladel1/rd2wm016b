package fr.eni.miniallocine.bo;

import java.time.LocalDate;

public abstract class Titre {

	private int id;
	private String nom;
	private String genre;
	private String realisateur;
	private int duree;
	private LocalDate dateSortie;// sql date_sortie
	private String platformeStreaming;
	
	public Titre() {		
	}
	
	public Titre(int id, String nom, String genre, String realisateur, int duree, LocalDate dateSortie,
			String platformeStreaming) {		
		this.id = id;
		this.nom = nom;
		this.genre = genre;
		this.realisateur = realisateur;
		this.duree = duree;
		this.dateSortie = dateSortie;
		this.platformeStreaming = platformeStreaming;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getPlatformeStreaming() {
		return platformeStreaming;
	}

	public void setPlatformeStreaming(String platformeStreaming) {
		this.platformeStreaming = platformeStreaming;
	}

	@Override
	public String toString() {
		return "Titre [id=" + id + ", nom=" + nom + ", genre=" + genre + ", realisateur=" + realisateur + ", duree="
				+ duree + ", dateSortie=" + dateSortie + ", platformeStreaming=" + platformeStreaming + "]";
	}
	
	
	
	
}
