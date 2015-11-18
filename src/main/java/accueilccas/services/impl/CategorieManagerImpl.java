package accueilccas.services.impl;

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


import java.util.List;

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;
import accueilccas.bean.Groupe;
import accueilccas.dao.CategorieDAO;
import accueilccas.dao.GroupeDAO;
import accueilccas.services.CategorieManager;

public class CategorieManagerImpl implements CategorieManager {

		
	public AttributCategorie getAttributById(int id) {
		return categoriedao.getAttributById(id);
	}
	
	private GroupeDAO groupedao;
		
	public GroupeDAO getGroupedao() {
		return groupedao;
	}

	public void setGroupedao(GroupeDAO groupedao) {
		this.groupedao = groupedao;
	}
	private CategorieDAO categoriedao ;
		
	public Categorie getCategorieById(int id) {
		return categoriedao.getCategorie(id);
	}

	public List<Categorie> getCategories() {
		return categoriedao.getListCategorie();
	}

	public Categorie ajouterCategorie(int idGroupe, String libCat){
		
		Categorie newCategorie  = new Categorie();
		Groupe groupe = new Groupe();
		
		groupe= groupedao.getGroupe(idGroupe);
		newCategorie.setGroupe(groupe);
		newCategorie.setLibelleCategorie(libCat);
		newCategorie.setEnabled(true);
		newCategorie.setPositionCategorie(groupedao.getGroupe(idGroupe).getCategories().size());
		categoriedao.saveCategorie(newCategorie);
		return newCategorie;
	}
		
	public void saveCategorie(Categorie c) {
			categoriedao.saveCategorie(c);
	}

	public CategorieDAO getCategoriedao() {
		return categoriedao;
	}

	public void setCategoriedao(CategorieDAO categoriedao) {
		this.categoriedao = categoriedao;
	}

	public void reOrderCategorie(String newOrder) {
		String order[] = newOrder.split("-");
		
		int[] orderInt= new int[order.length];
		
		for(int i=0;i<order.length;i++)
			orderInt[i]=Integer.parseInt(order[i]);
		
		 categoriedao.reOrderCategorie(orderInt);
	}

	public Categorie modifierCategorie(int elementId, String libelleCat) {
		
		Categorie modCat= new Categorie();
		modCat = categoriedao.getCategorie(elementId);
		modCat.setLibelleCategorie(libelleCat);
		categoriedao.saveCategorie(modCat);
		return modCat;
	}

	
	public void enableCategorie(int elementId, boolean b) {
		
		Categorie modCat = categoriedao.getCategorie(elementId);
		modCat.setEnabled(b);
		categoriedao.saveCategorie(modCat);
		
	}

}
