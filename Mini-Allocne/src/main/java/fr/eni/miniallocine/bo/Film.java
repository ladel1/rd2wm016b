package fr.eni.miniallocine.bo;

import java.time.LocalDate;

public class Film extends Titre {

	private int nombreOscars;

	public Film() {
		super();
	}
	
	public Film(int id, String nom, String genre, String realisateur, int duree, LocalDate dateSortie,
			String platformeStreaming, int nombreOscars) {
		super(id, nom, genre, realisateur, duree, dateSortie, platformeStreaming);
		this.nombreOscars = nombreOscars;
	}

	public int getNombreOscars() {
		return nombreOscars;
	}

	public void setNombreOscars(int nombreOscars) {
		this.nombreOscars = nombreOscars;
	}

	@Override
	public String toString() {
		return "Film [nombreOscars=" + nombreOscars + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
