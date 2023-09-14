package bo;

import java.io.Serializable;

public class Voiture implements Serializable { // la notion JavaBean
	// attr en prive
	private String marque;
	private String model;
	private String mat;
	private int vitesseMax;
	
	// constructeur
	public Voiture() {}

	public Voiture(String marque, String model, String mat, int vitesseMax) {
		this.marque = marque;
		this.model = model;
		this.mat = mat;
		this.vitesseMax = vitesseMax;
	}
	// getter & setters
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	

	
	
	

}
