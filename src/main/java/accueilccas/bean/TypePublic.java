package accueilccas.bean;

/*
 * #%L
 * Accueil CCAS
 * %%
 * Copyright (C) 2012 - 2015 Mairie de Nouméa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


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
