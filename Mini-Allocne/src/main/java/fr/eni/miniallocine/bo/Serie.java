package fr.eni.miniallocine.bo;

import java.time.LocalDate;

public class Serie extends Titre {

	private int nombreEpisodes;
	private int nombreSaisons;
	
	public Serie() {
		super();
	}
	
	public Serie(int id, String nom, String genre, String realisateur, int duree, LocalDate dateSortie,
			String platformeStreaming, int nombreEpisodes, int nombreSaisons) {
		super(id, nom, genre, realisateur, duree, dateSortie, platformeStreaming);
		this.nombreEpisodes = nombreEpisodes;
		this.nombreSaisons = nombreSaisons;
	}

	public int getNombreEpisodes() {
		return nombreEpisodes;
	}

	public void setNombreEpisodes(int nombreEpisodes) {
		this.nombreEpisodes = nombreEpisodes;
	}

	public int getNombreSaisons() {
		return nombreSaisons;
	}

	public void setNombreSaisons(int nombreSaisons) {
		this.nombreSaisons = nombreSaisons;
	}

	@Override
	public String toString() {
		return "Serie [nombreEpisodes=" + nombreEpisodes + ", nombreSaisons=" + nombreSaisons + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
