package accueilccas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TypeReception implements Serializable {

	private int idTypeReception;
	private String libelleTypeReception;
	private int positionTypeReception;
	private boolean enabled;
	
	
	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	// Getters / Setters
	public int getIdTypeReception() {
		return idTypeReception;
	}


	public void setIdTypeReception(int idTypeReception) {
		this.idTypeReception = idTypeReception;
	}


	public String getLibelleTypeReception() {
		return libelleTypeReception;
	}


	public void setLibelleTypeReception(String libelleTypeReception) {
		this.libelleTypeReception = libelleTypeReception;
	}


	public int getPositionTypeReception() {
		return positionTypeReception;
	}


	public void setPositionTypeReception(int positionTypeReception) {
		this.positionTypeReception = positionTypeReception;
	}


	// Constructeurs
	public TypeReception () {
		
	}
	
	
	// Méthodes
	public String toString () {
		return "objet=[TypeReception]; id=["+ idTypeReception +"],libelle=["+ libelleTypeReception +"], position=["+ positionTypeReception +"],activation=["+ enabled +"]";
	}
	
}
