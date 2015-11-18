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
