package accueilccas.bean;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	
	private int idCategorie;
	private String libelleCategorie;
	private int positionCategorie;
	private Groupe groupe;
	private List<AttributCategorie> attributs;
	private boolean enabled;
	
	// Getters / Setters
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public int getPositionCategorie() {
		return positionCategorie;
	}

	public void setPositionCategorie(int positionCategorie) {
		this.positionCategorie = positionCategorie;
	}

	public List<AttributCategorie> getAttributs() {
		return attributs;
	}

	public void setAttributs(List<AttributCategorie> attributs) {
		this.attributs = attributs;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	// Constructeur(s)
	public Categorie () {
		
	}
	
	// Méthodes
	public String toString () {
		return "objet=[Categorie]; id=["+ idCategorie +"],libelle=["+ libelleCategorie +"], position=["+ positionCategorie +"]";
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	
}
