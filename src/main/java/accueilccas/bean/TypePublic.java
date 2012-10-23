package accueilccas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TypePublic implements Serializable {

	private int idTypePublic;
	private String libelleTypePublic;
	private int positionTypePublic;
	private boolean enabled;
	
	
	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	// Getters / Setters
	public int getIdTypePublic() {
		return idTypePublic;
	}


	public void setIdTypePublic(int idTypePublic) {
		this.idTypePublic = idTypePublic;
	}


	public String getLibelleTypePublic() {
		return libelleTypePublic;
	}


	public void setLibelleTypePublic(String libelleTypePublic) {
		this.libelleTypePublic = libelleTypePublic;
	}


	public int getPositionTypePublic() {
		return positionTypePublic;
	}


	public void setPositionTypePublic(int positionTypePublic) {
		this.positionTypePublic = positionTypePublic;
	}
	
	
	// Constructeurs
	public TypePublic () {
		
	}
	
	
	// Méthodes
	public String toString () {
		return "objet=[TypePublic]; id=["+ idTypePublic +"],libelle=["+ libelleTypePublic +"], position=["+ positionTypePublic +"]";
	}

}
