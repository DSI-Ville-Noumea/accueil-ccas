package accueilccas.bean;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Groupe implements Serializable  {
	
	private int idgroupe;
	private String nom;
	private int position;
	private List<Categorie> categories;
	private boolean enabled;

	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}
		
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	public String toString()
	{
		return "groupe " + nom;
	}
	
	
}
