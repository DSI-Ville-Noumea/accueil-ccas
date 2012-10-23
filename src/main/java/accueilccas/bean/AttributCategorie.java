package accueilccas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AttributCategorie implements Serializable {

	/**
	 * 
	 */

	private int idAttribut;
	private String libelleAttribut;
	private int positionAttribut;
	private Categorie categorie;
	private boolean enabled;
	
	
	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// Getters / Setters
	public int getIdAttribut() {
		return idAttribut;
	}


	public void setIdAttribut(int idAttribut) {
		this.idAttribut = idAttribut;
	}


	public String getLibelleAttribut() {
		return libelleAttribut;
	}


	public void setLibelleAttribut(String libelleAttribut) {
		this.libelleAttribut = libelleAttribut;
	}


	public int getPositionAttribut() {
		return positionAttribut;
	}


	public void setPositionAttribut(int positionAttribut) {
		this.positionAttribut = positionAttribut;
	}
	
	
	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	// Constructeurs
	public AttributCategorie () {
		
	}
	
	
	// Méthodes
	public String toString () {
		return "objet=[AttributCategorie]; id=["+ idAttribut +"],libelle=["+ libelleAttribut +"], position=["+ positionAttribut +"]";
	}
	
}
