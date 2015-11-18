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
