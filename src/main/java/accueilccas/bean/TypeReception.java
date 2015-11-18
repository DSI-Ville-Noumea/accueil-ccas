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
